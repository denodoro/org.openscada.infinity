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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DisposeListener;

public class MouseWheelZoomer implements MouseWheelListener
{
    private final XAxis x;

    private final YAxis y;

    private final ChartRenderer chart;

    public MouseWheelZoomer ( final ChartRenderer chart, final XAxis x, final YAxis y )
    {
        this.x = x;
        this.y = y;
        this.chart = chart;

        this.chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );
        this.chart.addMouseWheelListener ( this );
    }

    public void dispose ()
    {
        this.chart.removeMouseWheelListener ( this );
    }

    @Override
    public void mouseScrolled ( final MouseEvent e )
    {
        if ( e.stateMask == 0 )
        {
            this.x.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        else if ( ( e.stateMask & SWT.MOD1 ) > 0 )
        {
            this.y.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        this.chart.redraw ();
    }
}