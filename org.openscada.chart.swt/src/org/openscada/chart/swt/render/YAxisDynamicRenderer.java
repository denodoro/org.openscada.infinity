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
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Composite;
import org.openscada.chart.swt.YAxis;

public class YAxisDynamicRenderer extends AbstractStaticRenderer
{

    private YAxis axis;

    private String format;

    private final boolean left;

    private Double step;

    private final Transform rotate;

    public YAxisDynamicRenderer ( final Composite parent, final int style )
    {
        super ( parent );

        this.rotate = createTransform ( parent.getDisplay () );

        this.left = ( style & SWT.RIGHT ) > 0;
    }

    public void setFormat ( final String format )
    {
        this.format = format != null ? format : "%s";
    }

    @Override
    protected void onDispose ()
    {
        this.rotate.dispose ();
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

        final Point sampleLabelSize = e.gc.textExtent ( String.format ( this.format, this.axis.getMin () ) );
        final double step = this.step != null ? this.step : makeDynamicStep ( sampleLabelSize.y + this.labelSpacing, rect.height, this.axis.getMax () - this.axis.getMin () );
        double value = stepValue ( this.axis.getMin (), step );

        while ( value < this.axis.getMax () )
        {
            value = value + step;
            final int y = (int)this.axis.translateToClient ( rect.height, value );

            final String label = String.format ( this.format, value );
            final Point labelSize = e.gc.textExtent ( label );
            e.gc.drawText ( label, this.left ? x + 10 : x - ( labelSize.x + 10 ), y - labelSize.y / 2 );
            e.gc.drawLine ( x, y, x + ( this.left ? 1 : -1 ) * 8, y );
        }

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            final Transform rotate = new Transform ( e.gc.getDevice () );
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

    private double makeDynamicStep ( final int textHeight, final int clientHeight, final double valueHeight )
    {
        return valueHeight / ( clientHeight / textHeight );
    }

    private double stepValue ( final double value, final double step )
    {
        return Math.floor ( value / step ) * step;
    }

    @Override
    public Point computeSize ( final int wHint, final int hHint, final boolean changed )
    {
        return new Point ( 100, hHint );
    }

    public void setStep ( final Double step )
    {
        this.step = step;
    }

    private Transform createTransform ( final Device device )
    {
        final Transform rotate = new Transform ( device );
        rotate.rotate ( -90 );
        return rotate;
    }

}
