/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>YAxis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.YAxis#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.YAxis#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getYAxis()
 * @model
 * @generated
 */
public interface YAxis extends Axis
{

    /**
     * Returns the value of the '<em><b>Minimum</b></em>' attribute.
     * The default value is <code>"-100.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum</em>' attribute.
     * @see #setMinimum(double)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getYAxis_Minimum()
     * @model default="-100.0" required="true"
     * @generated
     */
    double getMinimum ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.YAxis#getMinimum <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum</em>' attribute.
     * @see #getMinimum()
     * @generated
     */
    void setMinimum ( double value );

    /**
     * Returns the value of the '<em><b>Maximum</b></em>' attribute.
     * The default value is <code>"100.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum</em>' attribute.
     * @see #setMaximum(double)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getYAxis_Maximum()
     * @model default="100.0" required="true"
     * @generated
     */
    double getMaximum ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.YAxis#getMaximum <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum</em>' attribute.
     * @see #getMaximum()
     * @generated
     */
    void setMaximum ( double value );
} // YAxis
