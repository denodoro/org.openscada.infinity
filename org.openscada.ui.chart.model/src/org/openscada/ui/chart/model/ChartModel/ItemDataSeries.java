/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Data Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.ItemDataSeries#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getItemDataSeries()
 * @model abstract="true"
 * @generated
 */
public interface ItemDataSeries extends DataSeries
{
    /**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(Item)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getItemDataSeries_Item()
     * @model containment="true" required="true"
     * @generated
     */
    Item getItem ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.ItemDataSeries#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
    void setItem ( Item value );

} // ItemDataSeries
