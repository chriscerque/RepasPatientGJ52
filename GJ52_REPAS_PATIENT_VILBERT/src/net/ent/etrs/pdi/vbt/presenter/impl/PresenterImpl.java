package net.ent.etrs.pdi.vbt.presenter.impl;

import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.Repas;
import net.ent.etrs.pdi.vbt.model.facade.FacadeMetier;
import net.ent.etrs.pdi.vbt.model.facade.exceptions.BusinessException;
import net.ent.etrs.pdi.vbt.presenter.Presenter;
import net.ent.etrs.pdi.vbt.view.FacadeVue;
import net.ent.etrs.pdi.vbt.view.exceptions.VueException;

import java.util.List;

public class PresenterImpl implements Presenter {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private FacadeVue vue;
    private FacadeMetier metier;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected PresenterImpl(FacadeVue vue, FacadeMetier metier) {
        this.vue = vue;
        this.metier = metier;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    SETTERS	                         				//
    //////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    GETTERS					                      	//
    //////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void executer() {
        this.metier.init();
        int choix;
        do {
            choix = this.vue.afficherMenu();
            traiterOption(choix);
        } while (choix != 0);
    }

    /**
     * Méthode qui permet de rediriger l'utilisateur selon son choix dans le menu
     * @param choix de l'utilisateur
     */
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
            case 0:
        }
    }

    private void listerPatient() {
        vue.afficherPatients(metier.listerPatients());
    }

    private void creerPatient() {
        try {
            metier.sauvegarderPatient(vue.saisirPatient());
        } catch (BusinessException | VueException e) {
            e.printStackTrace();
        }
    }

    private void modifierPatient() {
        try {
            metier.mettreAJourPatient(vue.modifierPatient(vue.selectionnerPatient(metier.listerPatients())));
        } catch (BusinessException | VueException e) {
            e.printStackTrace();
        }
    }

    private void supprimerPatient() {
        try {
            metier.supprimerPatient(vue.selectionnerPatient(metier.listerPatients()));
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    private void ajouterRepasPatient() {
        vue.ajouterRepasPatient(metier.listerPatients(), metier.listerRepas());
    }

}
