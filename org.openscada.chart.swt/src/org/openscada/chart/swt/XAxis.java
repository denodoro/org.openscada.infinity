package org.openscada.chart.swt;

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
        setMin ( min );
        setMax ( max );
    }

    public void zoom ( final double factor )
    {
        double diff = this.max - this.min;
        diff = diff * factor;

        setMinMax ( (long) ( this.min + diff ), (long) ( this.max - diff ) );
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

}
