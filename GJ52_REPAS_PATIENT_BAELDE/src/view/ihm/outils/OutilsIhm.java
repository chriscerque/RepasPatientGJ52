package view.ihm.outils;

import view.ihm.exceptions.OutilsException;
import view.ihm.references.ConstanteIhm;

import java.util.Objects;

public final class OutilsIhm {
    private OutilsIhm(){}

    /**
     * Methode permettant de transformer un tableau de chaine representant un menu en une chaine.
     * La premiere chaine sera le titre du tableau donc ne sera pas numerote et si il y a un choix zero, il sera le dernier element du tableau en paramètre.
     * @param menu String[]
     * @param choixZero boolean
     * @return String
     * @throws OutilsException
     */
    public static String creerStrMenuFenetre(final String[] menu, final boolean titre, final boolean choixZero) {
        String[] copie = numeroterElementTableau(menu, titre, choixZero);
        StringBuilder sb = new StringBuilder();
        int min = 0;
        if (titre) {
            min++;
            sb.append(menu[0]);
            sb.append(System.lineSeparator());
        }
        for (int i = min; i < menu.length; i++) {
            sb.append(System.lineSeparator());
            sb.append(menu[i]);
        }
        return sb.toString();
    }

    /**
     * Methode permettant de creer un menu (tableau de string) avec les elements d'un enum.
     * @param enumValues tableau d'element d'un enum ( enum.values() )
     * @param choixAnnule si on ajoute le choix annule comme dernier element du tableau de chaine en sortie
     * @param <T> type des elements de l'enum (son nom)
     * @return tableau de chaine de caractere
     */
    public static <T> String[] creerMenuChoixElementEnum(final T[] enumValues, final boolean choixAnnule) {
        String[] menu = new String[enumValues.length +2];
        menu[0] = String.format("Choisir %s", enumValues[0].getClass().getSimpleName());
        if (choixAnnule) {
            menu[menu.length - 1] = "Annuler";
        }
        for (int i = 0; i < enumValues.length; i++) {
            menu[i +1] = enumValues[i].toString().toLowerCase();
        }
        return menu;
    }

    /**
     * Methode chargee de donner la longueur max des chaines du tableau.
     * @param tableauStr:String[]
     * @return int
     */
    public static int rechercherNbMaxChar(final String[] tableauStr) {
        int maxChar = -1;
        int longueur;

        for (String chaine : tableauStr) {
            longueur = chaine.length();
            if (longueur > maxChar) {
                maxChar = longueur;
            }
        }

        return maxChar;
    }

    /**
     * Methode mermettant de recuperer dans un tableau 1D la n-ieme colonne d'un tableau 2D.
     * @param tableauStr:String[][]
     * @param numColonne:int
     * @return String[]
     */
    public static String[] recupererColonne(final String[][] tableauStr, final int numColonne) {
        String[] colonne = new String[tableauStr.length];

        for (int ligne = 0; ligne < tableauStr.length; ligne++) {
            colonne[ligne] = tableauStr[ligne][numColonne];
        }
        return colonne;
    }

    /**
     * Methode permettant de centrer une chaine de caractere.
     * Rajoute des caracteres jusqu'a atteindre la valeur du parametre width
     * @param str chaine a aligner
     * @param width taille sur laquelle aligner la chaine
     * @param caractere caractere avec lequel on aligne le texte (caractere d'ajout)
     * @return chaine de caractere alignee
     */
    public static String alignerTexteCentre(final String str, final int width, final char caractere) {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < (width - str.length()) /2; ++i) {
            strb.append(caractere);
        }
        strb.append(str);
        while (strb.length() < width) {
            strb.append(caractere);
        }
        return strb.toString();
    }

    /**
     * Methode permettant d'aligner a droite une chaine de caractere.
     * Rajoute des caracteres jusqu'a atteindre la valeur du parametre width
     * @param str chaine a aligner
     * @param width taille sur laquelle aligner la chaine
     * @param caractere caractere avec lequel on aligne le texte (caractere d'ajout)
     * @return chaine de caractere alignee
     */
    public static String alignerTexteDroite(final String str, final int width, final char caractere) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < (width - str.length())) {
            sb.append(caractere);
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * Methode permettant d'aligner a gauche une chaine de caractere.
     * Rajoute des caracteres jusqu'a atteindre la valeur du parametre width
     * @param str chaine a aligner
     * @param width taille sur laquelle aligner la chaine
     * @param caractere caractere avec lequel on aligne le texte (caractere d'ajout)
     * @return chaine de caractere alignee
     */
    public static String alignerTexteGauche(final String str, final int width, final char caractere) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (sb.length() < width) {
            sb.append(caractere);
        }
        return sb.toString();
    }

    /**
     * Methode permettant de creer une ligne separatrice pour un tableau dont on renseigne la taille des colonnes.
     * La chaine de caracteres sera composee de '+' pour delimiter la colonne et de '-' pour effectuer la ligne.
     * La chaine commencera et finira par un '+'. Pour chaque colonne on aura ca longueur +2 '-'.
     * @param tabTailleColonnes tableau contenant les tailles de chaque colonne {@see rechercherNbMaxChar}
     * @return chaine de caractere contenant la ligne separatrice utilisee sur l'ihm console
     * {@see ConsoleIhmImpl.afficherTableau}
     */
    public static String creerLigneSeparatriceTableau(final int[] tabTailleColonnes) {
        StringBuilder strb = new StringBuilder();

        for (int colonne = 0; colonne < tabTailleColonnes.length; colonne++) {
            strb.append("+");
            for (int i = 0; i < tabTailleColonnes[colonne] + 2; i++) {
                strb.append("-");
            }
        }
        strb.append("+");

        return strb.toString();
    }

    /**
     * Methode permettant d'encadrer un tableau verticalement pour la vue console.
     * @param tableau tableau contenant le titre comme premier element
     * @param titre si il le premier element du tableau est un titre
     * @return la chaine prete a etre affichee
     */
    public static String encadrerTableauVerticalement(final String[] tableau, final boolean titre) {
        int max = rechercherNbMaxChar(tableau);
        StringBuilder sbLigne = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sbLigne.append('-');
        }
        StringBuilder sb = new StringBuilder();
        if (!titre) {
            sb.append(String.format("+-%s-+", sbLigne));
        }
        for (int i = 0; i < tableau.length; i++) {
            if (i == 0 && titre) {
                sb.append(String.format("+-%s-+", alignerTexteCentre(tableau[i], max, '-')));
            } else {
                sb.append(System.lineSeparator());
                sb.append(String.format("| %s |", alignerTexteGauche(tableau[i], max, ' ')));
            }
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("+-%s-+", sbLigne));

        return sb.toString();
    }

    /**
     * Methode permettant de numeroter les elements d'un tableau de chaine de caractere.
     * @param tableau tableau de chaine a numeroter
     * @param titre si il y a un titre dans le tableau (en premiere position
     * @param choixZero si il y a un choix qui doit etre numerote a 0 dans le tableau (dernier element)
     * @return le tableau contenant la numerotation
     */
    public static String[] numeroterElementTableau(final String[] tableau, final boolean titre, final boolean choixZero) {
        String[] copie = new String[tableau.length];
        int min = 0;
        int max = tableau.length;
        int numerotation = 1;
        if (titre) {
            min++;
            copie[0] = tableau[0];
        }
        if (choixZero) {
            max--;
            copie[copie.length -1] = String.format("%d - %s", 0, tableau[tableau.length -1]);
        }
        for (int i = min; i < max; i++) {
            copie[i] = String.format("%d - %s", numerotation, tableau[i]);
            numerotation++;
        }
        return copie;
    }
}
