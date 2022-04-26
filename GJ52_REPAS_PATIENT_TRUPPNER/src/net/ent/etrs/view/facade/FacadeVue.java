package net.ent.etrs.view.facade;

import net.ent.etrs.model.entities.EntitiesFactory;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.RegimeAlimentaire;
import net.ent.etrs.model.entities.Repas;
import net.ent.etrs.model.exceptions.PatientException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.view.exceptions.ViewException;
import net.ent.etrs.view.ihm.IhmFactory;
import net.ent.etrs.view.ihm.Ihm;
import net.ent.etrs.view.ihm.exceptionsIhm.BooleanException;
import net.ent.etrs.view.ihm.references.TableauxIhm;
import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;

import java.time.LocalDate;
import java.util.List;

public class FacadeVue implements IFacadeVue{
    private Ihm ihm = IhmFactory.creerIhmConsole();

    /////METHODES/////
    //TODO: écrire javadoc des méthodes non implentées.


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                     SAISIE                      ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public Patient saisirPatient() throws ViewException {
        Patient patient = null;
        boolean choix = false;


        try {
            String nom = saisirNom();
            String prenom = saisirPrenom();
            String numSecu = saisirNumSecu();
            this.ihm.afficherChaine("Veuillez saisir la date de naissance: ");
            LocalDate dateEntree = saisirDate();

            patient = EntitiesFactory.fabriquerPatient(nom, prenom, numSecu, dateEntree);

            do {
                this.ihm.afficherChaine("Veuillez choisir un régime alimentaire: ");
                RegimeAlimentaire ra = choisirRegimeAlimentaire();
                patient.ajouterRegimeAlimentaire(ra);
                this.ihm.afficherChaine("Voulez-vous choisir un autre régime alimentaire ?");
                choix = this.ihm.saisirBooleen();
            }while(choix);

        } catch (PatientException | BooleanException e) {
            throw new ViewException(e.getMessage());
        }

        this.ihm.afficherChaine(String.format(C_MSG.MSG_PATIENT_CREATION, patient.getNom(), patient.getPrenom()));

        return patient;
    }

    private String saisirNom() {
        String nom = null;

        do {
            nom = this.ihm.saisirChaine("Veuillez saisir le nom: ");

            if(nom.length() < 5 || nom.length() > 30)
            {
                this.ihm.saisirChaine("Le nom doit être compris entre 5 et 30 caractères!!");
            }
        }while(nom.length() < 5 || nom.length() > 30);

        return nom.toUpperCase();
    }

    private String saisirPrenom() {
        String prenom = null;

        do {
            prenom = this.ihm.saisirChaine("Veuillez saisir le prénom: ");

            if(prenom.length() < 5 || prenom.length() > 30)
            {
                this.ihm.saisirChaine("Le prénom doit être compris entre 5 et 30 caractères!!");
            }
        }while(prenom.length() < 5 || prenom.length() > 30);

        return prenom;
    }

    private String saisirNumSecu() {
        String numSecu = null;

        do {
            numSecu = this.ihm.saisirChaine("Veuillez saisir un numéro de sécu: ");

            if(numSecu.length() != 5)
            {
                numSecu = this.ihm.saisirChaine("Le numéro de sécu doit être coonstitué de 5 caractères!!");
            }
        }while(numSecu.length() != 5);

        return numSecu;
    }

    private LocalDate saisirDate() {
        return this.ihm.saisirDateJMA();
    }

    private RegimeAlimentaire choisirRegimeAlimentaire() throws ViewException {
        try {
            return RegimeAlimentaire.values()[this.ihm.saisirChoixMenuTabObject2(RegimeAlimentaire.values(), TableauxIhm.TITRE_AFF_REG_ALIM) - 1];
        } catch (OutilsMenuException e) {
            throw new ViewException(e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Patient modifierPatient(Patient patient, List<Repas> lstRepas) throws ViewException {
        boolean choix = false;

        try {
            this.afficherMessage("Voulez vous modifier le nom ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.setNom(this.saisirNom());
            }

            this.afficherMessage("Voulez vous modifier le prénom ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.setPrenom(this.saisirPrenom());
            }

            this.afficherMessage("Voulez vous modifier le numéro de sécu ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.setNumSecu(this.saisirNumSecu());
            }

            this.afficherMessage("Voulez vous modifier la date de naissance ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.setDateNaissance(this.saisirDate());
            }

            this.afficherMessage("Voulez vous ajouter un régime alimentaire ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.ajouterRegimeAlimentaire(this.choisirRegimeAlimentaire());
            }

            this.afficherMessage("Voulez vous ajouter un repas ? ");
            choix = this.ihm.saisirBooleen();
            if(choix)
            {
                patient.ajouterRepas(selectionnerRepas(lstRepas));
            }

            this.afficherMessage(C_MSG.PATIENT_MODIFICATION_OK);
        } catch (BooleanException | PatientException e) {
            throw new ViewException(e.getMessage());
        }

        return patient;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) throws ViewException {
        Patient patient = null;

        String[] lstPatStr = new String[lstPatients.size()];

        for (int i = 0; i < lstPatStr.length; i++) {
            lstPatStr[i] = afficherPatient(lstPatients.get(i));
        }

        this.afficherMessage(C_MSG.SELECTION_PATIENT);

        try {
            patient = lstPatients.get(this.ihm.saisirChoixMenuTabString2(lstPatStr, "") - 1);
        } catch (OutilsMenuException e) {
            throw new ViewException(e.getMessage());
        }

        this.afficherMessage(String.format(C_MSG.MSG_PATIENT_SUPPRESSION, patient.getNom(), patient.getPrenom()));

        return patient;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> lstRepas) throws ViewException {
        //TODO: ajouter règle gestion correspondance repas/régime alimentaire
        Patient patient = null;
        Repas repas = null;
        try {
            patient = selectionnerPatient(lstPatients);
            repas = selectionnerRepas(lstRepas);
            patient.ajouterRepas(repas);
        } catch (ViewException e) {
            throw new ViewException(e.getMessage());
        }

        this.afficherMessage(String.format(C_MSG.REPAS_AJOUT,
                                           repas.getTypeRepas(),
                                           repas.getDateRepas(),
                                           patient.getNom(),
                                           patient.getPrenom()));

        return patient;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Repas selectionnerRepas(List<Repas> lstRepas) throws ViewException {
        Repas repas = null;

        String[] lstRepStr = new String[lstRepas.size()];

        for (int i = 0; i < lstRepStr.length; i++) {
            lstRepStr[i] = afficherRepas(lstRepas.get(i));
        }

        this.afficherMessage(C_MSG.SELECTION_REPAS);

        try {
            repas = lstRepas.get(this.ihm.saisirChoixMenuTabString2(lstRepStr, "") - 1);
        } catch (OutilsMenuException e) {
            throw new ViewException(e.getMessage());
        }

        return repas;
    }
    /////////////////////////////////////////////////////////////////////////////////////








    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                    AFFICHAGE                    ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int afficherMenu() throws OutilsMenuException {
        return this.ihm.saisirChoixMenuTabString(TableauxIhm.TABLO_STR_MENU, TableauxIhm.TITRE_MENU_PRINCIPAL);
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        String[] lstPatStr = new String[lstPatients.size()];

        for (int i = 0; i < lstPatStr.length; i++) {
            lstPatStr[i] = afficherPatient(lstPatients.get(i));
        }

        try {
            this.ihm.afficherTabObject(lstPatStr, "");
        } catch (OutilsMenuException e) {
            afficherMessageErreur(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String afficherPatient(Patient patient) {
        StringBuilder sb = new StringBuilder();

        sb.append(C_MSG.CARACTERE_SEPARATEUR);
        sb.append("Patient ").append(patient.getNumSecu());
        sb.append(" ").append(patient.getNom());
        sb.append(" (").append(patient.getPrenom()).append(")");
        sb.append("\n   Liste des régimes alimentaires :");

        for (RegimeAlimentaire ra: patient.getLstRegimeAlimentaire()) {
                sb.append("\n     ").append(ra.getLibelle());
        }

        return sb.toString();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private String afficherRepas(Repas repas) {
        StringBuilder sb = new StringBuilder();

        sb.append(repas.getTypeRepas());
        sb.append(", date: ").append(repas.getDateRepas());
        sb.append(", régime alimentaire: ");

        for (RegimeAlimentaire ra: repas.getLstRegimeAlimentaire()) {
            sb.append(ra.getLibelle());
        }

        sb.append("\n");

        return sb.toString();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void afficherMessage(String message) {
        this.ihm.afficherChaine(message);
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void afficherMessageErreur(String msg)  {
        this.ihm.afficherChaine(msg);
    }
    /////////////////////////////////////////////////////////////////////////////////////
}
