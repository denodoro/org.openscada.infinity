/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.ui.chart.model.ChartModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openscada.ui.chart.model.ChartModel.ChartPackage;
import org.openscada.ui.chart.model.ChartModel.XAxis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAxis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.XAxisImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.openscada.ui.chart.model.ChartModel.impl.XAxisImpl#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XAxisImpl extends AxisImpl implements XAxis
{
    /**
     * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinimum()
     * @generated
     * @ordered
     */
    protected static final long MINIMUM_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinimum()
     * @generated
     * @ordered
     */
    protected long minimum = MINIMUM_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximum()
     * @generated
     * @ordered
     */
    protected static final long MAXIMUM_EDEFAULT = 1000L;

    /**
     * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximum()
     * @generated
     * @ordered
     */
    protected long maximum = MAXIMUM_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XAxisImpl ()
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
        return ChartPackage.Literals.XAXIS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getMinimum ()
    {
        return minimum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMinimum ( long newMinimum )
    {
        long oldMinimum = minimum;
        minimum = newMinimum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.XAXIS__MINIMUM, oldMinimum, minimum ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getMaximum ()
    {
        return maximum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaximum ( long newMaximum )
    {
        long oldMaximum = maximum;
        maximum = newMaximum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.XAXIS__MAXIMUM, oldMaximum, maximum ) );
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
            case ChartPackage.XAXIS__MINIMUM:
                return getMinimum ();
            case ChartPackage.XAXIS__MAXIMUM:
                return getMaximum ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ChartPackage.XAXIS__MINIMUM:
                setMinimum ( (Long)newValue );
                return;
            case ChartPackage.XAXIS__MAXIMUM:
                setMaximum ( (Long)newValue );
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
            case ChartPackage.XAXIS__MINIMUM:
                setMinimum ( MINIMUM_EDEFAULT );
                return;
            case ChartPackage.XAXIS__MAXIMUM:
                setMaximum ( MAXIMUM_EDEFAULT );
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
            case ChartPackage.XAXIS__MINIMUM:
                return minimum != MINIMUM_EDEFAULT;
            case ChartPackage.XAXIS__MAXIMUM:
                return maximum != MAXIMUM_EDEFAULT;
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
        result.append ( " (minimum: " );
        result.append ( minimum );
        result.append ( ", maximum: " );
        result.append ( maximum );
        result.append ( ')' );
        return result.toString ();
    }

} //XAxisImpl
