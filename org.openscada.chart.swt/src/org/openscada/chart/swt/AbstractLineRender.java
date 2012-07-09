package org.openscada.chart.swt;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.LineAttributes;

public abstract class AbstractLineRender extends AbstractRenderer
{
    protected Color lineColor;

    protected LineAttributes lineAttributes;

    public AbstractLineRender ( final Series series )
    {
        super ( series );
        this.lineAttributes = new LineAttributes ( 1.0f );
    }

    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.lineAttributes = lineAttributes;
    }

    public void setLineWidth ( final float width )
    {
        this.lineAttributes.width = width;
    }

    public void setLineColor ( final Color lineColor )
    {
        this.lineColor = lineColor;
    }
}