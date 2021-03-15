package org.eclipse.epsilon.peacemaker.benchmarks;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.peacemaker.benchmarks.PSLConflictModelsGenerator.ModelsPath;
import org.eclipse.epsilon.peacemaker.util.CopyUtils;

import boxes.Box;
import boxes.Boxes;
import boxes.BoxesFactory;
import boxes.BoxesPackage;

public class BoxesConflictModelsGenerator {

	public static void main(String[] args) throws Exception {
		BoxesConflictModelsGenerator generator = new BoxesConflictModelsGenerator();

		int[][] experiments = getExperiments();
		for (int i = 0; i < experiments.length; i++) {
			int numElems = experiments[i][0];
			int numConflicts = experiments[i][1];

			generator.createUpdateDeleteConflictModels(numElems, numConflicts,
					(EClass) BoxesPackage.eINSTANCE.getEClassifier("Box1"));

			generator.createUpdateDeleteConflictModels(numElems, numConflicts,
					(EClass) BoxesPackage.eINSTANCE.getEClassifier("Box10"));

			generator.createUpdateDeleteConflictModels(numElems, numConflicts,
					(EClass) BoxesPackage.eINSTANCE.getEClassifier("Box20"));
		}
		System.out.println("Done");
	}

	public static final String LEFT = "left";
	public static final String ANCESTOR = "ancestor";
	public static final String RIGHT = "right";
	public static final String CONFLICTED = "conflicted";

	public static final String UPDATE_DELETE_BOX1 = "UpdateDeleteBox1";
	public static final String UPDATE_DELETE_BOX10 = "UpdateDeleteBox10";
	public static final String UPDATE_DELETE_BOX20 = "UpdateDeleteBox20";

	public static ModelsPath DOUBLEUPDATE_BOXES_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/boxes-doubleupdate/%delems-%dconflicts_%s.model",
					numTasks, numConflicts, suffix);

	public static ModelsPath UPDATEDELETE_BOX1_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/boxes-updatedelete/%delems-%dconflicts-box1_%s.model",
					numTasks, numConflicts, suffix);

	public static ModelsPath UPDATEDELETE_BOX10_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/boxes-updatedelete/%delems-%dconflicts-box10_%s.model",
					numTasks, numConflicts, suffix);

	public static ModelsPath UPDATEDELETE_BOX20_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/boxes-updatedelete/%delems-%dconflicts-box20_%s.model",
					numTasks, numConflicts, suffix);

	public static ModelsPath UPDATEDELETE_BOXES_EXTRA_CHANGES_PATH = (numElems, numConflicts, suffix)
			-> String.format("models/boxes-updatedelete-extraChanges/%delems-%dconflicts_%s.model",
					numElems, numConflicts, suffix);

	public static ModelsPath getUpdateDeleteBoxesPath(String boxType) {
		switch (boxType) {
		case "Box1":
			return UPDATEDELETE_BOX1_PATH;
		case "Box10":
			return UPDATEDELETE_BOX10_PATH;
		case "Box20":
			return UPDATEDELETE_BOX20_PATH;
		default:
			return null;
		}
	}

	public static ModelsPath getModelsPath(String modelsPathName) {
		switch (modelsPathName) {
		case UPDATE_DELETE_BOX1:
			return UPDATEDELETE_BOX1_PATH;
		case UPDATE_DELETE_BOX10:
			return UPDATEDELETE_BOX10_PATH;
		case UPDATE_DELETE_BOX20:
			return UPDATEDELETE_BOX20_PATH;
		}
		return null;
	}

	/** number of elems and conflicts per experiment */
	public static int[][] EXPERIMENTS = null;

	public static int[] NUM_ELEMS = { 1000, 2000, 5000, 10000, 15000, 30000, 50000, 100000, 150000, 200000 };
	public static int[] NUM_CONFLICTS = { 10 };
	
	public static int[][] getExperiments() {
		if (EXPERIMENTS != null) {
			return EXPERIMENTS;
		}
		
		int numExperiments = NUM_CONFLICTS.length * NUM_ELEMS.length;

		EXPERIMENTS = new int[numExperiments][2];

		for (int elems = 0; elems < NUM_ELEMS.length; elems++) {
			for (int conflicts = 0; conflicts < NUM_CONFLICTS.length; conflicts++) {
				int position = elems * NUM_CONFLICTS.length + conflicts;
				EXPERIMENTS[position][0] = NUM_ELEMS[elems];
				EXPERIMENTS[position][1] = NUM_CONFLICTS[conflicts];
			}
		}
		return EXPERIMENTS;
	}


	protected BoxesFactory boxesFactory = BoxesPackage.eINSTANCE.getBoxesFactory();

	public BoxesConflictModelsGenerator() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"*", new XMIResourceFactoryImpl());
	}

	/**
	 * Creates conflict models where tasks with conflicts have their efforts modified
	 */
	public void createDoubleUpdateConflictModels(
			int numElems, int numConflicts, EClass boxType) throws Exception {

		String ancestorPath = DOUBLEUPDATE_BOXES_PATH.getPath(numElems, numConflicts, ANCESTOR);
		String leftPath = DOUBLEUPDATE_BOXES_PATH.getPath(numElems, numConflicts, LEFT);
		String rightPath = DOUBLEUPDATE_BOXES_PATH.getPath(numElems, numConflicts, RIGHT);
		String conflictedPath = DOUBLEUPDATE_BOXES_PATH.getPath(numElems, numConflicts, CONFLICTED);

		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Boxes ancestorRoot = boxesFactory.createBoxes();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "boxesId");

		Random rand = new Random();
		rand.setSeed(127);

		populateAncestor(ancestorResource, ancestorRoot, boxType, numElems, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);

		Set<Integer> conflicted = new HashSet<>();
		while (conflicted.size() < numConflicts) {
			conflicted.add(rand.nextInt(numElems));
		}

		List<Box> leftElems = ((Boxes) leftResource.getContents().get(0)).getBoxes();
		List<Box> rightElems = ((Boxes) rightResource.getContents().get(0)).getBoxes();

		EStructuralFeature feature = boxType.getEStructuralFeature("thing1");
		for (int index : conflicted) {
			leftElems.get(index).eSet(feature, leftElems.get(index).eGet(feature) + LEFT);
			rightElems.get(index).eSet(feature, rightElems.get(index).eGet(feature) + RIGHT);
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	/**
	 * Creates conflict models where tasks with conflicts have their efforts modified
	 */
	public void createUpdateDeleteConflictModels(
			int numElems, int numConflicts, EClass boxType) throws Exception {

		ModelsPath boxesPath = getUpdateDeleteBoxesPath(boxType.getName());

		String ancestorPath = boxesPath.getPath(numElems, numConflicts, ANCESTOR);
		String leftPath = boxesPath.getPath(numElems, numConflicts, LEFT);
		String rightPath = boxesPath.getPath(numElems, numConflicts, RIGHT);
		String conflictedPath = boxesPath.getPath(numElems, numConflicts, CONFLICTED);

		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Boxes ancestorRoot = boxesFactory.createBoxes();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "boxesId");

		Random rand = new Random();
		rand.setSeed(127);
		
		populateAncestor(ancestorResource, ancestorRoot, boxType, numElems, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);

		Set<Integer> conflicted = new HashSet<>();
		while (conflicted.size() < numConflicts) {
			conflicted.add(rand.nextInt(numElems));
		}

		List<Box> leftElems = ((Boxes) leftResource.getContents().get(0)).getBoxes();

		EStructuralFeature feature = boxType.getEStructuralFeature("thing1");
		for (int index : conflicted) {
			leftElems.get(index).eSet(feature, leftElems.get(index).eGet(feature) + LEFT);
		}

		List<Integer> orderedConflictedElems = new ArrayList<>(conflicted);
		Collections.sort(orderedConflictedElems, Collections.reverseOrder());

		Boxes rightRoot = (Boxes) rightResource.getContents().get(0);
		for (int index : orderedConflictedElems) {
			rightRoot.getBoxes().remove(index);
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	/**
	 * Creates conflict models where tasks with conflicts have their efforts modified
	 */
	public void createUpdateDeleteConflictModelsExtraChanges(
			int numElems, int numConflicts, EClass boxType) throws Exception {

		ModelsPath path = UPDATEDELETE_BOXES_EXTRA_CHANGES_PATH;

		String ancestorPath = path.getPath(numElems, numConflicts, ANCESTOR);
		String leftPath = path.getPath(numElems, numConflicts, LEFT);
		String rightPath = path.getPath(numElems, numConflicts, RIGHT);
		String conflictedPath = path.getPath(numElems, numConflicts, CONFLICTED);

		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Boxes ancestorRoot = boxesFactory.createBoxes();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "boxesId");

		Random rand = new Random();
		rand.setSeed(127);

		populateAncestor(ancestorResource, ancestorRoot, boxType, numElems, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);

		Set<Integer> conflicted = new HashSet<>();
		while (conflicted.size() < numConflicts) {
			conflicted.add(rand.nextInt(numElems));
		}

		List<Box> leftElems = ((Boxes) leftResource.getContents().get(0)).getBoxes();

		EStructuralFeature feature = boxType.getEStructuralFeature("thing1");
		for (int index : conflicted) {
			leftElems.get(index).eSet(feature, leftElems.get(index).eGet(feature) + LEFT);
		}

		List<Integer> orderedConflictedElems = new ArrayList<>(conflicted);
		Collections.sort(orderedConflictedElems, Collections.reverseOrder());

		Boxes rightRoot = (Boxes) rightResource.getContents().get(0);
		for (int index : orderedConflictedElems) {
			rightRoot.getBoxes().remove(index);
		}

		// add changes that do not generate a conflict
		int numExtraChanges = numElems / 10;
		Set<Integer> changed = new HashSet<>();
		while (changed.size() < numExtraChanges) {
			int elem = rand.nextInt(numElems - numConflicts);
			if (!conflicted.contains(elem)) {
				changed.add(elem);
			}
		}

		List<Box> rightElems = rightRoot.getBoxes();

		for (int changedElem : changed) {
			Box box = rightElems.get(changedElem);

			for (EAttribute attr : boxType.getEAttributes()) {
				box.eSet(attr, box.eGet(attr) + LEFT);
			}
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	protected void saveMergedResource(String leftPath, String ancestorPath,
			String rightPath, String conflictedPath) throws Exception {

		ProcessBuilder pb = new ProcessBuilder("git", "merge-file", "-p", leftPath, ancestorPath, rightPath);
		pb.directory(new File(System.getProperty("user.dir")));
		pb.redirectOutput(new File(conflictedPath));
		Process process = pb.start();
		process.waitFor();
	}

	public void populateAncestor(XMIResource ancestorResource, Boxes ancestorRoot,
			EClass boxType, int numElems, Random rand) {

		for (int t = 0; t < numElems; t++) {
			Box box = (Box) boxesFactory.create(boxType);

			int thingNumber = 1;
			for (EAttribute attr : boxType.getEAttributes()) {
				box.eSet(attr, "value" + thingNumber);
				thingNumber++;
			}

			ancestorRoot.getBoxes().add(box);
			ancestorResource.setID(box, "boxID" + t);
		}
	}
}