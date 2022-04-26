package net.ent.etrs.rnbm.view.ihm;


import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstructeur;
import net.ent.etrs.rnbm.view.ihm.commons.outilsIhm.MesOutilsIhm;
import net.ent.etrs.rnbm.view.ihm.commons.references.constantes.IhmConstantes;
import net.ent.etrs.rnbm.view.ihm.commons.references.enumerateds.TypeAlignement;

import javax.swing.*;

public class JPanelIhmImpl implements Ihm {

    @Override
    public String saisirChaine(String invite) {
        String strSaisie = JOptionPane.showInputDialog(null, invite);
        return strSaisie;
    }

    @Override
    public int saisirChoixMenu(String[] tabloStr, int min, int max, boolean pied_page) throws ExceptionsConstructeur {
        int choix = -1;
        if (pied_page){
            //Affiche le menu avec une option "Quitter" en pied de page.
            choix = saisirEntier(String.format(MesOutilsIhm.creerStrMenuAvecPiedDePage(tabloStr) + IhmConstantes.MSG_INVITE, min, max-1), min, max-1);

        } else {
            //Affiche le menu sans option en pied de page.
            choix = saisirEntier(String.format("%s%n%s",MesOutilsIhm.creerStrMenu(tabloStr),String.format(IhmConstantes.MSG_INVITE, min, max-1)), min, max-1);
        }


        return choix;
    }

    @Override
    public int saisirEntier(String msg, int min, int max) {
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
                    JOptionPane.showMessageDialog(null,"ERR : entier saisi hors intervalle demandé [" + min + " : " + max +"[");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"ERR: erreur de type de données saisie");
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
            //0 afficher le message et faire saisir l'entier
            strSaisie = JOptionPane.showInputDialog(msg);

            try {

                saisie = Integer.parseInt(strSaisie);
                ok = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ERR: erreur de type de données saisie");
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public void afficherChaine(String msg) {

        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void afficherTableau(String titre, String[][] tableauStr, TypeAlignement alignement, boolean entete) {
        StringBuilder strb = new StringBuilder("<html><h2>");
        strb.append(titre);
        strb.append("</h2><table border=1>");

        int debut = 0;

        if (entete) {
            debut = 1;

            strb.append("<thead><tr>");
            for (String chaine : tableauStr[0]) {
                strb.append(String.format("<th color=red align=\"%s\">%s</th>", alignement.name(), chaine));
            }
            strb.append("</tr></thead>");
        }

        strb.append("<tbody>");
        for (int ligne = debut; ligne < tableauStr.length; ligne++) {
            strb.append("<tr>");
            for (int colonne = 0; colonne < tableauStr[ligne].length; colonne++) {
                strb.append(String.format("<td align=\"%s\">%s</td>", alignement.name(), tableauStr[ligne][colonne]));
            }
            strb.append("</tr>");
        }

        strb.append("</tbody></table></html>");

        afficherChaine(strb.toString());
    }

}
