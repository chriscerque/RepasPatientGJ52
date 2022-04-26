package net.ent.etrs.rnbm.view.ihm;


import net.ent.etrs.rnbm.view.ihm.commons.outilsIhm.MesOutilsIhm;
import net.ent.etrs.rnbm.view.ihm.commons.references.constantes.IhmConstantes;
import net.ent.etrs.rnbm.view.ihm.commons.references.enumerateds.TypeAlignement;
import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstructeur;
import net.ent.etrs.rnbm.model.commons.exceptions.OutilsException;

import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {

    private final Scanner scan = new Scanner(System.in);

    @Override
    public String saisirChaine(String invite) {
        String str = null;
        // 0 afficher le message
        afficherChaine(invite);
        // 1 saisir la chaine demandée
        str = scan.nextLine();

        return str;
    }

    @Override
    public int saisirChoixMenu(String[] tabloStr, int min, int max, boolean pied_page) throws ExceptionsConstructeur {
        int choix = -1;

        if (pied_page){
            //Affiche le menu avec une option "Quitter" en pied de page.
            afficherChaine(MesOutilsIhm.creerStrMenuAvecPiedDePage(tabloStr));
        } else {
            //Affiche le menu sans option en pied de page.
            afficherChaine(MesOutilsIhm.creerStrMenu(tabloStr));
        }


        //Demande le choix à l'utilisateur
        choix = saisirEntier(String.format(IhmConstantes.MSG_INVITE,min, max-1), min, max-1);

        return choix;
    }

    @Override
    public int saisirEntier(String msg, int min, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message
            afficherChaine(msg);
            //1 faire saisir l'entier
            //   saisie = scan.nextInt(); // pb avec mismatch exception
            strSaisie = scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max[
                if (saisie >= min && saisie < max) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    afficherChaine("ERR : entier saisi hors intervalle demandé [" + min + " : " + max + "[");
                }
            } catch (NumberFormatException nfe) {
                afficherChaine("ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntier(String msg) {

        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message
            afficherChaine(msg);
            //1 faire saisir l'entier
            strSaisie = scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);
                ok = true;

            } catch (NumberFormatException nfe) {
                afficherChaine("ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;

    }

    @Override
    public void afficherChaine(String msg) {

        System.out.println(msg);


    }

    @Override
    public void afficherTableau(String titre, String[][] tableauStr, TypeAlignement alignement, boolean entete) {
        try {
            // creer un tableau avec la taille de chaque colonne
            int[] tailleColonnes = new int[tableauStr[0].length];
            for (int colonne = 0; colonne < tailleColonnes.length; colonne++) {
                tailleColonnes[colonne] = MesOutilsIhm.rechercherNbMaxChar(MesOutilsIhm.recupererColonne(tableauStr, colonne));
            }
            // creer la chaine constructrice + ajout du titre + ajout d'une ligne pour commencer le tableau
            StringBuilder strb = new StringBuilder(titre);
            strb.append(System.lineSeparator());
            strb.append(this.creerLigneSeparatriceTableau(tailleColonnes));
            strb.append(System.lineSeparator());

            // ajouter les donnees a la chaine
            for (int ligne = 0; ligne < tableauStr.length; ligne++) {

                // ligne separatrice entre les titres des colonnes et les donnees
                if (ligne == 1 && entete) {
                    strb.append(this.creerLigneSeparatriceTableau(tailleColonnes));
                    strb.append(System.lineSeparator());
                }
                for (int colonne = 0; colonne < tableauStr[ligne].length; colonne++) {
                    strb.append("| ");
                    strb.append(MesOutilsIhm.alignerTexte(alignement, tableauStr[ligne][colonne], tailleColonnes[colonne]));
                    strb.append(" ");
                }
                // ajout de la separation a la fin du tableau car il n'y a plus de colonne apres + retour a la ligne
                strb.append("|");
                strb.append(System.lineSeparator());
            }
            // ajouter une ligne separatrice a la fin du tableau
            strb.append(this.creerLigneSeparatriceTableau(tailleColonnes));
            strb.append(System.lineSeparator());

            // afficher la chaine
            afficherChaine(strb.toString());
        } catch (OutilsException oe) {
            afficherChaine(IhmConstantes.MSG_ERR_AFFICHAGE_TABLEAU + "(" + oe.getMessage() + ").");
        }
    }

    /**
     * Methode permettant de creer une ligne separatrice pour un tableau dont on renseigne la taille des colonnes.
     * La chaine de caracteres sera composee de '+' pour delimiter la colonne et de '-' pour effectuer la ligne.
     * La chaine commencera et finira par un '+'. Pour chaque colonne on aura ca longueur +2 '-'.
     *
     * @param tabTailleColonnes:int[]
     * @return String
     */
    private static String creerLigneSeparatriceTableau(int[] tabTailleColonnes) {
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


}

