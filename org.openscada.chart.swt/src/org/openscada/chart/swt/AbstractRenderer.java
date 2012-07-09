package org.openscada.chart.swt;

import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;

public abstract class AbstractRenderer implements SeriesRenderer
{

    protected final Series series;

    public AbstractRenderer ( final Series series )
    {
        this.series = series;
    }

    protected static boolean translateToPoint ( final Rectangle clientRect, final XAxis x, final YAxis y, final DataPoint point, final DataEntry entry )
    {
        point.x = x.translateToClient ( clientRect.width, entry.getTimestamp ().getTime () );

        final Double value = entry.getValue ();
        if ( value == null )
        {
            return false;
        }

        point.y = y.translateToClient ( clientRect.height, value );

        return true;
    }

}