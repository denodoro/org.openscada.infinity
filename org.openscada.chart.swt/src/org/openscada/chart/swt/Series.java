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
