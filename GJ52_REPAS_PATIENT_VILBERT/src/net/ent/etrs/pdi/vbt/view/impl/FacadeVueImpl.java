package net.ent.etrs.pdi.vbt.view.impl;

import net.ent.etrs.pdi.vbt.model.entities.EntitiesFactory;
import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.Repas;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.PatientException;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.RegimeAlimentaireException;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;
import net.ent.etrs.pdi.vbt.model.entities.references.RegimeAlimentaire;
import net.ent.etrs.pdi.vbt.view.FacadeVue;
import net.ent.etrs.pdi.vbt.view.exceptions.VueException;
import net.ent.etrs.pdi.vbt.view.ihm.Ihm;
import net.ent.etrs.pdi.vbt.view.ihm.IhmFactory;
import net.ent.etrs.pdi.vbt.view.ihm.exceptions.IhmException;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FacadeVueImpl implements FacadeVue {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private Ihm ihm = IhmFactory.createViewConsole();

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected FacadeVueImpl() {
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
    public void afficherMessage(String msg) {
        ihm.afficher(msg);
    }

    @Override
    public void afficherMessageErreur(String msg) {
        ihm.afficherErreur(msg);
    }

    @Override
    public int afficherMenu() {
        return ihm.saisirChoixMenu(C_MSG.TITRE_MENU_PRINCIPAL, C_MSG.MENU_PRINCIPAL, C_MSG.CHOIX);
    }

    @Override
    public void afficherPatient(Patient patient) {
        ihm.afficher(String.format("%s", C_MSG.CARACTERE_SEPARATEUR),false);
        ihm.afficher(String.format("Patient %s %s (%s)", patient.getNumSecu(), patient.getNom(), patient.getPrenom()));
        afficherRegimeAlimentaire(patient.getLstRegimeAlimentaire());
    }

    private void afficherRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) {
        ihm.afficher("Liste des régimes alimentaires : ");
        for (RegimeAlimentaire regimeAlimentaire : lstRegimeAlimentaire) {
            ihm.afficher(regimeAlimentaire.getLibelle());
        }
    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        for (Patient patient : lstPatients) {
            afficherPatient(patient);
        }
    }

    @Override
    public Patient saisirPatient() throws VueException {
        String numsecu = ihm.saisir(C_MSG.SAISIR_NUMSECU);
        String nom = ihm.saisir(C_MSG.SAISIR_NOM);
        String prenom = ihm.saisir(C_MSG.SAISIR_PRENOM);
        LocalDate dateEntree =  LocalDate.parse(ihm.saisir(C_MSG.SAISIR_DATE_ENTREE), DateTimeFormatter.ofPattern(C_MSG.PATTERN_DATE));

        try {
            Patient patient = EntitiesFactory.fabriquerPatient(numsecu, nom, prenom, dateEntree);
            ihm.afficher(C_MSG.MSG_PATIENT_CREATION);
            selectionnerRegimeAlimentaire(patient);
            return patient;
        } catch (PatientException e) {
            e.printStackTrace();
        }
        throw new VueException(C_MSG.MSG_PATIENT_CREATION_EXCEPTION);
    }

    private void selectionnerRegimeAlimentaire(Patient patient) {
        boolean continuer = false;
        do {
            try {
                patient.ajouterRegimeAlimentaire(choisirRegimeAlimentaire());
            } catch (RegimeAlimentaireException e) {
                e.printStackTrace();
            }
            continuer = ihm.saisirBooleen(C_MSG.AJOUTER_REGIME_ALIMENTAIRE);
        } while (continuer);
    }

    private RegimeAlimentaire choisirRegimeAlimentaire() {
        for (int i=0; i<RegimeAlimentaire.values().length; i++) {
            ihm.afficher(String.format("%d - %s", i+1, RegimeAlimentaire.values()[i].toString()));
        }
        return RegimeAlimentaire.values()[ihm.saisirEntier(C_MSG.SAISIR_REGIME_ALIMENTAIRE, 0, RegimeAlimentaire.values().length)];
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        return null;
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        return null;
    }

    @Override
    public Patient modifierPatient(Patient patient) throws VueException {
        return null;
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        return null;
    }
}
