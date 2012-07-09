package org.openscada.chart.swt;

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

        final double diffY = this.max - this.min;

        return diffY * pos + this.min;
    }

}
