package org.openscada.chart.swt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractStaticRenderer extends Canvas
{

    protected PropertyChangeListener propertyChangeListener;

    protected final LineAttributes lineAttributes;

    protected int labelSpacing;

    public AbstractStaticRenderer ( final Composite parent )
    {
        super ( parent, SWT.DOUBLE_BUFFERED );

        this.lineAttributes = new LineAttributes ( 1.0f, SWT.CAP_FLAT, SWT.JOIN_BEVEL, SWT.LINE_SOLID, new float[0], 0.0f, 0.0f );
        this.labelSpacing = 20;

        this.propertyChangeListener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };

        addPaintListener ( new PaintListener () {

            @Override
            public void paintControl ( final PaintEvent e )
            {
                onPaint ( e );
            }
        } );
        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );
    }

    protected abstract void onDispose ();

    protected abstract void onPaint ( PaintEvent e );

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        redraw ();
    }

    public void setLabelSpacing ( final int labelSpacing )
    {
        checkWidget ();

        this.labelSpacing = labelSpacing;
        redraw ();
    }

}
