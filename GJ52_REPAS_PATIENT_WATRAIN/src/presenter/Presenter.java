package presenter;

import model.entities.Patient;
import model.facade.FacadeMetier;
import model.facade.exceptions.BusinessException;
import model.references.C;
import presenter.exceptions.PresenterException;
import view.exceptions.ViewException;
import view.facades.FacadeVue;
import view.references.C_VIEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Presenter {

    private final FacadeVue vue;
    private final FacadeMetier metier;

    public Presenter(FacadeMetier metier, FacadeVue vue) throws PresenterException {
        if (Objects.isNull(metier)) {
            throw new PresenterException("FacadeMetier is null");
        }
        if (Objects.isNull(vue)) {
            throw new PresenterException("FacadeVue is null");
        }
        this.vue = vue;
        this.metier = metier;

        metier.init();
    }

    public void exec() {
        int choix = 0;
        do {
            try {
                choix = vue.afficherMenu();
                if(choix != -1) {traiterOption(choix);}
            } catch (PresenterException e) {
                vue.afficherMessage(e.getMessage());
            }
        } while (choix != -1);
    }

    private void traiterOption(int choix) throws PresenterException {
        switch (choix) {
            case C_VIEW.LISTER_PATIENT:
                listerPatient();
                break;
            case C_VIEW.CREER_PATIENT:
                creerPatient();
                break;
            case C_VIEW.MODIFIER_PATIENT:
                modifierPatient();
                break;
            case C_VIEW.SUPPRIMER_PATIENT:
                supprimerPatient();
                break;
            case C_VIEW.AJOUTER_REPAS_PATIENT:
                ajouterRepasPatient();
                break;
            default:
                vue.afficherMessage("Choix inconnu");
        }
    }

    /**
     * Ajoute un ou plusieurs repas à un patient.
     */
    private void ajouterRepasPatient() {
        try {
            metier.mettreAJourPatient(vue.ajouterRepasPatient(metier.listerPatients(), metier.listerRepas()));
        } catch (BusinessException e) {
            vue.afficherMessage(e.getMessage());
        }
    }

    /**
     * liste les patients.
     */
    private void listerPatient() {
        vue.afficherPatients(metier.listerPatients());
    }

    /**
     * Supprime un patient.
     */
    private void supprimerPatient() {
        try {
            Patient patient = vue.selectionnerPatient(metier.listerPatients());
            if(Objects.nonNull(patient)) {
                metier.supprimerPatient(patient);
                vue.afficherMessage(String.format(C.MSG_PATIENT_SUPPRESSION, patient.getNom(), patient.getPrenom()));
            }
        } catch (BusinessException e) {
            vue.afficherMessage(e.getMessage());
        }
    }

    /**
     * Crée un patient.
     * @throws PresenterException
     */
    private void creerPatient() throws PresenterException {
        try {
            metier.sauvegarderPatient(vue.saisirPatient());
            vue.afficherMessage(C.MSG_PATIENT_CREATION);
        } catch (BusinessException | ViewException e) {
            vue.afficherMessage(C.MSG_PATIENT_CREATION);
            throw new PresenterException(e.getMessage());
        }
    }

    /**
     * Modifie un patient.
     */
    private void modifierPatient() {
        try {
            metier.mettreAJourPatient(vue.modifierPatient(vue.selectionnerPatient(metier.listerPatients())));
        } catch (BusinessException | ViewException e) {
            System.out.println(e.getMessage());
        }
    }
}
