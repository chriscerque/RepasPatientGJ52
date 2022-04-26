package ent.etrs.pdi.pre.view.ihm;

import ent.etrs.pdi.pre.view.ihm.exceptions.IhmException;
import ent.etrs.pdi.pre.view.ihm.references.ConstantesIhm;
import ent.etrs.pdi.pre.view.ihm.references.OutilsIhm;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class JPanelIhm implements Ihm {

    /*------- Affichages -------*/
    @Override
    public void afficherChaine(final String str){
        // Affichge de la chaîne dans le panel
        JOptionPane.showMessageDialog(null, str);

    }

    @Override
    public void afficher2DMTableau(final String titre, final String[] tabEnTete, final String[][] tab) {
        // Création des variables
        StringBuilder str = new StringBuilder();
        // Stylisation avec html
        str.append("<html>");
        // Création du titre du tableau
        str.append("<h2 align='center'>").append(titre).append("</h2>");
        str.append("<table border='1'>");
        // Création de l'en-tête du tableau
        str.append(creerEnTete(tabEnTete));
        // Création des données du tableau
        str.append(creerDonneesTab(tab));
        str.append("</table>");
        str.append("</html>");
        // Affichage du tableau
        afficherChaine(str.toString());
    }

    @Override
    public void afficherErreur(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /*------- Saisis -------*/
    @Override
    public String saisirChaine(final String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }

    @Override
    public int saisirEntier(final String msg){
        int entier = -1;
        boolean incorrecte = false;
        do {
            try {
                String saisie = JOptionPane.showInputDialog(msg);
                entier = Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                incorrecte = true;
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);

        return entier;
    }

    @Override
    public int saisirEntier(final String msg, final int min, final int max){
        int entier = -1;
        boolean incorrecte = false;
        do {
            try {
                String saisie = JOptionPane.showInputDialog(msg + " ([" + min + ":" + (max) + "[) ?");
                entier = Integer.parseInt(saisie);

                if (entier < min || entier >= max) {
                    incorrecte=true;
                    afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_BORNES+" ([" + min + ":" + max + "[)");
                }
            } catch (NumberFormatException nfe) {
                incorrecte = true;
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        return entier;
    }

    @Override
    public double saisirDouble(String msg) {
        double entier = -1;
        boolean incorrecte = false;
        do {
            try {
                String saisie = JOptionPane.showInputDialog(msg);
                entier = Double.parseDouble(saisie);
            } catch (NumberFormatException e) {
                incorrecte = true;
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);

        return entier;
    }

    @Override
    public double saisirDouble(String msg, double min, double max) {
        double entier = -1;
        boolean incorrecte = false;
        do {
            try {
                String saisie = JOptionPane.showInputDialog(msg + " ([" + min + ":" + (max) + "[) ?");
                entier = Double.parseDouble(saisie);

                if (entier < min || entier >= max) {
                    incorrecte=true;
                    afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_BORNES+" ([" + min + ":" + max + "[)");
                }
            } catch (NumberFormatException nfe) {
                incorrecte = true;
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECTE);
            }
        } while (incorrecte);
        return entier;
    }

    @Override
    public boolean saisirBoolean(String msg) {
        msg = String.format("%s%n%s%n%s", msg, ConstantesIhm.MENU_BOOLEAN_OUI, ConstantesIhm.MENU_BOOLEAN_NON);
        int saisi = saisirEntier(msg, ConstantesIhm.MENU_BORNES_MIN, ConstantesIhm.MENU_BOOLEAN_BORNES_MAX);
        if (saisi == 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate saisirDate(String msg) {
        return null;
    }

    @Override
    public int saisirChoixMenuEntier(final String[] tabStr) throws IhmException {
        int chx;
        chx = saisirEntier(OutilsIhm.creerStrMenu(tabStr)+ConstantesIhm.MSG_CHX_MENU, ConstantesIhm.MENU_BORNES_MIN, tabStr.length-1);
        return chx;
    }

    @Override
    public int saisirChoixMenuEnum(final Object[] nomEnumAvecValues) throws IhmException {
        int chx = saisirEntier(OutilsIhm.creerMenuFromEnum(nomEnumAvecValues), 0, nomEnumAvecValues.length);
        return chx;
    }

    /*------- Autres méthodes (unique au panel) -------*/
    /**
     * Méthode qui permet de creer (+styliser) l'en-tête du tableau.
     * @param tabEnTete: String[], correspond au tableau des valeurs de l'en-tête
     * @return String, retourne la chaîne de l'en-tête stylisé
     */
    private String creerEnTete(final String[] tabEnTete) {
        StringBuilder str = new StringBuilder();
        str.append("<tr>");
        for (String s : tabEnTete) {
            str.append("<th>").append(s.toUpperCase()).append("</th>");
        }
        str.append("</tr>");
        return str.toString();
    }

    /**
     * Méthode qui permet de creer (+styliser) les données du tableau.
     * @param tab: String[], correspond au tableau des données
     * @return String, retourne la chaine du tableau stylisé
     */
    private String creerDonneesTab(final String[][] tab) {
        StringBuilder str = new StringBuilder();
        for (int ligne = 0; ligne < tab.length; ligne++) {
            str.append("<tr>");
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                str.append("<td>").append(tab[ligne][colonne]).append("</td>");
            }
            str.append("</tr>");
        }
        return str.toString();
    }
}
