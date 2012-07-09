package org.openscada.chart.swt;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Rectangle;

public interface SeriesRenderer
{

    public void render ( Rectangle rectangle, PaintEvent e );

}
