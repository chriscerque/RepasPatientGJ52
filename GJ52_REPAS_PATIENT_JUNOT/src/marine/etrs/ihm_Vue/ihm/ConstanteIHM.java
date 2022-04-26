package marine.etrs.ihm_Vue.ihm;

public final class ConstanteIHM {


    public static final String SAISIR_NOM = "SAISIR NOM";
    public static final String SAISIR_NUM_SECU = "SAISI NUM SECU";
    public static final String SAISIR_PRENOM = "SAISIE UN PRENOM";
    public static final String SELECTIONNNER_PATIENT = "Veuillez selectionne un patient";

    private ConstanteIHM() {
    }

    /**
     * CREATION D'UN MENU VIA A TABLEAU DE STRING
     */
    public static final String[] TABLEAU_STR_MENU = {
            "/*------ MENU ------*/",
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
    public static final String AUCUN_REGIME_ALIMENTAIRE = "Aucune régime alimentaire.";

    /**
     * GESTION DES ERREURS VIA DES CONSTANSTES
     */
    public static final String MSG_ERR_TABLEAU_MENU_VAUT_NULL = "ERR null dans le tableau";
    public static final String MSG_INVITE = "votre choix";


    public final static int MENU1_CHX_MINI = 0;
    public final static int MENU1_CHX_MAXI = TABLEAU_STR_MENU.length-2;



}

