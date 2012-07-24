/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.openscada.ui.chart.model.ChartModel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage
 * @generated
 */
public class ChartSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ChartPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ChartPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case ChartPackage.CHART:
            {
                Chart chart = (Chart)theEObject;
                T result = caseChart ( chart );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.XAXIS:
            {
                XAxis xAxis = (XAxis)theEObject;
                T result = caseXAxis ( xAxis );
                if ( result == null )
                    result = caseAxis ( xAxis );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.YAXIS:
            {
                YAxis yAxis = (YAxis)theEObject;
                T result = caseYAxis ( yAxis );
                if ( result == null )
                    result = caseAxis ( yAxis );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.AXIS:
            {
                Axis axis = (Axis)theEObject;
                T result = caseAxis ( axis );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.DATA_SERIES:
            {
                DataSeries dataSeries = (DataSeries)theEObject;
                T result = caseDataSeries ( dataSeries );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.DATA_ITEM_SERIES:
            {
                DataItemSeries dataItemSeries = (DataItemSeries)theEObject;
                T result = caseDataItemSeries ( dataItemSeries );
                if ( result == null )
                    result = caseItemDataSeries ( dataItemSeries );
                if ( result == null )
                    result = caseDataSeries ( dataItemSeries );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.ARCHIVE_SERIES:
            {
                ArchiveSeries archiveSeries = (ArchiveSeries)theEObject;
                T result = caseArchiveSeries ( archiveSeries );
                if ( result == null )
                    result = caseItemDataSeries ( archiveSeries );
                if ( result == null )
                    result = caseDataSeries ( archiveSeries );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.ITEM:
            {
                Item item = (Item)theEObject;
                T result = caseItem ( item );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.URI_ITEM:
            {
                UriItem uriItem = (UriItem)theEObject;
                T result = caseUriItem ( uriItem );
                if ( result == null )
                    result = caseItem ( uriItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.ID_ITEM:
            {
                IdItem idItem = (IdItem)theEObject;
                T result = caseIdItem ( idItem );
                if ( result == null )
                    result = caseItem ( idItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ChartPackage.ITEM_DATA_SERIES:
            {
                ItemDataSeries itemDataSeries = (ItemDataSeries)theEObject;
                T result = caseItemDataSeries ( itemDataSeries );
                if ( result == null )
                    result = caseDataSeries ( itemDataSeries );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Chart</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Chart</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChart ( Chart object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XAxis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XAxis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXAxis ( XAxis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>YAxis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>YAxis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseYAxis ( YAxis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Axis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Axis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAxis ( Axis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataSeries ( DataSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Item Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Item Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataItemSeries ( DataItemSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Archive Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Archive Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseArchiveSeries ( ArchiveSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem ( Item object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Uri Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Uri Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUriItem ( UriItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Id Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Id Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdItem ( IdItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Data Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Data Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemDataSeries ( ItemDataSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //ChartSwitch
