package marine.etrs.ihm_Vue;

import marine.etrs.ihm_Vue.ihm.Ihm;
import marine.etrs.ihm_Vue.ihm.JPanelIhmImpl;

public final class FabriqueFacadeVue {

	private FabriqueFacadeVue() {}

	public static FacadeVue fabriquerVue(){
		return new FacadeVueConsoleImpl();
	}


}