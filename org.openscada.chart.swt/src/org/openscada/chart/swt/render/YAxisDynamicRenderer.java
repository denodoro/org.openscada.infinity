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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;

public class YAxisDynamicRenderer extends AbstractRenderer
{
    private YAxis axis;

    private String format = "%s";

    private boolean left;

    private Double step;

    private final Transform rotate;

    private final PropertyChangeListener propertyChangeListener;

    private Rectangle rect;

    private int width = -1;

    protected final LineAttributes lineAttributes;

    private final int labelSpacing;

    public YAxisDynamicRenderer ( final ChartArea chartArea )
    {
        super ( chartArea );

        this.rotate = createTransform ( chartArea.getDisplay () );

        this.lineAttributes = new LineAttributes ( 1.0f, SWT.CAP_FLAT, SWT.JOIN_BEVEL, SWT.LINE_SOLID, new float[0], 0.0f, 0.0f );
        this.labelSpacing = 20;

        this.propertyChangeListener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };
    }

    public void setWidth ( final int width )
    {
        this.width = width;
    }

    public int getWidth ()
    {
        return this.width;
    }

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        redraw ();
    }

    public void setAlign ( final int alignment )
    {
        this.left = ( alignment & SWT.RIGHT ) != SWT.RIGHT;
        redraw ();
    }

    public void setFormat ( final String format )
    {
        this.format = format != null ? format : "%s";
        redraw ();
    }

    public String getFormat ()
    {
        return this.format;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
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

    private double makeDynamicStep ( final int textHeight, final int clientHeight, final double valueHeight )
    {
        return valueHeight / ( clientHeight / textHeight );
    }

    private double stepValue ( final double value, final double step )
    {
        return Math.floor ( value / step ) * step;
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

    @Override
    public void render ( final PaintEvent e, final Rectangle clientRectangle )
    {
        if ( this.rect.width == 0 || this.rect.height == 0 )
        {
            return;
        }

        e.gc.setClipping ( this.rect );

        e.gc.setLineAttributes ( this.lineAttributes );

        final int x = ( this.left ? this.rect.width - 1 : 0 ) + this.rect.x;

        e.gc.drawLine ( x, this.rect.y, x, this.rect.y + this.rect.height );

        final Point sampleLabelSize = e.gc.textExtent ( String.format ( this.format, this.axis.getMin () ) );
        final double step = this.step != null ? this.step : makeDynamicStep ( sampleLabelSize.y + this.labelSpacing, this.rect.height, this.axis.getMax () - this.axis.getMin () );
        double value = stepValue ( this.axis.getMin (), step );

        while ( value < this.axis.getMax () )
        {
            value = value + step;
            final int y = (int)this.axis.translateToClient ( this.rect.height, value ) + this.rect.y;

            final String label = String.format ( this.format, value );
            final Point labelSize = e.gc.textExtent ( label );
            e.gc.drawText ( label, this.left ? x - ( labelSize.x + 10 ) : x + 10, y - labelSize.y / 2 );
            e.gc.drawLine ( x, y, x + ( this.left ? -1 : 1 ) * 8, y );
        }

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            try
            {
                e.gc.setTransform ( this.rotate );
                final Point size = e.gc.textExtent ( label );
                e.gc.drawText ( label, -this.rect.height + this.rect.height / 2 - size.x / 2, !this.left ? this.rect.width - size.y : 0 );
            }
            finally
            {
                e.gc.setTransform ( null );
            }
        }
        e.gc.setClipping ( (Rectangle)null );
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        final int width = this.width >= 0 ? this.width : calcWidth ();

        if ( this.left )
        {
            this.rect = new Rectangle ( clientRectangle.x, clientRectangle.y, width, clientRectangle.height );
            return new Rectangle ( clientRectangle.x + width, clientRectangle.y, clientRectangle.width - width, clientRectangle.height );
        }
        else
        {
            this.rect = new Rectangle ( clientRectangle.x + clientRectangle.width - width, clientRectangle.y, width, clientRectangle.height );
            return new Rectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width - width, clientRectangle.height );
        }
    }

    private int calcWidth ()
    {
        return 100;
    }

}
