package net.ent.etrs.view.ihm.references;

public final class TableauxIhm {
    /////TABLEAUX/////
    /**
     * CONSTANTE TABLEAU contenant un menu.
     * ATTENTION:
     * 1ère ligne = titre du menu
     * Dernière ligne = choix QUITTER
     */
    public static final String[] TABLO_STR_MENU = {
            " Lister les patients ",
            " Créer un nouveau patient ",
            " Modifier un patient ",
            " Supprimer un patient ",
            " Ajouter un repas à un patient ",
    };

    public static final String TITRE_MENU_PRINCIPAL = "\n---------- Repas patient ----------";
    public static final String TITRE_AFF_REG_ALIM = "\n---------- Régimes alimentaires ----------";

    /////CONSTRUCTEUR/////
    private TableauxIhm() {}
}
