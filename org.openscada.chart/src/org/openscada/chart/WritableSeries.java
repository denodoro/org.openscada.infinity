package org.openscada.chart;


public class WritableSeries extends Series
{

    private WritableSeriesData data = new WritableSeriesData ();

    public WritableSeries ( final XAxis xAxis, final YAxis yAxis )
    {
        super ( xAxis, yAxis );
    }

    public void setData ( final WritableSeriesData data )
    {
        this.data = data;
    }

    @Override
    public WritableSeriesData getData ()
    {
        return this.data;
    }
}
