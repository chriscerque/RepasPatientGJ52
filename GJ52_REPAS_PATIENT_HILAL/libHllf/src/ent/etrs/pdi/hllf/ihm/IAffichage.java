package ent.etrs.pdi.hllf.ihm;

import java.util.List;

public interface IAffichage
{
    /**
     * affiche un menu avec contour et une option de sortie
     * @param list: List<String>
     * @param titre: String
     */
    public void afficherMenuEntoureAvecOptionSortie(List<String> list, String titre, String invite);

    /**
     * affiche un message avec un saut de ligne
     * @param message: String
     */
    public void afficherMessageAvecSautLigne(String message);

    /**
     * affiche un menu sans mise en forme
     * @param entete: List<String>
     */
    public void afficherMenuSimple(List<String> entete, String titre, String invite);

    /**
     * affiche une chaine de caractère
     * @param phrase: String
     */
    public void afficherString(String phrase);
}
