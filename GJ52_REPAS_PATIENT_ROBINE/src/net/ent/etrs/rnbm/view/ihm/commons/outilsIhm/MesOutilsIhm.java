package net.ent.etrs.rnbm.view.ihm.commons.outilsIhm;

import net.ent.etrs.rnbm.view.ihm.commons.references.constantes.IhmConstantes;
import net.ent.etrs.rnbm.view.ihm.commons.references.enumerateds.TypeAlignement;
import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstantes;
import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstructeur;
import net.ent.etrs.rnbm.model.commons.exceptions.OutilsException;

import java.util.Objects;

public class MesOutilsIhm {

    /*----------------------
    CONSTRUCTEURS BLOQUE
    -----------------------*/
    private MesOutilsIhm(){}



    /**
     *
     * Méthode chargée de transformer le tableau de chaînes d'un menu en une seule chaîne.
     *
     *ATTENTION :
     * 1ere lige = titre du menu
     *
     *
     * @param tabloStr: String[]
     * @returnString
     */

    public static String creerStrMenu(String[] tabloStr) throws ExceptionsConstructeur {

        if(Objects.isNull(tabloStr)){
            throw new ExceptionsConstructeur(ExceptionsConstantes.MSG_ERR_TABMENU_VAUT_NULL);
        }
        // 0 car la première ligne c'est l'en-tête :
        StringBuilder strb = new StringBuilder(tabloStr[0]);
        strb.append(System.lineSeparator());

        // 1 et -1 car je ne traite pas la première et dernière ligne :
        for (int i = 1 ; i < tabloStr.length-1; i++) {
            strb.append(String.format("%n %2d) %10s", i, tabloStr[i]));
        }

        return strb.toString();


    }
    /**
     *
     * Méthode chargée de transformer le tableau de chaînes d'un menu en une seule chaîne.
     *
     *ATTENTION :
     * Le choix quitter est 0 (Zéro) !
     * 1ere lige = titre du menu
     * Dernière ligne = choix quitter
     *
     * @param tabloStr: String[]
     * @returnString
     */

    public static String creerStrMenuAvecPiedDePage(String[] tabloStr) throws ExceptionsConstructeur {

        if(Objects.isNull(tabloStr)){
            throw new ExceptionsConstructeur(ExceptionsConstantes.MSG_ERR_TABMENU_VAUT_NULL);
        }
        // 0 car la première ligne c'est l'en-tête :
        StringBuilder strb = new StringBuilder(tabloStr[0]);
        strb.append(System.lineSeparator());

        // 1 et -1 car je ne traite pas la première et dernière ligne :
        for (int i = 1 ; i < tabloStr.length-1; i++) {
            strb.append(String.format("%n %2d) %10s", i, tabloStr[i]));
        }

        // -1 car je traite la dernière ligne qui est quitter :
        strb.append(String.format("%n %n %2d] %10s", 0, tabloStr[tabloStr.length-1]));
        strb.append(System.lineSeparator());

        return strb.toString();


    }

    // création d'une méthode qui génère un menu : entête + valeurs Enum + Quitter:
    public static String [] creerMenuFromEnum(Object[] UnMenuEnum, String en_tete, String pied_page) {

        // +2 pour ajouter en-tête et pied de page :
        String[] tabMenu = new String[UnMenuEnum.length+2];

        // Insertion ligne en-tête :
        tabMenu[0] = en_tete;

        // Insertion des valeurs de l'Enum :
        for (int i = 0; i < UnMenuEnum.length; i++) {
            String unType = UnMenuEnum[i].toString();
            tabMenu[i + 1] = unType;
        }
        // Insertion ligne pied de tableau :
        tabMenu[UnMenuEnum.length+1] = pied_page;

        return tabMenu;
    }

    /**
     * Méthode chargée de donner la longueur max des chaines du tableau.
     * @param tableauStr:String[]
     * @return int
     */
    public static int rechercherNbMaxChar(String[] tableauStr) {
        int maxChar = -1;
        int longueur = -1;

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
    public static String[] recupererColonne(String[][] tableauStr, int numColonne) throws OutilsException {
        if (Objects.isNull(tableauStr)) {
            throw new OutilsException(IhmConstantes.MSG_ERR_RECUPERER_COLONNE_TABLEAUSTR_NULL);
        }
        String[] colonne = new String[tableauStr.length];

        for (int ligne = 0; ligne < tableauStr.length; ligne++) {
            colonne[ligne] = tableauStr[ligne][numColonne];
        }

        return colonne;
    }

    /**
     * Methode permettant d'aligner une chaine de caractere en fonction d'une taille
     * @param ta:TypeAlignement
     * @param str:String
     * @param width:int
     * @return String
     * @throws OutilsException
     */
    public static String alignerTexte(TypeAlignement ta, String str, int width) throws OutilsException {
        String strw;
        switch(ta) {
            case CENTER:
                StringBuilder strb = new StringBuilder();
                for (int i = 0; i < (width - str.length()) /2; ++i) {
                    strb.append(' ');
                }
                strb.append(str);
                while (strb.length() < width) {
                    strb.append(' ');
                }
                strw = strb.toString();
                break;
            case RIGHT:
                strw = String.format("%" + width + "s", str);
                break;
            case LEFT:
                strw = String.format("%-" + width + "s", str);
                break;
            default:
                throw new OutilsException(IhmConstantes.MSG_ERR_ALIGNERTEXTE_SWITCH_DEFAULT);
        }
        return strw;
    }



}
