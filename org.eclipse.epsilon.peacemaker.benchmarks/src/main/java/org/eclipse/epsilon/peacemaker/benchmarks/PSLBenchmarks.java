package org.eclipse.epsilon.peacemaker.benchmarks;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
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

	public void Peacemaker(PeacemakerState state, Blackhole blackhole) throws Exception {

		PeacemakerResource resource = (PeacemakerResource) state.resourceSet.createResource(state.conflictedURI);
		resource.load(null);
		
		blackhole.consume(resource.getConflicts());
	}

	public void EMFDiffMerge(ThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		IEditableModelScope targetScope =
				new FragmentedModelScope(state.resourceSet.getResource(state.leftURI, true), false);
		IEditableModelScope referenceScope =
				new FragmentedModelScope(state.resourceSet.getResource(state.rightURI, true), false);
		IEditableModelScope ancestorScope =
				new FragmentedModelScope(state.resourceSet.getResource(state.ancestorURI, true), false);

		IComparison<EObject> comparison = new EComparisonImpl(targetScope, referenceScope, ancestorScope);
		comparison.compute(new DefaultMatchPolicy(), new DefaultDiffPolicy(), new DefaultMergePolicy(), null);

		blackhole.consume(comparison.getRemainingDifferences());
	}

	public void EMFCompare(ThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		IComparisonScope scope = new DefaultComparisonScope(
				state.resourceSet.getResource(state.leftURI, true),
				state.resourceSet.getResource(state.rightURI, true),
				state.resourceSet.getResource(state.ancestorURI, true));
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		blackhole.consume(comparison.getConflicts());
	}

	@Benchmark
	public void XMILoad(ThreeModelVersionsState state, Blackhole blackhole) throws Exception {

		Resource resource = state.resourceSet.createResource(state.leftURI);
		resource.load(null);
		blackhole.consume(resource.getContents());
	}
}
