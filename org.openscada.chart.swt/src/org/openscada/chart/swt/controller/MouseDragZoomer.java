/*
 * This file is part of the openSCADA project
 * Copyright (C) 2011-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

package org.openscada.chart.swt.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartMouseListener;
import org.openscada.chart.swt.ChartMouseListener.MouseState;
import org.openscada.chart.swt.ChartMouseMoveListener;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DisposeListener;
import org.openscada.chart.swt.Graphics;
import org.openscada.chart.swt.render.Renderer;

public class MouseDragZoomer implements Renderer
{
    private final ChartRenderer chart;

    private final ChartMouseMoveListener mouseMoveListener;

    private Point start;

    private Rectangle selection;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseDragZoomer ( final ChartRenderer chart, final XAxis xAxis, final YAxis yAxis )
    {
        this.chart = chart;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        chart.addRenderer ( this );

        this.mouseMoveListener = new ChartMouseMoveListener () {

            @Override
            public void onMouseMove ( final MouseState state )
            {
                handleMouseMove ( state );
            }
        };

        chart.addMouseListener ( new ChartMouseListener () {

            @Override
            public void onMouseDoubleClick ( final MouseState state )
            {
            }

            @Override
            public void onMouseDown ( final MouseState state )
            {
                if ( state.button == 1 && state.state == 0 )
                {
                    startZoom ( state );
                }
            }

            @Override
            public void onMouseUp ( final MouseState state )
            {
                endZoom ( state );
            }

        } );

        chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );
    }

    private void detachMouseMoveListener ()
    {
        this.chart.removeMouseMoveListener ( this.mouseMoveListener );
    }

    public void dispose ()
    {
        this.chart.removeRenderer ( this );
        detachMouseMoveListener ();
    }

    protected void endZoom ( final MouseState e )
    {
        processZoom ( this.selection );
        detachMouseMoveListener ();
        this.selection = null;
        this.chart.redraw ();
    }

    protected void startZoom ( final MouseState state )
    {
        this.chart.addMouseMoveListener ( this.mouseMoveListener );
        this.start = new Point ( state.x, state.y );
    }

    protected void handleMouseMove ( final MouseState state )
    {
        this.selection = makeSelection ( new Point ( state.x, state.y ) );
        this.chart.redraw ();
    }

    private Rectangle makeSelection ( final Point point )
    {
        return new Rectangle ( this.start.x, this.start.y, point.x - this.start.x, point.y - this.start.y );
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.selection != null )
        {
            g.setLineAttributes ( new LineAttributes ( 1.0f ) );
            g.setForeground ( g.getSystemColor ( SWT.COLOR_BLACK ) );

            g.drawRectangle ( this.selection );
        }
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        // NO-OP
        return null;
    }

    private void processZoom ( final Rectangle selection )
    {
        if ( selection == null )
        {
            return;
        }

        final Rectangle client = this.chart.getClientArea ();

        if ( selection.width > 0 && selection.height > 0 )
        {
            // zoom in
            final long minTimestamp = this.xAxis.translateToValue ( client.width, selection.x );
            final long maxTimestamp = this.xAxis.translateToValue ( client.width, selection.x + selection.width );

            final double maxValue = this.yAxis.translateToValue ( client.height, selection.y );
            final double minValue = this.yAxis.translateToValue ( client.height, selection.y + selection.height );

            this.xAxis.setMinMax ( minTimestamp, maxTimestamp );
            this.yAxis.setMinMax ( minValue, maxValue );
        }
        else
        {
            final int widthSelection = Math.abs ( selection.width );
            final int heightSelection = Math.abs ( selection.height );
            final int widthClient = client.width;
            final int heightClient = client.height;

            this.xAxis.zoom ( 1.0 + Math.abs ( (double)widthSelection ) / widthClient );
            this.yAxis.zoom ( 1.0 + Math.abs ( (double)heightSelection ) / heightClient );
        }
    }
}
