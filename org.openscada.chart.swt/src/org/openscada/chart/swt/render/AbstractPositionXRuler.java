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

import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.XAxis;
import org.openscada.chart.swt.Graphics;

public abstract class AbstractPositionXRuler extends AbstractRuler
{

    public abstract Long getPosition ();

    protected XAxis axis;

    public AbstractPositionXRuler ( final XAxis axis )
    {
        this.axis = axis;
    }

    public void setAxis ( final XAxis axis )
    {
        this.axis = axis;
    }

    @Override
    protected void doRender ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.axis == null )
        {
            return;
        }

        final Long position = getPosition ();

        if ( position == null )
        {
            return;
        }

        final int x = (int)this.axis.translateToClient ( clientRectangle.width, position );

        if ( x < 0 || x > clientRectangle.width )
        {
            return;
        }

        g.drawLine ( clientRectangle.x + x, clientRectangle.y, clientRectangle.x + x, clientRectangle.y + clientRectangle.height );
    }

}