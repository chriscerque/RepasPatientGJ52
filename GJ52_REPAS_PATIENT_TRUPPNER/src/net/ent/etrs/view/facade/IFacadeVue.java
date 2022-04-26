package net.ent.etrs.view.facade;


import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.Repas;
import net.ent.etrs.view.exceptions.ViewException;
import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;

import java.util.List;

public interface IFacadeVue {

    /**
     * Affiche un message.
     *
     * @param msg le message à afficher.
     */
    void afficherMessage(String msg);
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche un message d'erreur.
     *
     * @param msg le message à afficher.
     */
    void afficherMessageErreur(String msg);
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche le menu principal de l'application.
     *
     * @return le choix de l'option choisie.
     */
    int afficherMenu() throws OutilsMenuException;
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche un patient.
     * @param patient le patient à afficher.
     * @return String
     */
    String afficherPatient(Patient patient);
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche un ensemble de patients.
     *
     * @param lstPatients la liste des patients à afficher.
     */
    void afficherPatients(List<Patient> lstPatients);
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Demande la saisie d'un patient.
     *
     * @return le patient saisi.
     * @throws ViewException si une erreur est survenue durant la saisie.
     */
    Patient saisirPatient() throws ViewException;
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche un ensemble de patients et demande la sélection d'un des patients.
     *
     * @param lstPatients la liste des patients à afficher.
     * @return le patient sélectionné.
     */
    Patient selectionnerPatient(List<Patient> lstPatients) throws ViewException;
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Affiche un ensemble de repas et demande la sélection d'un des repas.
     *
     * @param lstRepas la liste des repas à afficher.
     * @return le repas sélectionné.
     */
    Repas selectionnerRepas(List<Repas> lstRepas) throws ViewException;
    /////////////////////////////////////////////////////////////////////////////////////
    /**
	 * Propose la modification des différents attributs d'un patient.
     * @param patient le patient à modifier.
     * @return le patient modifié.
     * @throws ViewException si une erreur est survenue durant la saisie.
     */
    Patient modifierPatient(Patient patient, List<Repas> lstrepas) throws ViewException;
    /////////////////////////////////////////////////////////////////////////////////////
    /**
	 * Affiche un ensemble de patients et demande la sélection d'un des patients 
	 * puis propose la liste des repas à ajouter au patient sélectionné.
     * @param lstPatients la liste des patients à afficher.
     * @param listRepas la liste des repas à afficher.
     * @return le patient portant sa liste de repas.
     */
    Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) throws ViewException;
    /////////////////////////////////////////////////////////////////////////////////////
}
