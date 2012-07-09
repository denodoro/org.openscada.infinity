package org.openscada.chart.swt.test;

import java.util.Date;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.openscada.chart.DataEntry;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.LinearRenderer;
import org.openscada.chart.swt.QualityRenderer;
import org.openscada.chart.swt.Series;
import org.openscada.chart.swt.StepRenderer;
import org.openscada.chart.swt.XAxis;
import org.openscada.chart.swt.XAxisRenderer;
import org.openscada.chart.swt.YAxis;
import org.openscada.chart.swt.YAxisDynamicRenderer;
import org.openscada.chart.swt.YAxisStaticRenderer;

public class Application implements IApplication
{

    public class MouseZoomer implements MouseWheelListener
    {
        private final XAxis x;

        private final YAxis y;

        private final ChartArea chart;

        public MouseZoomer ( final XAxis x, final YAxis y, final ChartArea chart )
        {
            this.x = x;
            this.y = y;
            this.chart = chart;
        }

        @Override
        public void mouseScrolled ( final MouseEvent e )
        {
            if ( e.stateMask == 0 )
            {
                this.x.zoom ( e.count < 0 ? 0.1 : -0.1 );
            }
            else if ( ( e.stateMask & SWT.MOD1 ) > 0 )
            {
                this.y.zoom ( e.count < 0 ? 0.1 : -0.1 );
            }
            this.chart.redraw ();
        }
    }

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        final Display display = new Display ();

        final Shell shell = new Shell ( display );
        shell.setText ( "Chart Test" );
        shell.setSize ( 800, 600 );

        final GridLayout layout = new GridLayout ( 3, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;

        shell.setLayout ( layout );

        new Composite ( shell, SWT.NONE ); // dummy 

        final XAxisRenderer xRenderer = new XAxisRenderer ( shell, SWT.TOP );
        xRenderer.setLayoutData ( new GridData ( SWT.FILL, SWT.BOTTOM, true, false ) );

        new Composite ( shell, SWT.NONE ); // dummy 

        final YAxisDynamicRenderer yRenderer = new YAxisDynamicRenderer ( shell, SWT.NONE );
        yRenderer.setLayoutData ( new GridData ( SWT.END, SWT.FILL, false, true ) );
        // yRenderer.setStep ( 15.0 );
        // yRenderer.setQuantizer ( new Quantizer1 ( 100 ) );

        final ChartArea chart = new ChartArea ( shell, SWT.NONE );
        chart.setLayoutData ( makeCenterData () );
        chart.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );

        final YAxisStaticRenderer yRendererRight = new YAxisStaticRenderer ( shell, SWT.RIGHT );
        yRendererRight.setLayoutData ( new GridData ( SWT.END, SWT.FILL, false, true ) );

        // new row

        new Composite ( shell, SWT.NONE ); // dummy 

        final XAxisRenderer xRendererButtom = new XAxisRenderer ( shell, SWT.BOTTOM );
        xRendererButtom.setLayoutData ( new GridData ( SWT.FILL, SWT.TOP, true, false ) );

        final XAxis x = new XAxis ();
        xRendererButtom.setAxis ( x );
        xRenderer.setAxis ( x );
        x.setLabel ( "Time" );

        final YAxis y = new YAxis ();
        yRenderer.setAxis ( y );
        yRenderer.setFormat ( "%.02f" );
        yRendererRight.setAxis ( y );
        yRendererRight.setFormat ( "%.02f" );
        y.setLabel ( "Value" );

        final ResourceManager resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        final Series series1 = new Series ( x, y );
        final Series series2 = new Series ( x, y );
        final Series series3 = new Series ( x, y );

        final LinearRenderer series1Renderer = new LinearRenderer ( series1 );
        series1Renderer.setLineColor ( resourceManager.createColor ( new RGB ( 255, 0, 0 ) ) );
        chart.addRenderer ( series1Renderer );

        chart.addRenderer ( new LinearRenderer ( series2 ) );

        chart.addRenderer ( new StepRenderer ( series3 ) );

        chart.addRenderer ( new QualityRenderer ( series3 ) );

        createSine ( series1, -10, +10, 0.05, 100.0, 100 );
        createSine ( series2, -20, +20, 0.1, 50.0, 200 );
        createLinear ( series3, 40, 240, 80.0, 40 );

        series1.fillAutoXYAxis ();

        chart.addMouseWheelListener ( new MouseZoomer ( x, y, chart ) );

        final MouseTransformer tracker = new MouseTransformer ( chart, x, y );
        chart.addMouseListener ( tracker );
        chart.addMouseMoveListener ( tracker );

        // start

        shell.open ();

        while ( !shell.isDisposed () )
        {
            if ( !display.readAndDispatch () )
            {
                display.sleep ();
            }
        }

        display.dispose ();

        return null;
    }

    private GridData makeCenterData ()
    {
        final GridData result = new GridData ( SWT.FILL, SWT.FILL, true, true );
        return result;
    }

    private void createSine ( final Series series, final int startTimestampOffset, final int endTimestampOffset, final double frequency, final double amplitude, final int numberOfSamples )
    {
        final long now = System.currentTimeMillis ();

        final long start = now + startTimestampOffset * 1000;
        final long end = now + endTimestampOffset * 1000;

        final long diff = end - start;

        final double timeSlice = (double)diff / numberOfSamples;

        double currentTime = start;
        while ( currentTime < end )
        {
            final Date timestamp = new Date ( (long)currentTime );

            series.getData ().add ( new DataEntry ( timestamp, Math.sin ( Math.toRadians ( currentTime ) * frequency ) * amplitude ) );
            currentTime += timeSlice;
        }
    }

    private void createLinear ( final Series series, final int startTimestampOffset, final int endTimestampOffset, final double ampltiude, final int numberOfSamples )
    {
        final long now = System.currentTimeMillis ();

        final long start = now + startTimestampOffset * 1000;
        final long end = now + endTimestampOffset * 1000;

        final long diff = end - start;

        final double timeSlice = (double)diff / numberOfSamples;

        final double add = ampltiude / numberOfSamples;

        double currentTime = start;
        double value = 0.0;
        int cnt = 0;
        while ( currentTime < end )
        {
            final Date timestamp = new Date ( (long)currentTime );

            if ( cnt % 10 == 0 )
            {
                series.getData ().add ( new DataEntry ( timestamp, null ) );
            }
            else
            {
                series.getData ().add ( new DataEntry ( timestamp, value ) );
            }

            value += add;
            currentTime += timeSlice;
            cnt++;
        }
    }

    @Override
    public void stop ()
    {
    }

}
