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
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

public class SWTGraphics implements Graphics
{

    private final GC gc;

    public SWTGraphics ( final GC gc )
    {
        this.gc = gc;
    }

    @Override
    public void setAlpha ( final int alpha )
    {
        this.gc.setAlpha ( alpha );
    }

    @Override
    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.gc.setLineAttributes ( lineAttributes );
    }

    @Override
    public void drawLine ( final int x1, final int y1, final int x2, final int y2 )
    {
        this.gc.drawLine ( x1, y1, x2, y2 );
    }

    @Override
    public void fillRectangle ( final int x, final int y, final int width, final int height )
    {
        this.gc.fillRectangle ( x, y, width, height );
    }

    @Override
    public void setBackground ( final Color color )
    {
        this.gc.setBackground ( color );
    }

    @Override
    public void setClipping ( final Rectangle rect )
    {
        this.gc.setClipping ( rect );
    }

    @Override
    public void setForeground ( final Color color )
    {
        this.gc.setForeground ( color );
    }

    @Override
    public Color getSystemColor ( final int color )
    {
        return this.gc.getDevice ().getSystemColor ( color );
    }

    @Override
    public void drawRectangle ( final int x, final int y, final int width, final int height )
    {
        this.gc.drawRectangle ( x, y, width, height );
    }

    @Override
    public void drawRectangle ( final Rectangle rect )
    {
        this.gc.drawRectangle ( rect );
    }

    @Override
    public Path createPath ()
    {
        return new Path ( this.gc.getDevice () );
    }

    @Override
    public void drawPath ( final Path path )
    {
        this.gc.drawPath ( path );
    }

    @Override
    public void fillRectangle ( final Rectangle rect )
    {
        this.gc.fillRectangle ( rect );
    }

    @Override
    public void drawText ( final String string, final int x, final int y, final Float rotate )
    {
        final Transform t;

        if ( rotate != null )
        {
            t = new Transform ( this.gc.getDevice () );
            t.rotate ( rotate );
        }
        else
        {
            t = null;
        }

        this.gc.setTransform ( t );
        this.gc.drawText ( string, x, y );

        this.gc.setTransform ( null );

        if ( t != null )
        {
            t.dispose ();
        }
    }

    @Override
    public Point textExtent ( final String string )
    {
        return this.gc.textExtent ( string );
    }

}
