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
import org.openscada.chart.XAxis;

public class XRulerRenderer extends AbstractXRuler
{

    private long position;

    public XRulerRenderer ( final XAxis axis )
    {
        super ( axis );
        this.color = Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK );
    }

    public void setPosition ( final long position )
    {
        this.position = position;
    }

    @Override
    public long getPosition ()
    {
        return this.position;
    }

}
