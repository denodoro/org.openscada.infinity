/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getLabel <em>Label</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getX <em>X</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getDataSeries()
 * @model abstract="true"
 * @generated
 */
public interface DataSeries extends EObject
{

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getDataSeries_Label()
     * @model
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

    /**
     * Returns the value of the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>X</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>X</em>' reference.
     * @see #setX(XAxis)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getDataSeries_X()
     * @model required="true"
     * @generated
     */
    XAxis getX ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getX <em>X</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>X</em>' reference.
     * @see #getX()
     * @generated
     */
    void setX ( XAxis value );

    /**
     * Returns the value of the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' reference.
     * @see #setY(YAxis)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getDataSeries_Y()
     * @model required="true"
     * @generated
     */
    YAxis getY ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.DataSeries#getY <em>Y</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' reference.
     * @see #getY()
     * @generated
     */
    void setY ( YAxis value );
} // DataSeries
