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
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DataPoint;
import org.openscada.chart.swt.Graphics;

public class QualityRenderer extends AbstractDataSeriesRenderer
{

    public QualityRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
    }

    @Override
    protected void performRender ( final Graphics g, final Rectangle clientRect )
    {
        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        g.setBackground ( g.getSystemColor ( SWT.COLOR_RED ) );
        g.setAlpha ( 128 );

        final SortedSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
        if ( entries.isEmpty () )
        {
            g.fillRectangle ( clientRect );
            return;
        }

        g.setClipping ( clientRect );

        final DataPoint point = new DataPoint ();

        Integer lastPosition = null;
        Integer lastValidPosition = null;

        final DataEntry first = entries.first ();
        translateToPoint ( clientRect, xAxis, yAxis, point, first );
        if ( point.x > 0 )
        {
            g.fillRectangle ( clientRect.x, clientRect.y, (int)point.x - clientRect.x, clientRect.height );
        }

        final DataEntry last = entries.last ();
        translateToPoint ( clientRect, xAxis, yAxis, point, last );
        if ( point.x >= 0 && point.x < clientRect.width )
        {
            g.fillRectangle ( (int)point.x, clientRect.y, (int) ( clientRect.width - ( point.x - 1 - clientRect.x ) ), clientRect.height );
        }
        else if ( point.x < 0 )
        {
            g.fillRectangle ( clientRect );
        }

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

            if ( lastPosition != null )
            {
                g.fillRectangle ( lastPosition, clientRect.y, (int)point.x - lastPosition, clientRect.height );
            }

            if ( !hasData )
            {
                if ( lastValidPosition != null && lastPosition == null )
                {
                    g.fillRectangle ( lastValidPosition, clientRect.y, (int)point.x - lastValidPosition, clientRect.height );
                }
                lastPosition = (int)point.x;
            }
            else
            {
                lastValidPosition = (int)point.x;
                lastPosition = null;
            }
        }

        g.setClipping ( clientRect );
    }
}
