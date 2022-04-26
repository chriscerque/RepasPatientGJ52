package ent.etrs.pdi.pre.view.ihm;

import ent.etrs.pdi.pre.view.ihm.exceptions.IhmException;

import java.time.LocalDate;

public interface Ihm {
    /*------- Affichages -------*/

    /**
     * Méthode qui permet de réaliser l'affichage d'une chaîne.
     * @param str: String, correspond au message à afficher
     */
    void afficherChaine(final String str);

    /**
     * Méthode qui permet d'afficher un tableau à 2 dimension avec une mise en forme.
     * @param titre: String, correspond au titre du tableau
     * @param tabEnTete: String[], correspond à l'en-tête de notre tableau
     * @param tab: String[][], correspond à notre tableau de données à afficher
     * @throws IhmException
     */
    void afficher2DMTableau(final String titre, final String[] tabEnTete, final String[][] tab);

    /**
     * Méthode qui permet l'affichage d'un message au format Erreur.
     * @param msg: String, correspond au message affiché à l'utilisateur
     */
    void afficherErreur(String msg);

    /*------- Saisis -------*/

    /**
     * Méthode qui permet de demander la saisie d'un chîne à l'utilisateur.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @return String, retourne la chaîne saisie par l'utilisateur
     * @throws IhmException
     */
    String saisirChaine(final String msg);

    /**
     * Méthode qui permet la saisie d'un entier à l'utilisateur sans bornes.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @return int, retourne l'entier saisie par l'utilisateur
     */
    int saisirEntier(final String msg);

    /**
     * Méthode qui permet la saisie d'un entier à l'utlisateur avec bornes.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @param min: int, correspond à la borne minimum de choix
     * @param max: int, correspond à la borne maximum de choix (non inclus)
     * @return int, retourne l'entier saisie par l'utilisateur
     */
    int saisirEntier(final String msg, final int min, final int max);

    /**
     * Méthode qui permet la saisie d'un double à l'utilisateur sans bornes.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @return int, retourne l'entier saisie par l'utilisateur
     */
    double saisirDouble(final String msg);

    /**
     * Méthode qui permet la saisie d'un double à l'utilisateur avec bornes.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @param min: double, correspond à la borne minimum de choix
     * @param max: double, correspond à la borne maximum de choix (non inclus)
     * @return int, retourne l'entier saisie par l'utilisateur
     */
    double saisirDouble(final String msg, final double min, final double max);

    /**
     * Méthode qui permet de gérer un boolean dans l'application.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @return boolean, retourne le choix de l'utilisateur
     */
    boolean saisirBoolean(final String msg);

    /**
     * Méthode qui permet la saisie d'une date à l'utilisateur.
     * @param msg: String, correspond au message affiché à l'utilisateur
     * @return LocalDate, retourne la date saisie par l'utilisateur
     */
    LocalDate saisirDate(final String msg);

    /**
     * Méthode qui permet l'affichage d'un menu et la saisie d'un entier à l'utilisateur.
     * @param tabStr: String[], correspond au tableau du menu
     * @return int, retourne l'entier (choix menu) saisie de l'utilisateur
     * @throws IhmException
     */
    int saisirChoixMenuEntier(final String[] tabStr) throws IhmException;

    /**
     * Méthode qui permet l'affichage d'un menu d'enum et la saisie d'un entier à l'utilisateur.
     * @param nomEnumAvecValues: Object[], correspond au tableau d'objets (ici pour les enum)
     * @return int, retourne l'entier (choix menu) saisie de l'utilisateur
     * @throws IhmException
     */
    int saisirChoixMenuEnum(final Object[] nomEnumAvecValues) throws IhmException;
}
