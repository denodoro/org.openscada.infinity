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
import org.openscada.chart.DataEntry;
import org.openscada.chart.Series;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.DataPoint;

public abstract class AbstractRenderer implements Renderer
{

    protected final Series series;

    public AbstractRenderer ( final Series series )
    {
        this.series = series;
    }

    protected static boolean translateToPoint ( final Rectangle clientRect, final XAxis x, final YAxis y, final DataPoint point, final DataEntry entry )
    {
        point.x = x.translateToClient ( clientRect.width, entry.getTimestamp () );

        final Double value = entry.getValue ();
        if ( value == null )
        {
            return false;
        }

        point.y = y.translateToClient ( clientRect.height, value );

        return true;
    }

}