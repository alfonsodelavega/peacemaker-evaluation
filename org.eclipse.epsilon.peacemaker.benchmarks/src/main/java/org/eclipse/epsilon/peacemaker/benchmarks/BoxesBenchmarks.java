package org.eclipse.epsilon.peacemaker.benchmarks;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.generic.api.IComparison;
import org.eclipse.emf.diffmerge.impl.policies.DefaultDiffPolicy;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy;
import org.eclipse.emf.diffmerge.impl.scopes.FragmentedModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class BoxesBenchmarks {

	// peacemaker boxes benchmarks are also run in PSLBenchmarks 

	@Benchmark
	public void EMFDiffMerge(BoxesThreeModelVersionsState state, Blackhole blackhole) throws Exception {

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
	public void EMFCompare(BoxesThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource leftResource = state.resourceSet.createResource(state.leftURI);
		leftResource.load(null);

		Resource rightResource = state.resourceSet.createResource(state.rightURI);
		rightResource.load(null);

		Resource ancestorResource = state.resourceSet.createResource(state.ancestorURI);
		ancestorResource.load(null);

		IComparisonScope scope = new DefaultComparisonScope(leftResource, rightResource, ancestorResource);

		// omit ordering check because of an existing bug as of now
		//  https://bugs.eclipse.org/bugs/show_bug.cgi?id=432497

		IDiffProcessor diffProcessor = new DiffBuilder();
		IDiffEngine diffEngine = new DefaultDiffEngine(diffProcessor) {

			@Override
			protected FeatureFilter createFeatureFilter() {
				return new FeatureFilter() {

					@Override
					public boolean checkForOrderingChanges(EStructuralFeature feature) {
						return false;
					}
				};
			}
		};
		Comparison comparison = EMFCompare.builder().setDiffEngine(diffEngine).build().compare(scope);

		blackhole.consume(comparison.getConflicts());
	}

	@Benchmark
	public void XMILoad(BoxesThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource resource = state.resourceSet.createResource(state.leftURI);
		resource.load(null);

		blackhole.consume(resource.getContents());
	}
}
