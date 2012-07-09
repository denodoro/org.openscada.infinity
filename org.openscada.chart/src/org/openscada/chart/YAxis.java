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

import org.openscada.utils.beans.AbstractPropertyChange;

public class YAxis extends AbstractPropertyChange
{
    public static final String PROP_MIN = "min";

    public static final String PROP_MAX = "max";

    public static final String PROP_LABEL = "label";

    private double min;

    private double max;

    private String label;

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    public double getMin ()
    {
        return this.min;
    }

    public void setMin ( final double min )
    {
        firePropertyChange ( PROP_MIN, this.min, this.min = min );
    }

    public double getMax ()
    {
        return this.max;
    }

    public void setMax ( final double max )
    {
        firePropertyChange ( PROP_MAX, this.max, this.max = max );
    }

    public void setMinMax ( final double min, final double max )
    {
        setMin ( min );
        setMax ( max );
    }

    public void zoom ( final double factor )
    {
        final double diff = ( this.max - this.min ) * factor;

        setMinMax ( this.min + diff, this.max - diff );
    }

    public void transform ( final double offset, final int clientHeight )
    {
        final double diff = this.max - this.min;
        final double factor = diff / clientHeight;

        final double clientOffset = offset * factor;

        setMinMax ( this.min - clientOffset, this.max - clientOffset );
    }

    public float translateToClient ( final int height, final Double value )
    {
        final double diffY = this.max - this.min;
        final double factorY = height / diffY;

        return (float) ( height - factorY * ( value - this.min ) );

    }

    public double translateToValue ( final int height, final float position )
    {
        final double pos = 1.0 - position / height;

        final double diffX = this.max - this.min;

        return diffX * pos + this.min;
    }

}
