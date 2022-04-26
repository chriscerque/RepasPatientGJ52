package marine.etrs.start;
import marine.etrs.ihm_Vue.FabriqueFacadeVue;
import marine.etrs.ihm_Vue.FacadeVue;
import marine.etrs.ihm_Vue.ihm.exeception.VueException;
import marine.etrs.model_Metier.facade.FabriqueFacadeMetier;
import marine.etrs.model_Metier.facade.FacadeMetier;
import marine.etrs.model_Metier.facade.exceptions_business.BusinessException;
import marine.etrs.presenteur.Presenter;
import marine.etrs.presenteur.PresenterException;


public class Lanceur_MVP {
	public static void main(String[] args) {

		try {
			FacadeMetier fmetier = FabriqueFacadeMetier.fabriquerFacadeMetier();// METIER
			fmetier.init();

			FacadeVue fvue = FabriqueFacadeVue.fabriquerVue(); //TYPE INTERFACE !

			Presenter presenter = new Presenter(fvue,fmetier);

			presenter.executer();
		} catch ( PresenterException | VueException e) {
			e.printStackTrace();
		}
	}
}