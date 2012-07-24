/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage
 * @generated
 */
public interface ChartFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartFactory eINSTANCE = org.openscada.ui.chart.model.ChartModel.impl.ChartFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Chart</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Chart</em>'.
     * @generated
     */
    Chart createChart ();

    /**
     * Returns a new object of class '<em>XAxis</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XAxis</em>'.
     * @generated
     */
    XAxis createXAxis ();

    /**
     * Returns a new object of class '<em>YAxis</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>YAxis</em>'.
     * @generated
     */
    YAxis createYAxis ();

    /**
     * Returns a new object of class '<em>Data Item Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Item Series</em>'.
     * @generated
     */
    DataItemSeries createDataItemSeries ();

    /**
     * Returns a new object of class '<em>Archive Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Archive Series</em>'.
     * @generated
     */
    ArchiveSeries createArchiveSeries ();

    /**
     * Returns a new object of class '<em>Uri Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Uri Item</em>'.
     * @generated
     */
    UriItem createUriItem ();

    /**
     * Returns a new object of class '<em>Id Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Id Item</em>'.
     * @generated
     */
    IdItem createIdItem ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ChartPackage getChartPackage ();

} //ChartFactory
