package net.ent.etrs.view.ihm.menus;

//import ent.etrs.pndg.ihm.Ihm;

import net.ent.etrs.view.ihm.Ihm;

import java.util.Objects;

public class MenuChar extends AbstractMenu {
    private static final String FORMAT_LIGNE_MENU_CHAR = "%c) %-20s";
    private static final String FORMAT_INVITE_DFLT = " Votre choix ? ds [%s] ";
    public static final char CHX_CHAR_SORTIE_DFLT = 'Q';
    public final static int CHX_INT_SORTIE_DFLT = 81;

    private char[] lesChoix;

    public MenuChar(String titre, Object[] lesLibs) throws Exception {
        super(titre, lesLibs);
        initialiserLesChoix(lesLibs.length);
    }

    private void initialiserLesChoix(int nbChoixMax) {
        char[] tablo = new char[nbChoixMax];
        for (int i = 0; i < nbChoixMax; i++) {
            tablo[i] = (char) (i + 65);
        }
        lesChoix = tablo;

    }

    private void setLesChoix(char[] lesChoix) throws Exception {
        if (Objects.isNull(lesChoix)) {
            throw new Exception("ERR: le tableau des choix vaut NULL");
        }
        this.lesChoix = lesChoix;
    }

    private String getStrLesChoixChar() {
        StringBuilder sb = new StringBuilder();
        sb.append(CHX_CHAR_SORTIE_DFLT).append(" ");

        for (int i = 0; i < lesChoix.length; i++) {
            sb.append(lesChoix[i]).append(" ");
        }
        return sb.toString();
    }

    private char[] getAllChoixCar() {
        char[] tab2 = new char[lesChoix.length + 1];
        tab2[0] = CHX_CHAR_SORTIE_DFLT;
        for (int i = 0; i < lesChoix.length; i++) {
            tab2[i + 1] = lesChoix[i];
        }
        return tab2;
    }

    @Override
    public String getStrMenu() {
        StringBuilder sb = new StringBuilder(titre);

        //MEP des lignes de choix
        for (int i = 0; i < lesLibelles.length; i++) {
            sb.append(System.lineSeparator());
            sb.append(String.format(FORMAT_LIGNE_MENU_CHAR,
                    lesChoix[i],
                    lesLibelles[i]));
        }
        //choix de sortie
        sb.append(System.lineSeparator());
        sb.append(String.format(FORMAT_LIGNE_MENU_CHAR,
                CHX_CHAR_SORTIE_DFLT,
                LIB_QUITTER_DFLT));

        //invite de saisie
        sb.append(System.lineSeparator());
        sb.append(String.format(FORMAT_INVITE_DFLT, getStrLesChoixChar()));

        return sb.toString();

    }

    @Override
    public int saisirChoixEntierMenu(Ihm vue) throws Exception {
        char c = saisirChoixCarMenu(vue);
        int result = (int) c;
        return result;
    }

    private char saisirChoixCarMenu(Ihm vue) throws Exception {
        String strMenu = getStrMenu();
        char chx = vue.saisirChoixMenuChar(strMenu, getAllChoixCar());
        return chx;
    }

    public char getCharChoixAt(int idx) throws Exception {
        if (idx < 0 || idx > lesChoix.length) {
            throw new Exception("ERR: indice incorrect");
        }
        char cAt = lesChoix[idx];

        return cAt;
    }

    public int getIntChoixAt(int idx) throws Exception {
        char[] getCharChoixAt;
        char cAt = getCharChoixAt(idx);

        return (int) cAt;
    }

    @Override
    public char getCharFromIntChoix(int ascii) {
        return (char) ascii;
    }
}
