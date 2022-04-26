package net.ent.etrs.sgr.presenter;

import net.ent.etrs.sgr.model.entities.Patient;
import net.ent.etrs.sgr.model.exceptions.BusinessException;
import net.ent.etrs.sgr.model.exceptions.VueException;
import net.ent.etrs.sgr.model.facade.IFacadeMetier;
import net.ent.etrs.sgr.view.IFacadeVue;

public class Presenter {

    private IFacadeMetier metier;
    private IFacadeVue vue;

    public Presenter(IFacadeMetier metier, IFacadeVue vue) {
        this.metier = metier;
        this.vue = vue;
    }

    public void executer() {
        try {
            int choix = 0;
            do {
                choix = this.vue.afficherMenu();

                traiterOption(choix);
            } while (choix != 0);
        } catch (VueException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }

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
            case 4 :
                supprimerPatient();
                break;
            case 5 :
                ajouterRepasPatient();
                break;
            default:
                break;
        }
    }

    private void listerPatient(){
        vue.afficherPatients(metier.listerPatients());
    }

    private void creerPatient(){
        try {
            metier.sauvegarderPatient(vue.saisirPatient());
        } catch (BusinessException | VueException e) {
            vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void modifierPatient(){

        Patient mod = null;
        try {
            mod = vue.modifierPatient(vue.selectionnerPatient(metier.listerPatients()));
            metier.mettreAJourPatient(mod);
        } catch (VueException | BusinessException e) {
            vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void supprimerPatient(){
        ;
        try {
            metier.supprimerPatient(vue.selectionnerPatient(metier.listerPatients()));
        } catch (BusinessException | VueException e) {
            vue.afficherMessageErreur(e.getMessage());
        }
    }

    private void ajouterRepasPatient(){

        try {
            vue.ajouterRepasPatient(metier.listerPatients(), metier.listerRepas());
        } catch (VueException e) {
            vue.afficherMessageErreur(e.getMessage());
        }

    }


}
