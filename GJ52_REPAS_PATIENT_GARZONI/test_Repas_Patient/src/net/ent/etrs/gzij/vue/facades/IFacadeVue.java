package net.ent.etrs.gzij.vue.facades;

import net.ent.etrs.gzij.model.entities.Patient;
import net.ent.etrs.gzij.model.entities.Repas;
import net.ent.etrs.gzij.model.exceptions.PatientException;
import net.ent.etrs.gzij.vue.ihm.ModeAffichage;
import net.ent.etrs.gzij.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.gzij.vue.ihm.exceptions.ViewException;

import java.util.List;

public interface IFacadeVue {

    /**
     * Méthode permettant de définir quelle affcihage prendra l'application.
     * @param modeAffichage ModeAffichage Enumération donnant le choix d'affichage
     */
    void definirModeAffichage(ModeAffichage modeAffichage);

    /**
     * Méthode permettant de définir quelle affcihage prendra l'application.
     *
     * Si le programme doit tourner en mode panel, l'utilisateur doit renseinger le paramètre
     * à PANEL
     * 
     * @param modeAffichage String donnant le choix d'affichage
     */
    void definirModeAffichage(String modeAffichage);


    /**
     * Méthode permettant d'afficher le menu principal de l'application.
     */
    int afficherMenuPrincipal();

    /**
     * Affiche un message.
     *
     * @param msg le message à afficher.
     */
    void afficherMessage(String msg);

    /**
     * Affiche un message d'erreur.
     *
     * @param msg le message à afficher.
     */
    void afficherMessageErreur(String msg);

    /**
     * Affiche le menu principal de l'application.
     *
     * @return le choix de l'option choisie.
     */
    int afficherMenu();

    /**
     * Affiche un patient.
     *
     * @param patient le patient à afficher.
     */
    void afficherPatient(Patient patient);

    /**
     * Affiche un ensemble de patients.
     *
     * @param lstPatients la liste des patients à afficher.
     */
    void afficherPatients(List<Patient> lstPatients);

    /**
     * Demande la saisie d'un patient.
     *
     * @return le patient saisi.
     * @throws ViewException si une erreur est survenue durant la saisie.
     */
    Patient saisirPatient() throws ViewException;

    /**
     * Affiche un ensemble de patients et demande la sélection d'un des patients.
     *
     * @param lstPatients la liste des patients à afficher.
     * @return le patient sélectionné.
     */
    Patient selectionnerPatient(List<Patient> lstPatients);

//    void afficherRepas(Patient c);

    /**
     * Affiche un ensemble de repas et demande la sélection d'un des repas.
     *
     * @param lstRepas la liste des repas à afficher.
     * @return le repas sélectionné.
     */
    List<Repas> selectionnerRepas(List<Repas> lstRepas);

    /**
     * Propose la modification des différents attributs d'un patient.
     * @param patient le patient à modifier.
     * @return le patient modifié.
     * @throws ViewException si une erreur est survenue durant la saisie.
     */
    Patient modifierPatient(Patient patient) throws ViewException;

    /**
     * Affiche un ensemble de patients et demande la sélection d'un des patients
     * puis propose la liste des repas à ajouter au patient sélectionné.
     * @param lstPatients la liste des patients à afficher.
     * @param listRepas la liste des repas à afficher.
     * @return le patient portant sa liste de repas.
     */
    Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) throws ViewException;
} // fin d'Interface
