package ent.etrs.pdi.pre.presenter;

import ent.etrs.pdi.pre.model.entities.Patient;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;
import ent.etrs.pdi.pre.model.facades.FacadeMetier;
import ent.etrs.pdi.pre.model.facades.exceptions.BusinessException;
import ent.etrs.pdi.pre.view.exceptions.ViewException;
import ent.etrs.pdi.pre.view.facades.FacadeVue;
import ent.etrs.pdi.pre.view.references.ConstantesView;

import java.util.List;
import java.util.Objects;

public class Presenter {
    /*------- ATTRIBUTS -------*/
    private FacadeMetier metier;
    private FacadeVue vue;

    /*------- CONSTRUCTEUR(S) -------*/
    public Presenter(FacadeMetier metier, FacadeVue vue) {
        this.metier = metier;
        this.vue = vue;
    }

    /*------- AUTRES METHODES -------*/
    public void executer() {
        int choix = 0;
        do {
            // afficher le menu
            try {
                choix = this.vue.afficherMenu();
            } catch (ViewException e) {
                this.vue.afficherMessage(e.getMessage());
            }
            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);

    }

    private void traiterOption(int choix) {
        switch (choix) {
            case 1: //Afficher la liste des patient
                listerPatient();
                break;
            case 2: //Créer un nouveau patient
                creerPatient();
                break;
            case 3: //Modifier un patient
                modifierPatient();
                break;
            case 4: //Supprimer un patient
                supprimerPatient();
                break;
            case 5: //Ajouter un repas à un patient
                ajouterRepasPatient();
                break;

            default:
                break;
        }
    }

    private void listerPatient(){
        List<Patient> lstPatients = this.metier.listerPatients();
        this.vue.afficherPatients(lstPatients);
    }

    private void creerPatient(){
        try {
            Patient patient = this.vue.saisirPatient();
            if (patient.getLstRegimeAlimentaire().size() == 0 || patient.getDateEntree() == null){
                this.vue.afficherMessageErreur("Le patient n'a pas été crée.");
            } else {
                this.metier.sauvegarderPatient(patient);
            }
        } catch (BusinessException | ViewException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void modifierPatient(){
        try {
            this.vue.modifierPatient(this.vue.selectionnerPatient(this.metier.listerPatients()));
        } catch (ViewException e) {
            e.printStackTrace();
        }
    }

    private void supprimerPatient(){
        try {
            this.metier.supprimerPatient(this.vue.selectionnerPatient(this.metier.listerPatients()));
            this.vue.afficherMessage(ConstantesModel.MSG_PATIENT_SUPPRESSION);
        } catch (BusinessException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void ajouterRepasPatient(){
        this.vue.ajouterRepasPatient(this.metier.listerPatients(), this.metier.listerRepas());
    }

}
