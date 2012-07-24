/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getTitle <em>Title</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#isShowCurrenTimeRuler <em>Show Curren Time Ruler</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getTop <em>Top</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getLeft <em>Left</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getRight <em>Right</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getSelectedYAxis <em>Selected YAxis</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getSelectedXAxis <em>Selected XAxis</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.Chart#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart()
 * @model
 * @generated
 */
public interface Chart extends EObject
{
    /**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Title</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(String)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Title()
     * @model
     * @generated
     */
    String getTitle ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Chart#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
    void setTitle ( String value );

    /**
     * Returns the value of the '<em><b>Show Curren Time Ruler</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Curren Time Ruler</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Curren Time Ruler</em>' attribute.
     * @see #setShowCurrenTimeRuler(boolean)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_ShowCurrenTimeRuler()
     * @model default="true" required="true"
     * @generated
     */
    boolean isShowCurrenTimeRuler ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Chart#isShowCurrenTimeRuler <em>Show Curren Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Curren Time Ruler</em>' attribute.
     * @see #isShowCurrenTimeRuler()
     * @generated
     */
    void setShowCurrenTimeRuler ( boolean value );

    /**
     * Returns the value of the '<em><b>Background Color</b></em>' attribute.
     * The default value is <code>"#FFFFFF"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Color</em>' attribute.
     * @see #setBackgroundColor(RGB)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_BackgroundColor()
     * @model default="#FFFFFF" dataType="org.openscada.ui.chart.model.ChartModel.RGB" required="true"
     *        extendedMetaData="name='backgroundColor'"
     * @generated
     */
    RGB getBackgroundColor ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Chart#getBackgroundColor <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color</em>' attribute.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor ( RGB value );

    /**
     * Returns the value of the '<em><b>Bottom</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.ui.chart.model.ChartModel.XAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bottom</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Bottom</em>' containment reference list.
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Bottom()
     * @model containment="true"
     * @generated
     */
    EList<XAxis> getBottom ();

    /**
     * Returns the value of the '<em><b>Top</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.ui.chart.model.ChartModel.XAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Top</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Top</em>' containment reference list.
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Top()
     * @model containment="true"
     * @generated
     */
    EList<XAxis> getTop ();

    /**
     * Returns the value of the '<em><b>Left</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.ui.chart.model.ChartModel.YAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left</em>' containment reference list.
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Left()
     * @model containment="true"
     * @generated
     */
    EList<YAxis> getLeft ();

    /**
     * Returns the value of the '<em><b>Right</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.ui.chart.model.ChartModel.YAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right</em>' containment reference list.
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Right()
     * @model containment="true"
     * @generated
     */
    EList<YAxis> getRight ();

    /**
     * Returns the value of the '<em><b>Selected YAxis</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected YAxis</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected YAxis</em>' reference.
     * @see #setSelectedYAxis(YAxis)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_SelectedYAxis()
     * @model
     * @generated
     */
    YAxis getSelectedYAxis ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Chart#getSelectedYAxis <em>Selected YAxis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selected YAxis</em>' reference.
     * @see #getSelectedYAxis()
     * @generated
     */
    void setSelectedYAxis ( YAxis value );

    /**
     * Returns the value of the '<em><b>Selected XAxis</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected XAxis</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected XAxis</em>' reference.
     * @see #setSelectedXAxis(XAxis)
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_SelectedXAxis()
     * @model
     * @generated
     */
    XAxis getSelectedXAxis ();

    /**
     * Sets the value of the '{@link org.openscada.ui.chart.model.ChartModel.Chart#getSelectedXAxis <em>Selected XAxis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selected XAxis</em>' reference.
     * @see #getSelectedXAxis()
     * @generated
     */
    void setSelectedXAxis ( XAxis value );

    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.ui.chart.model.ChartModel.DataSeries}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.openscada.ui.chart.model.ChartModel.ChartPackage#getChart_Inputs()
     * @model containment="true"
     * @generated
     */
    EList<DataSeries> getInputs ();

} // Chart
