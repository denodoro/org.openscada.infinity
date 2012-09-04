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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.openscada.chart.swt.ChartMouseListener.MouseState;

public class ChartAreaRenderer extends ChartRenderer
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
    public void setFocus ()
    {
        this.control.setFocus ();
    }

    @Override
    public Rectangle getClientArea ()
    {
        return this.control.getClientArea ();
    }

    protected MouseState convertState ( final MouseEvent e )
    {
        final MouseState state = new MouseState ();
        state.button = e.button;
        state.x = e.x;
        state.y = e.y;
        state.state = e.stateMask;
        return state;
    }

    private final Map<ChartMouseListener, MouseListener> mouseListenerMap = new HashMap<ChartMouseListener, MouseListener> ();

    private final Map<ChartMouseMoveListener, MouseMoveListener> mouseMoveListenerMap = new HashMap<ChartMouseMoveListener, MouseMoveListener> ();

    @Override
    public void addMouseListener ( final ChartMouseListener listener )
    {
        removeMouseListener ( listener );
        final MouseListener proxyListener = new MouseListener () {

            @Override
            public void mouseUp ( final MouseEvent e )
            {
                listener.onMouseUp ( convertState ( e ) );
            }

            @Override
            public void mouseDown ( final MouseEvent e )
            {
                listener.onMouseDown ( convertState ( e ) );
            }

            @Override
            public void mouseDoubleClick ( final MouseEvent e )
            {
                listener.onMouseDoubleClick ( convertState ( e ) );
            }
        };
        this.mouseListenerMap.put ( listener, proxyListener );
        this.control.addMouseListener ( proxyListener );
    }

    @Override
    public void removeMouseListener ( final ChartMouseListener listener )
    {
        final MouseListener proxyListener = this.mouseListenerMap.remove ( listener );
        if ( proxyListener != null )
        {
            this.control.removeMouseListener ( proxyListener );
        }
    }

    @Override
    public void addMouseMoveListener ( final ChartMouseMoveListener listener )
    {
        removeMouseMoveListener ( listener );
        final MouseMoveListener proxyListener = new MouseMoveListener () {

            @Override
            public void mouseMove ( final MouseEvent e )
            {
                listener.onMouseMove ( convertState ( e ) );
            }

        };
        this.mouseMoveListenerMap.put ( listener, proxyListener );
        this.control.addMouseMoveListener ( proxyListener );
    }

    @Override
    public void removeMouseMoveListener ( final ChartMouseMoveListener listener )
    {
        final MouseMoveListener proxyListener = this.mouseMoveListenerMap.remove ( listener );
        if ( proxyListener != null )
        {
            this.control.removeMouseMoveListener ( proxyListener );
        }
    }

    @Override
    public void addMouseWheelListener ( final MouseWheelListener listener )
    {
        this.control.addMouseWheelListener ( listener );
    }

    @Override
    public void removeMouseWheelListener ( final MouseWheelListener listener )
    {
        this.control.removeMouseWheelListener ( listener );
    }

    @Override
    public DropTarget createDropTarget ( final Transfer[] transfers, final DropTargetAdapter createDropTarget )
    {
        checkWidget ();

        final DropTarget target = new DropTarget ( this.control, DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_LINK );
        target.setTransfer ( transfers );
        target.addDropListener ( createDropTarget );
        return target;
    }
}