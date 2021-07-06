package org.eclipse.epsilon.peacemaker.benchmarks;

import java.io.File;

import org.eclipse.epsilon.peacemaker.benchmarks.PSLConflictModelsGenerator.ModelsPath;

public class PSLMergeModelsMeasurements {

	public static void main(String[] args) throws Exception {
		new PSLMergeModelsMeasurements().measureMergingTime();
		System.out.println("Done");
	}

	public void measureMergingTime() throws Exception {

		int numConflicts = 10;
		int numReps = 10;
		for (int rep = 0; rep < numReps; rep++) {
			System.out.println("Rep " + rep);
			for (int taskIndex = 0; taskIndex < PSLConflictModelsGenerator.NUM_TASKS.length; taskIndex++) {
				int numTasks = PSLConflictModelsGenerator.NUM_TASKS[taskIndex];

				ModelsPath path = PSLConflictModelsGenerator.DOUBLEUPDATE_TAKS_PATH;

				String ancestorPath = path.getPath(numTasks, numConflicts, PSLConflictModelsGenerator.ANCESTOR);
				String leftPath = path.getPath(numTasks, numConflicts, PSLConflictModelsGenerator.LEFT);
				String rightPath = path.getPath(numTasks, numConflicts, PSLConflictModelsGenerator.RIGHT);
				String conflictedPath = path.getPath(numTasks, numConflicts, PSLConflictModelsGenerator.CONFLICTED);

				long start = System.nanoTime();
				saveMergedResource(leftPath, ancestorPath, rightPath, conflictedPath);
				long end = System.nanoTime();
				System.out.printf("NumTasks: %10d\tElapsed:%5d\n", numTasks, (end - start) / 1000000);
			}
		}
	}

	protected void saveMergedResource(String leftPath, String ancestorPath,
			String rightPath, String conflictedPath) throws Exception {

		ProcessBuilder pb = new ProcessBuilder("git", "merge-file", "--diff3", "-p", leftPath, ancestorPath, rightPath);
		pb.directory(new File(System.getProperty("user.dir")));
		pb.redirectOutput(new File(conflictedPath));
		Process process = pb.start();
		process.waitFor();
	}
}