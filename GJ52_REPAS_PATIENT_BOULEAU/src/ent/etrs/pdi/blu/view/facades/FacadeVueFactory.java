package ent.etrs.pdi.blu.view.facades;

public final class FacadeVueFactory {

	private FacadeVueFactory() {
	}

	public static FacadeVue fabriquerVueConsole() {
		return new FacadeVueConsoleImpl();
	}

	public static FacadeVue fabriquerVuePanel() {
		return new FacadeVuePanelmpl();
	}

}
