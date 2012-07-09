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
