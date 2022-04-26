package net.ent.etrs.gzij.vue.ihm.outils;

import net.ent.etrs.gzij.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.gzij.vue.ihm.referencies.TypeAlignement;
import net.ent.etrs.gzij.vue.ihm.exceptions.ExceptionsConstantesIhm;

import java.util.Objects;

public final class IhmOutils {

    /**
     *
     * Méthode chargée de transformer le tableau de chaînes d'un menu en une seule chaîne.
     *
     * ATTENTION :
     * Le choix quitter est 0 (Zéro) !
     * 1ere lige = titre du menu
     * Dernière ligne = choix quitter
     *
     * @param tabloStr String[]
     * @return String
     * @throws ExceptionsIhm Déclenche une exception si le tableau est null
     */

    public static String creerStrMenu(final String[] tabloStr) throws ExceptionsIhm {

        if(Objects.isNull(tabloStr)){
            throw new ExceptionsIhm(ExceptionsConstantesIhm.MSG_ERR_TABMENU_VAUT_NULL);
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

    /**
     *
     * Méthode chargée de transformer le tableau de chaînes d'un menu en une seule chaîne.
     *
     * ATTENTION :
     * Le choix quitter est 0 (Zéro) !
     * 1ere lige = titre du menu
     * Dernière ligne = choix quitter
     *
     * @param titreMenu String titre du menu
     * @param piedMenu String dernière ligne du menu
     * @param UnMenuEnum Object[] élément utiliser pour générer le tableau
     * @return String
     */
    // création d'une méthode qui génère un menu : entête + valeurs Enum + Quitter:
    public static String creerMenuFromEnum(final String titreMenu, final String piedMenu, final Object[] UnMenuEnum) {

        // 0 car la première ligne c'est l'en-tête :
        StringBuilder strb = new StringBuilder(titreMenu);
        strb.append(System.lineSeparator());

        // 1 et -1 car je ne traite pas la première et dernière ligne :
        for (int i = 0 ; i < UnMenuEnum.length; i++) {
            strb.append(String.format("%n %2d) %10s", (i+1), UnMenuEnum[i]));
            // Menu avec A/B/C/D...
            //strb.append(String.format("%n %s) %10s", Character.toChars(65+i)[0], UnMenuEnum[i]));
        }

        // -1 car je traite la dernière ligne qui est quitter :
        strb.append(String.format("%n %n %2d] %10s", 0, piedMenu));
        strb.append(System.lineSeparator());

        return strb.toString();

    }

    //--------------------------------------------------------------------------------------------------------//
    // Methodes pour gérer les alignements de texte
    //--------------------------------------------------------------------------------------------------------//

    /**
     * Méthode permettant de centrer le texte en bourrant avec des caractères à définir.
     *
     * @param chaineEntree String chaine à traiter
     * @param tailleMaxMot int longueur que doit prendre la ligne
     * @param charCompletion char caractère de bourage, peut utiliser le caractère ESPACE
     * @return : String
     */
    private static String centrerTexte(final String chaineEntree, final int tailleMaxMot, final char charCompletion){
        if (chaineEntree == null || tailleMaxMot <= chaineEntree.length())
            return chaineEntree;

        StringBuilder chaineSortie = new StringBuilder(tailleMaxMot+2);

        for (int i = 0; i < (tailleMaxMot - chaineEntree.length()) / 2; i++) {
            chaineSortie.append(charCompletion);
        }
        chaineSortie.append(chaineEntree);
        while (chaineSortie.length() < tailleMaxMot) {
            chaineSortie.append(charCompletion);
        }
        return chaineSortie.toString();
    }

    /**
     * Méthode permettant de définir l'alignement d'une chaine de caractères.
     *
     * @param alignement TypeAlignement spécifier l'alignement voulu
     * @param chaineEntree String chaine à aligner
     * @param tailleMaxMot int taille du mot
     * @return : String
     */
    public static String alignerTexte(final TypeAlignement alignement, final String chaineEntree, final int tailleMaxMot) {
        String chaineSortie = null;

        switch (alignement) {
            case CENTER:
                chaineSortie = centrerTexte(chaineEntree, tailleMaxMot, ' ');
                chaineSortie = "! " + chaineSortie + " ";
                break;
            case RIGHT:
                String formatRight = "! %" + tailleMaxMot + "s ";
                chaineSortie = String.format(formatRight, chaineEntree);
                break;
            case LEFT:
                String formatLeft = "! %-" + tailleMaxMot + "s ";
                chaineSortie = String.format(formatLeft, chaineEntree);
                break;
            case JUSTIFY:
                chaineSortie = chaineEntree;
                while (chaineSortie.length() < tailleMaxMot) {
                    chaineSortie = ".";
                }
                break;
        }
        return chaineSortie;
    }

/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private IhmOutils(){}

} // fin de classe
