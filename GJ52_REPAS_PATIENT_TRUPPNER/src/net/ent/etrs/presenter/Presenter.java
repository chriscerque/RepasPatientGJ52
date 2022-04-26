package net.ent.etrs.presenter;


import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.presenter.exceptions.PresenterException;
import net.ent.etrs.view.exceptions.ViewException;
import net.ent.etrs.view.facade.FacadeVue;
import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;
import java.util.Objects;

public class Presenter {
    /////ATTRIBUTS/////
    private FacadeMetier metier;
    private FacadeVue vue;

    /////CONSTRUCTEUR/////
    public Presenter(FacadeMetier metier, FacadeVue vue) throws PresenterException {
        if (Objects.isNull(metier)) {
            throw new PresenterException(C_MSG.MSG_FM_NULL);
        }
        if (Objects.isNull(vue)) {
            throw new PresenterException(C_MSG.MSG_FV_NULL);
        }
        this.metier = metier;
        this.vue = vue;
    }

    //TODO: écrire javadoc des méthodes du presenter.
    /////METHODES/////
    public void exec() throws OutilsMenuException {
        this.metier.init();

        int choix = 0;
        do {
            choix = this.vue.afficherMenu();

            traiterOption(choix);
        } while (choix != 0);
    }
    /////////////////////////////////////////////////////////////////////////////////////
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
                this.vue.afficherMessage("\nArrêt de l'application.");
                break;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void listerPatient() {
        this.vue.afficherPatients(this.metier.listerPatients());
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void creerPatient() {
        try {
            this.metier.creerPatient(this.vue.saisirPatient());
        } catch (ViewException | BusinessException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void modifierPatient() {
//        this.vue.afficherMessage("\nOption pas encore disponible...");
        try {
            this.metier.mettreAJourPatient(this.vue.modifierPatient(this.vue.selectionnerPatient(this.metier.listerPatients()), this.metier.listerRepas()));
        } catch (BusinessException | ViewException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void supprimerPatient() {
        try {
            this.metier.supprimerPatient(this.vue.selectionnerPatient(this.metier.listerPatients()));
        } catch (BusinessException | ViewException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void ajouterRepasPatient() {
        try {
            this.vue.ajouterRepasPatient(this.metier.listerPatients(), this.metier.listerRepas());
        } catch (ViewException e) {
            this.vue.afficherMessageErreur(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
}
