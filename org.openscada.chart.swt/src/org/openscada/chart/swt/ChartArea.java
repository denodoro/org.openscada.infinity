package org.openscada.chart.swt;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class ChartArea extends Canvas
{

    private final List<SeriesRenderer> renderers = new LinkedList<SeriesRenderer> ();

    public ChartArea ( final Composite parent, final int style )
    {
        super ( parent, style | SWT.DOUBLE_BUFFERED );

        addPaintListener ( new PaintListener () {

            @Override
            public void paintControl ( final PaintEvent e )
            {
                onPaint ( e );
            }
        } );

    }

    protected void onPaint ( final PaintEvent e )
    {
        final Rectangle rect = getClientArea ();
        if ( rect.width == 0 || rect.height == 0 )
        {
            return;
        }

        e.gc.setAntialias ( SWT.ON );

        for ( final SeriesRenderer renderer : this.renderers )
        {
            renderer.render ( rect, e );
        }

    }

    public void addRenderer ( final SeriesRenderer renderer )
    {
        this.renderers.add ( renderer );
    }

    public void removeRenderer ( final SeriesRenderer renderer )
    {
        this.renderers.remove ( renderer );
    }

    public XAxis createXAxis ()
    {
        final XAxis axis = new XAxis ();
        return axis;
    }

    public YAxis createYAxis ()
    {
        final YAxis axis = new YAxis ();
        return axis;
    }

}
