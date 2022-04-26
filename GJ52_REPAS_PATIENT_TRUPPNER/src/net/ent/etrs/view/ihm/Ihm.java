package net.ent.etrs.view.ihm;


//import ent.etrs.pndg.ihm.exceptions.IhmException;

import net.ent.etrs.view.ihm.exceptions.IhmException;

public interface Ihm {

    /**
     * Méthode permettant la saisie d'une chaîne.
     *
     * @param invite: le message d'invite
     * @return String
     */
    public String saisirChaine(String invite);

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu.
     * @param tabloStr: String[], le contenu du menu sous forme de tableau de chaine)
     * @return int: le choix
     * @throws IhmException levée si le tableau est NULL
     */
    //   public int saisirChoixMenu(String[] tabloStr) throws IhmException;

    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu.
     * ATTENTION: le choix doit appartenir à [min:max[
     * @param strMenu: String, le menu au format chaine de car
     * @param min: int, le choix mini
     * @param max: int, le choix maxi
     * @return int
     */
    // int saisirchoixMenu(String strMenu,int min,int max);

    /**
     * Méthode chargée de réaliser la saisie d'un entier dans [min:max[
     *
     * @param msg : String
     * @param min : int, le choix mini
     * @param max : int, le choix maxi
     * @return int
     */
    public int saisirEntier(String msg, int min, int max);

    /**
     * Méthode chargée de saisir un double ds [min:max]
     *
     * @param msg: invite de saisie
     * @param min: double, le min
     * @param max: double, le max
     * @return double
     */
    public double saisirDouble(String msg, double min, double max);

    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne, avec ou sans saut de ligne.
     *
     * @param msg:       String, le message à afficher
     * @param sautLigne: boolean
     */
    public void afficherChaine(String msg, boolean sautLigne);

    public void afficherChaine(String msg);

    /**
     * Méthode chargée de réaliser un affichage sous forme d'un tableua.
     *
     * @param titre:            String le titre du tableau
     * @param tabEntetes:       String[], les entêtes
     * @param tablo:String[][], les données
     * @param tabTa:            Typealignement[], les alignements ds chaque colonne
     * @param withNoLine:       boolean, TRUE = avec no de line, FALSe= sans
     * @throws Exception en case de pbm
     */
    public void afficherTableau(String titre, String[] tabEntetes, String[][] tablo, TypeAlignement[] tabTa, boolean withNoLine) throws Exception;


    public void afficherErreur(String msg);

    // -----------------Pour les menus

    /**
     * Méthode chargée de réaliser la saisie du choix sous la forme d'un caractère appartenant au tableau des car passé en paramètre.
     *
     * @param invite:   String, le message d'invite où texte du menu
     * @param tabChoix: char[] le tableau des choix
     * @return char: le caractère saisi
     */
    public char saisirChoixMenuChar(String invite, char[] tabChoix);

    /**
     * Méthode chargée de réaliser la saisie du choix sous la forme d'un entier appartenant au tableau des int passé en paramètre.
     *
     * @param invite:   String, le message d'invite où texte du menu
     * @param tabChoix: int[] le tableau des choix
     * @return int: l'netier saisi
     * @throws Exception sera levée en cas de problème
     */
    public int saisirChoixMenuInt(String invite, int[] tabChoix) throws Exception;
}
