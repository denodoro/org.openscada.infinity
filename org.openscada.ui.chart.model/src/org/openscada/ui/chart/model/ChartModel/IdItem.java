/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.IdItem#getConnectionId <em>Connection Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getIdItem()
 * @model
 * @generated
 */
public interface IdItem extends Item
{
    /**
     * Returns the value of the '<em><b>Connection Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Id</em>' attribute.
     * @see #setConnectionId(String)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getIdItem_ConnectionId()
     * @model required="true"
     * @generated
     */
    String getConnectionId ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.IdItem#getConnectionId <em>Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Id</em>' attribute.
     * @see #getConnectionId()
     * @generated
     */
    void setConnectionId ( String value );

} // IdItem
