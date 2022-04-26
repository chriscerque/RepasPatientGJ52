package net.ent.etrs.sgr.view.ihm.outils;

import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;
import net.ent.etrs.view.ihm.references.ConstantesIhm;

import java.util.List;
import java.util.Objects;

public final class MesOutils {

    /////CONSTRUCTEUR/////
    private MesOutils() {
    }

    ;


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////               CREER MENU FROM TAB               ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de transformer un tableau de String en une seule chaine pour constituer un menu de choix.
     * Ici un menu avec titre et option quitter est construit.
     * ATTENTION: le choix quitter est 0 (Zéro)!
     *
     * @param tabStr: String[]
     * @return String
     */
    public static String creerStrMenuFromStrTab(String[] tabStr, String titreMenu) throws OutilsMenuException {

        String[] tablo = new String[tabStr.length + 2];

        tablo[0] = titreMenu;

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tabStr)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation du StringBuilder, première position de tabloStr (titre menu) en argument
        StringBuilder strb = new StringBuilder(tablo[0]);

        //On saute une ligne (append = ajoute à)
        strb.append(System.lineSeparator());

        for (int i = 0; i < tabStr.length; i++) {
            tablo[i + 1] = tabStr[i];
        }

        //-1 à tabloStr.length car au dernier j'ai "quitter"
        for (int i = 1; i < tabStr.length + 1; i++) {
            strb.append(String.format("%n %2d) %10s", i, tablo[i]));
        }

        //On saute une ligne
        strb.append(System.lineSeparator());

        tablo[tablo.length - 1] = "QUITTER";

        //Ici on ajoute le choix "Quitter", il n'est pas dans la boucle car on veut l'afficher différemment (sans numérotation)
        strb.append(String.format("%n  %d] %9s", 0, tablo[tablo.length - 1]));

        //On saute une ligne
        strb.append(System.lineSeparator());

        //La méthode retourne le StringBuilder du tabloStr construit
        return strb.toString();
    }

    /**
     * Méthode permettant de transformer un tableau de String en une seule chaine pour constituer un menu de choix.
     * Ici un menu avec titre et option quitter est construit.
     * ATTENTION: le choix quitter est 0 (Zéro)!
     *
     * @param tabStr: String[]
     * @return String
     */
    public static String creerStrMenuFromStrTab2(String[] tabStr, String titreMenu) throws OutilsMenuException {

        String[] tablo = new String[tabStr.length + 1];

        tablo[0] = titreMenu;

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tabStr)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation du StringBuilder, première position de tabloStr (titre menu) en argument
        StringBuilder strb = new StringBuilder(tablo[0]);

        //On saute une ligne (append = ajoute à)
        strb.append(System.lineSeparator());

        for (int i = 0; i < tabStr.length; i++) {
            tablo[i + 1] = tabStr[i];
        }

        //-1 à tabloStr.length car au dernier j'ai "quitter"
        for (int i = 1; i < tabStr.length + 1; i++) {
            strb.append(String.format("%n %2d) %10s", i, tablo[i]));
        }

        //On saute une ligne
        strb.append(System.lineSeparator());

        //On saute une ligne
        strb.append(System.lineSeparator());

        //La méthode retourne le StringBuilder du tabloStr construit
        return strb.toString();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode permettant de transformer un tableau de String 2 dimensions en une seule chaine pour constituer un menu de choix.
     * ATTENTION: le choix quitter est 0 (Zéro)!
     *
     * @param tabStr: String[][]
     * @return String
     */
    public static String creerMenuFromStrTab2D(String[][] tabStr) throws OutilsMenuException {

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tabStr)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation du StringBuilder, première position de tabloStr (titre menu) en argument
        StringBuilder strb = new StringBuilder(tabStr[0][0]);

        //On saute une ligne (append = ajoute à)
        strb.append(System.lineSeparator());

        //-1 à tabloStr.length car au dernier j'ai "quitter"
        for (int i = 1; i < tabStr.length - 1; i++) {
            strb.append(String.format("%n %2d) %10s", i, tabStr[i]));
        }

        //On saute une ligne
        strb.append(System.lineSeparator());

        //Ici on ajoute le choix "Quitter", il n'est pas dans la boucle car on veut l'afficher différemment (sans numérotation)
        strb.append(String.format("%n  %2d] %9s", 0, tabStr[tabStr.length - 1]));

        //On saute une ligne
        strb.append(System.lineSeparator());

        //La méthode retourne le StringBuilder du tabloStr construit
        return strb.toString();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////              CREER TABLEAU STRING               ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de caster n'importe quel type de tableau en tableau de type String.
     * Types permis: Enums, ClassName [] tableau, etc...
     *
     * @param tableau
     * @return tableauStr: tableau de String
     */
    public static String[] creerTableauStringFromAnything(Object[] tableau) throws OutilsMenuException {

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tableau)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation d'un tableau de String à la taille du tableau fourni
        String[] tableauStr = new String[tableau.length];

        //On attribut aux autres positions du tableau de String les autre valeurs du tableau fourni
        for (int i = 0; i < tableau.length; i++) {
            tableauStr[i] = tableau[i].toString();
        }

        return tableauStr;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode permettant de créer un tableau de String à partir d'une liste quelconque.
     *
     * @param liste: List<Object>
     * @throws OutilsMenuException
     * @return: String[]
     */
    public static String[] creerTableauStringFromList(List liste) throws OutilsMenuException {
        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(liste)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_LIST_NULL);
        }

        //Initialisation d'un tableau de String à la taille du tableau fourni
        String[] tableauStr = new String[liste.size()];

        //On attribut aux autres positions du tableau de String les autre valeurs du tableau fourni
        for (int i = 0; i < liste.size(); i++) {
            tableauStr[i] = liste.get(i).toString();
        }

        return tableauStr;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                    AFFICHAGE                    ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    /**
     * Méthode permettant de transformer un tableau de String en une seule chaine pour afficher un tableau.
     * Ici seules les données du tableau sont retournées, sans titre et sans option quitter.
     * ATTENTION: le choix quitter est 0 (Zéro)!
     *
     * @param tabStr: String[]
     * @return String
     */
    public static String creerAffichageStrFromStrTab(String[] tabStr) throws OutilsMenuException {

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tabStr)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation du StringBuilder, première position de tabloStr (titre menu) en argument
        StringBuilder strb = new StringBuilder(tabStr[0]);

        //On saute une ligne (append = ajoute à)
        strb.append(System.lineSeparator());

        //-1 à tabloStr.length car au dernier j'ai "quitter"
        for (int i = 1; i < tabStr.length; i++) {
            strb.append(String.format("%n %10s", tabStr[i]));
        }

        //La méthode retourne le StringBuilder du tabloStr construit
        return strb.toString();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode permettant de caster n'importe quel type de tableau en tableau de type String pour afficher un tableau.
     * Types permis: Enums, ClassName [] tableau, etc...
     *
     * @param tableau
     * @return tableauStr: tableau de String
     */
    public static String[] creerAffichageStringFromAnything(Object[] tableau, String titre) throws OutilsMenuException {

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(tableau)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_TAB_NULL);
        }

        //Initialisation d'un tableau de String à la taille du tableau fourni (+1 car titre MENU)
        String[] tableauStr = new String[tableau.length + 1];

        //On attribut au tableau de String à la première position la valeur "MENU"
        tableauStr[0] = titre;

        //On attribut aux autres positions du tableau de String les autre valeurs du tableau fourni
        for (int i = 1; i < tableau.length + 1; i++) {
            tableauStr[i] = tableau[i - 1].toString();
        }

        return tableauStr;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode permettant de caster une List<Object> en tableau de type String pour afficher un tableau.
     *
     * @param liste: List<Object>
     * @return tableauStr: tableau de String
     */
    public static String[] creerAffichageStringFromList(List liste, String titre) throws OutilsMenuException {

        //Contrôle si argument NULL, on lève l'exception "OutilsMenuException"
        if (Objects.isNull(liste)) {
            throw new OutilsMenuException(ConstantesIhm.MSG_ERR_LIST_NULL);
        }

        //Initialisation d'un tableau de String à la taille du tableau fourni (+1 car Titre Liste)
        String[] tableauStr = new String[liste.size() + 1];

        //On attribut au tableau de String à la première position la valeur titre(String)
        tableauStr[0] = titre;

        //On attribut aux autres positions du tableau de String les autre valeurs du tableau fourni
        for (int i = 0; i < liste.size(); i++) {
            tableauStr[i + 1] = liste.get(i).toString();
        }

        return tableauStr;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
