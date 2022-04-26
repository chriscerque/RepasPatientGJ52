package net.ent.etrs.presenter;


import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.view.FacadeVue;
import net.ent.etrs.view.exceptions.ViewException;

//@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Presenter {
    private FacadeMetier metier;
    private FacadeVue vue;

    public Presenter(FacadeMetier metier, FacadeVue vue) {
        this.metier = metier;
        this.vue = vue;
    }

    public void exec() {
        int choix = 0;
        do {
            choix = vue.afficherMenu();
            traiterOption(choix);
        } while (choix != 0);
    }

    private void traiterOption(int choix) {
        switch (choix) {
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
                ajouterRepasPatient();
                break;
            default:
                break;
        }

    }

    private void ajouterRepasPatient() {

        try {
            Patient patient = this.vue.ajouterRepasPatient(this.metier.listerPatients(), this.metier.listerRepas());
            this.metier.mettreAJourPatient(patient);
            this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR, patient.getNom(), patient.getPrenom()));
        } catch (BusinessException e) {
            this.vue.afficherMessageErreur(e.getMessage());
//            //TODO stack
//            e.printStackTrace();
        }
    }

    private void modifierPatient() {

        try {
            Patient patient = this.vue.selectionnerPatient(this.metier.listerPatients());
            this.metier.mettreAJourPatient(this.vue.modifierPatient(patient));
            this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR, patient.getNom(), patient.getPrenom()));
        } catch (BusinessException | ViewException e) {
            this.vue.afficherMessageErreur(e.getMessage());
//            //TODO stack
//            e.printStackTrace();
        }
    }


    private void supprimerPatient() {
        try {
            Patient patient = this.vue.selectionnerPatient(this.metier.listerPatients());
            this.metier.supprimerPatient(patient);
            this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_SUPPRESSION, patient.getNom(), patient.getPrenom()));
        } catch (BusinessException e) {
            this.vue.afficherMessageErreur(e.getMessage());
//            //TODO stack
//            e.printStackTrace();
        }

    }

    private void creerPatient() {
        try {
            Patient patient = this.vue.saisirPatient();
            this.metier.sauvegarderPatient(patient);
            this.vue.afficherMessage(String.format(C_MSG.MSG_PATIENT_CREATION, patient.getNom(), patient.getPrenom()));
        } catch (BusinessException | ViewException e) {
            this.vue.afficherMessageErreur(e.getMessage());
//            //TODO stack
//            e.printStackTrace();
        }

    }

    private void listerPatient() {
        this.vue.afficherPatients(this.metier.listerPatients());
    }


}
