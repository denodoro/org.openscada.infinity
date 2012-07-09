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

package org.openscada.chart.swt;

import org.openscada.chart.DataEntry;
import org.openscada.chart.SeriesData;

public class Series
{
    private SeriesData data = new SeriesData ();

    private final XAxis xAxis;

    private final YAxis yAxis;

    public Series ( final XAxis xAxis, final YAxis yAxis )
    {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public XAxis getXAxis ()
    {
        return this.xAxis;
    }

    public YAxis getYAxis ()
    {
        return this.yAxis;
    }

    public void setData ( final SeriesData data )
    {
        this.data = data;
    }

    public SeriesData getData ()
    {
        return this.data;
    }

    public void fillAutoXYAxis ()
    {
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;

        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        for ( final DataEntry entry : this.data.getEntries () )
        {
            final long timestamp = entry.getTimestamp ().getTime ();
            final Double value = entry.getValue ();
            if ( timestamp < minX )
            {
                minX = timestamp;
            }
            if ( timestamp > maxX )
            {
                maxX = timestamp;
            }
            if ( value < minY )
            {
                minY = value;
            }
            if ( value > maxY )
            {
                maxY = value;
            }
        }

        this.xAxis.setMinMax ( minX, maxX );
        this.yAxis.setMinMax ( minY, maxY );
    }

}
