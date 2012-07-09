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

package org.openscada.chart.swt.test;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.XAxis;
import org.openscada.chart.swt.YAxis;

public class MouseTransformer implements MouseListener, MouseMoveListener
{
    private boolean active;

    private int startX;

    private int startY;

    private final ChartArea chartArea;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseTransformer ( final ChartArea chartArea, final XAxis xAxis, final YAxis yAxis )
    {
        this.chartArea = chartArea;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public void mouseDoubleClick ( final MouseEvent e )
    {
    }

    @Override
    public void mouseDown ( final MouseEvent e )
    {
        this.active = true;
        this.startX = e.x;
        this.startY = e.y;
    }

    @Override
    public void mouseUp ( final MouseEvent e )
    {
        this.active = false;
    }

    @Override
    public void mouseMove ( final MouseEvent e )
    {
        if ( !this.active )
        {
            return;
        }

        final int diffX = this.startX - e.x;
        this.startX = e.x;

        final int diffY = this.startY - e.y;
        this.startY = e.y;

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
