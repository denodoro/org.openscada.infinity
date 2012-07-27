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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFunctionSeriesData extends AbstractSeriesData
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractFunctionSeriesData.class );

    protected static final class Request
    {
        private final long start;

        private final long end;

        private final int width;

        public Request ( final long start, final long end, final int width )
        {
            super ();
            this.start = start;
            this.end = end;
            this.width = width;
        }

        public long getStart ()
        {
            return this.start;
        }

        public long getEnd ()
        {
            return this.end;
        }

        public int getWidth ()
        {
            return this.width;
        }

        @Override
        public String toString ()
        {
            return String.format ( "%s - >%s #%s", this.start, this.end, this.width );
        }
    }

    protected Request request;

    public AbstractFunctionSeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        super ( realm, xAxis, yAxis );
    }

    protected WritableSeriesData makeData ( final Request request )
    {
        final WritableSeriesData result = new WritableSeriesData ();

        final long startTimestamp = request.getStart ();
        final long endTimestamp = request.getEnd ();

        final double step = (double) ( endTimestamp - startTimestamp ) / (double)request.getWidth ();

        for ( double i = startTimestamp; i < endTimestamp; i += step )
        {
            final long tx = (long)i;
            result.add ( new DataEntry ( tx, eval ( tx ) ) );
        }
        return result;
    }

    protected abstract Double eval ( long timestamp );

    @Override
    public void setRequestWidth ( final int width )
    {
        final Request request = this.request;
        setRequest ( new Request ( request.getStart (), request.getEnd (), width ) );
    }

    @Override
    public void setRequestWindow ( final long startTimestamp, final long endTimestamp )
    {
        final Request request = this.request;
        setRequest ( new Request ( startTimestamp, endTimestamp, request.getWidth () ) );
    }

    protected void setRequest ( final Request request )
    {
        logger.debug ( "Setting request: {}", request );
        this.request = request;
    }
}
