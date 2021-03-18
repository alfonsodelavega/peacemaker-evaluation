package org.eclipse.epsilon.peacemaker.benchmarks;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.peacemaker.util.CopyUtils;

import psl.Effort;
import psl.Person;
import psl.Project;
import psl.PslFactory;
import psl.PslPackage;
import psl.Task;

public class PSLConflictModelsGenerator {

	public static void main(String[] args) throws Exception {
		PSLConflictModelsGenerator generator = new PSLConflictModelsGenerator();

		int[][] taskExperiments = getTaskExperiments();
		for (int i = 0; i < taskExperiments.length; i++) {
			int numTasks = taskExperiments[i][0];
			int numConflicts = taskExperiments[i][1];

			generator.createDoubleUpdateTasks(numTasks, numConflicts);
			generator.createUpdateDeleteTasks(numTasks, numConflicts, UPDATEDELETE_TAKS_PATH);
		}

		for (int i = 0; i < NUM_TASKS.length; i++) {
			generator.createUpdateDeleteTasksWithExtraChanges(NUM_TASKS[i], 10);
			generator.createUpdateDeleteTasksWithExtraChanges(NUM_TASKS[i], 50);
			generator.createUpdateDeleteTasksWithExtraChanges(NUM_TASKS[i], 100);

			generator.createUpdateDeleteTasksPercentageConflicts(NUM_TASKS[i], 10);
			generator.createUpdateDeleteTasksPercentageConflicts(NUM_TASKS[i], 50);
			generator.createUpdateDeleteTasksPercentageConflicts(NUM_TASKS[i], 100);
		}
		System.out.println("Done");
	}

	public static final String LEFT = "left";
	public static final String ANCESTOR = "ancestor";
	public static final String RIGHT = "right";
	public static final String CONFLICTED = "conflicted";

	public static final String UPDATE_DELETE_TASKS = "UpdateDeleteTasks";
	public static final String DOUBLE_UPDATE_TASKS = "DoubleUpdateTasks";

	public static final String UPDATEDELETE_TAKS_10PERC_EXTRA_CHANGES = "UpdateDeleteTasks10PercChanges";
	public static final String UPDATEDELETE_TAKS_50PERC_EXTRA_CHANGES = "UpdateDeleteTasks50PercChanges";
	public static final String UPDATEDELETE_TAKS_100PERC_EXTRA_CHANGES = "UpdateDeleteTasks100PercChanges";

	public static final String UPDATEDELETE_TAKS_10PERC_CONFLICTS = "UpdateDeleteTasks10PercConflicts";
	public static final String UPDATEDELETE_TAKS_50PERC_CONFLICTS = "UpdateDeleteTasks50PercConflicts";
	public static final String UPDATEDELETE_TAKS_100PERC_CONFLICTS = "UpdateDeleteTasks100PercConflicts";

	@FunctionalInterface
	public interface ModelsPath {
		public String getPath(int numTasks, int numConflicts, String suffix);
	}

	public static ModelsPath DOUBLEUPDATE_TAKS_PATH = (numTasks, numConflicts, suffix) 
			-> String.format("models/psl-doubleupdateTasks/%delems-%dconflicts_%s.model",
					numTasks, numConflicts, suffix);
			
	public static ModelsPath UPDATEDELETE_TAKS_PATH = (numTasks, numConflicts, suffix) 
			-> String.format("models/psl-updatedeleteTasks/%delems-%dconflicts_%s.model",
					numTasks, numConflicts, suffix);

	// numConflicts is irrelevant for these models
	public static ModelsPath UPDATEDELETE_TAKS_10PERC_EXTRA_CHANGES_PATH = (numTasks, numConflicts, suffix) 
	-> String.format("models/psl-updatedeleteTasks-extraChanges/%delems-10percChanges_%s.model",
					numTasks, suffix);

	public static ModelsPath UPDATEDELETE_TAKS_50PERC_EXTRA_CHANGES_PATH = (numTasks, numConflicts, suffix) 
	-> String.format("models/psl-updatedeleteTasks-extraChanges/%delems-50percChanges_%s.model",
					numTasks, suffix);

	public static ModelsPath UPDATEDELETE_TAKS_100PERC_EXTRA_CHANGES_PATH = (numTasks, numConflicts, suffix) 
	-> String.format("models/psl-updatedeleteTasks-extraChanges/%delems-100percChanges_%s.model",
					numTasks, suffix);

	public static ModelsPath getUpdateDeleteExtraChangesPath(int percentage) {
		switch (percentage) {
		case 10:
			return UPDATEDELETE_TAKS_10PERC_EXTRA_CHANGES_PATH;
		case 50:
			return UPDATEDELETE_TAKS_50PERC_EXTRA_CHANGES_PATH;
		case 100:
			return UPDATEDELETE_TAKS_100PERC_EXTRA_CHANGES_PATH;
		default:
			return null;
		}
	}
	
	// numConflicts is irrelevant for these models
	public static ModelsPath UPDATEDELETE_TAKS_10PERC_CONFLICTS_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/psl-updatedeleteTasks-conflicts/%delems-10percConflicts_%s.model",
					numTasks, suffix);

	public static ModelsPath UPDATEDELETE_TAKS_50PERC_CONFLICTS_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/psl-updatedeleteTasks-conflicts/%delems-50percConflicts_%s.model",
					numTasks, suffix);

	public static ModelsPath UPDATEDELETE_TAKS_100PERC_CONFLICTS_PATH =
			(numTasks, numConflicts, suffix) -> String.format("models/psl-updatedeleteTasks-conflicts/%delems-100percConflicts_%s.model",
					numTasks, suffix);

	public static ModelsPath getUpdateDeletePercentConflicts(int percentage) {
		switch (percentage) {
		case 10:
			return UPDATEDELETE_TAKS_10PERC_CONFLICTS_PATH;
		case 50:
			return UPDATEDELETE_TAKS_50PERC_CONFLICTS_PATH;
		case 100:
			return UPDATEDELETE_TAKS_100PERC_CONFLICTS_PATH;
		default:
			return null;
		}
	}

	public static ModelsPath getModelsPath(String modelsPathName) {
		switch (modelsPathName) {
		case UPDATE_DELETE_TASKS:
			return UPDATEDELETE_TAKS_PATH;
		case DOUBLE_UPDATE_TASKS:
			return DOUBLEUPDATE_TAKS_PATH;

		case UPDATEDELETE_TAKS_10PERC_EXTRA_CHANGES:
			return UPDATEDELETE_TAKS_10PERC_EXTRA_CHANGES_PATH;
		case UPDATEDELETE_TAKS_50PERC_EXTRA_CHANGES:
			return UPDATEDELETE_TAKS_50PERC_EXTRA_CHANGES_PATH;
		case UPDATEDELETE_TAKS_100PERC_EXTRA_CHANGES:
			return UPDATEDELETE_TAKS_100PERC_EXTRA_CHANGES_PATH;

		case UPDATEDELETE_TAKS_10PERC_CONFLICTS:
			return UPDATEDELETE_TAKS_10PERC_CONFLICTS_PATH;
		case UPDATEDELETE_TAKS_50PERC_CONFLICTS:
			return UPDATEDELETE_TAKS_50PERC_CONFLICTS_PATH;
		case UPDATEDELETE_TAKS_100PERC_CONFLICTS:
			return UPDATEDELETE_TAKS_100PERC_CONFLICTS_PATH;
		}
		return null;
	}

	/** number of tasks and conflicts per experiment */
	public static int[][] TASK_EXPERIMENTS = null;

	public static int[] NUM_TASKS = { 1000, 2000, 5000, 10000, 15000, 30000, 50000, 100000, 150000, 200000 };
	public static int[] NUM_CONFLICTS = { 10 };

	public static int[][] getTaskExperiments() {
		if (TASK_EXPERIMENTS != null) {
			return TASK_EXPERIMENTS;
		}

		int numExperiments = NUM_CONFLICTS.length * NUM_TASKS.length;

		TASK_EXPERIMENTS = new int[numExperiments][2];

		for (int tasks = 0; tasks < NUM_TASKS.length; tasks++) {
			for (int conflicts = 0; conflicts < NUM_CONFLICTS.length; conflicts++) {
				int position = tasks * NUM_CONFLICTS.length + conflicts;
				TASK_EXPERIMENTS[position][0] = NUM_TASKS[tasks];
				TASK_EXPERIMENTS[position][1] = NUM_CONFLICTS[conflicts];
			}
		}
		return TASK_EXPERIMENTS;
	}


	protected PslFactory pslFactory = PslPackage.eINSTANCE.getPslFactory();

	public PSLConflictModelsGenerator() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"*", new XMIResourceFactoryImpl());
	}

	/**
	 * Creates conflict models where tasks with conflicts have a name update in both versions
	 */
	public void createDoubleUpdateTasks(int numTasks, int numConflicts) throws Exception {
		String ancestorPath = DOUBLEUPDATE_TAKS_PATH.getPath(numTasks, numConflicts, ANCESTOR);
		String leftPath = DOUBLEUPDATE_TAKS_PATH.getPath(numTasks, numConflicts, LEFT);
		String rightPath = DOUBLEUPDATE_TAKS_PATH.getPath(numTasks, numConflicts, RIGHT);
		String conflictedPath = DOUBLEUPDATE_TAKS_PATH.getPath(numTasks, numConflicts, CONFLICTED);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Project ancestorRoot = pslFactory.createProject();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "projectID");
		
		Random rand = new Random();
		rand.setSeed(127);

		populateAncestor(ancestorResource, ancestorRoot, numTasks, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);


		Set<Integer> conflictedTasks = new HashSet<>();
		while (conflictedTasks.size() < numConflicts) {
			conflictedTasks.add(rand.nextInt(numTasks));
		}

		List<Task> leftTasks = ((Project) leftResource.getContents().get(0)).getTasks();
		List<Task> rightTasks = ((Project) rightResource.getContents().get(0)).getTasks();

		for (int index : conflictedTasks) {
			leftTasks.get(index).setTitle(leftTasks.get(index).getTitle() + LEFT);
			rightTasks.get(index).setTitle(rightTasks.get(index).getTitle() + RIGHT);
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	/**
	 * Creates conflict models where tasks with conflicts have their efforts modified
	 */
	public void createUpdateDeleteTasks(int numTasks, int numConflicts,
			ModelsPath modelsPath) throws Exception {

		String ancestorPath = modelsPath.getPath(numTasks, numConflicts, ANCESTOR);
		String leftPath = modelsPath.getPath(numTasks, numConflicts, LEFT);
		String rightPath = modelsPath.getPath(numTasks, numConflicts, RIGHT);
		String conflictedPath = modelsPath.getPath(numTasks, numConflicts, CONFLICTED);

		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Project ancestorRoot = pslFactory.createProject();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "projectID");

		Random rand = new Random();
		rand.setSeed(127);

		populateAncestor(ancestorResource, ancestorRoot, numTasks, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);

		Set<Integer> conflictedTasks = new HashSet<>();
		while (conflictedTasks.size() < numConflicts) {
			conflictedTasks.add(rand.nextInt(numTasks));
		}

		List<Task> leftTasks = ((Project) leftResource.getContents().get(0)).getTasks();
		List<Task> rightTasks = ((Project) rightResource.getContents().get(0)).getTasks();

		for (int index : conflictedTasks) {
			// left: first effort goes to 70; right: deleted first effort
			leftTasks.get(index).getEffort().get(0).setPercentage(70);
			rightTasks.get(index).getEffort().remove(0);
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	public void createUpdateDeleteTasksPercentageConflicts(
			int numTasks, int percentConflicts) throws Exception {

		ModelsPath modelsPath = getUpdateDeletePercentConflicts(percentConflicts);

		int numConflicts = numTasks * percentConflicts / 100;

		createUpdateDeleteTasks(numTasks, numConflicts, modelsPath);
	}

	/**
	 * Creates conflict models where tasks with conflicts have their efforts modified
	 */
	public void createUpdateDeleteTasksWithExtraChanges(
			int numTasks, int percentChanges) throws Exception {

		ModelsPath modelsPath = getUpdateDeleteExtraChangesPath(percentChanges);

		int numConflicts = 10;
		int numExtraChanges = percentChanges != 100 ? numTasks * percentChanges / 100 : numTasks - numConflicts;

		String ancestorPath = modelsPath.getPath(numTasks, numConflicts, ANCESTOR);
		String leftPath = modelsPath.getPath(numTasks, numConflicts, LEFT);
		String rightPath = modelsPath.getPath(numTasks, numConflicts, RIGHT);
		String conflictedPath = modelsPath.getPath(numTasks, numConflicts, CONFLICTED);

		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResource ancestorResource = (XMIResource) resourceSet.createResource(URI.createFileURI(ancestorPath));

		Project ancestorRoot = pslFactory.createProject();
		ancestorResource.getContents().add(ancestorRoot);
		ancestorResource.setID(ancestorRoot, "projectID");

		Random rand = new Random();
		rand.setSeed(127);

		populateAncestor(ancestorResource, ancestorRoot, numTasks, rand);

		XMIResource leftResource = (XMIResource) resourceSet.createResource(URI.createFileURI(leftPath));
		CopyUtils.copyContents(ancestorResource, leftResource);

		XMIResource rightResource = (XMIResource) resourceSet.createResource(URI.createFileURI(rightPath));
		CopyUtils.copyContents(ancestorResource, rightResource);

		Set<Integer> conflictedTasks = new HashSet<>();
		while (conflictedTasks.size() < numConflicts) {
			conflictedTasks.add(rand.nextInt(numTasks));
		}

		List<Task> leftTasks = ((Project) leftResource.getContents().get(0)).getTasks();
		List<Task> rightTasks = ((Project) rightResource.getContents().get(0)).getTasks();

		for (int index : conflictedTasks) {
			// left: first effort goes to 70; right: deleted first effort
			leftTasks.get(index).getEffort().get(0).setPercentage(70);
			rightTasks.get(index).getEffort().remove(0);
		}

		// changed tasks only in the right side (should be merged with no problem)
		Set<Integer> changedTasks = new HashSet<>();
		while (changedTasks.size() < numExtraChanges) {
			int task = rand.nextInt(numTasks);
			if (!conflictedTasks.contains(task)) {
				changedTasks.add(task);
			}
		}

		for (int task : changedTasks) {
			rightTasks.get(task).setTitle(rightTasks.get(task).getTitle() + RIGHT);
			rightTasks.get(task).setStart(100);
			rightTasks.get(task).setDuration(30);
		}

		ancestorResource.save(Collections.EMPTY_MAP);
		leftResource.save(Collections.EMPTY_MAP);
		rightResource.save(Collections.EMPTY_MAP);

		saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
	}

	protected void saveMergedResource(String leftPath, String ancestorPath,
			String rightPath, String conflictedPath) throws Exception {

		ProcessBuilder pb = new ProcessBuilder("git", "merge-file", "--diff3", "-p", leftPath, ancestorPath, rightPath);
		pb.directory(new File(System.getProperty("user.dir")));
		pb.redirectOutput(new File(conflictedPath));
		Process process = pb.start();
		process.waitFor();
	}

	public void populateAncestor(XMIResource ancestorResource, Project ancestorRoot,
			int numTasks, Random rand) {

		int numPeople = 5;
		for (int p = 0; p < numPeople; p++) {
			Person person = pslFactory.createPerson();
			person.setName("Person" + p);
			ancestorRoot.getPeople().add(person);
			ancestorResource.setID(person, "PersonID" + p);
		}

		for (int t = 0; t < numTasks; t++) {
			Task task = pslFactory.createTask();
			task.setTitle("task" + t);
			task.setDuration(10);
			task.setStart(20);

			// each task made by two people
			Effort effort = pslFactory.createEffort();
			effort.setPercentage(50);
			effort.setPerson(ancestorRoot.getPeople().get(rand.nextInt(numPeople)));
			task.getEffort().add(effort);
			ancestorResource.setID(effort, task.getTitle() + "effort1");

			effort = pslFactory.createEffort();
			effort.setPercentage(50);
			effort.setPerson(ancestorRoot.getPeople().get(rand.nextInt(numPeople)));
			task.getEffort().add(effort);
			ancestorResource.setID(effort, task.getTitle() + "effort2");

			ancestorRoot.getTasks().add(task);
			ancestorResource.setID(task, "taskID" + t);
		}
	}
}