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

package org.openscada.chart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

public abstract class SeriesData
{
    private final XAxis xAxis;

    private final YAxis yAxis;

    private final PropertyChangeListener listener;

    private final Set<SeriesDataListener> listeners = new HashSet<SeriesDataListener> ();

    private final Realm realm;

    public SeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        this.realm = realm;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        this.listener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };

        xAxis.addPropertyChangeListener ( this.listener );
    }

    public void addListener ( final SeriesDataListener listener )
    {
        this.listeners.add ( listener );
    }

    public void removeListener ( final SeriesDataListener listener )
    {
        this.listeners.remove ( listener );
    }

    protected void fireUpdateListener ( final long startTimestamp, final long endTimestamp )
    {
        this.realm.asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                for ( final SeriesDataListener listener : SeriesData.this.listeners )
                {
                    listener.dataUpdate ( startTimestamp, endTimestamp );
                }
            }
        } );
    }

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        setRequestWindow ( this.xAxis.getMin (), this.xAxis.getMax () );
    }

    public void dispose ()
    {
        this.xAxis.removePropertyChangeListener ( this.listener );
    }

    public XAxis getXAxis ()
    {
        return this.xAxis;
    }

    public YAxis getYAxis ()
    {
        return this.yAxis;
    }

    public abstract void setRequestWindow ( final long startTimestamp, final long endTimestamp );

    public abstract void setRequestWidth ( final int width );

    public abstract SeriesViewData getViewData ();

}
