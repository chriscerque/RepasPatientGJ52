package ent.etrs.pdi.pre.view.facades;

public final class FacadeVueFactory {

	private FacadeVueFactory() {
	}

	public static FacadeVue fabriquerFacadeVue() {
		return new FacadeVueConsoleImpl();
	}
	
	
}
