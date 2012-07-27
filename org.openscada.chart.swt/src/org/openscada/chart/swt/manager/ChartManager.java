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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.chart.SeriesData;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;
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

    private final Composite cell21;

    private final Composite cell23;

    private final Composite cell32;

    private final Label title;

    private final Composite cell12;

    public ChartManager ( final Composite parent, final int style )
    {
        super ( parent, style );

        setLayout ( makeLayout () );

        // title row

        this.title = new Label ( this, SWT.NONE );
        this.title.setLayoutData ( new GridData ( GridData.CENTER, GridData.FILL, true, false, 3, 1 ) );

        // row 1

        new EmptyComposite ( this, SWT.NONE );
        this.cell12 = makeCell ( SWT.VERTICAL );
        new EmptyComposite ( this, SWT.NONE );

        // row 2

        this.cell21 = makeCell ( SWT.HORIZONTAL );
        this.chartArea = new ChartArea ( this, SWT.NONE );
        this.chartArea.setLayoutData ( makeMainLayoutData () );
        this.cell23 = makeCell ( SWT.HORIZONTAL );

        // row 3

        new EmptyComposite ( this, SWT.NONE );
        this.cell32 = makeCell ( SWT.VERTICAL );
        new EmptyComposite ( this, SWT.NONE );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );
    }

    private Composite makeCell ( final int fillLayoutType )
    {
        final Composite cell = new Composite ( this, SWT.NONE );
        cell.setVisible ( false );
        cell.setLayout ( new FillLayout ( fillLayoutType ) );

        if ( fillLayoutType == SWT.HORIZONTAL )
        {
            cell.setLayoutData ( new GridData ( GridData.END, GridData.FILL, false, true ) );
        }
        else
        {
            cell.setLayoutData ( new GridData ( GridData.FILL, GridData.BEGINNING, true, false ) );
        }

        return cell;
    }

    private GridLayout makeLayout ()
    {
        final GridLayout layout = new GridLayout ( 3, false );
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

    public void setChartBackground ( final Color color )
    {
        checkWidget ();

        this.chartArea.setBackground ( color );
    }

    public void addDefaultControllers ( final XAxis x, final YAxis y )
    {
        checkWidget ();

        new MouseTransformer ( this.chartArea, x, y );
        new MouseDragZoomer ( this.chartArea, x, y );
        new MouseWheelZoomer ( this.chartArea, x, y );
    }

    public XAxisDynamicRenderer addDynamicXAxis ( final XAxis x, final boolean top )
    {
        checkWidget ();

        final Composite cell = top ? this.cell12 : this.cell32;

        cell.setVisible ( true );

        final XAxisDynamicRenderer renderer = new XAxisDynamicRenderer ( cell, top ? SWT.TOP : SWT.BOTTOM );
        renderer.setAxis ( x );
        cell.layout ();
        layout ();
        return renderer;
    }

    public YAxisDynamicRenderer addDynamicYAxis ( final YAxis y, final boolean left )
    {
        checkWidget ();

        final Composite cell = left ? this.cell21 : this.cell23;

        cell.setVisible ( true );

        final YAxisDynamicRenderer renderer = new YAxisDynamicRenderer ( cell, left ? SWT.LEFT : SWT.RIGHT );
        renderer.setAxis ( y );
        cell.layout ();
        layout ();
        return renderer;
    }

    public StepRenderer createStepSeries ( final SeriesData abstractSeriesData )
    {
        checkWidget ();

        final StepRenderer renderer = new StepRenderer ( this.chartArea, abstractSeriesData );
        this.chartArea.addRenderer ( renderer );
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

    public void addRenderer ( final Renderer renderer )
    {
        checkWidget ();

        this.chartArea.addRenderer ( renderer );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        checkWidget ();

        this.chartArea.removeRenderer ( renderer );
    }

}
