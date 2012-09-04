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

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.openscada.chart.swt.render.Renderer;

public abstract class ChartRenderer
{

    private static class RendererEntry
    {
        private final Integer order;

        private final Renderer renderer;

        private Rectangle bounds;

        public RendererEntry ( final Renderer renderer, final int order )
        {
            this.renderer = renderer;
            this.order = order;
        }

        public Integer getOrder ()
        {
            return this.order;
        }

        public Renderer getRenderer ()
        {
            return this.renderer;
        }

        public void setBounds ( final Rectangle bounds )
        {
            this.bounds = bounds;
        }

        public void render ( final Graphics g )
        {
            this.renderer.render ( g, this.bounds );
        }
    }

    private final List<RendererEntry> renderers = new LinkedList<RendererEntry> ();

    private boolean stale;

    private boolean updatePending;

    private boolean disposed;

    protected void resizeAll ( Rectangle clientRectangle )
    {
        for ( final RendererEntry renderer : this.renderers )
        {
            final Rectangle newBounds = renderer.getRenderer ().resize ( clientRectangle );
            if ( newBounds != null )
            {
                clientRectangle = newBounds;
            }
            renderer.setBounds ( clientRectangle );
        }
    }

    protected void checkWidget ()
    {
    }

    public abstract void redraw ();

    public abstract Rectangle getClientArea ();

    public void paint ( final Graphics g )
    {
        g.setAntialias ( true );

        for ( final RendererEntry renderer : this.renderers )
        {
            renderer.render ( g );
        }
    }

    public void addRenderer ( final Renderer renderer )
    {
        addRenderer ( renderer, 0 );
    }

    public void addRenderer ( final Renderer renderer, final int order )
    {
        checkWidget ();

        this.renderers.add ( new RendererEntry ( renderer, order ) );

        Collections.sort ( this.renderers, new Comparator<RendererEntry> () {

            @Override
            public int compare ( final RendererEntry o1, final RendererEntry o2 )
            {
                return o1.getOrder ().compareTo ( o2.getOrder () );
            }
        } );

        resizeAll ( getClientArea () );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        checkWidget ();

        final Iterator<RendererEntry> i = this.renderers.iterator ();
        while ( i.hasNext () )
        {
            final RendererEntry entry = i.next ();
            if ( entry.getRenderer ().equals ( renderer ) )
            {
                i.remove ();
            }
        }
    }

    public void refreshData ()
    {
        checkWidget ();
        if ( this.stale )
        {
            this.updatePending = true;
        }
        else
        {
            redraw ();
        }
    }

    public void setStale ( final boolean stale )
    {
        setStale ( stale, false );
    }

    public void setStale ( final boolean stale, final boolean forceUpdate )
    {
        checkWidget ();
        this.stale = stale;
        if ( !stale && ( this.updatePending || forceUpdate ) )
        {
            this.updatePending = false;
            redraw ();
        }
    }

    public void dispose ()
    {
        checkWidget ();

        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;

        for ( final DisposeListener listener : this.disposeListeners )
        {
            SafeRunnable.getRunner ().run ( new SafeRunnable () {
                @Override
                public void run () throws Exception
                {
                    listener.onDispose ();
                };
            } );
        }
    }

    private final Set<DisposeListener> disposeListeners = new LinkedHashSet<DisposeListener> ();

    public void addDisposeListener ( final DisposeListener disposeListener )
    {
        checkWidget ();
        this.disposeListeners.add ( disposeListener );
    }

    public abstract void addMouseListener ( MouseListener mouseListener );

    public abstract void removeMouseListener ( MouseListener mouseListener );

    public abstract void addMouseMoveListener ( MouseMoveListener mouseMoveListener );

    public abstract void removeMouseMoveListener ( MouseMoveListener mouseMoveListener );

    public abstract void addMouseWheelListener ( MouseWheelListener listener );

    public abstract void removeMouseWheelListener ( MouseWheelListener listener );

    public boolean isDisposed ()
    {
        return this.disposed;
    }

    public abstract Display getDisplay ();

}
