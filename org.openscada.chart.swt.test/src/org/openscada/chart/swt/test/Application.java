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

package org.openscada.chart.swt.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.openscada.chart.AsyncFunctionSeriesData;
import org.openscada.chart.DataEntry;
import org.openscada.chart.Realm;
import org.openscada.chart.SeriesData;
import org.openscada.chart.WritableSeries;
import org.openscada.chart.XAxis;
import org.openscada.chart.YAxis;
import org.openscada.chart.swt.ChartArea;
import org.openscada.chart.swt.DisplayRealm;
import org.openscada.chart.swt.controller.MouseDragZoomer;
import org.openscada.chart.swt.controller.MouseTransformer;
import org.openscada.chart.swt.controller.MouseWheelZoomer;
import org.openscada.chart.swt.render.LinearRenderer;
import org.openscada.chart.swt.render.QualityRenderer;
import org.openscada.chart.swt.render.StepRenderer;
import org.openscada.chart.swt.render.XAxisDynamicRenderer;
import org.openscada.chart.swt.render.YAxisDynamicRenderer;

public class Application implements IApplication
{
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

        // final YAxisDynamicWidget yRenderer = new YAxisDynamicWidget ( shell, SWT.NONE );
        // yRenderer.setLayoutData ( new GridData ( SWT.END, SWT.FILL, false, true ) );
        // yRenderer.setStep ( 15.0 );
        // yRenderer.setQuantizer ( new Quantizer1 ( 100 ) );

        final ChartArea chart = new ChartArea ( shell, SWT.NONE );
        chart.setLayoutData ( makeCenterData () );
        chart.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );

        // final YAxisStaticWidget yRendererRight = new YAxisStaticWidget ( shell, SWT.RIGHT );
        // yRendererRight.setLayoutData ( new GridData ( SWT.END, SWT.FILL, false, true ) );

        // new row

        final XAxis x = new XAxis ();
        x.setLabel ( "Time" );

        final YAxis y = new YAxis ();
        /*
        yRenderer.setAxis ( y );
        yRenderer.setFormat ( "%.02f" );
        yRendererRight.setAxis ( y );
        yRendererRight.setFormat ( "%.02f" );
        */
        y.setLabel ( "Value" );

        final ResourceManager resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        final Realm realm = new DisplayRealm ( Display.getDefault () );

        final WritableSeries series1 = new WritableSeries ( realm, x, y );
        final WritableSeries series2 = new WritableSeries ( realm, x, y );
        final WritableSeries series3 = new WritableSeries ( realm, x, y );
        final SeriesData series4 = new AsyncFunctionSeriesData ( realm, x, y, 1000 ) {

            @Override
            protected Double eval ( final long timestamp )
            {
                double v = Math.sin ( Math.toRadians ( timestamp / 100.0 ) ) * 100.0;

                v = v + Math.sin ( Math.toRadians ( timestamp ) ) * 10.0;
                v = v + Math.sin ( Math.toRadians ( timestamp / 10000.0 ) ) * 100.0;

                return v;
            }
        };

        final LinearRenderer series1Renderer = new LinearRenderer ( chart.getChartRenderer (), series1 );
        series1Renderer.setLineColor ( resourceManager.createColor ( new RGB ( 255, 0, 0 ) ) );
        chart.getChartRenderer ().addRenderer ( series1Renderer );

        chart.getChartRenderer ().addRenderer ( new LinearRenderer ( chart.getChartRenderer (), series4 ) );
        chart.getChartRenderer ().addRenderer ( new StepRenderer ( chart.getChartRenderer (), series3 ) );
        chart.getChartRenderer ().addRenderer ( new QualityRenderer ( chart.getChartRenderer (), series4 ) );

        createSine ( series1, -10, +10, 0.05, 100.0, 100 );
        createSine ( series2, -20, +20, 0.1, 50.0, 200 );
        createLinear ( series3, 40, 240, 80.0, 40 );

        x.setMinMax ( series1.getData ().getMinTimestamp (), series1.getData ().getMaxTimestamp () );
        y.setMinMax ( series1.getData ().getMinValue (), series1.getData ().getMaxValue () );

        new MouseWheelZoomer ( chart.getChartRenderer (), x, y );
        new MouseTransformer ( chart.getChartRenderer (), x, y );
        new MouseDragZoomer ( chart.getChartRenderer (), x, y );

        // add new renderers

        final XAxisDynamicRenderer xAxisRender1 = new XAxisDynamicRenderer ( chart.getChartRenderer () );
        xAxisRender1.setAxis ( x );
        chart.getChartRenderer ().addRenderer ( xAxisRender1, -1 );

        final XAxisDynamicRenderer xAxisRender2 = new XAxisDynamicRenderer ( chart.getChartRenderer () );
        xAxisRender2.setAlign ( SWT.TOP );
        xAxisRender2.setAxis ( x );
        xAxisRender2.setFormat ( "%1$tc\n%1$tc" );
        chart.getChartRenderer ().addRenderer ( xAxisRender2, -1 );

        final YAxisDynamicRenderer yAxisRender1 = new YAxisDynamicRenderer ( chart.getChartRenderer () );
        yAxisRender1.setAlign ( SWT.LEFT );
        yAxisRender1.setAxis ( y );
        chart.getChartRenderer ().addRenderer ( yAxisRender1, -1 );

        final YAxisDynamicRenderer yAxisRender2 = new YAxisDynamicRenderer ( chart.getChartRenderer () );
        yAxisRender2.setAlign ( SWT.RIGHT );
        yAxisRender2.setAxis ( y );
        chart.getChartRenderer ().addRenderer ( yAxisRender2, -1 );

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

    private void createSine ( final WritableSeries series, final int startTimestampOffset, final int endTimestampOffset, final double frequency, final double amplitude, final int numberOfSamples )
    {
        final long now = System.currentTimeMillis ();

        final long start = now + startTimestampOffset * 1000;
        final long end = now + endTimestampOffset * 1000;

        final long diff = end - start;

        final double timeSlice = (double)diff / numberOfSamples;

        double currentTime = start;
        while ( currentTime < end )
        {
            series.getData ().add ( new DataEntry ( (long)currentTime, Math.sin ( Math.toRadians ( currentTime ) * frequency ) * amplitude ) );
            currentTime += timeSlice;
        }
    }

    private void createLinear ( final WritableSeries series, final int startTimestampOffset, final int endTimestampOffset, final double ampltiude, final int numberOfSamples )
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
            if ( cnt % 10 == 0 )
            {
                series.getData ().add ( new DataEntry ( (long)currentTime, null ) );
            }
            else
            {
                series.getData ().add ( new DataEntry ( (long)currentTime, value ) );
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
