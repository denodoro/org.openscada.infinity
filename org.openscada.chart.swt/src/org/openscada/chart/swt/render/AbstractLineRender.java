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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.LineAttributes;
import org.openscada.chart.SeriesData;
import org.openscada.chart.swt.ChartArea;

public abstract class AbstractLineRender extends AbstractDataSeriesRenderer
{
    protected Color lineColor;

    protected LineAttributes lineAttributes;

    public AbstractLineRender ( final ChartArea chartArea, final SeriesData seriesData )
    {
        super ( chartArea, seriesData );
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

    public float getLineWidth ()
    {
        return this.lineAttributes.width;
    }

    public void setLineColor ( final Color lineColor )
    {
        this.lineColor = lineColor;
    }
}