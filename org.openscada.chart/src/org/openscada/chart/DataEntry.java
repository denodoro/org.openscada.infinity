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

import java.util.Date;

public class DataEntry implements Comparable<DataEntry>
{
    private final Date timestamp;

    private final Double value;

    public DataEntry ( final Date timestamp, final Double value )
    {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp ()
    {
        return this.timestamp;
    }

    public Double getValue ()
    {
        return this.value;
    }

    @Override
    public int compareTo ( final DataEntry o )
    {
        return this.timestamp.compareTo ( o.timestamp );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.timestamp == null ? 0 : this.timestamp.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final DataEntry other = (DataEntry)obj;
        if ( this.timestamp == null )
        {
            if ( other.timestamp != null )
            {
                return false;
            }
        }
        else if ( !this.timestamp.equals ( other.timestamp ) )
        {
            return false;
        }
        return true;
    }

}