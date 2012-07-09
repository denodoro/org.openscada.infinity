package org.openscada.chart;

public interface Realm
{
    public void asyncExec ( Runnable runnable );

    public void checkRealm () throws IllegalAccessException;
}
