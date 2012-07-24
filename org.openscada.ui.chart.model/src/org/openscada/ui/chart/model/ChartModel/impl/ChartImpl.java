/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.swt.graphics.RGB;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.model.ChartModel.ChartFactory;
import org.openscada.ui.chart.model.ChartModel.ChartPackage;
import org.openscada.ui.chart.model.ChartModel.DataSeries;
import org.openscada.ui.chart.model.ChartModel.XAxis;
import org.openscada.ui.chart.model.ChartModel.YAxis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#isShowCurrenTimeRuler <em>Show Curren Time Ruler</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getTop <em>Top</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getSelectedYAxis <em>Selected YAxis</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getSelectedXAxis <em>Selected XAxis</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.ChartImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChartImpl extends EObjectImpl implements Chart
{
    /**
     * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected static final String TITLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected String title = TITLE_EDEFAULT;

    /**
     * The default value of the '{@link #isShowCurrenTimeRuler() <em>Show Curren Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowCurrenTimeRuler()
     * @generated
     * @ordered
     */
    protected static final boolean SHOW_CURREN_TIME_RULER_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isShowCurrenTimeRuler() <em>Show Curren Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowCurrenTimeRuler()
     * @generated
     * @ordered
     */
    protected boolean showCurrenTimeRuler = SHOW_CURREN_TIME_RULER_EDEFAULT;

    /**
     * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final RGB BACKGROUND_COLOR_EDEFAULT = (RGB)ChartFactory.eINSTANCE.createFromString ( ChartPackage.eINSTANCE.getRGB (), "#FFFFFF" );

    /**
     * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected RGB backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getBottom() <em>Bottom</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBottom()
     * @generated
     * @ordered
     */
    protected EList<XAxis> bottom;

    /**
     * The cached value of the '{@link #getTop() <em>Top</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTop()
     * @generated
     * @ordered
     */
    protected EList<XAxis> top;

    /**
     * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeft()
     * @generated
     * @ordered
     */
    protected EList<YAxis> left;

    /**
     * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRight()
     * @generated
     * @ordered
     */
    protected EList<YAxis> right;

    /**
     * The cached value of the '{@link #getSelectedYAxis() <em>Selected YAxis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedYAxis()
     * @generated
     * @ordered
     */
    protected YAxis selectedYAxis;

    /**
     * The cached value of the '{@link #getSelectedXAxis() <em>Selected XAxis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedXAxis()
     * @generated
     * @ordered
     */
    protected XAxis selectedXAxis;

    /**
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<DataSeries> inputs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChartImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ChartPackage.Literals.CHART;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTitle ()
    {
        return title;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTitle ( String newTitle )
    {
        String oldTitle = title;
        title = newTitle;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__TITLE, oldTitle, title ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isShowCurrenTimeRuler ()
    {
        return showCurrenTimeRuler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowCurrenTimeRuler ( boolean newShowCurrenTimeRuler )
    {
        boolean oldShowCurrenTimeRuler = showCurrenTimeRuler;
        showCurrenTimeRuler = newShowCurrenTimeRuler;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__SHOW_CURREN_TIME_RULER, oldShowCurrenTimeRuler, showCurrenTimeRuler ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RGB getBackgroundColor ()
    {
        return backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundColor ( RGB newBackgroundColor )
    {
        RGB oldBackgroundColor = backgroundColor;
        backgroundColor = newBackgroundColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<XAxis> getBottom ()
    {
        if ( bottom == null )
        {
            bottom = new EObjectContainmentEList<XAxis> ( XAxis.class, this, ChartPackage.CHART__BOTTOM );
        }
        return bottom;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<XAxis> getTop ()
    {
        if ( top == null )
        {
            top = new EObjectContainmentEList<XAxis> ( XAxis.class, this, ChartPackage.CHART__TOP );
        }
        return top;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<YAxis> getLeft ()
    {
        if ( left == null )
        {
            left = new EObjectContainmentEList<YAxis> ( YAxis.class, this, ChartPackage.CHART__LEFT );
        }
        return left;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<YAxis> getRight ()
    {
        if ( right == null )
        {
            right = new EObjectContainmentEList<YAxis> ( YAxis.class, this, ChartPackage.CHART__RIGHT );
        }
        return right;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public YAxis getSelectedYAxis ()
    {
        if ( selectedYAxis != null && selectedYAxis.eIsProxy () )
        {
            InternalEObject oldSelectedYAxis = (InternalEObject)selectedYAxis;
            selectedYAxis = (YAxis)eResolveProxy ( oldSelectedYAxis );
            if ( selectedYAxis != oldSelectedYAxis )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.CHART__SELECTED_YAXIS, oldSelectedYAxis, selectedYAxis ) );
            }
        }
        return selectedYAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public YAxis basicGetSelectedYAxis ()
    {
        return selectedYAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSelectedYAxis ( YAxis newSelectedYAxis )
    {
        YAxis oldSelectedYAxis = selectedYAxis;
        selectedYAxis = newSelectedYAxis;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__SELECTED_YAXIS, oldSelectedYAxis, selectedYAxis ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis getSelectedXAxis ()
    {
        if ( selectedXAxis != null && selectedXAxis.eIsProxy () )
        {
            InternalEObject oldSelectedXAxis = (InternalEObject)selectedXAxis;
            selectedXAxis = (XAxis)eResolveProxy ( oldSelectedXAxis );
            if ( selectedXAxis != oldSelectedXAxis )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.CHART__SELECTED_XAXIS, oldSelectedXAxis, selectedXAxis ) );
            }
        }
        return selectedXAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis basicGetSelectedXAxis ()
    {
        return selectedXAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSelectedXAxis ( XAxis newSelectedXAxis )
    {
        XAxis oldSelectedXAxis = selectedXAxis;
        selectedXAxis = newSelectedXAxis;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__SELECTED_XAXIS, oldSelectedXAxis, selectedXAxis ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataSeries> getInputs ()
    {
        if ( inputs == null )
        {
            inputs = new EObjectContainmentEList<DataSeries> ( DataSeries.class, this, ChartPackage.CHART__INPUTS );
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__BOTTOM:
                return ( (InternalEList<?>)getBottom () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__TOP:
                return ( (InternalEList<?>)getTop () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__LEFT:
                return ( (InternalEList<?>)getLeft () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__RIGHT:
                return ( (InternalEList<?>)getRight () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__INPUTS:
                return ( (InternalEList<?>)getInputs () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                return getTitle ();
            case ChartPackage.CHART__SHOW_CURREN_TIME_RULER:
                return isShowCurrenTimeRuler ();
            case ChartPackage.CHART__BACKGROUND_COLOR:
                return getBackgroundColor ();
            case ChartPackage.CHART__BOTTOM:
                return getBottom ();
            case ChartPackage.CHART__TOP:
                return getTop ();
            case ChartPackage.CHART__LEFT:
                return getLeft ();
            case ChartPackage.CHART__RIGHT:
                return getRight ();
            case ChartPackage.CHART__SELECTED_YAXIS:
                if ( resolve )
                    return getSelectedYAxis ();
                return basicGetSelectedYAxis ();
            case ChartPackage.CHART__SELECTED_XAXIS:
                if ( resolve )
                    return getSelectedXAxis ();
                return basicGetSelectedXAxis ();
            case ChartPackage.CHART__INPUTS:
                return getInputs ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                setTitle ( (String)newValue );
                return;
            case ChartPackage.CHART__SHOW_CURREN_TIME_RULER:
                setShowCurrenTimeRuler ( (Boolean)newValue );
                return;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                setBackgroundColor ( (RGB)newValue );
                return;
            case ChartPackage.CHART__BOTTOM:
                getBottom ().clear ();
                getBottom ().addAll ( (Collection<? extends XAxis>)newValue );
                return;
            case ChartPackage.CHART__TOP:
                getTop ().clear ();
                getTop ().addAll ( (Collection<? extends XAxis>)newValue );
                return;
            case ChartPackage.CHART__LEFT:
                getLeft ().clear ();
                getLeft ().addAll ( (Collection<? extends YAxis>)newValue );
                return;
            case ChartPackage.CHART__RIGHT:
                getRight ().clear ();
                getRight ().addAll ( (Collection<? extends YAxis>)newValue );
                return;
            case ChartPackage.CHART__SELECTED_YAXIS:
                setSelectedYAxis ( (YAxis)newValue );
                return;
            case ChartPackage.CHART__SELECTED_XAXIS:
                setSelectedXAxis ( (XAxis)newValue );
                return;
            case ChartPackage.CHART__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends DataSeries>)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                setTitle ( TITLE_EDEFAULT );
                return;
            case ChartPackage.CHART__SHOW_CURREN_TIME_RULER:
                setShowCurrenTimeRuler ( SHOW_CURREN_TIME_RULER_EDEFAULT );
                return;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                setBackgroundColor ( BACKGROUND_COLOR_EDEFAULT );
                return;
            case ChartPackage.CHART__BOTTOM:
                getBottom ().clear ();
                return;
            case ChartPackage.CHART__TOP:
                getTop ().clear ();
                return;
            case ChartPackage.CHART__LEFT:
                getLeft ().clear ();
                return;
            case ChartPackage.CHART__RIGHT:
                getRight ().clear ();
                return;
            case ChartPackage.CHART__SELECTED_YAXIS:
                setSelectedYAxis ( (YAxis)null );
                return;
            case ChartPackage.CHART__SELECTED_XAXIS:
                setSelectedXAxis ( (XAxis)null );
                return;
            case ChartPackage.CHART__INPUTS:
                getInputs ().clear ();
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals ( title );
            case ChartPackage.CHART__SHOW_CURREN_TIME_RULER:
                return showCurrenTimeRuler != SHOW_CURREN_TIME_RULER_EDEFAULT;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals ( backgroundColor );
            case ChartPackage.CHART__BOTTOM:
                return bottom != null && !bottom.isEmpty ();
            case ChartPackage.CHART__TOP:
                return top != null && !top.isEmpty ();
            case ChartPackage.CHART__LEFT:
                return left != null && !left.isEmpty ();
            case ChartPackage.CHART__RIGHT:
                return right != null && !right.isEmpty ();
            case ChartPackage.CHART__SELECTED_YAXIS:
                return selectedYAxis != null;
            case ChartPackage.CHART__SELECTED_XAXIS:
                return selectedXAxis != null;
            case ChartPackage.CHART__INPUTS:
                return inputs != null && !inputs.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (title: " );
        result.append ( title );
        result.append ( ", showCurrenTimeRuler: " );
        result.append ( showCurrenTimeRuler );
        result.append ( ", backgroundColor: " );
        result.append ( backgroundColor );
        result.append ( ')' );
        return result.toString ();
    }

} //ChartImpl
