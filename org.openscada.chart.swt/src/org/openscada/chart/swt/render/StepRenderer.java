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

import java.util.NavigableSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DataPoint;
import org.openscada.chart.swt.Graphics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepRenderer extends AbstractLineRender implements Renderer
{

    private final static Logger logger = LoggerFactory.getLogger ( StepRenderer.class );

    public StepRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRect )
    {
        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        final NavigableSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
        if ( entries.isEmpty () )
        {
            return;
        }

        final Path path = g.createPath ();
        try
        {

            boolean first = true;

            final DataPoint point = new DataPoint ();
            Float previousY = null;

            logger.trace ( "Render steps" );

            for ( final DataEntry entry : entries )
            {
                final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

                logger.trace ( "Entry - {}, hasData: {}, point: {}", new Object[] { entry, hasData, point } );

                if ( hasData )
                {
                    if ( first )
                    {
                        first = false;
                        path.moveTo ( point.x, point.y );
                    }
                    else
                    {
                        path.lineTo ( point.x, previousY );
                        path.lineTo ( point.x, point.y );
                    }
                    previousY = point.y;
                }
                else
                {
                    first = true;
                    if ( previousY != null )
                    {
                        path.lineTo ( point.x, previousY );
                        previousY = null;
                    }
                }
            }

            g.setAlpha ( 255 );
            g.setLineAttributes ( this.lineAttributes );
            g.setForeground ( this.lineColor != null ? this.lineColor : g.getSystemColor ( SWT.COLOR_BLACK ) );

            g.setClipping ( clientRect );
            g.drawPath ( path );
            g.setClipping ( (Rectangle)null );
        }
        finally
        {
            path.dispose ();
        }
    }
}
