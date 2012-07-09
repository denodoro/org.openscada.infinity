package org.openscada.chart.swt.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;

public class MouseZoomer implements MouseWheelListener
{
    private final XAxis x;

    private final YAxis y;

    private final ChartArea chart;

    public MouseZoomer ( final XAxis x, final YAxis y, final ChartArea chart )
    {
        this.x = x;
        this.y = y;
        this.chart = chart;

        this.chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                dispose ();
            }
        } );
        this.chart.addMouseWheelListener ( this );
    }

    public void dispose ()
    {
        this.chart.removeMouseWheelListener ( this );
    }

    @Override
    public void mouseScrolled ( final MouseEvent e )
    {
        if ( e.stateMask == 0 )
        {
            this.x.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        else if ( ( e.stateMask & SWT.MOD1 ) > 0 )
        {
            this.y.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        this.chart.redraw ();
    }
}