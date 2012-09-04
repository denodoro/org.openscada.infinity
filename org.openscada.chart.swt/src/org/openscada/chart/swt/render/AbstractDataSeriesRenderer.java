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

import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;
import org.openscada.chart.SeriesDataListener;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.DataPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDataSeriesRenderer implements Renderer
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractDataSeriesRenderer.class );

    protected final SeriesData seriesData;

    private SeriesDataListener listener;

    private final ChartRenderer chartArea;

    public AbstractDataSeriesRenderer ( final ChartRenderer chartArea, final SeriesData seriesData )
    {
        this.chartArea = chartArea;
        this.seriesData = seriesData;

        seriesData.addListener ( this.listener = new SeriesDataListener () {

            @Override
            public void dataUpdate ( final long startTimestamp, final long endTimestamp )
            {
                handleDataUpdate ( startTimestamp, endTimestamp );
            }
        } );
    }

    protected void handleDataUpdate ( final long startTimestamp, final long endTimestamp )
    {
        logger.debug ( "Data update - {} -> {}", startTimestamp, endTimestamp );
        if ( this.chartArea.isDisposed () )
        {
            return;
        }
        this.chartArea.refreshData ();
    }

    public void dispose ()
    {
        this.seriesData.removeListener ( this.listener );
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        this.seriesData.setRequestWidth ( clientRectangle.width );
        return null;
    }

    protected static boolean translateToPoint ( final Rectangle clientRect, final XAxis x, final YAxis y, final DataPoint point, final DataEntry entry )
    {
        point.x = clientRect.x + x.translateToClient ( clientRect.width, entry.getTimestamp () );

        final Double value = entry.getValue ();
        if ( value == null )
        {
            return false;
        }

        point.y = clientRect.y + y.translateToClient ( clientRect.height, value );

        return true;
    }

}