package presenter;

import model.entities.Patient;
import model.facade.FacadeMetier;
import model.facade.exceptions.MetierException;
import model.references.C_MSG;
import view.facade.FacadeVue;
import view.facade.exceptions.VueException;

import java.util.Objects;

public class Presenter {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private FacadeMetier metier;
    private FacadeVue vue;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    public Presenter(FacadeMetier metier, FacadeVue vue) {
        this.setMetier(metier);
        this.setVue(vue);
    }

    // +-------------------------------------------+
    // |                  SETTERS                  |
    // +-------------------------------------------+

    public void setMetier(FacadeMetier metier) {
        this.metier = metier;
    }

    public void setVue(FacadeVue vue) {
        this.vue = vue;
    }

    // +-------------------------------------------+
    // |                 METHODES                  |
    // +-------------------------------------------+

    public void exec() {
        this.metier.init();
        int choix;
        do {
            choix = this.vue.afficherMenu();
            this.traiteroption(choix);
        } while (choix != 0);
    }

    private void traiteroption(int choix) {
        switch (choix) {
            case 0:
                break;
            case 1:
                this.listerPatients();
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
        }
    }

    private void listerPatients() {
        this.vue.afficherPatients(this.metier.listerPatients());
    }

    private void creerPatient() {
        Patient patient = null;
        try {
            patient = this.vue.saisirPatient();
            this.metier.sauvegarderPatient(patient);
            this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_CREATION, patient.getPrenom(), patient.getNom().toUpperCase()));
        } catch (MetierException e) {
            this.vue.afficherMessageErreur(String.format(C_MSG.MSG_PATIENT_CREATION_EXCEPTION, patient.getPrenom(), patient.getNom().toUpperCase()));
        } catch (VueException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void modifierPatient() {

    }

    private void supprimerPatient() {
        Patient patient = this.vue.selectionnerPatient(this.metier.listerPatients());
        if (Objects.nonNull(patient)) {
            try {
                this.metier.supprimerPatient(patient);
                this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_SUPPRESSION, patient.getPrenom(), patient.getNom().toUpperCase()));
            } catch (MetierException e) {
                this.vue.afficherMessageErreur(String.format(C_MSG.MSG_PATIENT_SUPPRESSION_EXCEPTION, patient.getPrenom(), patient.getNom().toUpperCase()));
            }
        }
    }

    private void ajouterRepasPatient() {
        Patient patient = this.vue.ajouterRepasPatient(this.metier.listerPatients(), this.metier.listerRepas());
        if (Objects.nonNull(patient)) {
            try {
                this.metier.mettreAJourPatient(patient);
                this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR, patient.getPrenom(), patient.getNom().toUpperCase()));
            } catch (MetierException e) {
                this.vue.afficherMessageErreur(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR_EXCEPTION, patient.getPrenom(), patient.getNom().toUpperCase()));
            }
        }
    }
}
