package marine.etrs.presenteur;

import marine.etrs.ihm_Vue.FacadeVue;
import marine.etrs.ihm_Vue.exceptions.ViewException;
import marine.etrs.ihm_Vue.ihm.exeception.VueException;
import marine.etrs.model_Metier.entities_Class_Factory.Patient;
import marine.etrs.model_Metier.facade.FacadeMetier;
import marine.etrs.model_Metier.facade.exceptions_business.BusinessException;

import java.util.List;
import java.util.Objects;

public class Presenter {


    FacadeVue fVue;
    FacadeMetier fMetier;

    public Presenter(final FacadeVue fvue, final FacadeMetier fmetier) throws PresenterException {
        if (Objects.isNull(fvue) || Objects.isNull(fmetier)) {
            throw new PresenterException("ERR NUL PRESENT");
        }

        this.fMetier = fmetier;
        this.fVue = fvue;

    }

    public void executer() throws VueException {
        int choix = 0;
        do {

            // afficher le menu
            choix = fVue.afficherMenu();

            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);
    }


    private void traiterOption(final int choix) {
        switch (choix) {
            case 1: //Liste les patients
                listerPatient();
                break;

            case 2: //creeer un nouveau patient
                creerNouveauPatient();
                break;

            case 3: //MODIFIER (OPTIONNELLE)
                // modifie un patient
                modifierUnPatient();
                break;

            case 4: //supprime un patient
                supprimerUnPatient();
                break;

            case 5: //ajoute un repas à un patient
                ajouterRepasAPatient();
                break;

            default:
                break;
        }

    }

    private void ajouterRepasAPatient() {



    }

    private void supprimerUnPatient() {
        try {
            Patient patient;
            patient = this.fVue.saisirPatient();
            fMetier.supprimerPatient(patient);
        } catch (ViewException | BusinessException e) {
            e.printStackTrace();
        }

    }

    private void modifierUnPatient() {

        try {
            //TODO A FINIR
            Patient patient;
            patient = this.fVue.saisirPatient();
            fMetier.recupererPatientById(patient.getId());




        } catch (ViewException | BusinessException e) {
            e.printStackTrace();
        }
    }

    private void creerNouveauPatient() {
        try {
            Patient patient;
            patient = this.fVue.saisirPatient();
            fMetier.mettreAJourPatient(patient);
        } catch (ViewException | BusinessException e) {
            e.printStackTrace();
        }
    }

    private void listerPatient() {
        List<Patient> patients = this.fMetier.listerPatients();
        this.fVue.afficherPatients(patients);
    }



}


