/**
 */
package psl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link psl.Effort#getPerson <em>Person</em>}</li>
 *   <li>{@link psl.Effort#getPercentage <em>Percentage</em>}</li>
 * </ul>
 *
 * @see psl.PslPackage#getEffort()
 * @model
 * @generated
 */
public interface Effort extends EObject {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see psl.PslPackage#getEffort_Person()
	 * @model
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link psl.Effort#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(int)
	 * @see psl.PslPackage#getEffort_Percentage()
	 * @model default="100"
	 * @generated
	 */
	int getPercentage();

	/**
	 * Sets the value of the '{@link psl.Effort#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(int value);

} // Effort
