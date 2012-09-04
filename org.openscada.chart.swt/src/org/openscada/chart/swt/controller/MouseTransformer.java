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
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartMouseListener;
import org.openscada.chart.swt.ChartMouseMoveListener;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DisposeListener;

public class MouseTransformer implements ChartMouseListener, ChartMouseMoveListener
{
    private boolean active;

    private int startX;

    private int startY;

    private final ChartRenderer chartArea;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseTransformer ( final ChartRenderer chartArea, final XAxis xAxis, final YAxis yAxis )
    {
        this.chartArea = chartArea;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        chartArea.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );

        chartArea.addMouseListener ( this );
        chartArea.addMouseMoveListener ( this );
    }

    public void dispose ()
    {
        this.chartArea.removeMouseListener ( this );
        this.chartArea.removeMouseMoveListener ( this );
    }

    @Override
    public void onMouseDoubleClick ( final MouseState state )
    {
    }

    @Override
    public void onMouseDown ( final MouseState e )
    {
        if ( e.button != 1 || e.state != SWT.MOD1 )
        {
            return;
        }

        this.active = true;
        this.startX = e.x;
        this.startY = e.y;
    }

    @Override
    public void onMouseUp ( final MouseState state )
    {
        this.active = false;
    }

    @Override
    public void onMouseMove ( final MouseState state )
    {
        if ( !this.active )
        {
            return;
        }

        final int diffX = this.startX - state.x;
        this.startX = state.x;

        final int diffY = this.startY - state.y;
        this.startY = state.y;

        final Rectangle rect = this.chartArea.getClientArea ();
        boolean update = false;
        if ( rect.width > 0 )
        {
            this.xAxis.transform ( diffX, rect.width );
            update = true;
        }
        if ( rect.height > 0 )
        {
            this.yAxis.transform ( diffY, rect.height );
            update = true;
        }

        if ( update )
        {
            this.chartArea.redraw ();
        }
    }

}
