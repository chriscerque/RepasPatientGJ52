package view.ihm.references;

public final class ConstanteIhm {
    private ConstanteIhm(){}

    public static final String MSG_ERR_TYPESAISIE_ENTIER = "Erreur : type de la saisie incorrecte. Veuillez saisir un entier !";
    public static final String MSG_ERR_SAISIR_ENTIER_MIN_FORMAT = "L'entier entre n'est pas compris dans l'intervalle [%d:+8[.";
    public static final String MSG_ERR_SAISIR_ENTIER_MIN_MAX_FORMAT = "L'entier entre n'est pas compris dans l'intervalle [%d:%d].";
    public static final String MSG_ERR_TYPESAISIE_DECIMAL = "Erreur : type de la saisie incorrecte. Veuillez saisir un decimal !";
    public static final String MSG_ERR_SAISIR_DECIMAL_MIN_FORMAT = "Le decimal entre n'est pas compris dans l'intervalle [%f:+8[.";
    public static final String MSG_ERR_SAISIR_DECIMAL_MIN_MAX_FORMAT = "Le decimal entre n'est pas compris dans l'intervalle [%f:%f].";

    public static final String MSG_DEMANDE_CHOIX_ENTIER_FORMAT_MIN_MAX = "Choix dans [%d:%d] : ";


    public final static String[] TAB_STR_MENU = {
            "Menu",
            "Lister",
            "Créer",
            "Modifier",
            "Supprimer"
    };


    public static final String MSG_ERR_RECUPERER_COLONNE_TABLEAUSTR_NULL = "ERREUR : Le tableau dont on veut recuperer la colonne vaut NULL.";
    public static final String MSG_ERR_SAISIRCHOIXMENU_LONGUEUR_TAB = "ERREUR : Le tableau du menu est trop petit.";
}
