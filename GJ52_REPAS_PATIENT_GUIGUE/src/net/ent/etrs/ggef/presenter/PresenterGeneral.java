package net.ent.etrs.ggef.presenter;

import net.ent.etrs.ggef.model.exceptions.BusinessException;
import net.ent.etrs.ggef.model.facades.FacadeMetier;
import net.ent.etrs.ggef.presenter.exceptions.ExceptionPresenterGeneral;
import net.ent.etrs.ggef.vue.facades.FacadeVue;
import net.ent.etrs.ggef.vue.facades.exceptions.DisplayException;

import java.util.Objects;

public class PresenterGeneral {
/*----------------------
Attributs +0+1
-----------------------*/
private FacadeVue vue;
private FacadeMetier metier;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

	public PresenterGeneral(final FacadeMetier unMetier, final FacadeVue uneVue) throws ExceptionPresenterGeneral {
		if (Objects.isNull(unMetier)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_METIER_NULL);
		}
		if (Objects.isNull(uneVue)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_VUE_NULL);
		}
		this.metier = unMetier;
		this.vue = uneVue;
	}

	public void exec(){

		int choix = 0;
		do {
			// afficher le menu
			choix = this.vue.afficherMenu();
			// traiter les options du menu
			traiterOption(choix);

		} while (choix != 0);
	}


/*----------------------
AUTRES METHODES
-----------------------*/

	private void traiterOption(int choixMenu){

		switch (choixMenu) {
			case 1:
				listerPatient();
				break;
			case 2:
				creerPatient();
				break;
			case 3:
				modifierPatient();
				break;
			case 4:
				supprimerPatient();
				break;
			case 5:
				AjouterRepasPatient();
				break;

			default:
				break;
		}
	}

	private void listerPatient(){
		vue.afficherPatients(metier.listerPatients());
	}
	private void modifierPatient(){
		try {
			metier.mettreAJourPatient(vue.selectionnerPatient(metier.listerPatients()));
		} catch (BusinessException e) {
			vue.afficherMessage(e.getMessage());
		}
	}
	private void supprimerPatient(){
		try {
			metier.supprimerPatient(vue.selectionnerPatient(metier.listerPatients()));
		} catch (BusinessException e) {
			vue.afficherMessage(e.getMessage());
		}
	}
	private void creerPatient(){
		try {
			metier.sauvegarderPatient(vue.saisirPatient());
		} catch (BusinessException | DisplayException e) {
			vue.afficherMessage(e.getMessage());
		}
	}

	private void AjouterRepasPatient(){
		vue.ajouterRepasPatient(metier.listerPatients(),metier.listerRepas());
	}


}  // fin de classe
