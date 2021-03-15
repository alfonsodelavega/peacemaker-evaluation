/**
 */
package boxes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see boxes.BoxesPackage
 * @generated
 */
public interface BoxesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoxesFactory eINSTANCE = boxes.impl.BoxesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boxes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boxes</em>'.
	 * @generated
	 */
	Boxes createBoxes();

	/**
	 * Returns a new object of class '<em>Box1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Box1</em>'.
	 * @generated
	 */
	Box1 createBox1();

	/**
	 * Returns a new object of class '<em>Box10</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Box10</em>'.
	 * @generated
	 */
	Box10 createBox10();

	/**
	 * Returns a new object of class '<em>Box20</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Box20</em>'.
	 * @generated
	 */
	Box20 createBox20();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BoxesPackage getBoxesPackage();

} //BoxesFactory
