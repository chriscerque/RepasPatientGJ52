package net.ent.etrs.view.ihm.menus;

//import ent.etrs.pndg.ihm.Ihm;
//import ent.etrs.pndg.ihm.OutilsIhm;

import net.ent.etrs.view.ihm.Ihm;
import net.ent.etrs.view.ihm.OutilsIhm;

public class MenuInt extends AbstractMenu {
    private static final String FORMAT_LIGNE_MENU_INT = "%d) %-20s";
    private static final String FORMAT_INVITE_DFLT = " Votre choix ? ds [%s] ";
    public static final int CHX_INT_SORTIE_DFLT = 0;

    private int[] lesChoix;

    public MenuInt(String titre, Object[] lesLibs) throws Exception {
        super(titre, lesLibs);

        initialiserLesChoix(lesLibs.length);

        if (lesLibs.length != lesChoix.length) {
            throw new Exception("ERR: le tableau des Libellés ne correspond pas au tableau des choix");
        }
    }

    private void initialiserLesChoix(int choixMax) throws Exception {
        if (choixMax < 2) {
            throw new Exception("ERR: nb choix insufisant (<2) ?");
        }
        lesChoix = new int[choixMax];
        for (int c = 0; c < choixMax; c++) {
            lesChoix[c] = c + 1;
        }
    }

    public String getStrMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append(titre);

        //MEP des lignes de choix
        for (int i = 0; i < lesLibelles.length; i++) {
            sb.append(System.lineSeparator());
            sb.append(String.format(FORMAT_LIGNE_MENU_INT,
                    lesChoix[i],
                    lesLibelles[i]));
        }
        //choix de sortie
        sb.append(System.lineSeparator());
        sb.append(String.format(FORMAT_LIGNE_MENU_INT,
                CHX_INT_SORTIE_DFLT,
                LIB_QUITTER_DFLT));

        //invite de saisie
        sb.append(System.lineSeparator());
        sb.append(String.format(FORMAT_INVITE_DFLT, getStrLesChoixInt()));

        return sb.toString();

    }

    private String getStrLesChoixInt() {
        StringBuilder sb = new StringBuilder();
        sb.append(CHX_INT_SORTIE_DFLT).append(" ");
        for (int i = 0; i < lesChoix.length; i++) {
            sb.append(lesChoix[i]).append(" ");
        }
        return sb.toString();
    }

    private int[] getIntLesChoixInt() {
        int[] tab2 = new int[lesChoix.length + 1];
        tab2[0] = CHX_INT_SORTIE_DFLT;

        for (int i = 0; i < lesChoix.length; i++) {
            tab2[i + 1] = lesChoix[i];
        }
        return tab2;
    }

    /**
     * Méthode chargée de réaliser la saisie d'un choix.
     *
     * @param vue: Ihm
     * @return int: le choix saisi
     * @throws Exception sera levée en cas de PBM sur saisirEntier()
     */
    public int saisirChoixEntierMenu(Ihm vue) throws Exception {
        int chx = -1;
        boolean entierOk = false;
        do {
            String strMenu = getStrMenu();
            chx = vue.saisirEntier(strMenu, CHX_INT_SORTIE_DFLT, lesChoix.length);

            if (!OutilsIhm.isIntInTableau(chx, getIntLesChoixInt())) {
                vue.afficherErreur("ERR: le choix n'est pas autorisé !");
            } else {
                entierOk = true;
            }
        } while (!entierOk);
        return chx;
    }

    @Override
    public char getCharFromIntChoix(int chx) {
        return (char) chx;
    }


}
