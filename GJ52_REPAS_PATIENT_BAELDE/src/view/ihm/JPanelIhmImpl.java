package view.ihm;

import view.ihm.outils.OutilsIhm;
import view.ihm.references.ConstanteIhm;

import javax.swing.*;

public class JPanelIhmImpl extends IhmImpl {

    @Override
    public String saisirChaine(String msg) {
        return JOptionPane.showInputDialog(msg);
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
            StringBuilder menuStr = new StringBuilder(OutilsIhm.creerStrMenuFenetre(OutilsIhm.numeroterElementTableau(menu, titre, choixZero), titre, choixZero));
            menuStr.append(System.lineSeparator());
            menuStr.append(System.lineSeparator());
            menuStr.append(String.format(ConstanteIhm.MSG_DEMANDE_CHOIX_ENTIER_FORMAT_MIN_MAX, min, max));
            choix = saisirEntier(menuStr.toString(), min, max);
        } else {
            afficherChaine(ConstanteIhm.MSG_ERR_SAISIRCHOIXMENU_LONGUEUR_TAB);
        }
        return choix;
    }

    @Override
    public void afficherChaine(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void afficherTableau(String[] tableau, String titre) {
        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());
        for (String ligne : tableau) {
            strb.append(System.lineSeparator());
            strb.append(ligne);
        }
        afficherChaine(strb.toString());
    }

    @Override
    public void afficherTableau(String[][] tableauStr, String titre, boolean entete) {
        StringBuilder strb = new StringBuilder(titre);
        strb.append(System.lineSeparator());
        strb.append("<html><table border=1>");

        int debut = 0;

        if (entete) {
            debut = 1;

            strb.append("<thead><tr>");
            for (String chaine : tableauStr[0]) {
                strb.append(String.format("<th color=red align=\"center\">%s</th>", chaine));
            }
            strb.append("</tr></thead>");
        }
        strb.append("<tbody>");
        for (int ligne = debut; ligne < tableauStr.length; ligne++) {
            strb.append("<tr>");
            for (int colonne = 0; colonne < tableauStr[ligne].length; colonne++) {
                strb.append(String.format("<td>%s</td>", tableauStr[ligne][colonne]));
            }
            strb.append("</tr>");
        }
        strb.append("</tbody></table></html>");

        afficherChaine(strb.toString());
    }
}
