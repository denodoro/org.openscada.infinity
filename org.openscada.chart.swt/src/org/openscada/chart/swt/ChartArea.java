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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.render.Renderer;

public class ChartArea extends Canvas
{

    private final List<Renderer> renderers = new LinkedList<Renderer> ();

    public ChartArea ( final Composite parent, final int style )
    {
        super ( parent, SWT.DOUBLE_BUFFERED );

        addPaintListener ( new PaintListener () {

            @Override
            public void paintControl ( final PaintEvent e )
            {
                onPaint ( e );
            }
        } );

        addListener ( SWT.Resize, new Listener () {

            @Override
            public void handleEvent ( final Event event )
            {
                onResize ( getClientArea () );
            }
        } );
    }

    protected void onResize ( final Rectangle clientRectangle )
    {
        for ( final Renderer renderer : this.renderers )
        {
            renderer.resize ( clientRectangle );
        }
    }

    protected void onPaint ( final PaintEvent e )
    {
        final Rectangle rect = getClientArea ();
        if ( rect.width == 0 || rect.height == 0 )
        {
            return;
        }

        e.gc.setAntialias ( SWT.ON );

        for ( final Renderer renderer : this.renderers )
        {
            renderer.render ( e, rect );
        }

    }

    public void addRenderer ( final Renderer renderer )
    {
        this.renderers.add ( renderer );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        this.renderers.remove ( renderer );
    }

    public XAxis createXAxis ()
    {
        final XAxis axis = new XAxis ();
        return axis;
    }

    public YAxis createYAxis ()
    {
        final YAxis axis = new YAxis ();
        return axis;
    }

}
