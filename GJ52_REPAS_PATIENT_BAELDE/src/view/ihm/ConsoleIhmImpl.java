package view.ihm;

import view.ihm.references.ConstanteIhm;
import view.ihm.outils.OutilsIhm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleIhmImpl extends IhmImpl {
    private final Scanner scan = new Scanner(System.in);

    @Override
    public String saisirChaine(final String msg) {
        afficherChaine(msg);
        return scan.nextLine();
    }

    @Override
    public int saisirChoixMenu(final String[] menu, final boolean titre, final boolean choixZero) {
        int choix = -1;
        if (menu.length > 1) {
            int min = 1;
            int max = menu.length - 1;
            if (choixZero) {
                min = 0;
                max = menu.length - 2;
            }
            StringBuilder menuStr = new StringBuilder(OutilsIhm.encadrerTableauVerticalement(OutilsIhm.numeroterElementTableau(menu, titre, choixZero), titre));
            menuStr.append(System.lineSeparator());
            menuStr.append(String.format(ConstanteIhm.MSG_DEMANDE_CHOIX_ENTIER_FORMAT_MIN_MAX, min, max));
            choix = saisirEntier(menuStr.toString(), min, max);
        } else {
            afficherChaine(ConstanteIhm.MSG_ERR_SAISIRCHOIXMENU_LONGUEUR_TAB);
        }
        return choix;
    }

    @Override
    public void afficherChaine(final String msg) {
        System.out.println(msg);
    }

    @Override
    public void afficherTableau(final String[] tableauStr, final String titre) {
        // creer un tableau avec la taille de chaque colonne
        int[] tailleColonnes = new int[tableauStr.length];
        for (int colonne = 0; colonne < tailleColonnes.length; colonne++) {
            tailleColonnes[colonne] = tableauStr[colonne].length();
        }
        // creer la chaine constructrice + ajout du titre + ajout d'une ligne pour commencer le tableau
        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());
        strb.append(OutilsIhm.creerLigneSeparatriceTableau(tailleColonnes));
        strb.append(System.lineSeparator());
        for (int colonne = 0; colonne < tableauStr.length; colonne++) {
            strb.append(String.format("| %s ", tableauStr[colonne]));
        }
        // ajout de la separation a la fin du tableau car il n'y a plus de colonne apres + retour a la ligne
        strb.append("|");
        strb.append(System.lineSeparator());
        strb.append(OutilsIhm.creerLigneSeparatriceTableau(tailleColonnes));
        // affichage
        afficherChaine(strb.toString());
    }

    @Override
    public void afficherTableau(final String[][] tableauStr, final String titre, final boolean entete) {
        // creer un tableau avec la taille de chaque colonne
        int[] tailleColonnes = new int[tableauStr[0].length];
        for (int colonne = 0; colonne < tailleColonnes.length; colonne++) {
            tailleColonnes[colonne] = OutilsIhm.rechercherNbMaxChar(OutilsIhm.recupererColonne(tableauStr, colonne));
        }
        // creer la chaine constructrice + ajout du titre + ajout d'une ligne pour commencer le tableau
        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());
        strb.append(OutilsIhm.creerLigneSeparatriceTableau(tailleColonnes));
        strb.append(System.lineSeparator());

        // ajouter les donnees a la chaine
        for (int ligne = 0; ligne < tableauStr.length; ligne++) {

            // ligne separatrice entre les titres des colonnes et les donnees
            if (ligne == 1 && entete) {
                strb.append(OutilsIhm.creerLigneSeparatriceTableau(tailleColonnes));
                strb.append(System.lineSeparator());
            }
            for (int colonne = 0; colonne < tableauStr[ligne].length; colonne++) {
                strb.append("| ");
                strb.append(OutilsIhm.alignerTexteGauche(tableauStr[ligne][colonne], tailleColonnes[colonne], '.'));
                strb.append(" ");
            }
            // ajout de la separation a la fin du tableau car il n'y a plus de colonne apres + retour a la ligne
            strb.append("|");
            strb.append(System.lineSeparator());
        }
        // ajouter une ligne separatrice a la fin du tableau
        strb.append(OutilsIhm.creerLigneSeparatriceTableau(tailleColonnes));
        strb.append(System.lineSeparator());

        // afficher la chaine
        afficherChaine(strb.toString());
    }

}
