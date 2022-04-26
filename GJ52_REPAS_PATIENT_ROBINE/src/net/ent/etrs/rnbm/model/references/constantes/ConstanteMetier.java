package net.ent.etrs.rnbm.model.references.constantes;

public class ConstanteMetier {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */

    public static final int MIN_LENGTH_NOM = 3;
    public static final int MAX_LENGTH_NOM = 50;
    public static final int MIN_LENGTH_PRENOM = 3;
    public static final int MAX_LENGTH_PRENOM = 50;
    public static final int LENGTH_NUM_SECU = 9;
    public static final String PATTERN_DATE_ENTREE = "dd-MM-yyyy";



    public static final String[] MENU = {
            "-- Repas patient --",
            "Lister les patiens",
            "Créer un nouveau patient",
            "Modifier un nouveau patient",
            "Supprimer un patient",
            "Ajouter un repas à un patient",
            "Sortir"
    };
    public static final String MSG_FIN_PROGRAMME = "Merci et au revoir !";

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */

    private ConstanteMetier() {
    }


}
