package view.ihm;

public final class ConstantesIhm {
    public static final String MSG_ERR_TABMENU_VAUT_NULL = "ERR le tableau de chaînes vaut NULL";
    public static final String MSG_INVITE = "Votre choix ?" ;
    public static final String MSG_ERR_SAISIE_INCORRECT = "ERR: saisie incorrecte, recommencez svp !";
    public static final String MSG_ERR_CHOIX_INCORRECT = "ERR: choix incorrect";
    public static final String CHOIX_QUITTER = " Quitter";
    public static final String INVITE = "Votre choix ?";

    private ConstantesIhm(){}

    /**
     * En général un menu permet de faire un CRUD.
     */
    public final static String[] TABLO_STR_MENU={
            "---Le Menu de Loutres---",
            " Lister",
            " Créer",
            " Modifier",
            " Supprimer",
            " Quitter"
    };

    public final static int MENU1_CHX_MINI=0;
    public final static int MENU1_CHX_MAXI = TABLO_STR_MENU.length-2;

    public final static String INVITE_CHOIX=" votre choix ?";
    public final static String TITRE_MENU_DFLT="----Menu :";
    public static final String LIB_QUITTER_DFLT="Quitter";
}
