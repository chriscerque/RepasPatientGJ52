package net.ent.etrs.gzij.commons;

import java.util.Random;

public final class Outils {

    /**
     * Methode chargée de spliter les données brutes.
     *
     * le tableau retour doit être déclaré au préalable
     *
     * @param tabloSource String Chaine de caractères à découper
     * @param valeur_pour_spliter String chaine de caractères servant de séparateur
     * @return String[] le résultat du traitement de la ligne
     */
    private static String[] splitDonnees(final String tabloSource, final String valeur_pour_spliter) {
        String[] tablo;

        tablo = tabloSource.split(valeur_pour_spliter);
        for (int i = 0; i < tablo.length; i++) {
            tablo[i] = tablo[i].trim();
        }
        return tablo;
    }

    /**
     * Methode chargée de spliter les données présentes dans la case d'un tableau.
     *
     * le tableau retour doit être déclaré au préalable
     * calcul du nombre d'occurence du caractère parasite
     *
     * @param tabloDonnees String[] tableau de données à manipuler
     * @param idx_colonne_a_spliter int index de la colonne à découper
     * @param valeur_pour_spliter String chaine de caractères servant de séparateur
     * @return String[] le résultat du traitement du tableau
     */
    private static String[] splitTablo(final String[] tabloDonnees, final int idx_colonne_a_spliter, final String valeur_pour_spliter) {

        int calculNbSplit = 0;
        String[] tab2 = tabloDonnees[idx_colonne_a_spliter].split(valeur_pour_spliter);
        calculNbSplit = tab2.length;

        String[] tablo = new String[tabloDonnees.length + calculNbSplit - 1];

        for (int b = 0; b < idx_colonne_a_spliter; b++) {
            tablo[b] = tabloDonnees[b].trim();
        }

        for (int c = idx_colonne_a_spliter; c < (idx_colonne_a_spliter + calculNbSplit); c++) {
            tablo[c] = tab2[c - idx_colonne_a_spliter].trim();
        }

        for (int d = idx_colonne_a_spliter; d < tabloDonnees.length - 1; d++) {
            tablo[d + calculNbSplit] = tabloDonnees[d + 1].trim();
        }

        return tablo;
    }

    /**
     * Methode chargée de remplacer un caractère parasite dans chaque case d'un tableau.

     * calcul du nombre d'occurence du caractère parasite
     *
     * @param tabloDonnees String[] tableau de données à manipuler
     * @param caractereParasite String caractère à supprimer
     * @param caractereRemplacement String caratère devant remplacer
     * @return String[] le résultat du traitement du tableau
     */
    private static String[] remplacerCaractere(final String[] tabloDonnees, final String caractereParasite, final String caractereRemplacement) {

        String[] tablo = new String[tabloDonnees.length];

        for (int i = 0; i < tabloDonnees.length; i++) {
            tablo[i] = tabloDonnees[i].replace(caractereParasite, caractereRemplacement);
        }

        return tablo;
    }

    /**
     * Methode chargée de remplacer un caractère parasite dans une case précisée d'un tableau.
     * calcul du nombre d'occurence du caractère parasite
     *
     * @param tabloDonnees String[] tableau de données à manipuler
     * @param caractereParasite String caractère à supprimer
     * @param caractereRemplacement String caratère devant remplacer
     * @param idx_colonne int index de la colonne à manipuler
     * @return String[] le résultat du traitement du tableau
     */
    private static String[] remplacerCaractere(final String[] tabloDonnees, final String caractereParasite, final String caractereRemplacement, final int idx_colonne) {

        String[] tablo = new String[tabloDonnees.length];

        for (int i = 0; i < tabloDonnees.length; i++) {

            if (i == idx_colonne) {
                tablo[idx_colonne] = tabloDonnees[idx_colonne].replace(caractereParasite, caractereRemplacement);
            } else {
                tablo[i] = tabloDonnees[i];
            }
        }

        return tablo;
    }

    /**
     * Créer un nouvel entier compris entre 0 et 1 (exclu).
     *
     * @return renvoie le nouvelle entier généré.
     */
    public static double random() {
        return new Random().nextDouble();
    }

    /**
     * Créer un nouvel entier compris entre min et max (exclue).
     *
     * @param min Integer borne inférieure
     * @param max Integer borne supérieure (exclue)
     * @return renvoie le nouvelle entier généré.
     */
    public static Integer random(final Integer min, final Integer max) {
        Integer retour = -1;
        try {
            retour = new Random().nextInt(max - min) + min;
        } catch (IllegalArgumentException e) {
            System.out.println("la borne max doit être positive ou supérieure  à la borne inférieure.");

        }

        return retour;
    }

    /**
     * Tranformer un mois String en mois Integer.
     *
     * utile pour la fonction LocalDate.of()
     * génération d'une date à partir d'entiers.
     *
     * @param unMois String mois à convertir
     * @return renvoie l'entier correspondant au mois.
     */
    public static Integer transformerMois(final String unMois) {
        String[] tabloMois = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
        int mois = 0;
        boolean trouver = false;

        for (int i = 0; i < tabloMois.length && !trouver; i++) {
            if (unMois.equalsIgnoreCase(tabloMois[i])) {
                mois = i;
                trouver = true;
            }
        }
        return mois;
    }

/*----------------------
CONSTRUCTEURS PRIVE
-----------------------*/

    private Outils() {
    }

}  // fin de classe