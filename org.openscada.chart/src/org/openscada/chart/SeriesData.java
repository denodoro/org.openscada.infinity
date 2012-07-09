package org.openscada.chart;

import java.util.TreeSet;

public class SeriesData
{
    private final TreeSet<DataEntry> entries = new TreeSet<DataEntry> ();

    public boolean add ( final DataEntry entry )
    {
        return this.entries.add ( entry );
    }

    public TreeSet<DataEntry> getEntries ()
    {
        return this.entries;
    }
}
