package org.openscada.chart.swt.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.render.Renderer;

public class MouseDragZoomer implements Renderer
{
    private final ChartArea chart;

    private final MouseMoveListener mouseMoveListener;

    private Point start;

    private Rectangle selection;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseDragZoomer ( final ChartArea chart, final XAxis xAxis, final YAxis yAxis )
    {
        this.chart = chart;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        chart.addRenderer ( this );

        this.mouseMoveListener = new MouseMoveListener () {

            @Override
            public void mouseMove ( final MouseEvent e )
            {
                handleMouseMove ( e );
            }
        };

        chart.addMouseListener ( new MouseAdapter () {

            @Override
            public void mouseUp ( final MouseEvent e )
            {
                endZoom ( e );
            }

            @Override
            public void mouseDown ( final MouseEvent e )
            {
                if ( e.button == 1 && e.stateMask == 0 )
                {
                    startZoom ( e );
                }
            }

        } );

        chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                dispose ();
            }
        } );
    }

    private void detachMouseMoveListener ()
    {
        this.chart.removeMouseMoveListener ( this.mouseMoveListener );
    }

    public void dispose ()
    {
        this.chart.removeRenderer ( this );
        detachMouseMoveListener ();
    }

    protected void endZoom ( final MouseEvent e )
    {
        processZoom ( this.selection );
        detachMouseMoveListener ();
        this.selection = null;
        this.chart.redraw ();
    }

    protected void startZoom ( final MouseEvent e )
    {
        this.chart.addMouseMoveListener ( this.mouseMoveListener );
        this.start = new Point ( e.x, e.y );
    }

    protected void handleMouseMove ( final MouseEvent e )
    {
        this.selection = makeSelection ( new Point ( e.x, e.y ) );
        this.chart.redraw ();
    }

    private Rectangle makeSelection ( final Point point )
    {
        return new Rectangle ( this.start.x, this.start.y, point.x - this.start.x, point.y - this.start.y );
    }

    @Override
    public void render ( final PaintEvent e, final Rectangle clientRectangle )
    {
        if ( this.selection != null )
        {
            e.gc.setLineAttributes ( new LineAttributes ( 1.0f ) );
            e.gc.setForeground ( e.gc.getDevice ().getSystemColor ( SWT.COLOR_BLACK ) );

            e.gc.drawRectangle ( this.selection );
        }
    }

    @Override
    public void resize ( final Rectangle clientRectangle )
    {
        // NO-OP
    }

    private void processZoom ( final Rectangle selection )
    {
        if ( selection == null )
        {
            return;
        }

        final Rectangle client = this.chart.getClientArea ();

        if ( selection.width > 0 && selection.height > 0 )
        {
            // zoom in
            final long minTimestamp = this.xAxis.translateToValue ( client.width, selection.x );
            final long maxTimestamp = this.xAxis.translateToValue ( client.width, selection.x + selection.width );

            final double maxValue = this.yAxis.translateToValue ( client.height, selection.y );
            final double minValue = this.yAxis.translateToValue ( client.height, selection.y + selection.height );

            this.xAxis.setMinMax ( minTimestamp, maxTimestamp );
            this.yAxis.setMinMax ( minValue, maxValue );

        }
    }
}
