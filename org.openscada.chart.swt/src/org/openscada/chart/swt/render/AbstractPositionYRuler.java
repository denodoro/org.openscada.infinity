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
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.YAxis;

public abstract class AbstractPositionYRuler extends AbstractRuler
{

    protected YAxis axis;

    private int style;

    public AbstractPositionYRuler ( final YAxis axis, final int style )
    {
        this.axis = axis;
        this.style = style;
    }

    public void setStyle ( final int style )
    {
        this.style = style;
    }

    public void setAxis ( final YAxis axis )
    {
        this.axis = axis;
    }

    public abstract Double getPosition ();

    @Override
    protected void doRender ( final PaintEvent e, final Rectangle clientRectangle )
    {
        if ( this.axis == null )
        {
            return;
        }

        final Double position = getPosition ();
        if ( position == null )
        {
            return;
        }

        final int y = (int)this.axis.translateToClient ( clientRectangle.height, getPosition () );

        if ( ( this.style & SWT.TOP ) > 0 )
        {
            e.gc.fillRectangle ( 0, 0, clientRectangle.width, y );
        }
        else if ( ( this.style & SWT.BOTTOM ) > 0 )
        {
            e.gc.fillRectangle ( 0, y, clientRectangle.width, clientRectangle.height - y );
        }
        else
        {
            if ( y < 0 || y > clientRectangle.width )
            {
                return;
            }
            e.gc.drawLine ( 0, y, clientRectangle.width, y );
        }
    }

}