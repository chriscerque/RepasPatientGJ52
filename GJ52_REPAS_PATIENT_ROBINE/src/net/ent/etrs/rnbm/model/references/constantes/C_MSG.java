/**
 *
 */
package net.ent.etrs.rnbm.model.references.constantes;

/**
 * @author christophe.cerqueira
 *
 */
public final class C_MSG {


    public static final String REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION = "Le régime alimentaire n'a pas été trouvé.";
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le repas du patient est invalide.";
    public static final String REPAS_DATE_EXCEPTION = "La date du repas est non valide.";
    public static final String REPAS_DATE_EXCEPTION_NULL = "La date du repas n'est pas renseigné";
    public static final String REPAS_TYPE_REPAS_EXCEPTION = "Le type du repas est non valide.";
    public static final String REPAS_TYPE_REPAS_EXCEPTION_NULL = "Le type du repas n'est pas renseigné";
    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION = "Le repas ne correspond pas au régime alimentaire du patient.";
    public static final String MSG_PATIENT_NOM_EXCEPTION = "Le nom est non renseigné.";
    public static final String MSG_PATIENT_NOM_LENGTH_EXCEPTION = String.format("Le nom ne respecte pas la taille recommandée [%s et %s]",ConstanteMetier.MIN_LENGTH_NOM, ConstanteMetier.MAX_LENGTH_NOM);
    public static final String MSG_PATIENT_PRENOM_LENGTH_EXCEPTION = String.format("Le prenom ne respecte pas la taille recommandée [%s et %s]",ConstanteMetier.MIN_LENGTH_PRENOM,ConstanteMetier.MAX_LENGTH_PRENOM);





    //pattern
    public static final String MSG_PATIENT_PRENOM_EXCEPTION = "Le prenom est non renseigné.";
    public static final String MSG_PATIENT_DATE_ENTREE_EXCEPTION = "La date est non renseignée.";
    public static final String MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION = "La date de entree ne peut être postérieure à la date actuelle.";
    public static final String MSG_PATIENT_CREATION = "Le patient %s %s a été créé.";
    public static final String MSG_PATIENT_SUPPRESSION = "Le patient %s %s a été supprimé.";
    public static final String MSG_PATIENT_MISE_A_JOUR = "Le patient %s %s a été mis à jour.";
    public static final String MSG_PATIENT_NUMSECU_EXCEPTION = "Le numéro de sécurité social du patient est non renseigné";
    public static final String MSG_PATIENT_LENGTH_NUMSECU = String.format("La taille du numéro de sécurité social n'est pas réspecté [%s caractère]",ConstanteMetier.LENGTH_NUM_SECU);

    ////////////////////////
    //DAO
    //PATIENT
    public static final String MSG_PATIENT_CREATION_EXCEPTION = "La sauvegarde du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_SUPPRESSION_EXCEPTION = "La suppression du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_MISE_A_JOUR_EXCEPTION = "La mise à jour du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_DAO_PERSITANCE_PATIENT_NULL = "Dao : tentative de persistance d'un patient à null";
    public static final String MSG_DAO_PERSITANCE_PATIENT_EXISTANT = "Dao : tentative de création d'un patient déjà existant";
    public static final String MSG_DAO_SUPPRESSION_PATIENT_NULL = "Dao : tentative de suppression d'un patient à null";
    public static final String MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT = "Dao : tentative de suppression d'un patient inexistant";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_NULL = "Dao : tentative de modification d'un patient à null";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT = "Dao : tentative de modification d'un patient inexistant";
    public static final String MSG_DAO_PERSITANCE_PATIENT = "Dao : persistance d'un patient";
    public static final String MSG_DAO_SUPPRESSION_PATIENT = "Dao : suppression d'un patient";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT = "Dao : mise à jour d'un patient";
    //REPAS
    public static final String MSG_DAO_PERSITANCE_REPAS_EXISTANT = "Dao : tentative de création d'un repas déjà existant";
    public static final String MSG_DAO_SUPPRESSION_REPAS_INEXISTANT = "Dao : tentative de suppression d'un repas inexistant";
    public static final String MSG_DAO_SUPPRESSION_REPAS_NULL = "Dao : tentative de suppression d'un repas quit vaut null";
    public static final String MSG_DAO_PERSITANCE_REPAS_NULL = "Dao : tentative de persistance d'un repas à null";
    public static final String MSG_AUCUN_PATIENT = "Aucun patient disponible.";
    public static final String MSG_AUCUN_REPAS = "Aucun repas.";
    public static final Object CARACTERE_SEPARATEUR = "-------------------------------------------------------------------------------------------------\n";
    public static final String MSG_PATIENT_RECHERCHE_EXCEPTION = "Le patient n'a pas été trouvé.";
    public static final String MSG_DAO_REPAS_EXCEPTION_NULL = "Le repas vaut null";
    public static final String MSG_SAISIE_NUM_SECU = "Veuillez saisir le numémro de sécurité social :";
    public static final String MSG_SAISIE_NOM = "Veuillez saisir le nom :";
    public static final String MSG_SAISIE_PRENOM = "Veuillez saisir le prénom :";
    public static final String MSG_SAISIE_DATE_ENTREE = String.format("Veuillez saisir la date d'entrée  au format %s:",ConstanteMetier.PATTERN_DATE_ENTREE);
    public static final String MSG_SAISIE_REGIME_ALIMENTAIRE = "Veuillez sélectionner un régime alimentaire :";


    /**
     *
     */
    private C_MSG() {
    }

}
