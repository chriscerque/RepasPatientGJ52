package ent.etrs.pdi.hllf.view.facade;

import ent.etrs.pdi.hllf.model.entities.Patient;
import ent.etrs.pdi.hllf.model.entities.Repas;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;
import ent.etrs.pdi.hllf.view.exceptions.ViewException;

import java.util.List;

public interface FacadeVue
{
    /**
     * methode permettant de saisir un patient et de l'instancier en passant par la farbique
     * @return Patient
     */
    public Patient saisirPatient(List<RegimeAlimentaire> listRegime) throws ViewException;

    /**
     * methode permettant d'afficher une chaine
     * @param message String
     */
    public void afficherMessage(String message);

    /**
     * methode permettant d'afficher un patient
     * @param patient Patient
     */
    public void afficherPatient(Patient patient);

    /**
     * methode permettant de selectionner une liste de repas
     * @return List<Repas>
     */
    public List<Repas> selectionnerRepas(List<Repas> listRepas);

    /**
     * methode permettant d'afficher un message d'erreur (un message en rouge)
     * @param erreur
     */
    public void afficherMessageErreur(String erreur);

    /**
     * methode permettant d'afficher le menu principal et de recuerer le choix de l'utilisateur
     * @return int
     */
    public int afficherMenu();

    /**
     * methode permettant d'ajouter un repas à un patient
     * @param listPatient List<Patient>
     * @param listRepas List<Repas>
     * @return Patient
     */
    public Patient ajouterRepasPatient(List<Patient> listPatient, List<Repas> listRepas) throws ViewException;

    /**
     * methode permettant de choisir un patient dans une liste
     * @param listPatient List<Patient>
     * @return Patient
     */
    public Patient selectionnerPatient(List<Patient> listPatient);

    /**
     * methode permattant d'afficher la liste des patients
     * @param listPatient List<Patient>
     */
    public void afficherPatients(List<Patient> listPatient);

    /**
     * methode permettant de modifier un patient directement dans la liste
     * @param patient Patient
     * @return Patient
     */
    public Patient modifierPatient(Patient patient) throws ViewException;
}
