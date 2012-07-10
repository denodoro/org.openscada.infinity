package org.openscada.chart.swt.render;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AbstractRuler implements Renderer
{

    protected Color color;

    protected boolean visible = true;

    private int alpha = 255;

    private static final LineAttributes DEFAULT_LINE_ATTRIBUTES = new LineAttributes ( 1.0f );

    private LineAttributes lineAttributes = DEFAULT_LINE_ATTRIBUTES;

    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.lineAttributes = lineAttributes;
    }

    public void setVisible ( final boolean visible )
    {
        this.visible = visible;
    }

    public void setColor ( final Color color )
    {
        this.color = color;
    }

    public void setAlpha ( final int alpha )
    {
        this.alpha = alpha;
    }

    @Override
    public void render ( final PaintEvent e, final Rectangle clientRectangle )
    {
        if ( !this.visible )
        {
            return;
        }

        if ( this.color == null )
        {
            e.gc.setForeground ( e.gc.getDevice ().getSystemColor ( SWT.COLOR_BLACK ) );
            e.gc.setBackground ( e.gc.getDevice ().getSystemColor ( SWT.COLOR_BLACK ) );
        }
        else
        {
            e.gc.setForeground ( this.color );
            e.gc.setBackground ( this.color );
        }

        e.gc.setAlpha ( this.alpha );

        e.gc.setLineAttributes ( this.lineAttributes != null ? this.lineAttributes : DEFAULT_LINE_ATTRIBUTES );

        doRender ( e, clientRectangle );
    }

    protected abstract void doRender ( PaintEvent e, Rectangle clientRectangle );

    @Override
    public void resize ( final Rectangle clientRectangle )
    {
    }

}