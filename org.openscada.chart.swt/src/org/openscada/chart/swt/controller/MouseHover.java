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

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.XAxis;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DisposeListener;
import org.openscada.chart.swt.render.AbstractPositionXRuler;

public class MouseHover extends AbstractPositionXRuler implements MouseMoveListener
{
    public static interface Listener
    {
        public void mouseMove ( MouseEvent e, long timestamp );
    }

    private final ChartRenderer chart;

    private final XAxis xAxis;

    private final Listener listener;

    private long position;

    private Rectangle clientRect;

    public MouseHover ( final ChartRenderer chart, final XAxis xAxis, final Listener listener )
    {
        super ( xAxis );

        this.chart = chart;
        this.xAxis = xAxis;

        this.listener = listener;

        chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );

        chart.addMouseMoveListener ( this );
        chart.addRenderer ( this );
    }

    public void dispose ()
    {
        this.chart.removeRenderer ( this );
        this.chart.removeMouseMoveListener ( this );
    }

    @Override
    public void mouseMove ( final MouseEvent e )
    {
        if ( this.listener != null )
        {
            this.position = this.xAxis.translateToValue ( this.clientRect.width, e.x - this.clientRect.x );
            this.listener.mouseMove ( e, this.position );
            if ( this.visible )
            {
                this.chart.redraw ();
            }
        }
    }

    @Override
    public Long getPosition ()
    {
        return this.position;
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        this.clientRect = clientRectangle;
        return super.resize ( clientRectangle );
    }

}
