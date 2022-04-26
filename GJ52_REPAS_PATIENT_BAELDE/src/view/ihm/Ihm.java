package view.ihm;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public interface Ihm {

    // ************************************************** //
    // methodes ecrites dans la classe abstraite de l'ihm //
    // ************************************************** //


    /**
     * Methode permettant de demander la saisie d'un entier a l'utilisateur.
     * @param msg Message a afficher pour la saisie
     * @return l'entier entre par l'utilisateur
     */
    int saisirEntier(String msg);

    /**
     * Methode permettant de demander la saisie d'un entier a l'utilisateur superieur ou egal au minimum.
     * @param msg Message a afficher pour la saisie
     * @param min Entier en dessous lequel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @return l'entier entre par l'utilisateur
     */
    int saisirEntier(String msg, int min);

    /**
     * Methode permettant de demander la saisie d'un entier a l'utilisateur superieur ou egal au minimum et inferieur ou egal au maximum.
     * @param msg Message a afficher pour la saisie
     * @param min Entier en dessous duquel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @param max Entier au dessus duquel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @return l'entier entre par l'utilisateur
     */
    int saisirEntier(String msg, int min, int max);



    /**
     * Methode permettant de demander la saisie d'un decimal a l'utilisateur.
     * @param msg Message a afficher pour la saisie
     * @return le decimal entre par l'utilisateur
     */
    double saisirDecimal(String msg);

    /**
     * Methode permettant de demander la saisie d'un decimal a l'utilisateur superieur ou egal au minimum.
     * @param msg Message a afficher pour la saisie
     * @param min decimal en dessous lequel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @return le decimal entre par l'utilisateur
     */
    double saisirDecimal(String msg, double min);

    /**
     * Methode permettant de demander la saisie d'un decimal a l'utilisateur superieur ou egal au minimum et inferieur ou egal au maximum.
     * @param msg Message a afficher pour la saisie
     * @param min decimal en dessous duquel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @param max decimal au dessus duquel l'utilisateur sera oblige de rentrer une nouvelle fois un entier
     * @return le decimal entre par l'utilisateur
     */
    double saisirDecimal(String msg, double min, double max);


    /**
     * Methode permettant de demander la saisie d'une date a l'utilisateur.
     * @param msg Message a afficher pour la saisie
     * @return la date entree par l'utilisateur
     */
    LocalDate saisirDate(String msg);


    /**
     * Methode permettant de realiser la saisie d'un choix dans un menu.
     * Les elements du tableau en parametre sont des chaines de caracteres et seront numerotes a l'affichage en partant de 1 jusqu'a l'infini a partir du deuxieme element car le premier element est le titre.
     * @param menu String[], tableau des differents choix, comportant le titre et (si choix zero) le choix zero
     * @param titre boolean, si le premier element du tableau est le titre
     * @param choixZero boolean, si le dernier element du tableau est le choix zero
     * @return numero du choix de l'utilisateur
     */
    int saisirChoixMenu(String[] menu, boolean titre, boolean choixZero);

    /**
     * Methode permettant de faire choisir un element d'un enum a l'utilisateur.
     * @param enumValues tableau d'element de l'enum (enum.values() )
     * @param choixAnnuler si on permet a l'utilisateur de ne choisir aucun element
     * @param <T> type des elements de l'enum (son nom)
     * @return l'element de l'enum choisi par l'utilisateur ou null si le choix annule est possible et si l'utilisateur l'a choisi
     */
    <T> T saisirChoixElementEnum(T[] enumValues, boolean choixAnnuler);


    // ************************************************** //
    //     methodes ecrites dans les classes de l'ihm     //
    // ************************************************** //

    /**
     * Methode permettant de realiser l'affichage d'une chaine.
     * @param msg String, le message à afficher
     */
    void afficherChaine(String msg);

    /**
     * Methode permettant la saisie d'une chaîne.
     * @param msg: String, message a afficher avant
     * @return la chaine de caractere saisie
     */
    String saisirChaine(String msg);


    /**
     * Methode permettant d'afficher un tableau 1D.
     * @param titre String, texte a afficher au dessus du tableau
     * @param tableauStr String[], donnees a afficher
     */
    void afficherTableau(String[] tableauStr, String titre);

    /**
     * Methode permettant d'afficher un tableau 2D.
     * @param titre String, texte a afficher au dessus du tableau
     * @param tableauStr String[][], donnees a afficher
     * @param entete boolean, repond a la question "Est-ce que le tableau contient comme premiere ligne les entetes des colonnes ?"
     */
    void afficherTableau(String[][] tableauStr, String titre, boolean entete);


    /**
     * Lecture d'une date au format correspondant au pattern. La syntaxe de pattern
     * correspond à la description faite dans la java doc de
     * {@link SimpleDateFormat}. Si la date saisie n'est pas valide, le
     * message "Date erronée" est affiché, et la méthode attend une nouvelle saisie.
     *
     * @param message Libellé affiché avant la saisie.
     * @param pattern Représentation de la date souhaitée selon la description
     *                {@link SimpleDateFormat}.
     * @return La date de type LocalDate
     * @see SimpleDateFormat
     *
     */
    LocalDate saisirLocalDate(final String message, final String pattern);
}
