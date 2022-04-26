package net.ent.etrs.rnbm.presenter;

import net.ent.etrs.rnbm.presenter.exceptions.PresenterException;

public interface IPresentable {
    /**
     * Méthode qui permet d'initaliser les données de l'application
     */
    public void initialiser();

    /**
     * Méthodes execute le déroulement de l'application
     * @throws PresenterException
     */
    public void executer() throws PresenterException;

    /**
     * Méthode qui permet d'ajouter un repas a un patient
     */

    void ajouterRepasPatient();

    /**
     * Méthode qui permet de traiter les choix du menu menu principale;
     * la méthode fait reference a d'autres méthodes.
     * @param choixMenu
     * @throws PresenterException
     */

    void traiterOption(int choixMenu) throws PresenterException;

    /**
     * Méthode qui permet de lister les patient.
     */

    void listerPatient();

    void exec();

    /**
     * Méthode qui permet de supprimer un patient.
     */

    void supprimerPatient();

    /**
     * Méthode qui permet de creer un patient avec tout les parametre necessaires
     * @throws PresenterException
     */

    void creerPatient() throws PresenterException;

    /**
     * Méthode qui modifie un patient
     */

    void modifierPatient();

    /**
     * Message de fin de programme.
     */

    void affichageFinProgramme();



}
