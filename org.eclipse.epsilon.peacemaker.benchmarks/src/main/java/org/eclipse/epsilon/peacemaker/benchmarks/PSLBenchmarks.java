package org.eclipse.epsilon.peacemaker.benchmarks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.generic.api.IComparison;
import org.eclipse.emf.diffmerge.impl.policies.DefaultDiffPolicy;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy;
import org.eclipse.emf.diffmerge.impl.scopes.FragmentedModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.peacemaker.PeacemakerResource;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class PSLBenchmarks {

	@Benchmark
	public void Peacemaker(PeacemakerState state, Blackhole blackhole) throws Exception {

		PeacemakerResource resource = (PeacemakerResource) state.resourceSet.createResource(state.conflictedURI);
		resource.load(null);
		
		blackhole.consume(resource.getConflicts());
	}

	@Benchmark
	public void ParallelPeacemaker(PeacemakerState state, Blackhole blackhole) throws Exception {

		PeacemakerResource resource = (PeacemakerResource) state.resourceSet.createResource(state.conflictedURI);
		resource.setParallelLoad(true);
		resource.load(null);

		blackhole.consume(resource.getConflicts());
	}

	@Benchmark
	public void EMFDiffMerge(PSLThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource leftResource = state.resourceSet.createResource(state.leftURI);
		leftResource.load(null);
		
		Resource rightResource = state.resourceSet.createResource(state.rightURI);
		rightResource.load(null);
		
		Resource ancestorResource = state.resourceSet.createResource(state.ancestorURI);
		ancestorResource.load(null);
		
		IComparison<EObject> comparison = new EComparisonImpl(
				new FragmentedModelScope(leftResource, false),
				new FragmentedModelScope(rightResource, false),
				new FragmentedModelScope(ancestorResource, false));
		comparison.compute(new DefaultMatchPolicy(), new DefaultDiffPolicy(), new DefaultMergePolicy(), null);

		blackhole.consume(comparison.getRemainingDifferences());
	}

	@Benchmark
	public void ParallelEMFDiffMerge(PSLThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		final Resource leftResource = state.resourceSet.createResource(state.leftURI);
		final Resource rightResource = state.resourceSet.createResource(state.rightURI);
		final Resource ancestorResource = state.resourceSet.createResource(state.ancestorURI);

		ExecutorService versionLoadExecutor = Executors.newFixedThreadPool(3);
		List<Future<?>> loadingTasks = new ArrayList<>();

		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					leftResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));

		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					rightResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));

		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					ancestorResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));

		try {
			for (Future<?> task : loadingTasks) {
				task.get();
			}
		}
		catch (InterruptedException e1) {
			e1.printStackTrace(); // TODO: determine a better way to handle this
		}
		catch (ExecutionException executionEx) {
			if (executionEx.getCause() instanceof RuntimeException) {
				throw (RuntimeException) executionEx.getCause();
			}
		}
		versionLoadExecutor.shutdown(); // TODO: use shutdownNow?

		IComparison<EObject> comparison = new EComparisonImpl(
				new FragmentedModelScope(leftResource, false),
				new FragmentedModelScope(rightResource, false),
				new FragmentedModelScope(ancestorResource, false));
		comparison.compute(new DefaultMatchPolicy(), new DefaultDiffPolicy(), new DefaultMergePolicy(), null);

		blackhole.consume(comparison.getRemainingDifferences());
	}

	@Benchmark
	public void EMFCompare(PSLThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource leftResource = state.resourceSet.createResource(state.leftURI);
		leftResource.load(null);

		Resource rightResource = state.resourceSet.createResource(state.rightURI);
		rightResource.load(null);

		Resource ancestorResource = state.resourceSet.createResource(state.ancestorURI);
		ancestorResource.load(null);

		IComparisonScope scope = new DefaultComparisonScope(leftResource, rightResource, ancestorResource);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		blackhole.consume(comparison.getConflicts());
	}

	@Benchmark
	public void ParallelEMFCompare(PSLThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		final Resource leftResource = state.resourceSet.createResource(state.leftURI);
		final Resource rightResource = state.resourceSet.createResource(state.rightURI);
		final Resource ancestorResource = state.resourceSet.createResource(state.ancestorURI);

		ExecutorService versionLoadExecutor = Executors.newFixedThreadPool(3);
		List<Future<?>> loadingTasks = new ArrayList<>();

		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {
			@Override
			public void run() {
				try {
					leftResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));
		
		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {
			@Override
			public void run() {
				try {
					rightResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));
		
		loadingTasks.add(versionLoadExecutor.submit(new Runnable() {
			@Override
			public void run() {
				try {
					ancestorResource.load(null);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));

		try {
			for (Future<?> task : loadingTasks) {
				task.get();
			}
		}
		catch (InterruptedException e1) {
			e1.printStackTrace(); // TODO: determine a better way to handle this
		}
		catch (ExecutionException executionEx) {
			if (executionEx.getCause() instanceof RuntimeException) {
				throw (RuntimeException) executionEx.getCause();
			}
		}
		versionLoadExecutor.shutdown(); // TODO: use shutdownNow?

		IComparisonScope scope = new DefaultComparisonScope(leftResource, rightResource, ancestorResource);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		blackhole.consume(comparison.getConflicts());
	}

	@Benchmark
	public void XMILoad(PSLThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource resource = state.resourceSet.createResource(state.leftURI);
		resource.load(null);

		blackhole.consume(resource.getContents());
	}
}
