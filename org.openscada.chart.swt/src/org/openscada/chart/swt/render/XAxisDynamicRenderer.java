/*
 * This file is part of the openSCADA project
 * Copyright (C) 2011-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

package org.openscada.chart.swt.render;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.openscada.chart.XAxis;

public class XAxisDynamicRenderer extends AbstractStaticRenderer
{

    private XAxis axis;

    private final boolean bottom;

    private Long step;

    private String format = "%tc";

    public XAxisDynamicRenderer ( final Composite parent, final int style )
    {
        super ( parent );

        this.bottom = ( style & SWT.TOP ) > 0;
    }

    public void setFormat ( final String format )
    {
        this.format = format;
    }

    public void setStep ( final Long step )
    {
        this.step = step;
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

        final Point sampleLabelSize = e.gc.textExtent ( String.format ( this.format, this.axis.getMin () ) );
        final long step = this.step != null ? this.step : makeDynamicStep ( sampleLabelSize.x + this.labelSpacing, rect.width, this.axis.getMax () - this.axis.getMin () );

        if ( step <= 0 )
        {
            return;
        }

        long value = stepValue ( this.axis.getMin () - step /*previous step*/, step );

        while ( value < this.axis.getMax () )
        {
            value = value + step;
            final int x = (int)this.axis.translateToClient ( rect.width, value );

            final String label = String.format ( this.format, value );
            final Point labelSize = e.gc.textExtent ( label );

            e.gc.drawText ( label, x, this.bottom ? y - ( labelSize.y + 5 ) : 5 );
            e.gc.drawLine ( x, y, x, this.bottom ? y - 3 : 3 );
        }

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

    private long makeDynamicStep ( final int textWidth, final int clientWidth, final long valueWidth )
    {
        final long l = clientWidth / textWidth;
        if ( l == 0 )
        {
            return 0;
        }

        return valueWidth / l;
    }

    private long stepValue ( final long value, final long step )
    {
        return (long) ( Math.floor ( (double)value / (double)step ) * step );
    }

}
