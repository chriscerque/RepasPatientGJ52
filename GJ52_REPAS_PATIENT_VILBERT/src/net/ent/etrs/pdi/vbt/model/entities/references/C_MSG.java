package net.ent.etrs.pdi.vbt.model.entities.references;

public final class C_MSG {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private C_MSG() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    CONSTANTES			                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public static final String TITRE_MENU_PRINCIPAL = "Repas patient";
    public static final String[] MENU_PRINCIPAL = {
            "Lister les patients",
            "Créer un nouveau patient",
            "Modifier un patient",
            "Supprimer un patient",
            "Ajouter un repas à un patient"
    };
    public static final String CHOIX = "CHOIX : ";

    public static final int PATIENT_NOM_TAILLE_MINIMUM = 3;
    public static final int PATIENT_NOM_TAILLE_MAXIMUM = 50;
    public static final int PATIENT_NUMSECU_TAILLE = 5;

    public static final String SAISIR_NUMSECU = "Veuillez saisir le numéro de sécurité : ";
    public static final String SAISIR_NOM = "Veuillez saisir le nom : ";
    public static final String SAISIR_PRENOM = "Veuillez saisir le prénom : ";
    public static final String SAISIR_DATE_ENTREE = "Veuillez saisir la date d'entrée : ";
    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String SAISIR_REGIME_ALIMENTAIRE = "Veuillez sélectionner un régime alimentaire : ";
    public static final String AJOUTER_REGIME_ALIMENTAIRE = "Voulez-vous ajouter un régime alimentaire ? ";

    public static final String REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION = "Le régime alimentaire n'a pas été trouvé.";
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le repas du patient est invalide.";
    public static final String REPAS_DATE_EXCEPTION = "La date du repas est non valide.";
    public static final String REPAS_TYPE_REPAS_EXCEPTION = "Le type du repas est non valide.";
    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION = "Le repas ne correspond pas au régime alimentaire du patient.";
    public static final String MSG_PATIENT_NOM_EXCEPTION = "Le nom est non renseigné.";
    public static final String MSG_PATIENT_NOM_INVALIDE_EXCEPTION = "Le nom est invalide.";


    //pattern
    public static final String MSG_PATIENT_PRENOM_EXCEPTION = "Le prenom est invalide.";
    public static final String MSG_PATIENT_PRENOM_INVALIDE_EXCEPTION = "Le prenom est non renseigné.";
    public static final String MSG_PATIENT_NUMSECU_INVALIDE_EXCEPTION = "Le numéro de sécu est invalide.";
    public static final String MSG_PATIENT_NUMSECU_EXCEPTION = "Le numéro de sécu est non renseigné.";
    public static final String MSG_PATIENT_DATE_ENTREE_EXCEPTION = "La date est non renseignée.";
    public static final String MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION = "La date de naissance ne peut être postérieure à la date actuelle.";
    public static final String MSG_PATIENT_CREATION = "Le patient %s %s a été créé.";
    public static final String MSG_PATIENT_SUPPRESSION = "Le patient %s %s a été supprimé.";
    public static final String MSG_PATIENT_MISE_A_JOUR = "Le patient %s %s a été mis à jour.";
    ////////////////////////
    //DAO
    //PATIENT
    public static final String MSG_PATIENT_CREATION_EXCEPTION = "La sauvegarde du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_SUPPRESSION_EXCEPTION = "La suppression du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_MISE_A_JOUR_EXCEPTION = "La mise à jour du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_DAO_PERSITANCE_PATIENT_NULL = "Daot : tentative de persistance d'un patient à null";
    public static final String MSG_DAO_LECTURE_PATIENT_NULL = "Dao : tentative de lecture d'un patient à null";
    public static final String MSG_DAO_PERSITANCE_PATIENT_EXISTANT = "Dao : tentative de création d'un patient déjà existant";
    public static final String MSG_DAO_LECTURE_PATIENT_INEXISTANT = "Dao : tentative de lecture d'un patient inexistant";
    public static final String MSG_DAO_SUPPRESSION_PATIENT_NULL = "Dao : tentative de suppression d'un patient à null";
    public static final String MSG_DAO_SUPPRESSION_PATIENT_NUMSECU_NULL = "Dao : tentative de suppression d'un patient avec un numéro de sécu à null";

    public static final String MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT = "Dao : tentative de suppression d'un patient inexistant";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_NULL = "Dao : tentative de modification d'un patient à null";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT = "Dao : tentative de modification d'un patient inexistant";
    public static final String MSG_DAO_PERSITANCE_PATIENT = "Dao : persistance d'un patient";
    public static final String MSG_DAO_SUPPRESSION_PATIENT = "Dao : suppression d'un patient";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT = "Dao : mise à jour d'un patient";
    //REPAS
    public static final String MSG_DAO_PERSITANCE_REPAS_EXISTANT = "Dao : tentative de création d'un repas déjà existant";
    public static final String MSG_DAO_SUPPRESSION_REPAS_INEXISTANT = "Dao : tentative de suppression d'un repas inexistant";
    public static final String MSG_DAO_PERSITANCE_REPAS_NULL = "Dao : tentative de persistance d'un repas à null";
    public static final String MSG_DAO_SUPPRESSION_REPAS_NULL = "Dao : tentative de suppression d'un repas à null";
    public static final String MSG_DAO_LECTURE_REPAS_NULL = "Dao : tentative de lecture d'un repas à null";
    public static final String MSG_DAO_LECTURE_REPAS_INEXISTANT = "Dao : tentative de lecture d'un patient inexistant";
    public static final String MSG_DAO_MISE_A_JOUR_REPAS_NULL = "Dao : tentative de modification d'un repas à null";
    public static final String MSG_DAO_MISE_A_JOUR_REPAS_INEXISTANT = "Dao : tentative de modification d'un patient inexistant";
    public static final String MSG_DAO_SUPPRESSION_REPAS_ID_NULL = "Dao : tentative de suppression d'un repas avec un id à null";
    public static final String MSG_AUCUN_PATIENT = "Aucun patient disponible.";
    public static final String MSG_AUCUN_REPAS = "Aucun repas.";
    public static final Object CARACTERE_SEPARATEUR = "-------------------------------------------------------------------------------------------------\n";
    public static final String MSG_PATIENT_RECHERCHE_EXCEPTION = "Le patient n'a pas été trouvé.";
}
