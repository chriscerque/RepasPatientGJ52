package ent.etrs.pdi.blu.view.ihm.references;

public final class ConstantesIhm {
    /*------- CONSTRUCTEUR(S) -------*/
    private ConstantesIhm(){}

    /*------- GENERIQUE -------*/
    public static final int MENU_BORNES_MIN = 0;

    /*------- BOOLEAN -------*/
    public static final String MENU_BOOLEAN_OUI = "1 - Oui";
    public static final String MENU_BOOLEAN_NON = "2 - Non";
    public static final int MENU_BOOLEAN_BORNES_MAX = 2;

    /*------- MESSAGE ERREURS -------*/
    public static final String MSG_ERR_SAISIE_INCORRECTE = "ERR : Saisie incorrecte.";
    public static final String MSG_ERR_SAISIE_BORNES = "ERR: Entier saisi hors intervalle demandé.";

    /*------- MESSAGE UTILISATEUR -------*/
    public static final String MSG_CHX_MENU = "Votre choix ?";


     // En général un menu permet de faire un CRUD.

    public static final String[] MENU_CHOIX = {
            "nom du menu",
            "Afficher .................",
            "Créer ....................",
            "Modifier .................",
            "quitter"
    };


    public static final String MSG_ERR_TABMENU_VAUT_NULL = "ERR le tableau de chaînes vaut NULL";
    public static final String MSG_INVITE = "Votre choix ?" ;
    public static final String MSG_ERR_SAISIE_INCORRECT = "ERR: saisie incorrecte, recommencez svp !";
    public static final String MSG_ERR_CHOIX_INCORRECT = "ERR: choix incorrect";
    public static final String CHOIX_QUITTER = " Quitter";
    public static final String INVITE = "Votre choix ?";


    public final static int MENU1_CHX_MINI=0;
    public final static int MENU1_CHX_MAXI = MENU_CHOIX.length-2;
    public static final String DELIMITEUR = "//////////////////////////////////////////////////////";

    public final static String INVITE_CHOIX=" votre choix ?";
    public final static String TITRE_MENU_DFLT="*  *  *  MENU  *  *  *";
    public static final String LIB_QUITTER_DFLT="Quitter";
}
