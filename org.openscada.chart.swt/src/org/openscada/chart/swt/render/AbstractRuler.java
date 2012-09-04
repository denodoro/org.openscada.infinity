package org.openscada.chart.swt.render;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.swt.Graphics;

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
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( !this.visible )
        {
            return;
        }

        if ( this.color == null )
        {
            g.setForeground ( g.getSystemColor ( SWT.COLOR_BLACK ) );
            g.setBackground ( g.getSystemColor ( SWT.COLOR_BLACK ) );
        }
        else
        {
            g.setForeground ( this.color );
            g.setBackground ( this.color );
        }

        g.setAlpha ( this.alpha );

        g.setLineAttributes ( this.lineAttributes != null ? this.lineAttributes : DEFAULT_LINE_ATTRIBUTES );

        doRender ( g, clientRectangle );
    }

    protected abstract void doRender ( Graphics g, Rectangle clientRectangle );

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        return null;
    }

}