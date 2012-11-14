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

package org.openscada.chart.swt.test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openscada.chart.swt.Helper;
import org.openscada.chart.swt.Helper.Entry;

public class XAxis
{
    protected static void test ( final TimeUnit unit, final int diff, final int pixels, final int labelSize )
    {
        final long max = System.currentTimeMillis ();
        final long min = max - unit.toMillis ( diff );

        final int nticks = pixels / labelSize;

        final long range = max - min;
        final long step = (long)Helper.niceNum ( range / ( nticks - 1 ), true );

        final long graphmin = (long) ( Math.floor ( min / step ) * step );
        final long graphmax = (long) ( Math.ceil ( max / step ) * step );

        final List<Entry<Long>> values = Helper.chartTimes ( min, max, 1320, 100, Helper.makeFormat ( range ) );

        System.out.println ( "Range: " + range );
        System.out.println ( "Step: " + step );

        System.out.println ( String.format ( "%1$tF %1$tT.%1$TL", new Date ( graphmin ) ) );
        System.out.println ( String.format ( "%1$tF %1$tT.%1$TL", new Date ( graphmax ) ) );

        for ( int i = 0; i < values.size (); i++ )
        {
            System.out.print ( i + " -> " + values.get ( i ) );
            System.out.println ();
        }
    }

    public static void main ( final String[] args )
    {
        test ( TimeUnit.HOURS, 1, 1320, 80 );
    }

}
