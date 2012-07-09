package org.openscada.chart.swt;

import org.eclipse.swt.widgets.Display;
import org.openscada.chart.Realm;

public class DisplayRealm implements Realm
{

    private final Display display;

    public DisplayRealm ( final Display display )
    {
        this.display = display;
    }

    @Override
    public void asyncExec ( final Runnable runnable )
    {
        this.display.asyncExec ( runnable );
    }

    @Override
    public void checkRealm () throws IllegalAccessException
    {
        if ( Display.getCurrent () == this.display )
        {
            return;
        }
        throw new IllegalAccessException ( "Access outside of realm" );
    }

}
