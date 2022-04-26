package net.ent.etrs.sgr.view.ihm;
//
//import net.ent.etrs.view.ihm.exceptionsIhm.BooleanException;
//import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;

import net.ent.etrs.sgr.view.ihm.exceptionsIhm.BooleanException;
import net.ent.etrs.sgr.view.ihm.exceptionsIhm.OutilsMenuException;

import java.time.LocalDate;
import java.util.List;

public interface Ihm {


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                     SAISIE                      ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant la saisie d'une chaîne de caractère.
     *
     * @param msg: String (message invite à saisir "veuillez blablabla...")
     * @return String (retourne la chaine de caractère saisie)
     */
    public String saisirChaine(String msg);
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant la saisie d'un caractère.
     *
     * @param msg: String (message invite à saisir "veuillez blablabla...")
     * @return char (retourne le caractère saisi)
     */
    public char saisirCaractere(String msg);
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'un tableau de String fourni en paramètre.
     *
     * @param tabStr:    String[]
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    public int saisirChoixMenuTabString(String[] tabStr, String titreMenu) throws OutilsMenuException;

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'un tableau de String fourni en paramètre.
     *
     * @param tabStr:    String[]
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    public int saisirChoixMenuTabString2(String[] tabStr, String titreMenu) throws OutilsMenuException;
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'un tableau de n'importe quel type fourni.
     *
     * @param tableau:   Object[]
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    int saisirChoixMenuTabObject(Object[] tableau, String titreMenu) throws OutilsMenuException;

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'un tableau de n'importe quel type fourni.
     * ATTENTION:  sans option quitter!!!
     *
     * @param tableau:   Object[]
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    int saisirChoixMenuTabObject2(Object[] tableau, String titreMenu) throws OutilsMenuException;
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'une List<Object>.
     *
     * @param liste:     List<Object>
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    int saisirChoixMenuListObject(List liste, String titreMenu) throws OutilsMenuException;

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'une List<Object>.
     * ATTENTION:  sans option quitter!!!
     *
     * @param liste:     List<Object>
     * @param titreMenu: String(titre à donner au menu)
     * @return int (retourne le choix du menu saisi)
     * @throws OutilsMenuException
     */
    int saisirChoixMenuListObject2(List liste, String titreMenu) throws OutilsMenuException;
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un entier entre un min et un max.
     *
     * @param msg : String (message invite à saisir "veuillez blablabla...")
     * @param min : int, borne nombre minimum
     * @param max : int, borne nombre maximum
     * @return int (retourne le nombre saisi)
     */
    public int saisirEntierMinMax(String msg, int min, int max);
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un entier.
     *
     * @param msg : String (message invite à saisir "veuillez blablabla...")
     * @return int (retourne le nombre saisi)
     */
    public int saisirEntier(String msg);
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un booléen par appel de cette méthode.
     *
     * @return boolean
     */
    public boolean saisirBooleen() throws BooleanException;
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de saisir une date (aaaa-mm-jj) en saisissant le jour(int), le mois(int) et l'année(int).
     * ATTENTION:
     * jour entre 1 et 31, mois entre 1 et 12, année entre 1 et 9999.
     *
     * @return: LocalDate
     */
    public LocalDate saisirDateJMA();
    /////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                    AFFICHAGE                    ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser l'affichage d'une chaîne de caractères.
     *
     * @param msg: String, le message à afficher
     */
    public void afficherChaine(String msg);
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu
     * en créant ce menu à partir d'un tableau de n'importe quel type fourni.
     *
     * @param tableau : Object[]
     * @param titre:  String(titre à donner à l'affichage)
     * @return int (retourne le choix du menu saisi)
     */
    public void afficherTabObject(Object[] tableau, String titre) throws OutilsMenuException;
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant d'afficher une List<Object> (contenant ou non elle-même d'autre List<Object>.
     *
     * @param liste  : List<Object>
     * @param titre: String(titre à donner à l'affichage)
     * @return int (retourne le choix du menu saisi)
     */
    public void afficherList(List liste, String titre) throws OutilsMenuException;
    /////////////////////////////////////////////////////////


}
