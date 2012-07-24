/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.graphics.RGB;
import org.openscada.ui.chart.model.ChartModel.*;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.model.ChartModel.ChartFactory;
import org.openscada.ui.chart.model.ChartModel.ChartPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ChartFactoryImpl extends EFactoryImpl implements ChartFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static ChartFactory init ()
    {
        try
        {
            ChartFactory theChartFactory = (ChartFactory)EPackage.Registry.INSTANCE.getEFactory ( "http://openscada.org/UI/Chart" );
            if ( theChartFactory != null )
            {
                return theChartFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ChartFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ChartFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ChartPackage.CHART:
                return createChart ();
            case ChartPackage.XAXIS:
                return createXAxis ();
            case ChartPackage.YAXIS:
                return createYAxis ();
            case ChartPackage.DATA_ITEM_SERIES:
                return createDataItemSeries ();
            case ChartPackage.ARCHIVE_SERIES:
                return createArchiveSeries ();
            case ChartPackage.URI_ITEM:
                return createUriItem ();
            case ChartPackage.ID_ITEM:
                return createIdItem ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ChartPackage.RGB:
                return createRGBFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ChartPackage.RGB:
                return convertRGBToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Chart createChart ()
    {
        ChartImpl chart = new ChartImpl ();
        return chart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis createXAxis ()
    {
        XAxisImpl xAxis = new XAxisImpl ();
        return xAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public YAxis createYAxis ()
    {
        YAxisImpl yAxis = new YAxisImpl ();
        return yAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataItemSeries createDataItemSeries ()
    {
        DataItemSeriesImpl dataItemSeries = new DataItemSeriesImpl ();
        return dataItemSeries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArchiveSeries createArchiveSeries ()
    {
        ArchiveSeriesImpl archiveSeries = new ArchiveSeriesImpl ();
        return archiveSeries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UriItem createUriItem ()
    {
        UriItemImpl uriItem = new UriItemImpl ();
        return uriItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IdItem createIdItem ()
    {
        IdItemImpl idItem = new IdItemImpl ();
        return idItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public RGB createRGBFromString ( final EDataType eDataType, final String initialValue )
    {
        final Pattern p = Pattern.compile ( "#([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})" );
        final Matcher m = p.matcher ( initialValue );

        if ( m.matches () )
        {

            final int red = Integer.parseInt ( m.group ( 1 ), 16 );
            final int green = Integer.parseInt ( m.group ( 2 ), 16 );
            final int blue = Integer.parseInt ( m.group ( 3 ), 16 );

            return new RGB ( red, green, blue );
        }
        else
        {
            throw new IllegalArgumentException ( "RGB syntax does not match" );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertRGBToString ( final EDataType eDataType, final Object instanceValue )
    {
        final RGB rgb = (RGB)instanceValue;
        return String.format ( "#%02h%02h%02h", rgb.red, rgb.green, rgb.blue );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ChartPackage getChartPackage ()
    {
        return (ChartPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ChartPackage getPackage ()
    {
        return ChartPackage.eINSTANCE;
    }

} //ChartFactoryImpl
