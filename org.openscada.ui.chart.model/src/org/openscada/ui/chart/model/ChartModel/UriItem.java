/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uri Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.UriItem#getConnectionUri <em>Connection Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getUriItem()
 * @model
 * @generated
 */
public interface UriItem extends Item
{
    /**
     * Returns the value of the '<em><b>Connection Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Uri</em>' attribute.
     * @see #setConnectionUri(String)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getUriItem_ConnectionUri()
     * @model required="true"
     * @generated
     */
    String getConnectionUri ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.UriItem#getConnectionUri <em>Connection Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Uri</em>' attribute.
     * @see #getConnectionUri()
     * @generated
     */
    void setConnectionUri ( String value );

} // UriItem
