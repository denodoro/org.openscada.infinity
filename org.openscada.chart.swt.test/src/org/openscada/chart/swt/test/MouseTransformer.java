package org.openscada.chart.swt.test;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.XAxis;
import org.openscada.chart.swt.YAxis;

public class MouseTransformer implements MouseListener, MouseMoveListener
{

    private boolean active;

    private int startX;

    private int startY;

    private final ChartArea chartArea;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseTransformer ( final ChartArea chartArea, final XAxis xAxis, final YAxis yAxis )
    {
        this.chartArea = chartArea;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public void mouseDoubleClick ( final MouseEvent e )
    {
    }

    @Override
    public void mouseDown ( final MouseEvent e )
    {
        this.active = true;
        this.startX = e.x;
        this.startY = e.y;
    }

    @Override
    public void mouseUp ( final MouseEvent e )
    {
        this.active = false;
    }

    @Override
    public void mouseMove ( final MouseEvent e )
    {
        if ( !this.active )
        {
            return;
        }

        final int diffX = this.startX - e.x;
        this.startX = e.x;

        final int diffY = this.startY - e.y;
        this.startY = e.y;

        final Rectangle rect = this.chartArea.getClientArea ();
        boolean update = false;
        if ( rect.width > 0 )
        {
            this.xAxis.transform ( diffX, rect.width );
            update = true;
        }
        if ( rect.height > 0 )
        {
            this.yAxis.transform ( diffY, rect.height );
            update = true;
        }

        if ( update )
        {
            this.chartArea.redraw ();
        }
    }

}
