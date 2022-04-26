package view.facades;

import model.entities.EntitiesFactory;
import model.entities.Patient;
import model.entities.Repas;
import model.entities.exceptions.PatientConstructionException;
import model.entities.exceptions.PatientException;
import view.exceptions.ViewException;
import view.ihm.FabriqueIhm;
import view.ihm.Ihm;
import view.ihm.exceptions.IhmException;
import view.references.C_VIEW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FacadeVueImpl implements FacadeVue {

	private final Ihm ihm = FabriqueIhm.creerIhmconsole();

	@Override
	public void afficherMessage(String msg) {
		ihm.afficherChaine(msg);
	}

	@Override
	public void afficherMessageErreur(String msg) {
		ihm.afficherChaine(msg);
	}

	@Override
	public int afficherMenu() {
		try {
			return ihm.saisirChoixMenu(C_VIEW.MENU);
		} catch (IhmException e) {
			ihm.afficherChaine(e.getMessage());
		}
		return -1;
	}

	@Override
	public void afficherPatient(Patient patient) {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : ").append(patient.getNom()).append("\n");
		sb.append("Prenom : ").append(patient.getPrenom()).append("\n");
		sb.append("Numéro de sécurité sociale : ").append(patient.getNumSecu()).append("\n");
		sb.append("Entrée le : ").append(patient.getDateEntree()).append("\n");

		ihm.afficherChaine(sb.toString());
	}

	@Override
	public void afficherPatients(List<Patient> lstPatients) {
		for (Patient patient : lstPatients) {
			afficherPatient(patient);
		}
	}

	@Override
	public Patient saisirPatient() throws ViewException {
		// Saisi du nom du patient
		String nom = ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "nom"));

		// Saisi du prénom du patient
		String prenom = ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "prénom"));

		// Saisi du numéro de sécurité sociale du patient
		String numSecu = ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "numéro de sécurité sociale"));

		// Saisi de la date d'entrée du patient
		LocalDate dateEntree = ihm.saisirDate(C_VIEW.SAISIR_DATE_ENTREE);

		// Création du patient
		try {
			return EntitiesFactory.fabriquerPatient(numSecu, nom, prenom, dateEntree);
		} catch (PatientConstructionException e) {
			throw new ViewException(e.getMessage());
		}
	}

	@Override
	public Patient selectionnerPatient(List<Patient> lstPatients) {

		try {
			return ihm.saisirChoixMenu(lstPatients);
		} catch (IhmException e) {
			ihm.afficherChaine(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
		List<Repas> lstRepasSelectionnes = new ArrayList<>();
		Repas repas = null;

		do {
			try {
				repas = ihm.saisirChoixMenu(lstRepas);

				if (repas != null) {
					lstRepasSelectionnes.add(repas);
				}
			} catch (IhmException e) {
				ihm.afficherChaine(e.getMessage());
			}
		} while (Objects.nonNull(repas));

		return lstRepasSelectionnes;
	}

	@Override
	public Patient modifierPatient(Patient patient) throws ViewException {
		// Saisi du nom du patient
		String nouveauNom = ihm.saisirChaine(String.format("Nouveau nom " + C_VIEW.MSG_ACTUEL, patient.getNom()));

		// Saisi du prénom du patient
		String nouveauPrenom = ihm.saisirChaine(String.format("Nouveau prénom " + C_VIEW.MSG_ACTUEL, patient.getPrenom()));

		// Saisi du numéro de sécurité sociale du patient
		String nouveauNumSecu = ihm.saisirChaine(String.format("Nouveau numéro de sécurité sociale " + C_VIEW.MSG_ACTUEL, patient.getNumSecu()));

		// Saisi de la date d'entrée du patient
		LocalDate nouvelleDateEntree = ihm.saisirDate(String.format("Nouvelle date d'entrée " + C_VIEW.MSG_ACTUEL, patient.getDateEntree()));

		// Création du patient
		try {
			if(ihm.saisirEntier(C_VIEW.MSG_MODIF_QUESTION + " 1 : oui 0 : non")  == 1) {
				return EntitiesFactory.fabriquerPatient(nouveauNumSecu, nouveauNom, nouveauPrenom, nouvelleDateEntree);
			} else {
				return patient;
			}
		} catch (PatientConstructionException e) {
			throw new ViewException(e.getMessage());
		}
	}

	@Override
	public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
		List<Repas> repas = selectionnerRepas(listRepas);
		Patient patient = selectionnerPatient(lstPatients);
		for(Repas r: repas){
			try {
				patient.ajouterRepas(r);
			} catch (PatientException e) {
				ihm.afficherChaine(e.getMessage());
			}
		}

		return patient;
	}
}
