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
package org.openscada.chart;

public abstract class FunctionSeriesData extends SeriesData
{

    public FunctionSeriesData ( final XAxis xAxis, final YAxis yAxis )
    {
        super ( xAxis, yAxis );
    }

    @Override
    public SeriesViewData getViewData ( final long startTimestamp, final long endTimestamp, final int width )
    {
        final WritableSeriesData result = new WritableSeriesData ();

        final double step = (double) ( endTimestamp - startTimestamp ) / (double)width;

        for ( double i = startTimestamp; i < endTimestamp; i += step )
        {
            final long tx = (long)i;
            result.add ( new DataEntry ( tx, eval ( tx ) ) );
        }

        return result;
    }

    protected abstract Double eval ( long timestamp );

}
