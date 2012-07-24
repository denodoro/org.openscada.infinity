/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.openscada.ui.chart.model.ChartModel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage
 * @generated
 */
public class ChartAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ChartPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ChartPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChartSwitch<Adapter> modelSwitch = new ChartSwitch<Adapter> () {
        @Override
        public Adapter caseChart ( Chart object )
        {
            return createChartAdapter ();
        }

        @Override
        public Adapter caseXAxis ( XAxis object )
        {
            return createXAxisAdapter ();
        }

        @Override
        public Adapter caseYAxis ( YAxis object )
        {
            return createYAxisAdapter ();
        }

        @Override
        public Adapter caseAxis ( Axis object )
        {
            return createAxisAdapter ();
        }

        @Override
        public Adapter caseDataSeries ( DataSeries object )
        {
            return createDataSeriesAdapter ();
        }

        @Override
        public Adapter caseDataItemSeries ( DataItemSeries object )
        {
            return createDataItemSeriesAdapter ();
        }

        @Override
        public Adapter caseArchiveSeries ( ArchiveSeries object )
        {
            return createArchiveSeriesAdapter ();
        }

        @Override
        public Adapter caseItem ( Item object )
        {
            return createItemAdapter ();
        }

        @Override
        public Adapter caseUriItem ( UriItem object )
        {
            return createUriItemAdapter ();
        }

        @Override
        public Adapter caseIdItem ( IdItem object )
        {
            return createIdItemAdapter ();
        }

        @Override
        public Adapter caseItemDataSeries ( ItemDataSeries object )
        {
            return createItemDataSeriesAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.Chart <em>Chart</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.Chart
     * @generated
     */
    public Adapter createChartAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.XAxis <em>XAxis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.XAxis
     * @generated
     */
    public Adapter createXAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.YAxis <em>YAxis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.YAxis
     * @generated
     */
    public Adapter createYAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.Axis <em>Axis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.Axis
     * @generated
     */
    public Adapter createAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.DataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.DataSeries
     * @generated
     */
    public Adapter createDataSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.DataItemSeries <em>Data Item Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.DataItemSeries
     * @generated
     */
    public Adapter createDataItemSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.ArchiveSeries <em>Archive Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.ArchiveSeries
     * @generated
     */
    public Adapter createArchiveSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.Item
     * @generated
     */
    public Adapter createItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.UriItem <em>Uri Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.UriItem
     * @generated
     */
    public Adapter createUriItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.IdItem <em>Id Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.IdItem
     * @generated
     */
    public Adapter createIdItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.ui.chart.model.ChartModel.ItemDataSeries <em>Item Data Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.ui.chart.model.ChartModel.ItemDataSeries
     * @generated
     */
    public Adapter createItemDataSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ChartAdapterFactory
