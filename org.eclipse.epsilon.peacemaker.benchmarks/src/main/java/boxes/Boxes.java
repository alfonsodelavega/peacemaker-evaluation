/**
 */
package boxes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boxes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boxes.Boxes#getBoxes <em>Boxes</em>}</li>
 * </ul>
 *
 * @see boxes.BoxesPackage#getBoxes()
 * @model
 * @generated
 */
public interface Boxes extends EObject {
	/**
	 * Returns the value of the '<em><b>Boxes</b></em>' containment reference list.
	 * The list contents are of type {@link boxes.Box}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boxes</em>' containment reference list.
	 * @see boxes.BoxesPackage#getBoxes_Boxes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Box> getBoxes();

} // Boxes
