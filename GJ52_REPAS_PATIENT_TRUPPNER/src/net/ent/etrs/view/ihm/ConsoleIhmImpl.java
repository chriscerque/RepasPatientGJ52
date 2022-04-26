package net.ent.etrs.view.ihm;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {

    @Override
    public String saisirChaine(String invite) {
        String str = null;
        boolean ok = false;
        //0 afficher le message
        afficherChaine(invite, true);
        //1 saisir la chaine demandée
        do {
            str = this.getScan().nextLine();
            if (str.isEmpty()) {
                afficherErreur(">>Saisie vide");
            } else {
                ok = true;
            }
        } while (!ok);
        return str;
    }

    @Override
    public int saisirEntier(String msg, int min, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;
        do {
            //0) afficher message
            //TODO SUPP afficherChaine(msg + " ds [" + min + ":" + (max) + "[  ?", false);(msg);
            afficherChaine(msg);
            //1 faire saisir entier
            //saisie = scan.nextInt(); //1ere solution mais pbm InputMismatchException
            strSaisie = this.getScan().nextLine();
            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min:max[
                if (saisie >= min && saisie <= max) {
                    ok = true;
                } else {
                    //2.a si pbm => afficher msg erreur + resaisir
                    afficherChaine("ERR: entier saisi hors intervalle demandé [" + min + ":" + max + "[", true);
                }
            } catch (InputMismatchException | NumberFormatException ex) {
                afficherChaine("ERR: erreur de type de donnée saisi", true);
            }
        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public double saisirDouble(String msg, double min, double max) {
        double saisie = -1;
        boolean ok = false;
        do {
            afficherChaine(msg);
            String strSaisie = this.getScan().nextLine();
            try {
                saisie = Double.parseDouble(strSaisie);
                if (saisie < min || saisie > max) {
                    afficherChaine("ERR: erreur nombre incorrect, ds [" + min + ":" + max + "]", true);
                } else {
                    ok = true;
                }
            } catch (InputMismatchException | NumberFormatException ex) {
                afficherChaine("ERR: erreur de type de donnée saisi", true);
            }
        } while (!ok);
        return saisie;
    }

    @Override
    public void afficherChaine(String msg, boolean sautLigne) {
        if (sautLigne) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

    @Override
    public void afficherChaine(String msg) {
        afficherChaine(msg, true);
    }

    private int[] rechercherMaxDsColonne(String[][] tab2) {
        int[] tablow = new int[tab2.length];
        int idxColonne = 0;
        int c = 0;
        for (c = 0; c < tab2[0].length; c++) {
            int l = 0;
            int max = 0;
            for (l = 0; l < tab2.length; l++) {
                if (tab2[l][c].length() >= max) {
                    max = tab2[l][c].length();
                }
            }
            //Traitement tablo 1 colonne
            tablow[idxColonne] = max;
            idxColonne++;
        }

        return tablow;
    }

    public int getLargeurTotale(int[] tabloLg, boolean withNoLine) {
        int total = 0;
        for (int i = 0; i < tabloLg.length; i++) {
            total += tabloLg[i];
        }
        if (withNoLine) {
            total += 2;
        }

        return total;
    }

    public static final int NB_CAR = 2;

    private String creerLigne(int lg, int lgEntete) {
        StringBuilder strb = new StringBuilder();

        String str = "";
        while (str.length() < (lg + (NB_CAR * lgEntete))) {
            str += "-";
        }
        strb.append(str);
        return strb.toString();
    }

    private String creerLigne2(int totalLongueurs, int nbColonne, boolean withNoLine) {
        StringBuilder strb = new StringBuilder();
        int maxi = totalLongueurs + (nbColonne * 3);
        if (withNoLine) {
            maxi += 3;
        }
        maxi += 1; //Pour le dernier !
        while (strb.length() < maxi) {
            strb.append("-");
        }
        strb.append(System.lineSeparator());
        return strb.toString();
    }

    private int[] rechercherMaxLargeur(String[] tabEntetes, String[][] tabDonnees) {
        int dimEntetes = tabEntetes.length;

        String[][] tabDonnes2 = new String[tabDonnees.length + 1][tabDonnees[0].length];
        //recopie des donnees
        int l = 0;
        for (l = 0; l < tabDonnees.length; l++) {
            for (int c = 0; c < tabDonnees[l].length; c++) {
                if (Objects.nonNull(tabDonnees[l][c])) {
                    tabDonnes2[l][c] = tabDonnees[l][c];
                } else {
                    tabDonnes2[l][c] = "@";
                }
            }
        }

        //ajout des entetes
        for (int i = 0; i < tabEntetes.length; i++) {
            tabDonnes2[l][i] = tabEntetes[i];
        }

        //rechecrhe du max
        int[] tabloMax = rechercherMaxDsColonne(tabDonnes2);

        return tabloMax;

    }

    private void afficher(String[][] tablo) {

        System.out.println("contenu tableau");
        for (int l = 0; l < tablo.length; l++) {
            for (int c = 0; c < tablo[l].length; c++) {
                if (Objects.nonNull(tablo[l][c])) {
                    System.out.println(String.format("y:%02d x=%02d valeur=%S, lg=%02d",
                            l, c, tablo[l][c], tablo[l][c].length()));
                }
            }
        }
    }

    private String creerEntetes(String[] tabEntetes, TypeAlignement[] tabTa, int[] tabLargeursMax, int lgTot, boolean withNoLine) {
        StringBuffer strb = new StringBuffer();
        strb.append(creerLigne2(lgTot, tabEntetes.length, withNoLine));

        //entêtes
        if (withNoLine) {
            strb.append("! no ");
        }

        for (int e = 0; e < tabEntetes.length; e++) {
            strb.append(OutilsIhm.alignerTexte(tabTa[e], tabEntetes[e], tabLargeursMax[e]));
        }
        strb.append("!");
        strb.append(System.lineSeparator());
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
        //le titre
        StringBuilder strb = new StringBuilder();
        strb.append("\n" + (Objects.isNull(titre) ? "Contenu" : titre)).append(System.lineSeparator());

        //autres
        int[] tabLargeursMax = rechercherMaxLargeur(tabEntetes, tablo2);
        int largeurTotale = getLargeurTotale(tabLargeursMax, withNoLine);

        strb.append(creerEntetes(tabEntetes, tabTa, tabLargeursMax, largeurTotale, withNoLine));

        //Données
        strb.append(creerLigne2(largeurTotale, tabEntetes.length, withNoLine));

        for (int y = 0; y < tablo2.length; y++) {
            if (Objects.nonNull(tablo2[y])) {
                if (withNoLine && Objects.nonNull(tablo2[y][0])) {
                    strb.append(String.format("! %02d ", y));
                }
                if (Objects.nonNull(tablo2[y][0])) {
                    for (int x = 0; x < tablo2[0].length; x++) {

                        strb.append(OutilsIhm.alignerTexte(tabTa[x], tablo2[y][x], tabLargeursMax[x]));
                    }
                    strb.append("!");
                    strb.append(System.lineSeparator());
                }
            }
        }

        strb.append(creerLigne2(largeurTotale, tabEntetes.length, withNoLine));


        afficherChaine(strb.toString(), true);
    }

    @Override
    public void afficherErreur(String msg) {
        System.err.println(msg);
    }


    @Override
    public char saisirChoixMenuChar(String invite, char[] tabChoix) {
        char saisi = ' ';
        boolean trouve = false;
        int idx = 0;
        do {
            afficherChaine(invite);
            String strSaisie = this.getScan().nextLine().toUpperCase();
            saisi = strSaisie.charAt(0);
            if (!OutilsIhm.isCharInTableau(saisi, tabChoix)) {
                afficherErreur("ERR: le caractère saisi ne fait pas partie des choix autorisés");
            } else {
                trouve = true;
            }

        } while (!trouve && idx < tabChoix.length);
        return saisi;
    }

    @Override
    public int saisirChoixMenuInt(String invite, int[] tabChoix) throws Exception {
        int saisi = -1;
        boolean trouve = false;
        int idx = 0;
        do {
            afficherChaine(invite);
            saisi = this.getScan().nextInt();
            if (!OutilsIhm.isIntInTableau(saisi, tabChoix)) {
                afficherErreur("ERR: l'entier saisi ne fait pas partie des choix autorisés");
            } else {
                trouve = true;
            }
            idx++;

        } while (!trouve && idx < tabChoix.length);
        return saisi;
    }

    /**
     * Méthode chargée de fournir un nouvel objet.
     *
     * @return Scanner: java.util.Scanner
     */
    private Scanner getScan() {
        return new Scanner(System.in);
    }
}
