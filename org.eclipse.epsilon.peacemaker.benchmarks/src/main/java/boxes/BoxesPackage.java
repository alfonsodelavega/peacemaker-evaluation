/**
 */
package boxes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see boxes.BoxesFactory
 * @model kind="package"
 * @generated
 */
public interface BoxesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "boxes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "boxes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoxesPackage eINSTANCE = boxes.impl.BoxesPackageImpl.init();

	/**
	 * The meta object id for the '{@link boxes.impl.BoxesImpl <em>Boxes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boxes.impl.BoxesImpl
	 * @see boxes.impl.BoxesPackageImpl#getBoxes()
	 * @generated
	 */
	int BOXES = 0;

	/**
	 * The feature id for the '<em><b>Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXES__BOXES = 0;

	/**
	 * The number of structural features of the '<em>Boxes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Boxes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boxes.impl.BoxImpl <em>Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boxes.impl.BoxImpl
	 * @see boxes.impl.BoxesPackageImpl#getBox()
	 * @generated
	 */
	int BOX = 1;

	/**
	 * The number of structural features of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boxes.impl.Box1Impl <em>Box1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boxes.impl.Box1Impl
	 * @see boxes.impl.BoxesPackageImpl#getBox1()
	 * @generated
	 */
	int BOX1 = 2;

	/**
	 * The feature id for the '<em><b>Thing1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX1__THING1 = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Box1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX1_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Box1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX1_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boxes.impl.Box10Impl <em>Box10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boxes.impl.Box10Impl
	 * @see boxes.impl.BoxesPackageImpl#getBox10()
	 * @generated
	 */
	int BOX10 = 3;

	/**
	 * The feature id for the '<em><b>Thing1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING1 = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Thing2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING2 = BOX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Thing3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING3 = BOX_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Thing4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING4 = BOX_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Thing5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING5 = BOX_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Thing6</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING6 = BOX_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Thing7</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING7 = BOX_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Thing8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING8 = BOX_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Thing9</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING9 = BOX_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Thing10</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10__THING10 = BOX_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Box10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10_FEATURE_COUNT = BOX_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Box10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX10_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boxes.impl.Box20Impl <em>Box20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boxes.impl.Box20Impl
	 * @see boxes.impl.BoxesPackageImpl#getBox20()
	 * @generated
	 */
	int BOX20 = 4;

	/**
	 * The feature id for the '<em><b>Thing1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING1 = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Thing2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING2 = BOX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Thing3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING3 = BOX_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Thing4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING4 = BOX_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Thing5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING5 = BOX_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Thing6</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING6 = BOX_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Thing7</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING7 = BOX_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Thing8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING8 = BOX_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Thing9</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING9 = BOX_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Thing10</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING10 = BOX_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Thing11</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING11 = BOX_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Thing12</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING12 = BOX_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Thing13</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING13 = BOX_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Thing14</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING14 = BOX_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Thing15</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING15 = BOX_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Thing16</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING16 = BOX_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Thing17</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING17 = BOX_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Thing18</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING18 = BOX_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Thing19</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING19 = BOX_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Thing20</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20__THING20 = BOX_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Box20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20_FEATURE_COUNT = BOX_FEATURE_COUNT + 20;

	/**
	 * The number of operations of the '<em>Box20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX20_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link boxes.Boxes <em>Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boxes</em>'.
	 * @see boxes.Boxes
	 * @generated
	 */
	EClass getBoxes();

	/**
	 * Returns the meta object for the containment reference list '{@link boxes.Boxes#getBoxes <em>Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boxes</em>'.
	 * @see boxes.Boxes#getBoxes()
	 * @see #getBoxes()
	 * @generated
	 */
	EReference getBoxes_Boxes();

	/**
	 * Returns the meta object for class '{@link boxes.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box</em>'.
	 * @see boxes.Box
	 * @generated
	 */
	EClass getBox();

	/**
	 * Returns the meta object for class '{@link boxes.Box1 <em>Box1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box1</em>'.
	 * @see boxes.Box1
	 * @generated
	 */
	EClass getBox1();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box1#getThing1 <em>Thing1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing1</em>'.
	 * @see boxes.Box1#getThing1()
	 * @see #getBox1()
	 * @generated
	 */
	EAttribute getBox1_Thing1();

	/**
	 * Returns the meta object for class '{@link boxes.Box10 <em>Box10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box10</em>'.
	 * @see boxes.Box10
	 * @generated
	 */
	EClass getBox10();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing1 <em>Thing1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing1</em>'.
	 * @see boxes.Box10#getThing1()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing1();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing2 <em>Thing2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing2</em>'.
	 * @see boxes.Box10#getThing2()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing2();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing3 <em>Thing3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing3</em>'.
	 * @see boxes.Box10#getThing3()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing3();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing4 <em>Thing4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing4</em>'.
	 * @see boxes.Box10#getThing4()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing4();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing5 <em>Thing5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing5</em>'.
	 * @see boxes.Box10#getThing5()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing5();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing6 <em>Thing6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing6</em>'.
	 * @see boxes.Box10#getThing6()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing6();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing7 <em>Thing7</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing7</em>'.
	 * @see boxes.Box10#getThing7()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing7();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing8 <em>Thing8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing8</em>'.
	 * @see boxes.Box10#getThing8()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing8();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing9 <em>Thing9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing9</em>'.
	 * @see boxes.Box10#getThing9()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing9();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box10#getThing10 <em>Thing10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing10</em>'.
	 * @see boxes.Box10#getThing10()
	 * @see #getBox10()
	 * @generated
	 */
	EAttribute getBox10_Thing10();

	/**
	 * Returns the meta object for class '{@link boxes.Box20 <em>Box20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box20</em>'.
	 * @see boxes.Box20
	 * @generated
	 */
	EClass getBox20();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing1 <em>Thing1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing1</em>'.
	 * @see boxes.Box20#getThing1()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing1();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing2 <em>Thing2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing2</em>'.
	 * @see boxes.Box20#getThing2()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing2();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing3 <em>Thing3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing3</em>'.
	 * @see boxes.Box20#getThing3()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing3();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing4 <em>Thing4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing4</em>'.
	 * @see boxes.Box20#getThing4()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing4();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing5 <em>Thing5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing5</em>'.
	 * @see boxes.Box20#getThing5()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing5();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing6 <em>Thing6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing6</em>'.
	 * @see boxes.Box20#getThing6()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing6();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing7 <em>Thing7</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing7</em>'.
	 * @see boxes.Box20#getThing7()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing7();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing8 <em>Thing8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing8</em>'.
	 * @see boxes.Box20#getThing8()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing8();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing9 <em>Thing9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing9</em>'.
	 * @see boxes.Box20#getThing9()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing9();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing10 <em>Thing10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing10</em>'.
	 * @see boxes.Box20#getThing10()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing10();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing11 <em>Thing11</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing11</em>'.
	 * @see boxes.Box20#getThing11()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing11();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing12 <em>Thing12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing12</em>'.
	 * @see boxes.Box20#getThing12()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing12();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing13 <em>Thing13</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing13</em>'.
	 * @see boxes.Box20#getThing13()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing13();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing14 <em>Thing14</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing14</em>'.
	 * @see boxes.Box20#getThing14()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing14();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing15 <em>Thing15</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing15</em>'.
	 * @see boxes.Box20#getThing15()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing15();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing16 <em>Thing16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing16</em>'.
	 * @see boxes.Box20#getThing16()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing16();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing17 <em>Thing17</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing17</em>'.
	 * @see boxes.Box20#getThing17()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing17();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing18 <em>Thing18</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing18</em>'.
	 * @see boxes.Box20#getThing18()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing18();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing19 <em>Thing19</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing19</em>'.
	 * @see boxes.Box20#getThing19()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing19();

	/**
	 * Returns the meta object for the attribute '{@link boxes.Box20#getThing20 <em>Thing20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thing20</em>'.
	 * @see boxes.Box20#getThing20()
	 * @see #getBox20()
	 * @generated
	 */
	EAttribute getBox20_Thing20();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BoxesFactory getBoxesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link boxes.impl.BoxesImpl <em>Boxes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boxes.impl.BoxesImpl
		 * @see boxes.impl.BoxesPackageImpl#getBoxes()
		 * @generated
		 */
		EClass BOXES = eINSTANCE.getBoxes();

		/**
		 * The meta object literal for the '<em><b>Boxes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOXES__BOXES = eINSTANCE.getBoxes_Boxes();

		/**
		 * The meta object literal for the '{@link boxes.impl.BoxImpl <em>Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boxes.impl.BoxImpl
		 * @see boxes.impl.BoxesPackageImpl#getBox()
		 * @generated
		 */
		EClass BOX = eINSTANCE.getBox();

		/**
		 * The meta object literal for the '{@link boxes.impl.Box1Impl <em>Box1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boxes.impl.Box1Impl
		 * @see boxes.impl.BoxesPackageImpl#getBox1()
		 * @generated
		 */
		EClass BOX1 = eINSTANCE.getBox1();

		/**
		 * The meta object literal for the '<em><b>Thing1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX1__THING1 = eINSTANCE.getBox1_Thing1();

		/**
		 * The meta object literal for the '{@link boxes.impl.Box10Impl <em>Box10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boxes.impl.Box10Impl
		 * @see boxes.impl.BoxesPackageImpl#getBox10()
		 * @generated
		 */
		EClass BOX10 = eINSTANCE.getBox10();

		/**
		 * The meta object literal for the '<em><b>Thing1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING1 = eINSTANCE.getBox10_Thing1();

		/**
		 * The meta object literal for the '<em><b>Thing2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING2 = eINSTANCE.getBox10_Thing2();

		/**
		 * The meta object literal for the '<em><b>Thing3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING3 = eINSTANCE.getBox10_Thing3();

		/**
		 * The meta object literal for the '<em><b>Thing4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING4 = eINSTANCE.getBox10_Thing4();

		/**
		 * The meta object literal for the '<em><b>Thing5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING5 = eINSTANCE.getBox10_Thing5();

		/**
		 * The meta object literal for the '<em><b>Thing6</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING6 = eINSTANCE.getBox10_Thing6();

		/**
		 * The meta object literal for the '<em><b>Thing7</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING7 = eINSTANCE.getBox10_Thing7();

		/**
		 * The meta object literal for the '<em><b>Thing8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING8 = eINSTANCE.getBox10_Thing8();

		/**
		 * The meta object literal for the '<em><b>Thing9</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING9 = eINSTANCE.getBox10_Thing9();

		/**
		 * The meta object literal for the '<em><b>Thing10</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX10__THING10 = eINSTANCE.getBox10_Thing10();

		/**
		 * The meta object literal for the '{@link boxes.impl.Box20Impl <em>Box20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boxes.impl.Box20Impl
		 * @see boxes.impl.BoxesPackageImpl#getBox20()
		 * @generated
		 */
		EClass BOX20 = eINSTANCE.getBox20();

		/**
		 * The meta object literal for the '<em><b>Thing1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING1 = eINSTANCE.getBox20_Thing1();

		/**
		 * The meta object literal for the '<em><b>Thing2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING2 = eINSTANCE.getBox20_Thing2();

		/**
		 * The meta object literal for the '<em><b>Thing3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING3 = eINSTANCE.getBox20_Thing3();

		/**
		 * The meta object literal for the '<em><b>Thing4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING4 = eINSTANCE.getBox20_Thing4();

		/**
		 * The meta object literal for the '<em><b>Thing5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING5 = eINSTANCE.getBox20_Thing5();

		/**
		 * The meta object literal for the '<em><b>Thing6</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING6 = eINSTANCE.getBox20_Thing6();

		/**
		 * The meta object literal for the '<em><b>Thing7</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING7 = eINSTANCE.getBox20_Thing7();

		/**
		 * The meta object literal for the '<em><b>Thing8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING8 = eINSTANCE.getBox20_Thing8();

		/**
		 * The meta object literal for the '<em><b>Thing9</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING9 = eINSTANCE.getBox20_Thing9();

		/**
		 * The meta object literal for the '<em><b>Thing10</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING10 = eINSTANCE.getBox20_Thing10();

		/**
		 * The meta object literal for the '<em><b>Thing11</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING11 = eINSTANCE.getBox20_Thing11();

		/**
		 * The meta object literal for the '<em><b>Thing12</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING12 = eINSTANCE.getBox20_Thing12();

		/**
		 * The meta object literal for the '<em><b>Thing13</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING13 = eINSTANCE.getBox20_Thing13();

		/**
		 * The meta object literal for the '<em><b>Thing14</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING14 = eINSTANCE.getBox20_Thing14();

		/**
		 * The meta object literal for the '<em><b>Thing15</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING15 = eINSTANCE.getBox20_Thing15();

		/**
		 * The meta object literal for the '<em><b>Thing16</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING16 = eINSTANCE.getBox20_Thing16();

		/**
		 * The meta object literal for the '<em><b>Thing17</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING17 = eINSTANCE.getBox20_Thing17();

		/**
		 * The meta object literal for the '<em><b>Thing18</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING18 = eINSTANCE.getBox20_Thing18();

		/**
		 * The meta object literal for the '<em><b>Thing19</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING19 = eINSTANCE.getBox20_Thing19();

		/**
		 * The meta object literal for the '<em><b>Thing20</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX20__THING20 = eINSTANCE.getBox20_Thing20();

	}

} //BoxesPackage
