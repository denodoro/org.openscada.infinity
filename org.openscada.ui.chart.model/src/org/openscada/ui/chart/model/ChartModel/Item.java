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
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Item#getItemId <em>Item Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getItem()
 * @model abstract="true"
 * @generated
 */
public interface Item extends EObject
{
    /**
     * Returns the value of the '<em><b>Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Id</em>' attribute.
     * @see #setItemId(String)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getItem_ItemId()
     * @model required="true"
     * @generated
     */
    String getItemId ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Item#getItemId <em>Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item Id</em>' attribute.
     * @see #getItemId()
     * @generated
     */
    void setItemId ( String value );

} // Item
