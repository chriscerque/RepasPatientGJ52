package net.ent.etrs.view.ihm;


import javax.swing.*;
import java.util.Objects;

public class JPanelIhmImpl implements Ihm {

    @Override
    public String saisirChaine(String invite) {
        String strSaisie = JOptionPane.showInputDialog(null, invite);
        return strSaisie;
    }


    @Override
    public int saisirEntier(String msg, int min, int max) {
        int sai = -1;
        do {
            String strSaisie = JOptionPane.showInputDialog(msg);
            try {
                sai = Integer.parseInt(strSaisie);
                if (sai < min || sai > max) {
                    sai = -1;
                    afficherChaine(ConstantesIhm.MSG_ERR_CHOIX_INCORRECT, true);
                }
            } catch (Exception ex) {
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECT, true);
            }
        } while (sai == -1);
        return sai;
    }

    @Override
    public double saisirDouble(String msg, double min, double max) {
        double sai = -1;
        boolean ok = false;
        do {
            String strSaisie = JOptionPane.showInputDialog(msg);
            try {
                sai = Double.parseDouble(strSaisie);
                if (sai < min || sai > max) {
                    afficherChaine(ConstantesIhm.MSG_ERR_CHOIX_INCORRECT, true);
                } else {
                    ok = true;
                }
            } catch (Exception ex) {
                afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECT, true);
            }
        } while (!ok);
        return sai;
    }


    @Override
    public void afficherChaine(String msg, boolean sautLigne) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void afficherChaine(String msg) {
        afficherChaine(msg, true);
    }

    /**
     * Méthode chargée de créer la ligne des entêtes de colonne.
     *
     * @param tabEntetes:String[]
     * @param withNoLine:         boolean, avec un no de ligne
     * @return String
     */
    private String creerEntetes(String[] tabEntetes, boolean withNoLine) {
        //MEP entetes

        StringBuilder strb = new StringBuilder("<tr>");
        if (withNoLine) {
            strb.append("<th style='background-color:gray; color:white'><i>.no.</i></th>");
        }

        for (int i = 0; i < tabEntetes.length; i++) {
            strb.append("<th style='background-color:gray; color:white'><i>").append(tabEntetes[i]).append("</i></th>");
        }
        strb.append("</tr>");

        return strb.toString();
    }

    private String[][] ajusterDonnes(String[] tabEnt, String[][] tDonnees) {
        String[][] tabNewDonnees = new String[tDonnees.length][tabEnt.length];
        for (int l = 0; l < tDonnees.length; l++) {
            int c = 0;
            //recopie des données
            for (c = 0; c < tDonnees[l].length; c++) {
                tabNewDonnees[l][c] = tDonnees[l][c];
            }
            while (c < tabEnt.length) {
                tabNewDonnees[l][c] = "@NO_DATA";
                c++;
            }
        }
        return tabNewDonnees;
    }

    @Override
    public void afficherTableau(String titre, String[] tabEntetes, String[][] tablo, TypeAlignement[] tabTa, boolean withNoLine) throws Exception {
        if (tabEntetes.length < tablo[0].length) {
            throw new Exception("ERR: le tableau des Entêtes est plus petit que le nmobre de colonne du tableau des données");
        }
        String[][] tablo2 = ajusterDonnes(tabEntetes, tablo);

        StringBuilder strb = new StringBuilder("<html>");
        strb.append("<h2>" + titre + "</h2>");
        strb.append("<table border='1'>");

        //MEP entetes
        strb.append(creerEntetes(tabEntetes, withNoLine));

        //les données
        for (int l = 0; l < tablo2.length; l++) {
            if (Objects.nonNull(tablo2[l][0])) {
                strb.append("<tr>");
                if (withNoLine) {
                    strb.append("<td>").append(String.format("%02d", l)).append("</td>");
                }

                for (int c = 0; c < tablo[l].length; c++) {
                    strb.append("<td align='" + (tabTa[c].name().toLowerCase() + "'>")).append(tablo2[l][c]).append("</td>");
                }
                strb.append("</tr>");

            }
        }
        strb.append("</table></html>");

        afficherChaine(strb.toString(), true);
    }

    @Override
    public void afficherErreur(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public char saisirChoixMenuChar(String invite, char[] tabChoix) {
        char saisi = ' ';
        boolean trouve = false;
        int idx = 0;
        do {
            String strSaisie = saisirChaine(invite);
            saisi = strSaisie.charAt(0);
            if (!OutilsIhm.isCharInTableau(saisi, tabChoix)) {
                afficherErreur("ERR: le caractère saisi ne fait pas partie des choix autorisés");
            } else {
                trouve = true;
            }
            idx++;
        } while (!trouve && idx < tabChoix.length);
        return saisi;
    }

    @Override
    public int saisirChoixMenuInt(String invite, int[] tabChoix) throws Exception {
        int saisi = -1;
        boolean trouve = false;
        int idx = 0;
        do {
            saisi = saisirEntier(invite, 0, 9999);
            if (!OutilsIhm.isIntInTableau(saisi, tabChoix)) {
                afficherErreur("ERR: l'entier saisi ne fait pas partie des choix autorisés");
            }

        } while (!trouve && idx < tabChoix.length);
        return saisi;
    }

}
