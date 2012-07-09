package org.openscada.chart.swt;

import java.util.TreeSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;

public class QualityRenderer extends AbstractRenderer
{

    public QualityRenderer ( final Series series )
    {
        super ( series );
    }

    @Override
    public void render ( final Rectangle clientRect, final PaintEvent e )
    {
        final GC gc = e.gc;

        final TreeSet<DataEntry> entries = this.series.getData ().getEntries ();
        if ( entries.isEmpty () )
        {
            // FIXME: draw full rect
            return;
        }

        final DataPoint point = new DataPoint ();

        final XAxis xAxis = this.series.getXAxis ();
        final YAxis yAxis = this.series.getYAxis ();

        gc.setBackground ( gc.getDevice ().getSystemColor ( SWT.COLOR_RED ) );
        gc.setAlpha ( 128 );

        Integer lastPosition = null;
        Integer lastValidPosition = null;

        final DataEntry first = entries.first ();
        translateToPoint ( clientRect, xAxis, yAxis, point, first );
        if ( point.x > 0 )
        {
            e.gc.fillRectangle ( 0, 0, (int)point.x, clientRect.height );
        }

        final DataEntry last = entries.last ();
        translateToPoint ( clientRect, xAxis, yAxis, point, last );
        if ( point.x > 0 && point.x < clientRect.width )
        {
            e.gc.fillRectangle ( (int)point.x, 0, (int) ( clientRect.width - point.x ), clientRect.height );
        }

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

            if ( lastPosition != null )
            {
                e.gc.fillRectangle ( lastPosition, 0, (int)point.x - lastPosition, clientRect.height );
            }

            if ( !hasData )
            {
                if ( lastValidPosition != null && lastPosition == null )
                {
                    e.gc.fillRectangle ( lastValidPosition, 0, (int)point.x - lastValidPosition, clientRect.height );
                }
                lastPosition = (int)point.x;
            }
            else
            {
                lastValidPosition = (int)point.x;
                lastPosition = null;
            }
        }

    }
}
