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
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Composite;
import org.openscada.chart.swt.YAxis;

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
