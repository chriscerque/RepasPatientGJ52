package net.ent.etrs.pdi.vbt.view.ihm;
import java.math.BigDecimal;
import java.util.List;

public interface Ihm {

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode qui permet de saisir une chaîne de caractères
     * @param invite : le message qui invite l'utilisateur à faire une saisie
     * @return la chaîne de caractères
     */
    String saisir(String invite);

    /**
     * Méthode qui permet de saisir un entier
     * @param invite : le message qui invite l'utilisateur à saisir un entier
     * @return l'entier
     */
    int saisirEntier(String invite);

    /**
     * Méthode qui permet de saisir un entier
     * @param invite : le message qui invite l'utilisateur à saisir un entier
     * @param minimum : la borne minimale de l'entier
     * @param maximum : la borne maximale de l'entier
     * @return l'entier
     */
    int saisirEntier(String invite, int minimum, int maximum);

    /**
     * Méthode qui permet de saisir un réel
     * @param invite : le message qui invite l'utilisateur à saisir un réel
     * @return le réel
     */
    double saisirReel(String invite);

    /**
     * Méthode qui permet de saisir un réel
     * @param invite : le message qui invite l'utilisateur à saisir un réel
     * @param minimum : la borne minimale du réel
     * @param maximum : la borne maximale du réel
     * @return le réel
     */
    double saisirReel(String invite, double minimum, double maximum);

    /**
     * Méthode qui permet de saisir un grand réel
     * @param invite : le message qui invite l'utilisateur à saisir un grand réel
     * @return le grand réel
     */
    BigDecimal saisirGrandReel(String invite);

    /**
     * Méthode qui permet de saisir un grand réel
     * @param invite : le message qui invite l'utilisateur à saisir un grand réel
     * @param minimum : la borne minimale du grand réel
     * @param maximum : la borne maximale du grand réel
     * @return le grand réel
     */
    BigDecimal saisirGrandReel(String invite, BigDecimal minimum, BigDecimal maximum);

    /**
     * Méthode qui permet de saisir un booléen
     * @param invite : le message qui invite l'utilisateur à saisir un booléen
     * @return le booléen
     */
    boolean saisirBooleen(String invite);

    /**
     * Méthode qui permet de choisir l'option d'un menu à partir d'une liste
     * @param title : le titre du menu
     * @param list : le contenu du menu
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return : l'option choisie sous la forme d'un entier
     */
    int saisirChoixMenu(String title, List<Object> list, String invite);

    /**
     * Méthode qui permet de choisir l'option d'un menu à partir d'un tableau
     * @param title : le titre du menu
     * @param table : le contenu du menu
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return : l'option choisie sous la forme d'un entier
     */
    int saisirChoixMenu(String title, String[] table, String invite);

    /**
     * Méthode qui permet de choisir le tuple d'un tableau à partir d'une liste
     * @param title : le titre du tableau
     * @param list : le contenu du tableau
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return : le tuple choisi sous la forme d'un entier
     */
    int saisirChoixTableau(String title, List<Object> list, String invite);

    /**
     * Méthode qui permet de choisir le tuple d'un tableau à partir d'un tableau
     * @param title : le titre du tableau
     * @param table : le contenu du tableau
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return : le tuple choisi sous la forme d'un entier
     */
    int saisirChoixTableau(String title, String[] table, String invite);

    /**
     * Méthode qui permet d'afficher une chaîne de caractères
     * @param message : la chaîne de caractères à afficher
     */
    void afficher(String message);

    /**
     * Méthode qui permet d'afficher une chaîne de caractères
     * @param message : la chaîne de caractères à afficher
     * @param lineBreak : avec ou sans saut de ligne
     */
    void afficher(String message, boolean lineBreak);

    /**
     * Méthode qui permet d'afficher une liste verticalement à partir d'une liste
     * @param title : le titre de la liste
     * @param list : le contenu de la liste
     */
    void afficherListe(String title, List<Object> list);

    /**
     * Méthode qui permet d'afficher une liste verticalement à partir d'un tableau
     * @param title : le titre de la liste
     * @param table : le contenu de la liste
     */
    void afficherListe(String title, String[] table);

    /**
     * Méthode qui permet d'afficher un tableau à partir d'une liste
     * @param title : le titre du tableau
     * @param list : le contenu du tableau
     */
    void afficherTableau(String title, List<Object> list);

    /**
     * Méthode qui permet d'afficher un tableau à partir d'un tableau
     * @param title : le titre du tableau
     * @param table : le contenu du tableau
     */
    void afficherTableau(String title, String[] table);

    /**
     * Méthode qui permet d'afficher un message d'erreur
     * @param message : le message d'erreur à afficher
     */
    public void afficherErreur(String message);

}
