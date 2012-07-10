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

import java.util.SortedSet;
import java.util.TreeSet;

public class WritableSeriesData implements SeriesViewData
{

    private double minValue = Double.POSITIVE_INFINITY;

    private double maxValue = Double.NEGATIVE_INFINITY;

    private long minTimestamp = Long.MAX_VALUE;

    private long maxTimestamp = Long.MIN_VALUE;

    private final TreeSet<DataEntry> entries = new TreeSet<DataEntry> ();

    private final WritableSeries writableSeries;

    public WritableSeriesData ()
    {
        this ( null );
    }

    public WritableSeriesData ( final WritableSeries writableSeries )
    {
        this.writableSeries = writableSeries;
    }

    public boolean add ( final DataEntry entry )
    {
        this.minValue = minValue ( this.minValue, entry.getValue () );
        this.maxValue = maxValue ( this.maxValue, entry.getValue () );
        this.minTimestamp = Math.min ( this.minTimestamp, entry.getTimestamp () );
        this.maxTimestamp = Math.max ( this.maxTimestamp, entry.getTimestamp () );

        final boolean result = this.entries.add ( entry );

        if ( this.writableSeries != null )
        {
            this.writableSeries.fireUpdateListener ( entry.getTimestamp (), entry.getTimestamp () );
        }

        return result;
    }

    public void addAsLast ( final DataEntry entry )
    {
        this.entries.tailSet ( entry, true ).clear ();
        add ( entry );
    }

    public boolean remove ( final DataEntry entry )
    {
        final boolean result = this.entries.remove ( entry );

        this.writableSeries.fireUpdateListener ( entry.getTimestamp (), entry.getTimestamp () );

        return result;
    }

    private static double minValue ( final double a, final Double b )
    {
        if ( b == null )
        {
            return a;
        }

        return Math.min ( a, b );
    }

    private static double maxValue ( final double a, final Double b )
    {
        if ( b == null )
        {
            return a;
        }

        return Math.max ( a, b );
    }

    @Override
    public long getMaxTimestamp ()
    {
        return this.maxTimestamp;
    }

    @Override
    public long getMinTimestamp ()
    {
        return this.minTimestamp;
    }

    @Override
    public double getMaxValue ()
    {
        return this.maxValue;
    }

    @Override
    public double getMinValue ()
    {
        return this.minValue;
    }

    @Override
    public SortedSet<DataEntry> getEntries ()
    {
        return this.entries;
    }
}
