package net.ent.etrs.ggef.vue.ihm;

import net.ent.etrs.ggef.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.ggef.vue.ihm.referencies.IhmConstantes;
import net.ent.etrs.ggef.vue.ihm.referencies.TypeAlignement;
import net.ent.etrs.ggef.vue.ihm.outils.IhmOutils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class IhmConsole implements Ihm {

private final Scanner scan = new Scanner(System.in);

    @Override
    public void afficherChaine(String msg, boolean sautLigne) {
        if(sautLigne) {
            System.out.println(msg);
        }else{
            System.out.print(msg);
        }
    }

    @Override
    public void afficherChaine(String msg) {
        System.out.println(msg);
    }

    @Override
    public String saisirChaine(String invite) {
        String str = null;
        // 0 afficher le message
        afficherChaine(invite, true);
        // 1 saisir la chaine demandée
        str = scan.nextLine();

        return str;
    }

    @Override
    public int saisirEntier(String msg, int min, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message
            afficherChaine(msg, false);
            //1 faire saisir l'entier
            //   saisie = scan.nextInt(); // pb avec mismatch exception
            strSaisie = scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max]
                if (saisie >= min && saisie <= max) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    afficherChaine("ERR : entier saisi hors intervalle demandé [" + min + " : " + max + "]", true);
                }
            } catch (NumberFormatException nfe) {
                afficherChaine("ERR: erreur de type de données saisie", true);
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntier(String msg){

        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message
            afficherChaine(msg, false);
            //1 faire saisir l'entier
            strSaisie = scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);
                ok = true;

            } catch (NumberFormatException nfe) {
                afficherChaine("ERR: erreur de type de données saisie", true);
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;

    }

    @Override
    public LocalDate saisirLocalDate(String msg) {
        int annee = -1;
        int mois = -1;
        int jours = -1;
        boolean continuer = false;

        afficherChaine(msg, false);
        do {
            annee = saisirEntier("Saisir l'année entre 1970 et 2050 :", 1970, 2050);
            mois = saisirEntier("Saisir le mois entre 1 et 12 :", 1, 12);
            jours = saisirEntier("Saisir le jour entre 1 et 31 :", 1, 31);
            try {
                continuer = false;
                return LocalDate.of(annee, mois, jours);
            } catch (DateTimeException e) {
                continuer = true;
                System.out.println(e.getMessage());
            }
        } while (continuer);
        return null;
    }

    @Override
    public int saisirChoixMenu(String[] tabloStr, int min, int max) throws ExceptionsIhm {
        int chx = -1;

            //afficher menu :
            afficherChaine(IhmOutils.creerStrMenu(tabloStr), true);
            //faire choisir :
            chx = saisirEntier(IhmConstantes.MSG_INVITE, min, max);

        return chx;
    }

    @Override
    public int saisirchoixMenu(String strMenu, int min, int max) {
        String strMenu2=strMenu+"\n Votre choix ?";
        int chx = saisirEntier(strMenu,min,max);
        return chx;
    }

    @Override
    public int saisirChoixMenu(String titreMenu,String piedMenu, Object[] nomEnumAvecValues) {

        int chx = saisirEntier(IhmOutils.creerMenuFromEnum(titreMenu, piedMenu, nomEnumAvecValues), 0, nomEnumAvecValues.length);

        return chx;
    }

    @Override
    public void afficherTableau1D(String titre, Object[] tablo) {

        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());

        for (int i = 0 ; i < tablo.length; i++) {
            strb.append(tablo[i]);
            strb.append(System.lineSeparator());
        }
        afficherChaine(strb.toString());
    }

    @Override
    public void afficherTableau2D(String titre, String[] tabloEntetes, String[][] tabloDonnees, TypeAlignement[] tabloAlignement, boolean afficherNoLigne) {
        //le titre
        StringBuilder strbRetour = new StringBuilder();
        strbRetour.append("\n"+(Objects.isNull(titre) ? "Contenu" : titre)).append(System.lineSeparator());

        //autres
        int[] tabLargeursMax = rechercherMaxLargeur(tabloEntetes, tabloDonnees);
        int largeurTotale = getLargeurTotale(tabLargeursMax, afficherNoLigne);

        strbRetour.append(creerEntetes(tabloEntetes, tabloAlignement, tabLargeursMax, largeurTotale, afficherNoLigne));

        //Données
        strbRetour.append(creerLigne(largeurTotale,(afficherNoLigne ? tabloEntetes.length : 0)));
        strbRetour.append(System.lineSeparator());

        for(int ligne = 0; ligne < tabloDonnees.length; ligne++) {
            if (Objects.nonNull(tabloDonnees[ligne])) {

                if (afficherNoLigne && Objects.nonNull(tabloDonnees[ligne][0])) {
                    strbRetour.append(String.format("! %02d ", ligne + 1));
                }
                if(Objects.nonNull(tabloDonnees[ligne][0])) {
                    for (int colonne = 0; colonne < tabloDonnees[0].length; colonne++) {
                        strbRetour.append(IhmOutils.alignerTexte(tabloAlignement[colonne], tabloDonnees[ligne][colonne], tabLargeursMax[colonne]));
                    }
                    strbRetour.append("!");
                    strbRetour.append(System.lineSeparator());
                }
            }
        }

        strbRetour.append(creerLigne(largeurTotale,(afficherNoLigne ? tabloEntetes.length : 0)));
        strbRetour.append(System.lineSeparator());

        afficherChaine(strbRetour.toString(),true);
    }

    /**
     * Méthode permettant de rechercher la longueur de chaque colonne d'un tableau.
     *
     * Pour ce faire, la méthode fusionne un tableau d'entete et le tableau de données associer
     * puis utilise la méthode {@link rechercherMaxDsColonne}pour obtenir un tableau d'entier contenant la longueur de chaque colonne
     *
     * @param tabloEntetes String[] tableau contenant les entetes d'un tableau
     * @param tabloDonnees String[][] tableau contenant les données des lignes et colonnes d'un jeu de données
     * @return int[]
     */
    private int[] rechercherMaxLargeur(String[] tabloEntetes, String[][] tabloDonnees){

        String [][] tabloTemp = new String[tabloDonnees.length+1][tabloDonnees[0].length];
        //recopie des données
        int ligne=0;
        for(ligne=0; ligne < tabloDonnees.length; ligne++){
            for(int colonne = 0; colonne < tabloDonnees[ligne].length; colonne++){
                if(Objects.nonNull(tabloDonnees[ligne][colonne])) {
                    tabloTemp[ligne][colonne] = tabloDonnees[ligne][colonne];
                }else{
                    tabloTemp[ligne][colonne]="@";
                }
            }
        }
        //ajout des entêtes
        for(int i = 0; i < tabloEntetes.length; i++){
            tabloTemp[ligne][i]= tabloEntetes[i];
        }
        //recherche du max
        int[] tabloLongMaxMot = rechercherMaxDsColonne(tabloTemp);

        return tabloLongMaxMot;

    }

    /**
     * Méthode permettant de rechercher la longueur de chacune des colonnes d'un tableau.
     *
     * La méthode compare la taille de chaque ligne d'une même colonne avec les autres lignes de la colonne
     * et génère un tableau d'entier contenant la taille max de chaque colonne
     *
     * @param tabloDonnees String[][] tableau de données à parcourir
     * @return int[]
     */
    private int[] rechercherMaxDsColonne(String[][] tabloDonnees){
        int[] tabloLongMaxMot = new int[tabloDonnees.length];
        //int idxColonne = 0;
        int colonne = 0;

        for(colonne = 0; colonne < tabloDonnees[0].length; colonne++) {
            int ligne = 0;
            int max = 0;

            for(ligne = 0; ligne < tabloDonnees.length; ligne++){
                if(tabloDonnees[ligne][colonne].length() >= max){
                    max = tabloDonnees[ligne][colonne].length();
                }
            }
            //Traitement tablo 1 colonne
            //tabloLongMaxMot[idxColonne] = max;
            tabloLongMaxMot[colonne] = max;
            //idxColonne++;
        }
        return tabloLongMaxMot;
    }

    public int getLargeurTotale(int[] tabloLongMaxMot, boolean afficherNoLigne){
        int longueurTotale = 0;
        for(int i = 0; i < tabloLongMaxMot.length; i++){
            longueurTotale += tabloLongMaxMot[i]+1;
        }
        if(afficherNoLigne){
            longueurTotale += 4;
        }
        return longueurTotale;
    }

    public static final int NB_CHAR = 2;
    private String creerLigne(int longueur, int longueurEntete){
        StringBuilder chaineSortie = new StringBuilder();

        String chaine="";
        while(chaine.length() < (longueur+(NB_CHAR * longueurEntete))){
            chaine += "-";
        }
        chaineSortie.append(chaine);
        return chaineSortie.toString();
    }

    private String creerEntetes(String[] tabloEntetes, TypeAlignement[] tabloAlignement, int[] tabloLongMaxMot, int longueurTotale, boolean afficherNoLigne){
        StringBuffer stringValRetour = new StringBuffer();
        stringValRetour.append(creerLigne(longueurTotale,(afficherNoLigne ? tabloEntetes.length : 0)));
        stringValRetour.append(System.lineSeparator());

        //entêtes
        if(afficherNoLigne){
            stringValRetour.append("! No ");
        }

        for(int i = 0; i < tabloEntetes.length; i++){
            stringValRetour.append(IhmOutils.alignerTexte(tabloAlignement[i],tabloEntetes[i],tabloLongMaxMot[i]));
        }

        stringValRetour.append("!");
        stringValRetour.append(System.lineSeparator());

        return stringValRetour.toString();
    }

    @Override
    public void afficherErreur(String msg) {
        System.err.println(msg);
    }
} // fin de classe
