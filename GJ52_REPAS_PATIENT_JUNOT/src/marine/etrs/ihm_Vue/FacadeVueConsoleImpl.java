package marine.etrs.ihm_Vue;

import marine.etrs.ihm_Vue.exceptions.ViewException;
import marine.etrs.ihm_Vue.ihm.ConstanteIHM;
import marine.etrs.ihm_Vue.ihm.Ihm;
import marine.etrs.ihm_Vue.ihm.OutilsMenuException;
import marine.etrs.model_Metier.entities_Class_Factory.FabriqueMetier;
import marine.etrs.model_Metier.entities_Class_Factory.Patient;
import marine.etrs.model_Metier.entities_Class_Factory.PatientException;
import marine.etrs.model_Metier.entities_Class_Factory.Repas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacadeVueConsoleImpl implements FacadeVue {
    private Ihm ihm;

    public FacadeVueConsoleImpl() {}


    @Override
    public void afficherMessage(String msg) {
        this.ihm.afficherChaine(msg);
    }

    @Override
    public void afficherMessageErreur(String msg) {
        this.ihm.afficherChaine(msg);

    }

    @Override
    public int afficherMenu() {

        try {
            return this.ihm.saisirChoixMenu(ConstanteIHM.TABLEAU_STR_MENU);
        } catch (OutilsMenuException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public void afficherPatient(Patient patient) {
        this.ihm.afficherObjet(patient.toString());

    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        for(Patient patient : lstPatients){
            patient.toString();
        }
    }

    @Override
    public Patient saisirPatient() throws ViewException {

        String numSecu = saisirNumSecuPatient();
        String nom = saisirNomPatient();
        String prenom = saisirPrenomPatient();
        LocalDate dateEntree = saisirDateEntree();

        Patient patient =null;
        try {
            patient = FabriqueMetier.fabriquerPatient(numSecu,nom,prenom,dateEntree);
        } catch (PatientException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {

        this.ihm.afficherChaine(ConstanteIHM.SELECTIONNNER_PATIENT);
        List<String> lstPatientsNom = new ArrayList<>();
        for (Patient partien : lstPatients) {
            lstPatientsNom.add(partien.getNom());
        }
        int choixPatient = getChoixUtilisateur(lstPatients);
        return lstPatients.get(choixPatient-1);
    }

    private int getChoixUtilisateur(List<Patient> liste) {
        int choix = -1;
        choix = this.ihm.saisirEntier("Saisir une patient entre 0 et "+ liste.size(),0,liste.size());
        return choix;
    }


    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {

        //TODO A FAIRE
        return null;
    }


    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        //TODO A FAIRE
        return null;
    }

    @Override
    public Patient modifierPatient(Patient patient) throws ViewException {
        // OPTIONNELLE
        return null;
    }


    /*SAISIE DU NOM DU PATIENT*/
    private String saisirNumSecuPatient() {
        String secu = this.ihm.saisirChaine(ConstanteIHM.SAISIR_NUM_SECU);
        return secu;
    }

    /*SAISIE DU NOM DU PATIENT*/
    private String saisirNomPatient() {
        String nom = this.ihm.saisirChaine(ConstanteIHM.SAISIR_NOM);
        return nom;
    }

    /*SAISIE DU PRENOM DU PATIENT*/
    private String saisirPrenomPatient() {
        String prenom = this.ihm.saisirChaine(ConstanteIHM.SAISIR_PRENOM);
        return prenom;
    }


    /*SAISIE D'UNE DATE ENTREE DU PATIENT*/
    private LocalDate saisirDateEntree() {
         LocalDate date = this.ihm.saisirDate(ConstanteIHM.PATTERN_DATE);
        return date;
    }

}