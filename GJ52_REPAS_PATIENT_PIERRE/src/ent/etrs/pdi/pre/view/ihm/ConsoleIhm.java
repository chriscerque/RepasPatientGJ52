package ent.etrs.pdi.pre.view.ihm;

import ent.etrs.pdi.pre.view.ihm.exceptions.IhmException;
import ent.etrs.pdi.pre.view.ihm.references.ConstantesIhm;
import ent.etrs.pdi.pre.view.ihm.references.OutilsIhm;
import ent.etrs.pdi.pre.view.references.ConstantesView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleIhm implements Ihm{
    private final Scanner scan = new Scanner(System.in);

    /*------- Affichages -------*/
    @Override
    public void afficherChaine(final String str){
        // Affichge de la chaîne dans la console
        System.out.println(str);
    }

    @Override
    public void afficher2DMTableau(final String titre, final String[] tabEnTete, final String[][] tab){
        // Création des variables
        StringBuilder str = new StringBuilder();
        // Recherche de l'élément le plus grand de chaque colonne dans le tableau (avec l'en-tête)
        int[] tabLMax = rechercherMaxLCol(tabEnTete, tab);
        // Création du titre du tableau
        str.append(creerTitre(titre, tabLMax));
        str.append(System.lineSeparator());
        // Création de l'en-tête du tableau
        str.append(creerEnTete(tabEnTete, tabLMax));
        // Création des données du tableau
        str.append(creerDonneesTab(tab, tabLMax));
        // Affichage du tableau
        afficherChaine(str.toString());
    }

    @Override
    public void afficherErreur(String msg) {
        System.err.println(msg);
    }

    /*------- Saisis -------*/
    @Override
    public String saisirChaine(final String msg){
        // Affichage du message à l'utilisateur
        afficherChaine(msg);
        // Retourne la chaîne saisie
        return scan.nextLine();
    }

    @Override
    public int saisirEntier(final String msg){
        // Création variables
        int entier = -1;
        boolean incorrecte = false;
        // Boucle tant que la saisie n'est pas bonne
        do {
            incorrecte = false;
            // Exception qui est levé si l'utilisateur ne saisie pas en entier
            try {
                // Utilisation de la méthode saisirChaine() pour récupérer la saisie de l'utilisateur
                String saisie = saisirChaine(msg);
                // Transformation de la saisie en entier
                entier = Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                // Modification de la condition de la boucle
                incorrecte = true;
                // Affichage de l'erreur rencontrée
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        // Retourne l'entier saisi
        return entier;
    }

    @Override
    public int saisirEntier(final String msg, final int min, final int max){
        // Création variables
        int entier = -1;
        boolean incorrecte = false;
        // Boucle tant que la saisie n'est pas bonne
        do {
            incorrecte = false;
            // Exception qui est levé si l'utilisateur ne saisie pas en entier
            try {
                // Utilisation de la méthode saisirChaine() pour récupérer la saisie de l'utilisateur
                // Passage des bornes min et max pour l'utilisateur
                String saisie = saisirChaine(msg + " ([" + min + ":" + (max) + "[) ?");
                // Transformation de la saisie en entier
                entier = Integer.parseInt(saisie);
                // Vérification si l'entier est en dehors des bornes
                if (entier < min || entier >= max) {
                    // Modification de la condition de la boucle
                    incorrecte=true;
                    // Affichage de l'erreur rencontrée
                    afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_BORNES+" ([" + min + ":" + max + "[)");
                }
            } catch (NumberFormatException nfe) {
                // Modification de la condition de la boucle
                incorrecte = true;
                // Affichage de l'erreur rencontrée
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        return entier;
    }

    @Override
    public double saisirDouble(String msg) {
        // Création variables
        double entier = -1;
        boolean incorrecte = false;
        // Boucle tant que la saisie n'est pas bonne
        do {
            incorrecte = false;
            // Exception qui est levé si l'utilisateur ne saisie pas en entier
            try {
                // Utilisation de la méthode saisirChaine() pour récupérer la saisie de l'utilisateur
                String saisie = saisirChaine(msg);
                // Transformation de la saisie en entier
                entier = Double.parseDouble(saisie);
            } catch (NumberFormatException e) {
                // Modification de la condition de la boucle
                incorrecte = true;
                // Affichage de l'erreur rencontrée
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        // Retourne l'entier saisi
        return entier;
    }

    @Override
    public double saisirDouble(String msg, double min, double max) {
        // Création variables
        double entier = -1;
        boolean incorrecte = false;
        // Boucle tant que la saisie n'est pas bonne
        do {
            incorrecte = false;
            // Exception qui est levé si l'utilisateur ne saisie pas en entier
            try {
                // Utilisation de la méthode saisirChaine() pour récupérer la saisie de l'utilisateur
                // Passage des bornes min et max pour l'utilisateur
                String saisie = saisirChaine(msg + " ([" + min + ":" + (max) + "[) ?");
                // Transformation de la saisie en entier
                entier = Double.parseDouble(saisie);
                // Vérification si l'entier est en dehors des bornes
                if (entier < min || entier >= max) {
                    // Modification de la condition de la boucle
                    incorrecte=true;
                    // Affichage de l'erreur rencontrée
                    afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_BORNES+" ([" + min + ":" + max + "[)");
                }
            } catch (NumberFormatException nfe) {
                // Modification de la condition de la boucle
                incorrecte = true;
                // Affichage de l'erreur rencontrée
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        return entier;
    }

    @Override
    public boolean saisirBoolean(String msg) {
        msg = String.format("%s%n%s%n%s%n", msg, ConstantesIhm.MENU_BOOLEAN_OUI, ConstantesIhm.MENU_BOOLEAN_NON);
        int saisi = saisirEntier(msg, ConstantesIhm.MENU_BORNES_MIN+1, ConstantesIhm.MENU_BOOLEAN_BORNES_MAX+1);
        if (saisi == 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate saisirDate(String msg) {
        // Création variables
        LocalDate date = LocalDate.now();
        boolean incorrecte = false;
        // Boucle tant que la saisie n'est pas bonne
        do {
            // Exception qui est levé si l'utilisateur ne saisie pas en entier
            try {
                incorrecte = false;
                // Utilisation de la méthode saisirChaine() pour récupérer la saisie de l'utilisateur
                // Passage des bornes min et max pour l'utilisateur
                String saisie = saisirChaine(msg);
                // Transformation de la saisie en entier
                date = LocalDate.parse(saisie, DateTimeFormatter.ofPattern(ConstantesView.PATTERN_DATE));
            } catch (DateTimeParseException dtpe) {
                // Modification de la condition de la boucle
                incorrecte = true;
                // Affichage de l'erreur rencontrée
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        return date;
    }

    @Override
    public int saisirChoixMenuEntier(final String[] tabStr) throws IhmException {
        // Déclaration variable
        int chx;
        // Affichage du menu mis en forme avec creerStrMenu()
        afficherChaine(OutilsIhm.creerStrMenu(tabStr));
        // Récupération de la saisie de l'utilisateur
        chx = saisirEntier(ConstantesIhm.MSG_CHX_MENU, ConstantesIhm.MENU_BORNES_MIN, tabStr.length-1);
        // Retourne l'entier (choix menu) saisi
        return chx;
    }

    @Override
    public int saisirChoixMenuEnum(final Object[] nomEnumAvecValues) throws IhmException {
        int chx ;
        // Affichage du menu mis en forme avec creerStrMenu()
        afficherChaine(OutilsIhm.creerMenuFromEnum(nomEnumAvecValues));
        // Récupération de la saisie de l'utilisateur
        chx = saisirEntier(ConstantesIhm.MSG_CHX_MENU, ConstantesIhm.MENU_BORNES_MIN, nomEnumAvecValues.length);
        // Retourne l'entier (choix menu) saisi
        return chx;
    }

    /*------- Autres méthodes (unique à la console) -------*/
    /**
     * Méthode qui permet de rechercher l'élément le plus grand pour chaques colonnes du tableau de données (en-tête comprise).
     * @param tabEnTete: String[], correspond à l'en-tête du tableau
     * @param tab: String[][], correspond au tableau de données
     * @return String[], retourne un tableau d'entier
     */
    private static int[] rechercherMaxLCol(final String[] tabEnTete, final String[][] tab) {
        // Déclation variables
        int[] tabMax = new int[tabEnTete.length];
        // Tableau qui regroupe l'en-tête et le tableau de données
        String[][] tabConc = concatenerTab(tabEnTete, tab);
        // Boucle sur notre tableau regroupé
        for (int ligne = 0; ligne < tabConc.length; ligne++){
            for (int colonne = 0; colonne < tabConc[ligne].length; colonne++){
                // Vérification que la taille de l'élément est plus grand que celui enregistré
                if(tabConc[ligne][colonne].length() > tabMax[colonne]){
                    tabMax[colonne] = tabConc[ligne][colonne].length();
                }
            }
        }
        // Retourne le tableau d'entier
        return tabMax;
    }

    /**
     * Méthode qui permet de créer le titre du tableau.
     * @param titre: String, correspond au titre
     * @param tabLMax: int[], correspond au tableau des tailles max par colonnes
     * @return String, retourne une chaîne
     */
    private String creerTitre(final String titre, final int[] tabLMax) {
        // Déclaration des variables
        StringBuilder str = new StringBuilder();
        int lTotal = 0;
        // Boucle qui permet de mesurer la taille complète du tableau
        for (int lMax : tabLMax) {
            lTotal += lMax + 3; // Ajout de 3 pour les espaces et bordure
        }
        // Ajout de la dernière bordure du tableau
        lTotal+=1;
        // Répète les espaces pour centrer le titre par rapport au tableau
        str.append(" ".repeat(Math.max(0, (lTotal / 2) - (titre.length() / 2))));
        // Affiche le titre en majuscule
        str.append(titre.toUpperCase());
        // Retourne la chaine des espaces et titre
        return str.toString();
    }

    /**
     * Méthode qui permet de regrouper l'en-tête et le tableau de données.
     * @param tabEnTete: String[], correspond au tableau d'en-tête
     * @param tab: String[][], correspond au tableau de données
     * @return String[][], retourne le tableau regroupé
     */
    private static String[][] concatenerTab(final String[] tabEnTete, final String[][] tab) {
        // Déclaration des variables
        String[][] tabConc = new String[tab.length+1][tab[0].length];
        // Boucle sur le tableau avec valeurs regroupées
        for (int ligne = 0; ligne < tabConc.length; ligne++) {
            for (int colonne = 0; colonne < tabConc[ligne].length; colonne++) {
                // Vérifie si première ligne de tableau pour ajouter l'en-tête
                if(ligne == 0){
                    tabConc[ligne][colonne] = tabEnTete[colonne];
                // sinon ajout des données
                } else {
                    tabConc[ligne][colonne] = tab[ligne-1][colonne];
                }
            }
        }
        // Retourne le tableau
        return tabConc;
    }

    /**
     * Méthode qui permet de créer (+styliser) l'en-tête de notre tableau.
     * @param tabEnTete: String[], correspond au tableau des valeurs de l'en-tête
     * @param tabLMax: String[], correspond au tableau des taille maximum de chaque colonne
     * @return String, retourne la chaîne de l'en-tête stylisée
     */
    private String creerEnTete(final String[] tabEnTete, final int[] tabLMax) {
        // Déclaration variable
        StringBuilder str = new StringBuilder();
        // Création d'une bordure top
        str.append(creerLigneSeparation(tabLMax));
        // Boucle sur les valeurs de l'en-tête
        for (int i = 0; i < tabEnTete.length; i++) {
            // Ajout bordure gauche + aligner element au centre
            str.append("| ").append(alignerTab(tabEnTete[i], tabLMax[i], true));
        }
        // Ajout de la bordure droite
        str.append("|").append(System.lineSeparator());
        // Création d'une bordure bottom
        str.append(creerLigneSeparation(tabLMax));
        // Retourne la chaîne
        return str.toString();
    }

    /**
     * Méthode qui permet une bordure au tableau (séparer l'en-tête des données).
     * @param tabLMax: int[], correspond au tableau de la taille max par colonnes
     * @return String, retourne la chaîne de la ligne de séparation (bordure)
     */
    private String creerLigneSeparation(final int[] tabLMax) {
        // Déclaration variable
        StringBuilder str = new StringBuilder();
        // Boucle sur le tableau des tailles max
        for (int lMax : tabLMax) {
            str.append("*-");
            str.append("-".repeat(Math.max(0, lMax)));
            str.append("-");
        }
        str.append("*");
        str.append(System.lineSeparator());
        // Retourne la chaîne
        return str.toString();
    }

    /**
     * Méthode qui permet d'aligner les bordures (droite gauche) du tableau.
     * @param txt: String, correspond à la donnée
     * @param tabLMax: int, correspond à la taille max de la colonne
     * @param center: boolean, correspond à la stylisation du texte
     * @return String, retourne la chaîne (donnée + espace)
     */
    private String alignerTab(final String txt, final int tabLMax, final boolean center) {
        // Déclaration des variables
        StringBuilder str = new StringBuilder();
        // Vérification si stylisation centrer (utilisée uniquement pour l'en-tête)
        if(center){
            // Ajout des espaces avant
            str.append(" ".repeat(Math.max(0, (tabLMax - txt.length())/2)));
            // Affichage en majuscule de l'en-tête
            str.append(txt.toUpperCase());
            // Vérification si le texte
            if(tabLMax == txt.length()){
                // Ajout d'un espace après
                str.append(" ");
            } else {
                // Vérifie si la taille de la données est pair ou impair pour ajouter espaces nécessaires
                if (txt.length() % 2 == 0) {
                    // Ajout des espaces après
                    str.append(" ".repeat(Math.max(0, (tabLMax - txt.length() + 1) / 2)));
                } else {
                    // Ajout des espaces après
                    for (int i = 0; i < (tabLMax - txt.length() + 1) / 2; i++) {
                        str.append(" ");
                    }
                }
                str.append(" ");
            }
        // Sinon la donnée est alignée à gauche
        }else{
            str.append(txt);
            str.append(" ".repeat(Math.max(0, (tabLMax - txt.length()) + 1)));
        }
        // Retourne la chaîne
        return str.toString();
    }

    /**
     * Méthode qui permet de créer (+styliser) les données du tableau.
     * @param tab: String[][], correspond à notre tableau de données
     * @param tabLMax: int[], correspond à nos tailles max par colonnes
     * @return String, retourne la chaîne(tableau) de l'en-tête stylisée
     */
    private String creerDonneesTab(final String[][] tab, final int[] tabLMax) {
        // Déclarations des variables
        StringBuilder str = new StringBuilder();
        // Boucle sur notre tableau de données
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                // Ajout de la bordure gauche
                str.append("| ");
                // Ajout de l'élément et alignement bordure (pas centré)
                str.append(alignerTab(tab[ligne][colonne], tabLMax[colonne], false));
            }
            // Ajout de la bordure droite
            str.append("|");
            str.append(System.lineSeparator());
        }
        // Création d'une bordure bottom
        str.append(creerLigneSeparation(tabLMax));
        // Retourne la chaîne
        return str.toString();
    }
}
