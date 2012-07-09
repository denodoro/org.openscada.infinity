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
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.DataPoint;

public class QualityRenderer extends AbstractRenderer
{

    public QualityRenderer ( final ChartArea chartArea, final SeriesData seriesData )
    {
        super ( chartArea, seriesData );
    }

    @Override
    public void render ( final PaintEvent e, final Rectangle clientRect )
    {
        final GC gc = e.gc;

        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        gc.setBackground ( gc.getDevice ().getSystemColor ( SWT.COLOR_RED ) );
        gc.setAlpha ( 128 );

        final SortedSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
        if ( entries.isEmpty () )
        {
            e.gc.fillRectangle ( clientRect );
            return;
        }

        final DataPoint point = new DataPoint ();

        Integer lastPosition = null;
        Integer lastValidPosition = null;

        final DataEntry first = entries.first ();
        translateToPoint ( clientRect, xAxis, yAxis, point, first );
        if ( point.x > 0 )
        {
            e.gc.fillRectangle ( 0, 0, (int)point.x, clientRect.height );
        }

        final DataEntry last = entries.last ();
        translateToPoint ( clientRect, xAxis, yAxis, point, last );
        if ( point.x >= 0 && point.x < clientRect.width )
        {
            e.gc.fillRectangle ( (int)point.x, 0, (int) ( clientRect.width - 1 - point.x ), clientRect.height );
        }
        else if ( point.x < 0 )
        {
            e.gc.fillRectangle ( clientRect );
        }

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

            if ( lastPosition != null )
            {
                e.gc.fillRectangle ( lastPosition, 0, (int)point.x - lastPosition, clientRect.height );
            }

            if ( !hasData )
            {
                if ( lastValidPosition != null && lastPosition == null )
                {
                    e.gc.fillRectangle ( lastValidPosition, 0, (int)point.x - lastValidPosition, clientRect.height );
                }
                lastPosition = (int)point.x;
            }
            else
            {
                lastValidPosition = (int)point.x;
                lastPosition = null;
            }
        }

    }
}
