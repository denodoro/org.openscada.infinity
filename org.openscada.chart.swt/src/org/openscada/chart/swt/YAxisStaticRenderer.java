package org.openscada.chart.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Composite;

public class YAxisStaticRenderer extends AbstractStaticRenderer
{
    private YAxis axis;

    private String format;

    private final boolean left;

    public YAxisStaticRenderer ( final Composite parent, final int style )
    {
        super ( parent );

        this.left = ( style & SWT.RIGHT ) > 0;
    }

    public void setFormat ( final String format )
    {
        this.format = format != null ? format : "%s";
    }

    @Override
    protected void onDispose ()
    {
        setAxis ( null );
    }

    public void setAxis ( final YAxis axis )
    {
        checkWidget ();

        if ( this.axis != null )
        {
            this.axis.removePropertyChangeListener ( this.propertyChangeListener );
            this.axis = null;
        }

        this.axis = axis;

        if ( this.axis != null )
        {
            this.axis.addPropertyChangeListener ( this.propertyChangeListener );
            redraw ();
        }
    }

    @Override
    protected void onPaint ( final PaintEvent e )
    {
        final Rectangle rect = getClientArea ();
        if ( rect.width == 0 || rect.height == 0 )
        {
            return;
        }
        e.gc.setLineAttributes ( this.lineAttributes );

        final int x = this.left ? 0 : rect.width - 1;

        e.gc.drawLine ( x, 0, x, rect.height );

        int y = findStart ( rect );

        do
        {
            final double value = this.axis.translateToValue ( rect.height, y );
            final String label = String.format ( this.format, value );
            final Point labelSize = e.gc.textExtent ( label );
            e.gc.drawText ( label, this.left ? x + 10 : x - ( labelSize.x + 10 ), y - labelSize.y );
            e.gc.drawLine ( x, y, x + ( this.left ? 1 : -1 ) * 4, y );
            y -= labelSize.y + this.labelSpacing;

        } while ( y > 0 );

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            final Transform rotate = new Transform ( e.gc.getDevice () ); // FIXME: should be cached
            try
            {
                rotate.rotate ( -90 );
                e.gc.setTransform ( rotate );
                final Point size = e.gc.textExtent ( label );
                e.gc.drawText ( label, -rect.height + rect.height / 2 - size.x / 2, this.left ? rect.width - size.y : 0 );
            }
            finally
            {
                rotate.dispose ();
            }
        }
    }

    private int findStart ( final Rectangle rect )
    {
        return rect.height - 1;
    }

    @Override
    public Point computeSize ( final int wHint, final int hHint, final boolean changed )
    {
        return new Point ( 100, hHint );
    }

}
