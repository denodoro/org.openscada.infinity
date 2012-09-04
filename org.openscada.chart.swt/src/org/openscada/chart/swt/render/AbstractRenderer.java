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
import org.eclipse.swt.widgets.Display;
import org.openscada.chart.swt.ChartArea;

public abstract class AbstractRenderer implements Renderer
{
    private final ChartArea chartArea;

    private final Display display;

    private boolean disposed = false;

    public AbstractRenderer ( final ChartArea chartArea )
    {
        this.chartArea = chartArea;
        this.display = chartArea.getDisplay ();
    }

    public void dispose ()
    {
        if ( !this.disposed )
        {
            this.disposed = true;
            this.chartArea.removeRenderer ( this );
        }
    }

    protected void redraw ()
    {
        checkWidget ();
        this.chartArea.redraw ();
    }

    protected void checkWidget ()
    {
        final Display display = this.display;
        if ( display == null )
        {
            error ( SWT.ERROR_WIDGET_DISPOSED );
        }
        if ( display.getThread () != Thread.currentThread () )
        {
            error ( SWT.ERROR_THREAD_INVALID_ACCESS );
        }
        if ( this.disposed )
        {
            error ( SWT.ERROR_WIDGET_DISPOSED );
        }
    }

    private void error ( final int code )
    {
        SWT.error ( code );
    }

}
