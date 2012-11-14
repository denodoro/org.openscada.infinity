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

package org.openscada.chart.swt;

import java.util.LinkedList;
import java.util.List;

public class Helper
{

    public static double nice ( final double value, final boolean round )
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

    public static class Entry<T>
    {
        public String label;

        public T value;

        public int position;

        public Entry ( final String label, final T value, final int position )
        {
            this.label = label;
            this.value = value;
            this.position = position;
        }

        @Override
        public String toString ()
        {
            return String.format ( "%s - %s - %s", this.label, this.value, this.position );
        }
    }

    public static List<Entry<Double>> chartValues ( final double min, final double max, final int pixels, final int labelHeight )
    {
        final int nticks = pixels / labelHeight;

        final double range = nice ( max - min, false );
        final double d = nice ( range / ( nticks - 1 ), true );

        final double graphmin = Math.floor ( min / d ) * d;
        final double graphmax = Math.ceil ( max / d ) * d;

        final int nfrac = Math.max ( -(int)Math.floor ( Math.log10 ( d ) ), 0 );

        final List<Entry<Double>> result = new LinkedList<Entry<Double>> ();
        for ( double x = graphmin; x <= graphmax + .5 * d; x += d )
        {
            final int position = (int) ( pixels - pixels / ( max - min ) * ( x - min ) );
            try
            {
                result.add ( new Entry<Double> ( String.format ( "%." + nfrac + "f", x ), x, position ) );
            }
            catch ( final Exception e )
            {
                // if anything goes wrong
                result.add ( new Entry<Double> ( String.format ( "%f", x ), x, position ) );
            }
        }

        return result;
    }
}
