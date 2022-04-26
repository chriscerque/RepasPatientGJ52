package net.ent.etrs.gzij.vue.ihm;

import net.ent.etrs.gzij.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.gzij.vue.ihm.outils.IhmOutils;
import net.ent.etrs.gzij.vue.ihm.referencies.TypeAlignement;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

/**
 * Classe héritant de {@link Ihm} et définit les méthodes pour réaliser un interfacage utilisateur en mode fênetre.
 */
public class IhmPanel implements Ihm{

    @Override
    public void afficherChaine(final String msg,final boolean sautLigne) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void afficherChaine(final String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public String saisirChaine(final String invite) {
        String strSaisie = JOptionPane.showInputDialog(null, invite);
        return strSaisie;
    }

    @Override
    public int saisirEntier(final String msg, int min, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message et faire saisir l'entier
            strSaisie = JOptionPane.showInputDialog(msg);

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max]
                if (saisie >= min && saisie <= max) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    JOptionPane.showMessageDialog(null,"ERR : entier saisi hors intervalle demandé [" + min + " : " + max +"]");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntierMin(String msg, int min) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message et faire saisir l'entier
            strSaisie = JOptionPane.showInputDialog(msg);

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max]
                if (saisie >= min) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    JOptionPane.showMessageDialog(null,"ERR : entier saisi hors intervalle demandé [" + min + " : --]");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntierMax(String msg, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message et faire saisir l'entier
            strSaisie = JOptionPane.showInputDialog(msg);

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max]
                if (saisie <= max) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    JOptionPane.showMessageDialog(null,"ERR : entier saisi hors intervalle demandé [-- : " + max +"]");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntier(final String msg) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message et faire saisir l'entier
            strSaisie = JOptionPane.showInputDialog(msg);

            try {

                saisie = Integer.parseInt(strSaisie);
                ok = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public LocalDate saisirLocalDate(final String msg) {
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
    public int saisirChoixMenu(final String[] tabloStr) throws ExceptionsIhm {

        int chx = saisirEntier(IhmOutils.creerStrMenu(tabloStr), 0, tabloStr.length - 2);

        return chx;
    }

    @Override
    public int saisirChoixMenu(final String strMenu, final int min, final int max) {
        String strMenu2=strMenu+"\n Votre choix ?";
        int chx = saisirEntier(strMenu,min,max);
        return chx;
    }

    @Override
    public int saisirChoixMenu(final String titreMenu, final String piedMenu, final Object[] nomEnumAvecValues) {

        int chx = saisirEntier(IhmOutils.creerMenuFromEnum(titreMenu, piedMenu, nomEnumAvecValues), 0, nomEnumAvecValues.length);

        return chx;
    }

    @Override
    public void afficherTableau1D(final String titre, final Object[] tablo) {

        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());

        for (int i = 0 ; i < tablo.length; i++) {
            strb.append(tablo[i]);
            strb.append(System.lineSeparator());
        }
        afficherChaine(strb.toString());
    }

    @Override
    public void afficherTableau2D(final String titre, final String[] tabloEntetes, final String[][] tabloDonnees, final TypeAlignement[] tabloAlignement, final boolean afficherNoLigne) {
        StringBuilder strbRetour = new StringBuilder("<html>");
        strbRetour.append("<h2>"+titre+"</h2>");
        strbRetour.append("<table border='1'>");

        //MEP entetes
        strbRetour.append(creerEntetes(tabloEntetes,afficherNoLigne));

        //les données
        for(int ligne = 0; ligne < tabloDonnees.length; ligne++){

            if ( Objects.nonNull(tabloDonnees[ligne][0])) {
                strbRetour.append("<tr>");

                if (afficherNoLigne) {
                    strbRetour.append("<td>").append(String.format("%02d", ligne + 1 )).append("</td>");
                }
                for (int colonne = 0; colonne < tabloDonnees[ligne].length; colonne++) {
                    strbRetour.append("<td align='" + (tabloAlignement[colonne].name().toLowerCase() + "'>")).append(tabloDonnees[ligne][colonne]).append("</td>");
                }
                strbRetour.append("</tr>");
            }

        }
        strbRetour.append("</table></html>");

        afficherChaine(strbRetour.toString(),true);
    }

    /**
     * Méthode chargée de créer la ligne des entêtes de colonne.
     *
     * @param tabloEntetes String[]
     * @param afficherNoLigne boolean, avec un no de ligne
     * @return String
     */
    private String creerEntetes(final String[] tabloEntetes, final boolean afficherNoLigne){
        //MEP entetes

        StringBuilder stringValRetour = new StringBuilder("<tr >");
        if (afficherNoLigne) {
            stringValRetour.append("<th style='background-color:gray; color:white'><i> No </i></th>");
        }

        for (int i = 0; i < tabloEntetes.length; i++) {
            stringValRetour.append("<th style='background-color:gray; color:white'><i>").append(tabloEntetes[i]).append("</i></th>");
        }
        stringValRetour.append("</tr>");

        return stringValRetour.toString();
    }

    @Override
    public void afficherErreur(final String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public int saisirChoixMenuPrincipal(final String titre, final String[] str) {
        int chx = saisirEntier(IhmOutils.creerMenuFromEnum(titre, "Quitter", str), 0, str.length);

        return chx;
    }

} // fin de classe
