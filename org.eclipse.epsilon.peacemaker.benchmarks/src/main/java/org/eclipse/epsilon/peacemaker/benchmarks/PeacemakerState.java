package org.eclipse.epsilon.peacemaker.benchmarks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.peacemaker.PeacemakerResourceFactory;
import org.eclipse.epsilon.peacemaker.benchmarks.PSLConflictModelsGenerator.TaskModelsPath;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import boxes.BoxesPackage;
import psl.PslPackage;

@State(Scope.Thread)
public class PeacemakerState {

	// for preparation
	@Param({ "UpdateDeleteTasks" })
	public String modelsPathName;

	@Param({ "1000", "2000", "5000", "10000", "15000", "30000", "50000", "100000", "150000", "200000" })
	public int numElems;

	@Param({ "10" })
	public int numConflicts;

	// used in the benchmark
	public ResourceSet resourceSet;
	public URI conflictedURI;

	@Setup(Level.Trial)
	public void prepareURIs() {
		TaskModelsPath modelsPath = PSLConflictModelsGenerator.getModelsPath(modelsPathName);

		conflictedURI = URI.createFileURI(
				modelsPath.getPath(numElems, numConflicts, PSLConflictModelsGenerator.CONFLICTED));
	}

	@Setup(Level.Iteration)
	public void prepareResourceSet() throws Exception {
		resourceSet = getResourceSet();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"*", new PeacemakerResourceFactory());
	}

	@TearDown(Level.Iteration)
	public void disposeResourceSet() {
		resourceSet = null;
	}

	public ResourceSet getResourceSet() throws Exception {

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"*", new XMIResourceFactoryImpl());

		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getPackageRegistry().put(PslPackage.eINSTANCE.getNsURI(), PslPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(BoxesPackage.eINSTANCE.getNsURI(), BoxesPackage.eINSTANCE);

		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);

		return resourceSet;
	}
}
