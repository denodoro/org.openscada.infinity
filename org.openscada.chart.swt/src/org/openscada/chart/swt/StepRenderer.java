package org.openscada.chart.swt;

import java.util.TreeSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.DataEntry;

public class StepRenderer extends AbstractLineRender implements SeriesRenderer
{

    public StepRenderer ( final Series series )
    {
        super ( series );
    }

    @Override
    public void render ( final Rectangle clientRect, final PaintEvent e )
    {
        final GC gc = e.gc;

        final Path path = new Path ( gc.getDevice () );

        boolean first = true;

        final TreeSet<DataEntry> entries = this.series.getData ().getEntries ();
        if ( entries.isEmpty () )
        {
            return;
        }

        final DataPoint point = new DataPoint ();
        Float previousY = null;

        final XAxis xAxis = this.series.getXAxis ();
        final YAxis yAxis = this.series.getYAxis ();

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );
            if ( hasData )
            {
                if ( first )
                {
                    first = false;
                    path.moveTo ( point.x, point.y );
                }
                else
                {
                    path.lineTo ( point.x, previousY );
                    path.lineTo ( point.x, point.y );
                }
                previousY = point.y;
            }
            else
            {
                first = true;
            }
        }

        gc.setLineAttributes ( this.lineAttributes );
        gc.setForeground ( this.lineColor != null ? this.lineColor : gc.getDevice ().getSystemColor ( SWT.COLOR_BLACK ) );
        gc.drawPath ( path );
    }
}
