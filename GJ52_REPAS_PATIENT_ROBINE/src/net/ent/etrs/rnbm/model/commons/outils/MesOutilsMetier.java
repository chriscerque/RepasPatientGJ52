package net.ent.etrs.rnbm.model.commons.outils;

import java.util.Arrays;

public class MesOutilsMetier {
    /**
     * Methode qui permet de regarder si un element est contenu dans un tableau.
     * Utilise la methode equals de l'element
     *
     * @param tableau Object[]
     * @param element Object
     * @return true si l'element est dans le tableau
     * @return false si l'element n'est pas dans le tableau
     */
    public static boolean etreContenuDans(Object[] tableau, Object element) {
        for (Object contenu : tableau) {
            if (element.equals(contenu)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Methode permettant de supprimer un element d'un tableau.
     *
     * @param tableau Object[]
     * @param element Object
     * @return Object[]
     */
    public static Object[] supprimerDans(Object[] tableau, Object element) {
        if (etreContenuDans(tableau, element)) {
            int index = 0;
            for (Object contenu : tableau) {
                if (!element.equals(contenu)) {
                    tableau[index] = contenu;
                    index++;
                }
            }
            tableau = Arrays.copyOf(tableau, index);
        } else {
//            throw new Exception();
        }
        return tableau;
    }

    /**
     * Methode permettant d'extraire les donnees d'un tableau de chaine de caracteres.
     * Parcours le tableau et decoupe chaque chaine de caracteres ou le separateur de champ apparait et stocke les donnees dans un tableau dont l'indice dans le tableau de sorti et l'indice dans le tableau d'entre.
     * Retourne les donnees dans l'ordre de leur apparition dans le sens normal de lecture.
     * @param tableauDonnees String[], tableau de donnees a extraire
     * @param separateurDeChamp String[], chaineS de caracteres qui vont servir a separer les differentes donnees (doit contenir au moins une chaine de caracteres)
     * @param caracteresASupprimer char[], caractereS a supprimer (remplace chaque caractere trouve par un espace) (laisser vide si il n'y a aucun caractere a supprimer)
     * @return String[][]
     */
    public static String[][] extraireDonnees(String[] tableauDonnees, String[] separateurDeChamp, char[] caracteresASupprimer) {
        String[][] tableauDonnees2D = new String[0][];
        for (String donnees : tableauDonnees) {
            tableauDonnees2D = Arrays.copyOf(tableauDonnees2D, tableauDonnees2D.length + 1);
            tableauDonnees2D[tableauDonnees2D.length - 1] = extraireDonnees(donnees, separateurDeChamp, caracteresASupprimer);
        }
        return tableauDonnees2D;
    }
    /**
     * Methode permettant d'extraire les donnees d'un tableau de chaine de caracteres.
     * Parcours le tableau et decoupe chaque chaine de caracteres ou le separateur de champ apparait et stocke les donnees dans un tableau dont l'indice dans le tableau de sorti et l'indice d'apparition de la donnee dans la chaine de caractere.
     * Retourne les donnees dans l'ordre de leur apparition dans le sens normal de lecture.
     * @param donnees String, chaine de donnees a extraire
     * @param separateurDeChamp String[], chaineS de caracteres qui vont servir a separer les differentes donnees (doit contenir au moins une chaine de caracteres)
     * @param caracteresASupprimer char[], caractereS a supprimer (remplace chaque caractere trouve par un espace) (laisser vide si il n'y a aucun caractere a supprimer)
     * @return String[][]
     */
    public static String[] extraireDonnees(String donnees, String[] separateurDeChamp, char[] caracteresASupprimer) {
        String[] tableauDonnees = donnees.split(separateurDeChamp[0]);

        for (int index = 1; index < separateurDeChamp.length; index++) {
            tableauDonnees = splitTab(tableauDonnees, separateurDeChamp[index]);
        }
        for (int index = 0; index < tableauDonnees.length; index++) {
            for (char caractere : caracteresASupprimer) {
                tableauDonnees[index] = tableauDonnees[index].replace(caractere, ' ');
            }
            tableauDonnees[index] = tableauDonnees[index].trim();
        }
        return tableauDonnees;
    }
    /**
     * Methode permettant de decouper les chaines de caracteres dans un tableau via la fonction split.
     * Parcours le tableau et decoupe chaque chaine de caracteres ou le separateur de champ apparait.
     * Retourne les donnees dans l'ordre de leur apparition dans le sens normal de lecture.
     * @param tableau String[], tableau de chaines de caracteres
     * @param separateurDeChamp String, chaine de caracteres separatrice des donnees
     * @return String[], le nouveau tableau de taille agrandi ou de meme taille avec les donnees separees dans l'ordre dans lequel elles sont rentrees
     */
    public static String[] splitTab(String[] tableau, String separateurDeChamp) {
        int tableauLength = tableau.length;
        for (int index = 0; index < tableauLength; index++) {
            tableau = concatenerTableaux(tableau, tableau[index].split(separateurDeChamp));
        }
        for (int index = 0; index <= tableauLength; index++) {
            tableau[index] = tableau[index + tableauLength];
        }
        tableau = Arrays.copyOf(tableau, tableau.length - tableauLength);
        return tableau;
    }
    /**
     * Methode permettant de concatener deux tableaux ensemble dans le sens normal de lecture.
     * @param tableau1 String[], correspondra aux premiers elements du tableau de sortie
     * @param tableau2 String[], correspondra aux derniers elements du tableau de sortie
     * @return String[], le tableau contenant les deux tableaux
     */
    public static String[] concatenerTableaux(String[] tableau1, String[] tableau2) {
        String[] tableau3 = Arrays.copyOf(tableau1, tableau1.length + tableau2.length);
        for (int index = 0; index < tableau2.length; index++) {
            tableau3[tableau1.length + index] = tableau2[index];
        }
        return tableau3;
    }
}