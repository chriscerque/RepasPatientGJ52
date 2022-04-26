package view.facade;

import model.entities.EntitiesFactory;
import model.entities.Patient;
import model.entities.Repas;
import model.entities.exceptions.PatientException;
import model.references.C_MSG;
import model.references.RegimeAlimentaire;
import view.facade.exceptions.VueException;
import view.ihm.FabriqueIhm;
import view.ihm.Ihm;
import view.references.C_VIEW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FacadeVueImpl implements FacadeVue {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private Ihm ihm = FabriqueIhm.fabriquerIhmConsole();

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected FacadeVueImpl() {}

    // +-------------------------------------------+
    // |                 METHODES                  |
    // +-------------------------------------------+

    @Override
    public int afficherMenu() {
        // creation du menu
        String[] menu = new String[C_VIEW.MENU.length +2];
        menu[0] = C_VIEW.MENU_TITRE;
        menu[menu.length -1] = C_VIEW.MENU_SORTIR;
        for (int i = 0; i < C_VIEW.MENU.length; i++) {
            menu[i +1] = C_VIEW.MENU[i];
        }
        // saisie du choix par l'utilisateur
        return this.ihm.saisirChoixMenu(menu, true, true);
    }

    @Override
    public void afficherMessage(String message) {
        this.ihm.afficherChaine(message);
    }

    @Override
    public void afficherMessageErreur(String message) {
        this.ihm.afficherChaine(String.format("/!\\ %s /!\\", message));
    }

    @Override
    public void afficherPatient(Patient patient) {

    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        List<RegimeAlimentaire> lstRegimes;
        StringBuilder sb = new StringBuilder();
        for (Patient patient : lstPatients) {
            sb.append(C_MSG.CARACTERE_SEPARATEUR);
            sb.append(String.format("Patient %s %s (%s)%n", patient.getNumSecu(), patient.getNom().toUpperCase(), patient.getPrenom()));
            lstRegimes = patient.getLstRegimeAlimentaire();
            if (lstRegimes.size() == 0) {
                sb.append(C_VIEW.AUCUN_REGIME_ALIMENTAIRE);
            } else {
                sb.append(C_VIEW.ENTETE_REGIME_ALIMENTAIRE_EXISTANT);
                for (RegimeAlimentaire regime : lstRegimes) {
                    sb.append(String.format("%n\t\t%s", regime.getLibelle()));
                }
            }
            sb.append(System.lineSeparator());
        }
        this.ihm.afficherChaine(sb.toString());
    }


    @Override
    public Patient saisirPatient() throws VueException {
        //todo tests
        Patient patient;
        RegimeAlimentaire regime;
        String num = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "numéro de sécurité"));
        String nom = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "nom"));
        String prenom = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "prénom"));
        LocalDate date = this.ihm.saisirLocalDate(C_VIEW.SAISIR_DATE_ENTREE, C_VIEW.PATTERN_DATE);
        try {
            patient = EntitiesFactory.fabriquerPatient(num, nom, prenom, date);
            do {
                regime = this.selectionnerRegimeAlimentaire();
                try {
                    patient.ajouterRegimeAlimentaire(regime);
                } catch (PatientException e) {
                    this.afficherMessageErreur(e.getMessage());
                }
            } while (this.saisirBoolean(C_VIEW.CONTINUER_SELECTION_REGIME_ALIMENTAIRE));
            return patient;
        } catch (PatientException e) {
            throw new VueException(String.format(C_MSG.MSG_PATIENT_CREATION_EXCEPTION, nom, prenom));
        }
    }

    private RegimeAlimentaire selectionnerRegimeAlimentaire() {
        RegimeAlimentaire[] enumValues = RegimeAlimentaire.values();
        String[] menu = new String[RegimeAlimentaire.values().length +1];
        menu[0] = C_VIEW.MSG_SELECTIONNER_REGIME_ALIMENTAIRE;
        for (int i = 0; i < enumValues.length; i++) {
            menu[i +1] = enumValues[i].getLibelle();
        }
        int choix = this.ihm.saisirChoixMenu(menu, true, false);
        return enumValues[choix -1];
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> lstRepas) {
        if (lstPatients.size() == 0) {
            this.afficherMessage(C_MSG.MSG_AUCUN_PATIENT);
        } else if (lstRepas.size() == 0) {
            this.afficherMessage(C_MSG.MSG_AUCUN_REPAS);
        } else {
            Patient patient = this.selectionnerPatient(lstPatients);
            if (Objects.nonNull(patient)) {
                Repas repas;
                do {
                    repas = this.selectionnerUnRepas(lstRepas);
                    try {
                        patient.ajouterRepas(repas);
                    } catch (PatientException e) {
                        this.afficherMessageErreur(e.getMessage());
                    }
                } while (this.saisirBoolean(C_VIEW.CONTINUER_SELECTION_REPAS));
                return patient;
            }
        }
        return null;
    }

    private Repas selectionnerUnRepas(List<Repas> lstrepas) {
        String[] menu = new String[lstrepas.size() +1];
        menu[0] = C_VIEW.MSG_SELECTIONNER_REPAS;
        for (int i = 0; i < lstrepas.size(); i++) {
            menu[i +1] = this.formaterRepas(lstrepas.get(i));
        }
        int choix = this.ihm.saisirChoixMenu(menu, true, false);
        return lstrepas.get(choix -1);
    }

    private String formaterRepas(Repas repas) {
        return String.format("%s %s regime alimentaire :%n", repas.getDateRepas(), repas.getTypeRepas());
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        List<Repas> ajouts = new ArrayList<>();
        return ajouts;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        int choix = this.ihm.saisirChoixMenu(this.creerMenuSelectionPatient(lstPatients), true, true);
        if (choix == 0) {
            return null;
        } else {
            return lstPatients.get(choix -1);
        }
    }

    private String[] creerMenuSelectionPatient(List<Patient> lstPatients) {
        String[] menu = new String[lstPatients.size() +2];
        menu[0] = C_VIEW.MSG_SELECTIONNER_PATIENT;
        menu[menu.length -1] = "Annuler";

        Patient patient;
        for (int i = 0; i < lstPatients.size(); i++) {
            patient = lstPatients.get(i);
            menu[i +1] = String.format("%s %s (%s)", patient.getNom().toUpperCase(), patient.getPrenom(), patient.getNumSecu());
        }
        return menu;
    }

    private boolean saisirBoolean(String message) {
        String[] menu = new String[]{message, "oui", "non"};
        int choix = this.ihm.saisirChoixMenu(menu, true, true);
        if (choix == 0) {
            return false;
        } else {
            return true;
        }
    }
}
