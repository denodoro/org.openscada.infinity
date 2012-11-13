package org.openscada.chart.swt.test;

import java.util.LinkedList;
import java.util.List;

public class Axis
{
    public static void main ( final String[] args )
    {
        final String[] values = chartValues ( -10, 100, 1320, 30 );
        for ( int i = 0; i < values.length; i++ )
        {
            System.out.println ( i + " -> " + values[i] );
        }
    }

    private static double nice ( final double value, final boolean round )
    {
        final int exp = (int)Math.floor ( Math.log10 ( value ) );

        final double f = value / Math.pow ( 10.0, exp );

        double nf;

        if ( round )
        {
            if ( f < 1.5 )
            {
                nf = 1.0;
            }
            else if ( f < 3.0 )
            {
                nf = 2;
            }
            else if ( f < 7.0 )
            {
                nf = 5;
            }
            else
            {
                nf = 10;
            }
        }
        else
        {
            if ( f <= 1 )
            {
                nf = 1.0;
            }
            else if ( f <= 2.0 )
            {
                nf = 2;
            }
            else if ( f <= 5.0 )
            {
                nf = 5;
            }
            else
            {
                nf = 10;
            }
        }

        return nf * Math.pow ( 10.0, exp );
    }

    private static String[] chartValues ( final double min, final double max, final int pixels, final int labelHeight )
    {
        final int nticks = pixels / labelHeight;

        final double range = nice ( max - min, false );
        final double d = nice ( range / ( nticks - 1 ), true );

        final double graphmin = Math.floor ( min / d ) * d;
        final double graphmax = Math.ceil ( max / d ) * d;

        final int nfrac = Math.max ( -(int)Math.floor ( Math.log10 ( d ) ), 0 );

        final List<String> result = new LinkedList<String> ();
        for ( double x = graphmin; x <= graphmax + .5 * d; x += d )
        {
            result.add ( String.format ( "%." + nfrac + "f", x ) );
        }

        return result.toArray ( new String[result.size ()] );
    }

}
