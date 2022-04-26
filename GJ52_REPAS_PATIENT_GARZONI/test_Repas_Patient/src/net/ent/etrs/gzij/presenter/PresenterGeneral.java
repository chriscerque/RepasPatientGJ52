package net.ent.etrs.gzij.presenter;

import net.ent.etrs.gzij.model.entities.Patient;
import net.ent.etrs.gzij.model.entities.Repas;
import net.ent.etrs.gzij.model.exceptions.BusinessException;
import net.ent.etrs.gzij.model.facades.IFacadeMetier;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;
import net.ent.etrs.gzij.presenter.exceptions.ExceptionPresenterGeneral;
import net.ent.etrs.gzij.vue.facades.IFacadeVue;
import net.ent.etrs.gzij.vue.ihm.exceptions.ViewException;
import net.ent.etrs.gzij.vue.ihm.referencies.IhmConstantes;

import java.util.List;
import java.util.Objects;

public class PresenterGeneral {
/*----------------------
Attributs +0+1
-----------------------*/
private IFacadeVue vue;
private IFacadeMetier metier;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

	public PresenterGeneral(final IFacadeMetier unMetier, final IFacadeVue uneVue) throws ExceptionPresenterGeneral {
		if (Objects.isNull(unMetier)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_METIER_NULL);
		}
		if (Objects.isNull(uneVue)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_VUE_NULL);
		}
		this.metier = unMetier;
		this.vue = uneVue;
		this.init();
	}


/*----------------------
AUTRES METHODES
-----------------------*/
	public void init() {
		this.metier.init();
	}

	public void executer(){
		boolean quitter = false;
		do {
			int choixMenu;
			choixMenu = this.vue.afficherMenuPrincipal();
			quitter = traiterOption(choixMenu);
		} while(!quitter);
	}

	/**
	 * Méthode permettant de lister les patients.
	 */
	private void listerPatient() {
		List<Patient> patients = this.metier.listerPatients();
		this.vue.afficherPatients(patients);
	}

	/**
	 * Méthode permettant de modifier un patient.
	 *
	 * Non terminé
	 */
	private void modifierPatient() {

		this.vue.afficherMessage(IhmConstantes.METHODE_NON_TERMINEE);

		Patient patient = this.vue.selectionnerPatient(this.metier.listerPatients());

		try {
			patient = this.vue.modifierPatient(patient);

			this.metier.mettreAJourPatient(patient);

		} catch (ViewException | BusinessException e) {
			this.vue.afficherMessageErreur(e.getMessage());
		}
	}

	/**
	 * Méthode permettant de supprimer un patient.
	 */
	private void supprimerPatient() {
		Patient patient = this.vue.selectionnerPatient(this.metier.listerPatients());

		try {
			this.metier.supprimerPatient(patient);
		} catch (BusinessException e) {
			this.vue.afficherMessageErreur(e.getMessage());
		}
	}

	/**
	 * Méthode permettant de créer un patient.
	 */
	private void creerPatient() {
		Patient patient = null;
		try {
			patient = this.vue.saisirPatient();
			this.metier.sauvegarderPatient(patient);
			this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_CREATION, patient.getNom(), patient.getPrenom()));
		} catch (ViewException | BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Méthode permettant d'ajouter un repas à un patient choisi dans une liste.
	 */
	private void ajouterRepasPatient() {
		List<Patient> patients = this.metier.listerPatients();
		List<Repas> repas = this.metier.listerRepas();
		Patient patient;

		try {
			patient = this.vue.ajouterRepasPatient(patients, repas);
			if(Objects.isNull(patient)) {
				this.vue.afficherMessage("Opération annulée");
			}
			else {
				this.metier.mettreAJourPatient(patient);
			}
		} catch (ViewException | BusinessException e) {
			this.vue.afficherMessageErreur(e.getMessage());
		}

	}

	/**
	 * Méthode permettant de réaliser le choix de l'action à effectuer.
	 *
	 * @param choix int choix à effectuer
	 * @return boolean 
	 */
	private boolean traiterOption(final int choix) {
		switch(choix) {
			case 0:
				return true;
			case 1:
				this.listerPatient();
				break;
			case 2:
				this.creerPatient();
				break;
			case 3:
				this.modifierPatient();
				break;
			case 4:
				this.supprimerPatient();
				break;
			case 5:
				this.ajouterRepasPatient();
				break;
			default:
				return true;
		}
		return false;
	}

}  // fin de classe