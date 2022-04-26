package net.ent.etrs.ggef.vue.ihm;


import net.ent.etrs.ggef.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.ggef.vue.ihm.referencies.TypeAlignement;

import java.time.LocalDate;

public interface Ihm{

    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne, avec ou sans saut de ligne.
     * @param msg String, le message à afficher
     * @param sautLigne boolean
     */
    public void afficherChaine(String msg, boolean sautLigne);

    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne, avec saut de ligne.
     * @param msg String, le message à afficher
     */
    public void afficherChaine(String msg);

    /**
     * Méthode permettant la saisie d'une chaîne par un utilisateur.
     *
     * @param invite String - le message d'invite lu par le User
     * @return String
     */
    public String saisirChaine(String invite);

    /**
     * Méthode chargée de réaliser la saisie d'un entier dans [min:max]
     *
     * @param msg String
     * @param min int, le choix mini
     * @param max int, le choix maxi
     * @return int
     */
    public int saisirEntier(String msg, int min, int max);

    /**
     * Methode chargée de faire saisir un entier.
     *
     * @param msg String, le message d'invite
     * @return int la saisie
     */
    int saisirEntier(String msg);

    /**
     * Méthode chargée de réaliser la saisie d'une date
     *
     * @param msg String
     * @return LocalDate
     */
    public LocalDate saisirLocalDate(String msg);

    /**
     * Méthode permettant de réaliser la saisie d'un choix depuis un menu de constante.
     *
     * @param tabloStr String[] - tabeleau comportant la liste des choix
     * @param min int - choix possibles entre 0 et x → 0 pour Quitter/recommencer,etc
     * @param max int - choix possibles entre 0 et x     *
     * @return int
     * @throws ExceptionsIhm Déclenche une exception si le tableau est null
     */
    public int saisirChoixMenu(String[] tabloStr, int min, int max) throws ExceptionsIhm;

    /**
     * Méthode permettant de réaliser la saisie d'un choix depuis un menu réalisé en chaîne de caractère.
     * ATTENTION: le choix doit appartenir à [min:max]
     * exemple d'utilisation avec StringBuilder dans le IhmReadme.md
     *
     * @param strMenu String, le menu au format chaine de caractères
     * @param min int, le choix mini
     * @param max int, le choix maxi
     * @return int
     */
    public int saisirchoixMenu(String strMenu,int min,int max);

    /**
     * Méthode permettant de réaliser la saisie d'un choix depuis un menu d'Enum.
     *
     * Ecrire nomEnum.values() ou un tablo[] d'objets avec le toString
     * cela permettra de renvoyer les valeurs de l'enum sous forme de tableau
     * 0 sera automatiquement le choix de bas de menu pour quitter, recommencer,etc
     * L'entier max sera fourni automatiquement par le nb de valeur de l'enum
     *
     * @param titreMenu String - le titre du menu
     * @param piedMenu String - le pied du menu → Quitter, recommencer,etc
     * @param nomEnumAvecValues Object[] - nom de l'Enum ou tablo d'objets qui contient les valeurs du menu
     * @return int
     */
    public int saisirChoixMenu(String titreMenu, String piedMenu, Object[] nomEnumAvecValues);

    /**
     * Méthode permettant d'afficher un tablo d'Object (Personnages, String, etc).
     *
     * Dans le cadre d'une Enum, penser à ajouter .values()
     * Dans le cadre d'Objet autre que String, la méthode utilise le toString()
     *
     * @param titre String titre donné au tableau affiché
     * @param tablo Object[] Personnages, String, etc
     */
    public void afficherTableau1D(String titre, Object[] tablo);

    /**
     *Méthode permettant d'afficher un tableau2D avec mise en forme.
     * @param titre String titre du tableau
     * @param tabloEntetes String[] tableau contenant les entetes
     * @param tabloDonnees String[][] tableau contenant les données à afficher
     * @param tabloAlignement TypeAlignement[] tableau contenant les alignements de chaque colonne
     * @param afficherNoLigne boolean défini si la méthode doit afficher le numéro des lignes du tableau
     */
    public void afficherTableau2D(String titre, String[] tabloEntetes, String[][] tabloDonnees, TypeAlignement[] tabloAlignement, boolean afficherNoLigne);


    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne en utilisant la sortie d'erreur.
     * @param msg String, le message à afficher
     */
    public void afficherErreur(String msg);



} // fin d'Interface
