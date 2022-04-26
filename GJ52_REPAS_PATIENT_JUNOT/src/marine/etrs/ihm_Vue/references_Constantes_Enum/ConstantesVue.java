package marine.etrs.ihm_Vue.references_Constantes_Enum;

public final class ConstantesVue {

    public static final String[] MENU = {
            "Afficher la liste des articles",
            "Afficher la liste des commandes",
            "Créer un article",
            "Créer une commande"
    };
    public static final String[] MENU_OUI_NON = {"Oui", "Non"};
    public static final String[] MENU_AJOUTER_RETIRER = {"Ajouter", "Retirer"};
    public static final String SYMBOLE_MONETAIRE = "€";
    public static final String FORMAT_DETAIL_ARTICLE = "%-15s : %-40s %5.2f%s";
    public static final String FORMAT_DETAIL_COMMANDE = "Commande du %-25s : total = %5.2f%s";
    public static final String FORMAT_DETAIL_LIGNE_COMMANDE = "%02d X %-40s : %5.2f%s";
    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String CREATION_ARTICLE_DEJA_EXISTANT = "Le article existe déjà .";
    //constantes pour l'affichage des demandes de saisies de articles
    public static final String SAISIR_NOM_ARTICLE = "Saisir le nom du article : ";
    public static final String SAISIR_DESCRIPTION_ARTICLE = "Saisir la description du article :";
    public static final String SAISIR_PRIX_ARTICLE = "Saisir le prix :";
    public static final String SELECTIONNER_TYPE_ARTICLE = "Sélectionner le type de article :";
    public static final String SELECTIONNER_AUTRE_ARTICLE = "Souhaitez-vous sélectionner un autre article ?";
    public static final String SAISIR_QUANTITE_AJOUT_ARTICLE = "Saisir la quantité souhaitée :";
    public static final String MODIFIER_CONSO = "Souhaitez-vous modifier votre commande ?";
    public static final String SAISIR_QUANTITE_RETRAIT = "Saisir la quantité souhaitée à  retirer :";
    public static final String DELIMITEUR = "//////////////////////////////////////////////////////";
    public static final String AJOUTER_ARTICLE_IMPOSSIBLE = "L'article n'a pu être ajouté.";


    private ConstantesVue() {
    }


}
