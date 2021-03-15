/**
 */
package boxes.impl;

import boxes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BoxesFactoryImpl extends EFactoryImpl implements BoxesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoxesFactory init() {
		try {
			BoxesFactory theBoxesFactory = (BoxesFactory)EPackage.Registry.INSTANCE.getEFactory(BoxesPackage.eNS_URI);
			if (theBoxesFactory != null) {
				return theBoxesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BoxesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BoxesPackage.BOXES: return createBoxes();
			case BoxesPackage.BOX1: return createBox1();
			case BoxesPackage.BOX10: return createBox10();
			case BoxesPackage.BOX20: return createBox20();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boxes createBoxes() {
		BoxesImpl boxes = new BoxesImpl();
		return boxes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Box1 createBox1() {
		Box1Impl box1 = new Box1Impl();
		return box1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Box10 createBox10() {
		Box10Impl box10 = new Box10Impl();
		return box10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Box20 createBox20() {
		Box20Impl box20 = new Box20Impl();
		return box20;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoxesPackage getBoxesPackage() {
		return (BoxesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BoxesPackage getPackage() {
		return BoxesPackage.eINSTANCE;
	}

} //BoxesFactoryImpl
