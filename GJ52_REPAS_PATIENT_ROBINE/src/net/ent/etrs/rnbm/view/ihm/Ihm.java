package net.ent.etrs.rnbm.view.ihm;

import net.ent.etrs.rnbm.view.ihm.commons.references.enumerateds.TypeAlignement;
import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstructeur;

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
     * <p>
     * min: choix possibles entre 0 et x
     * max: choix possibles entre 0 et x
     *
     * @return int
     */
    public int saisirChoixMenu(String[] tabloStr, int min, int max, boolean pied_page) throws ExceptionsConstructeur;

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
     * Methode chargée de faire saisir un entier.
     *
     * @param msg : String, le message d'invite
     * @return int la saisie
     */
    int saisirEntier(String msg);

    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne, avec ou sans saut de ligne.
     *
     * @param msg: String, le message à afficher
     */
    public void afficherChaine(String msg);


    /**
     * Methode permettant d'afficher un tableau 2D.
     *
     * @param titre      String, texte a afficher au dessus du tableau
     * @param tableauStr String[][], donnees a afficher
     * @param alignement TypeAlignement, alignement des donnees dans le tableau
     * @param entete     boolean, repond a la question "Est-ce que le tableau contient comme premiere ligne les entetes des colonnes ?"
     */
    public void afficherTableau(String titre, String[][] tableauStr, TypeAlignement alignement, boolean entete);

}