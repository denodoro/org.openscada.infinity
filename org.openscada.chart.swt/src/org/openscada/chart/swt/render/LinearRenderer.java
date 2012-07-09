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

package org.openscada.chart.swt.render;

import java.util.SortedSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.DataPoint;

public class LinearRenderer extends AbstractLineRender implements Renderer
{

    public LinearRenderer ( final SeriesData seriesData )
    {
        super ( seriesData );
    }

    @Override
    public void render ( final PaintEvent e, final Rectangle clientRect )
    {
        final GC gc = e.gc;

        final Path path = new Path ( gc.getDevice () );

        // eval min/max
        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        final SortedSet<DataEntry> entries = this.seriesData.getView ( xAxis.getMin (), xAxis.getMax (), clientRect.width ).getEntries ();
        if ( entries.isEmpty () )
        {
            return;
        }

        boolean first = true;

        final DataPoint point = new DataPoint ();

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );
            if ( hasData )
            {
                if ( first )
                {
                    first = false;
                    path.moveTo ( point.x, point.y );
                }
                else
                {
                    path.lineTo ( point.x, point.y );
                }
            }
            else
            {
                first = true;
            }
        }
        gc.setLineAttributes ( this.lineAttributes );
        gc.setForeground ( this.lineColor != null ? this.lineColor : gc.getDevice ().getSystemColor ( SWT.COLOR_BLACK ) );
        gc.drawPath ( path );
    }
}