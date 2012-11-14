package org.openscada.chart.swt.test;

import java.util.List;

import org.openscada.chart.swt.Helper;
import org.openscada.chart.swt.Helper.Entry;

public class YAxis
{
    public static void main ( final String[] args )
    {
        final List<Entry> values = Helper.chartValues ( -10, 100, 1320, 30 );
        for ( int i = 0; i < values.size (); i++ )
        {
            System.out.println ( i + " -> " + values.get ( i ) );
        }
    }

}
