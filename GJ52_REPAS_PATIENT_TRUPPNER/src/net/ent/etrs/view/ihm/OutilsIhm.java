package net.ent.etrs.view.ihm;


public final class OutilsIhm {
    private OutilsIhm() {
    }
    //---------------------------------------MENUS

    /**
     * Méthode chargée de créer un menu sous la forme d'une chaîne.
     * Ajoute le choix 0] Quitter et l'invite de saisie
     *
     * @param strMenu:         String, le titre
     * @param tabloDesOptions: Object[], les options du menu (choix)
     * @return String
     */
    public static String construireMenu(String strMenu, Object[] tabloDesOptions) {
        StringBuilder strbMenu = new StringBuilder();

        strbMenu.append(strMenu);
        strbMenu.append(System.lineSeparator());

        for (int i = 0; i < tabloDesOptions.length; i++) {
            strbMenu.append(String.format("%n %d %s", (i + 1), tabloDesOptions[i].toString()));
        }
        //MEP du choix QUITTER
        strbMenu.append(String.format("%n  %d] Quitter", 0, ConstantesIhm.CHOIX_QUITTER));
        strbMenu.append(System.lineSeparator());
        //MEP de l'invite de saisie
        strbMenu.append(String.format("%n %s", ConstantesIhm.INVITE));

        return strbMenu.toString();
    }

    /**
     * Méthode chargée transformer un tableau d'options en tableau de chaine.
     * Particulièrement bien adapté pour les Enum !
     *
     * @param tabloOptions: Object[]
     * @return String[]
     */
    public static String[] getStringTabloFrom(Object[] tabloOptions) {
        String[] tab = new String[tabloOptions.length];
        for (int i = 0; i < tabloOptions.length; i++) {
            Object obj = tabloOptions[i];
            tab[i] = obj.toString();
        }
        return tab;
    }


    //--------------formattage de chaine

    /**
     * Méthode permettant de centrer un texte sur une longeur donnée avec un carcatère donné.
     *
     * @param s:String
     * @param size:int, lg de chaîne attendu
     * @param pad:      char, caractère de remplissage
     * @return String
     */
    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size + 2);

        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }

    /**
     * Méthode permettant d'appliquer un type d'alignement sur une chaîne.
     *
     * @param ta:TypeAlignement
     * @param str:String
     * @param lgm:              int
     * @return String
     */
    public static String alignerTexte(TypeAlignement ta, String str, int lgm) {
        String strw = null;
        switch (ta) {
            case CENTER:
                strw = center(str, lgm, '.');
                strw = "! " + strw + " ";
                break;
            case RIGHT:
                String modele = "! %" + lgm + "s ";
                strw = String.format(modele, str);
                break;
            case LEFT:
                String modele2 = "! %-" + lgm + "s ";

                strw = String.format(modele2, str);
                break;
            case JUSTIFY:
                strw = str;
//                while(strw.length()<lgm){
//                    strw=".";
//                }
                strw += ".".repeat(lgm - 1);

                break;
        }

        return strw;
    }

    public static boolean isCharInTableau(char c, char[] tablo) {
        boolean trouve = false;
        int idx = 0;
        do {
            if (c == tablo[idx]) {
                trouve = true;
            } else {
                idx++;
            }
        } while (!trouve && idx < tablo.length);
        return trouve;
    }

    public static boolean isIntInTableau(int c, int[] tablo) {
        boolean trouve = false;
        int idx = 0;
        do {
            if (c == tablo[idx]) {
                trouve = true;
            } else {
                idx++;
            }
        } while (!trouve && idx < tablo.length);
        return trouve;
    }

}
