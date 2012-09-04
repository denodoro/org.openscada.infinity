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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ChartArea extends Canvas
{

    public static class ChartAreaRenderer extends ChartRenderer
    {

        private final Composite control;

        public ChartAreaRenderer ( final Composite control )
        {
            this.control = control;
        }

        @Override
        public Display getDisplay ()
        {
            return this.control.getDisplay ();
        }

        @Override
        public void redraw ()
        {
            this.control.redraw ();
        }

        @Override
        public Rectangle getClientArea ()
        {
            return this.control.getClientArea ();
        }

        @Override
        public void addMouseListener ( final MouseListener listener )
        {
            this.control.addMouseListener ( listener );
        }

        @Override
        public void addMouseMoveListener ( final MouseMoveListener listener )
        {
            this.control.addMouseMoveListener ( listener );
        }

        @Override
        public void addMouseWheelListener ( final MouseWheelListener listener )
        {
            this.control.addMouseWheelListener ( listener );
        }

        @Override
        public void removeMouseListener ( final MouseListener listener )
        {
            this.control.removeMouseListener ( listener );
        }

        @Override
        public void removeMouseMoveListener ( final MouseMoveListener listener )
        {
            this.control.removeMouseMoveListener ( listener );
        }

        @Override
        public void removeMouseWheelListener ( final MouseWheelListener listener )
        {
            this.control.removeMouseWheelListener ( listener );
        }
    }

    private final ChartRenderer chartRenderer;

    public ChartArea ( final Composite parent, final int style )
    {
        super ( parent, SWT.DOUBLE_BUFFERED );
        this.chartRenderer = new ChartAreaRenderer ( this );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );

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
                resizeAll ( getClientArea () );
            }
        } );
    }

    public ChartRenderer getChartRenderer ()
    {
        return this.chartRenderer;
    }

    protected void resizeAll ( final Rectangle clientArea )
    {
        this.chartRenderer.resizeAll ( clientArea );
    }

    protected void onDispose ()
    {
        this.chartRenderer.dispose ();
    }

    protected void onPaint ( final PaintEvent e )
    {
        this.chartRenderer.paint ( new SWTGraphics ( e.gc ) );
    }
}
