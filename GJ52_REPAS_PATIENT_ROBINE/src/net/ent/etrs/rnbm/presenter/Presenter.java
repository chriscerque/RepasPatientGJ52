package net.ent.etrs.rnbm.presenter;

import net.ent.etrs.rnbm.model.entities.Patient;
import net.ent.etrs.rnbm.model.facades.FacadeMetier;
import net.ent.etrs.rnbm.model.facades.exceptions.BusinessException;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;
import net.ent.etrs.rnbm.presenter.exceptions.PresenterException;
import net.ent.etrs.rnbm.view.FacadeVue;
import net.ent.etrs.rnbm.view.exceptions.ViewException;

import java.util.List;
import java.util.Objects;

public class Presenter implements IPresentable {

    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private FacadeVue vue;
    private FacadeMetier metier;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public Presenter(final FacadeVue vue, final FacadeMetier metier) throws Exception {
        this.setMetier(metier);
        this.setVue(vue);
    }

    /* ****************** */
    /* ***** GETTER ***** */
    public FacadeVue getVue() {
        return vue;
    }

    public FacadeMetier getMetier() {
        return metier;
    }

    /* ****************** */
    /* ***** SETTER ***** */
    public void setVue(final FacadeVue vue) throws Exception {
        if (Objects.isNull(vue)) {
            throw new Exception("ERR : le paramètre vue vaut NULL");
        }
        this.vue = vue;
    }

    public void setMetier(final FacadeMetier metier) throws Exception {
        if (Objects.isNull(metier)) {
            throw new Exception("ERR : le paramètre metier vaut NULL");
        }
        this.metier = metier;
    }
    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */

    /* ********************* */
    /* ***** TO STRING ***** */

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void initialiser() {
        metier.initialiserApplication();

    }

    @Override
    public void executer() throws PresenterException {
        int choixMenu = -1;
        do {
            choixMenu = vue.afficherMenu();

            traiterOption(choixMenu);
        } while (choixMenu != 0);

    }

    @Override
    public void ajouterRepasPatient() {
//        try{
//            if (this.metier.listerPatients().size() > 0){
//                this.metier.mettreAJourPatient(vue.ajouterRepasPatient(vue.selectionnerPatient(metier.listerPatients())));
//            }
//
//        } catch (BusinessException e) {
//            vue.afficherMessage(e.getMessage());
//        }


    }

    @Override
    public void traiterOption( final int choixMenu) throws PresenterException {
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
                ajouterRepasPatient();
                break;
            case 0:
                affichageFinProgramme();
                break;

        }

    }

    @Override
    public void listerPatient() {
        vue.afficherPatients(metier.listerPatients());

    }

    @Override
    public void exec() {

    }

    @Override
    public void supprimerPatient() {
        try{
            if (this.metier.listerPatients().size() > 0){
                this.metier.supprimerPatient(vue.selectionnerPatient(metier.listerPatients()));
            }

        } catch (BusinessException e) {
            vue.afficherMessage(e.getMessage());
        }

    }

    @Override
    public void creerPatient() throws PresenterException {
        try {
            this.metier.sauvegarderPatient(this.vue.saisirPatient());
        } catch (BusinessException | ViewException e) {
           throw new PresenterException(C_MSG.MSG_PATIENT_CREATION_EXCEPTION);
        }

    }

    @Override
    public void modifierPatient() {

    }

    @Override
    public void affichageFinProgramme() {
        vue.affichageFinProgramme();

    }



}