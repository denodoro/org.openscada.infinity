package org.openscada.chart.swt.manager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.chart.swt.controller.MouseDragZoomer;
import org.openscada.chart.swt.controller.MouseTransformer;
import org.openscada.chart.swt.controller.MouseWheelZoomer;
import org.openscada.chart.swt.render.Renderer;
import org.openscada.chart.swt.render.StepRenderer;
import org.openscada.chart.swt.render.XAxisDynamicRenderer;
import org.openscada.chart.swt.render.YAxisDynamicRenderer;

public class ChartManager extends Composite
{

    public static class EmptyComposite extends Composite
    {
        public EmptyComposite ( final Composite parent, final int style )
        {
            super ( parent, style );
            setVisible ( false );
        }

        @Override
        public Point computeSize ( final int wHint, final int hHint, final boolean changed )
        {
            if ( !isVisible () )
            {
                return new Point ( 0, 0 );
            }
            else
            {
                return super.computeSize ( wHint, hHint, changed );
            }
        }

    }

    private final ChartArea chartArea;

    private final Label title;

    public ChartManager ( final Composite parent, final int style )
    {
        super ( parent, style );

        setLayout ( makeLayout () );

        // title row

        this.title = new Label ( this, SWT.NONE );
        this.title.setLayoutData ( new GridData ( GridData.CENTER, GridData.FILL, true, false, 1, 1 ) );

        // row 2

        this.chartArea = new ChartArea ( this, SWT.NONE );
        this.chartArea.setLayoutData ( makeMainLayoutData () );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );
    }

    private static GridLayout makeLayout ()
    {
        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        return layout;
    }

    private Object makeMainLayoutData ()
    {
        return new GridData ( SWT.FILL, SWT.FILL, true, true );
    }

    protected void onDispose ()
    {
    }

    public ChartArea getChartArea ()
    {
        return this.chartArea;
    }

    public ChartRenderer getChartRenderer ()
    {
        return this.chartArea.getChartRenderer ();
    }

    public void setChartBackground ( final Color color )
    {
        checkWidget ();

        this.chartArea.setBackground ( color );
    }

    public void addDefaultControllers ( final XAxis x, final YAxis y )
    {
        checkWidget ();

        new MouseTransformer ( this.chartArea.getChartRenderer (), x, y );
        new MouseDragZoomer ( this.chartArea.getChartRenderer (), x, y );
        new MouseWheelZoomer ( this.chartArea.getChartRenderer (), x, y );
    }

    public XAxisDynamicRenderer addDynamicXAxis ( final XAxis x, final boolean top )
    {
        checkWidget ();

        final XAxisDynamicRenderer renderer = new XAxisDynamicRenderer ( this.chartArea.getChartRenderer () );
        renderer.setAxis ( x );
        renderer.setAlign ( top ? SWT.TOP : SWT.BOTTOM );
        addRenderer ( renderer, -2 );
        return renderer;
    }

    public YAxisDynamicRenderer addDynamicYAxis ( final YAxis y, final boolean left )
    {
        checkWidget ();

        final YAxisDynamicRenderer renderer = new YAxisDynamicRenderer ( this.chartArea.getChartRenderer () );
        renderer.setAxis ( y );
        renderer.setAlign ( left ? SWT.LEFT : SWT.RIGHT );
        addRenderer ( renderer, -1 );
        return renderer;
    }

    public StepRenderer createStepSeries ( final SeriesData abstractSeriesData )
    {
        checkWidget ();

        final StepRenderer renderer = new StepRenderer ( this.chartArea.getChartRenderer (), abstractSeriesData );
        addRenderer ( renderer, 0 );
        return renderer;
    }

    public void setTitle ( final String title )
    {
        checkWidget ();

        this.title.setText ( title );
        this.title.pack ();
        layout ();
    }

    public String getTitle ()
    {
        checkWidget ();

        return this.title.getText ();
    }

    public DropTarget createDropTarget ( final Transfer[] transfers, final DropTargetListener dropTargetListener )
    {
        checkWidget ();

        final DropTarget target = new DropTarget ( this.chartArea, DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_LINK );
        target.setTransfer ( transfers );
        target.addDropListener ( dropTargetListener );
        return target;
    }

    public void addRenderer ( final Renderer renderer, final int order )
    {
        checkWidget ();

        this.chartArea.getChartRenderer ().addRenderer ( renderer, order );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        checkWidget ();

        this.chartArea.getChartRenderer ().removeRenderer ( renderer );
    }

}
