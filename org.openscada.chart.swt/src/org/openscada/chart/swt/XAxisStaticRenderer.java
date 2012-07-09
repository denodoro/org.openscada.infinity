package org.openscada.chart.swt;

import java.beans.PropertyChangeEvent;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class XAxisStaticRenderer extends AbstractStaticRenderer
{

    private XAxis axis;

    private final boolean bottom;

    public XAxisStaticRenderer ( final Composite parent, final int style )
    {
        super ( parent );

        this.bottom = ( style & SWT.TOP ) > 0;
    }

    @Override
    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        redraw ();
    }

    @Override
    protected void onDispose ()
    {
        setAxis ( null );
    }

    public void setAxis ( final XAxis axis )
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

        final int y = this.bottom ? rect.height - 1 : 0;

        e.gc.drawLine ( 0, y, rect.width, y );

        int x = 0;
        do
        {
            final long time = this.axis.translateToValue ( rect.width, x );
            final String label = String.format ( "%tc", new Date ( time ) );
            final Point labelSize = e.gc.textExtent ( label );
            e.gc.drawText ( label, x, this.bottom ? y - ( labelSize.y + 5 ) : 5 );
            e.gc.drawLine ( x, y, x, this.bottom ? y - 3 : 3 );
            x += labelSize.x + this.labelSpacing;

        } while ( x < rect.width );

        // drawLabel

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            final Point size = e.gc.textExtent ( label );
            final int labelX = rect.width / 2 - size.x / 2;
            e.gc.drawText ( label, labelX, this.bottom ? 0 : rect.height - size.y );
        }
    }

    @Override
    public Point computeSize ( final int wHint, final int hHint, final boolean changed )
    {
        return new Point ( wHint, 60 );
    }

}
