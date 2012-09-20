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

import java.util.concurrent.TimeUnit;

import org.openscada.utils.beans.AbstractPropertyChange;

public class XAxis extends AbstractPropertyChange
{
    public static final String PROP_MIN = "min";

    public static final String PROP_MAX = "max";

    public static final String PROP_LABEL = "label";

    private long min;

    private long max;

    private String label;

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    public long getMin ()
    {
        return this.min;
    }

    public void setMin ( final long min )
    {
        firePropertyChange ( PROP_MIN, this.min, this.min = min );
    }

    public long getMax ()
    {
        return this.max;
    }

    public void setMax ( final long max )
    {
        firePropertyChange ( PROP_MAX, this.max, this.max = max );
    }

    public void setMinMax ( final long min, final long max )
    {
        if ( min >= max )
        {
            return;
        }

        setMin ( min );
        setMax ( max );
    }

    public void zoom ( final double factor )
    {
        double diff = this.max - this.min;
        diff = diff * factor;

        if ( factor > 1.0 )
        {
            setMinMax ( (long) ( this.min - diff ), (long) ( this.max + diff ) );
        }
        else
        {
            setMinMax ( (long) ( this.min + diff ), (long) ( this.max - diff ) );
        }
    }

    public void transform ( final long offset, final int clientWidth )
    {
        final long diff = this.max - this.min;
        final double factor = (double)diff / (double)clientWidth;

        final long clientOffset = (long) ( offset * factor );

        setMinMax ( this.min + clientOffset, this.max + clientOffset );
    }

    public float translateToClient ( final int width, final long time )
    {
        final double diffX = this.max - this.min;
        final double factorX = width / diffX;

        return (float) ( factorX * ( time - this.min ) );
    }

    public long translateToValue ( final int width, final float position )
    {
        final double pos = position / width;

        final long diffX = this.max - this.min;

        return (long) ( diffX * pos ) + this.min;
    }

    public void setByTimespan ( final long amount, final TimeUnit timeUnit )
    {
        final long millis = timeUnit.toMillis ( amount );

        final long pos = this.min + ( this.max - this.min ) / 2;
        setMinMax ( pos - millis / 2, pos + millis / 2 );
    }

    public void shiftByTimespan ( final long duration, final TimeUnit timeUnit )
    {
        final long millis = timeUnit.toMillis ( duration );
        setMinMax ( this.min + millis, this.max + millis );
    }

    public void setNowCenter ()
    {
        final long diff = this.max - this.min;
        final long now = System.currentTimeMillis ();
        setMinMax ( now - diff / 2, now + diff / 2 );
    }

    /**
     * Set the start timestamp but don't change the period
     * 
     * @param milliseconds
     *            the new start timestamp
     */
    public void setStartTimestamp ( final long milliseconds )
    {
        final long diff = this.max - this.min;
        setMinMax ( milliseconds, milliseconds + diff );
    }

}
