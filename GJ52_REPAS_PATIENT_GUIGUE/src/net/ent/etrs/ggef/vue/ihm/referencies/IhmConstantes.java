package net.ent.etrs.ggef.vue.ihm.referencies;

public final class IhmConstantes {

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
        public static final String AUCUN_REGIME_ALIMENTAIRE = "Aucune régime alimentaire.";

    /**
     * Sert pour générer un menu à partir d'un tableau manuel.
     *
     * Utilisable depuis la classe JPanelIhmImpl avec la fonction :
     * public int saisirChoixMenu(String[] tabloStr, int min, int max)
     *
     * Utilisable depuis la classe ConsoleIhmImpl avec la fonction :
     * public int saisirChoixMenu(String[] tabloStr, int min, int max)
     *
     */

    public final static String[] TABLO_STR_MENU_PRINCIPAL =
            {
                    "---Menu principal---",
                    " Create",
                    " Read",
                    " Update",
                    " Delete",
                    " Quitter"
            };

    /**
     * CONSTANTE pour les Menus IHM sous forme String:
     *
     *
     */
    public static final String MSG_INVITE = "Votre choix ?";

    /**
     * création des 3 tableaux à afficher au format HTML en console ou panel.
     *
     * fonctionnement dans un lanceur :
     *
     * Ihm panel = FabriqueIhm.creerIhmPanel();
     * panel.afficherTableauEnHtml("Tableau des Z'humouristes",TABLO_HTML_ENTETES, TABLO_HTML_DONNEES,TABLO_HTML_ALIGNEMENT ,true);
     *
     * Ihm console = FabriqueIhm.creerIhmConsole();     *
     * console.afficherTableauEnHtml("Tableau des Z'humouristes",TABLO_HTML_ENTETES, TABLO_HTML_DONNEES,TABLO_HTML_ALIGNEMENT ,true);
     */
    // tableau1D contenant les en-têtes :
    public final static String[] TABLO_HTML_ENTETES =
            {
                    " Nom",
                    " Prénom"
            };
    // tableau2D de données :
    public final static String[][] TABLO_HTML_DONNEES =
            {
                    {"Beliveau","Marcel"},
                    {"Collucci","Michel"},
                    {"Bigard","Jean-Marie"},
                    {"Boon","Dany"},
                    {"Zumourist","Eric"}

            };
    // gère l'alignement de chaque colonne :
    public static final TypeAlignement[] TABLO_HTML_ALIGNEMENT =
            {
                    TypeAlignement.LEFT, // colonne1
                    TypeAlignement.LEFT // colonne2
            };







/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private IhmConstantes() { }

} // fin de classe
