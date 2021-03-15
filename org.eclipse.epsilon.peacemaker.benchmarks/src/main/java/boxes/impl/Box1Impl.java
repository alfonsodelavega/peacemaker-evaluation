/**
 */
package boxes.impl;

import boxes.Box1;
import boxes.BoxesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Box1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boxes.impl.Box1Impl#getThing1 <em>Thing1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Box1Impl extends BoxImpl implements Box1 {
	/**
	 * The default value of the '{@link #getThing1() <em>Thing1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThing1()
	 * @generated
	 * @ordered
	 */
	protected static final String THING1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThing1() <em>Thing1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThing1()
	 * @generated
	 * @ordered
	 */
	protected String thing1 = THING1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Box1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxesPackage.Literals.BOX1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThing1() {
		return thing1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThing1(String newThing1) {
		String oldThing1 = thing1;
		thing1 = newThing1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoxesPackage.BOX1__THING1, oldThing1, thing1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoxesPackage.BOX1__THING1:
				return getThing1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoxesPackage.BOX1__THING1:
				setThing1((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoxesPackage.BOX1__THING1:
				setThing1(THING1_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoxesPackage.BOX1__THING1:
				return THING1_EDEFAULT == null ? thing1 != null : !THING1_EDEFAULT.equals(thing1);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (thing1: ");
		result.append(thing1);
		result.append(')');
		return result.toString();
	}

} //Box1Impl
