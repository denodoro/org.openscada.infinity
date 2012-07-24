/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAxis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.XAxis#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.XAxis#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getXAxis()
 * @model
 * @generated
 */
public interface XAxis extends Axis
{

    /**
     * Returns the value of the '<em><b>Minimum</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum</em>' attribute.
     * @see #setMinimum(long)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getXAxis_Minimum()
     * @model default="0" required="true"
     * @generated
     */
    long getMinimum ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.XAxis#getMinimum <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum</em>' attribute.
     * @see #getMinimum()
     * @generated
     */
    void setMinimum ( long value );

    /**
     * Returns the value of the '<em><b>Maximum</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum</em>' attribute.
     * @see #setMaximum(long)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getXAxis_Maximum()
     * @model default="1000" required="true"
     * @generated
     */
    long getMaximum ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.XAxis#getMaximum <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum</em>' attribute.
     * @see #getMaximum()
     * @generated
     */
    void setMaximum ( long value );
} // XAxis
