package view.references;

public final class C_VIEW {
    /**
     * Options du menu de l'application.
     */
    public static final String[] MENU = {
        "Lister les patients",
        "Créer un nouveau patient",
        "Modifier un patient",
        "Supprimer un patient",
        "Ajouter un repas à un patient"
    };
    public static final String CONTINUER_SELECTION_REPAS = "Voulez-vous ajouter un repas ?";

    public static final String MSG_ACTUEL = "actuel : %s";
    public static final String MSG_MODIF_QUESTION = "Voulez-vous modifier ?";
    public static final String MSG_SELECTIONNER_REGIME_ALIMENTAIRE = "Veuillez sélectionner un régime alimentaire :";
    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String SAISIR_DATE_ENTREE = "Veuillez saisir la date d'entrée : ";
    public static final String SAISIR_TYPE_MSG = "veuillez saisir le %s";
    public static final String CONTINUER_SELECTION_REGIME_ALIMENTAIRE = "Voulez-vous ajouter un régime alimentaire ?";
    public static final String ENTETE_REGIME_ALIMENTAIRE_EXISTANT = "\tListe des régimes alimentaires :";
    public static final String AUCUN_REGIME_ALIMENTAIRE = "Aucun régime alimentaire.";

    // CONSTANTS MENU
	public static final int LISTER_PATIENT = 0;
    public static final int CREER_PATIENT = 1;
    public static final int MODIFIER_PATIENT = 2;
    public static final int SUPPRIMER_PATIENT = 3;
    public static final int AJOUTER_REPAS_PATIENT = 4;
}
