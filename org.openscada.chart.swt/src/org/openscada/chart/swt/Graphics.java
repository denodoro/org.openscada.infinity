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

package org.openscada.chart.swt;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * @author Jens Reimann
 * @see org.eclipse.swt.graphics.GC
 */
public interface Graphics
{

    public void setAlpha ( int alpha );

    public void setLineAttributes ( LineAttributes lineAttributes );

    public void drawLine ( int x1, int y1, int x2, int y2 );

    public void fillRectangle ( int x, int y, int width, int height );

    public Color getSystemColor ( int color );

    public void setForeground ( Color color );

    public void setBackground ( Color color );

    public void setClipping ( Rectangle rect );

    public void drawRectangle ( int x, int y, int width, int height );

    public void drawRectangle ( Rectangle rect );

    public Path createPath ();

    public void drawPath ( Path path );

    public void fillRectangle ( Rectangle rect );

    public void drawText ( String string, int x, int y, Float rotate );

    public Point textExtent ( String string );

    public void setAntialias ( boolean state );

    public FontMetrics getFontMetrics ();

}
