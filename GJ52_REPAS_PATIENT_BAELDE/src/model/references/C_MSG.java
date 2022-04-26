/**
 *
 */
package model.references;

/**
 * @author christophe.cerqueira
 *
 */
public final class C_MSG {


    public static final String REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION = "Le régime alimentaire n'a pas été trouvé.";

    public static final String REPAS_DATE_EXCEPTION = "La date du repas est non valide.";
    public static final String REPAS_TYPE_REPAS_EXCEPTION = "Le type du repas est non valide.";
    public static final String REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
    public static final String REPAS_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";

    public static final String PATIENT_NUMSECU_EXCEPTION = "Le numéro de sécurité est non valide.";
    public static final String PATIENT_NUMSECU_LONGUEUR_EXCEPTION = "Le numéro de sécurité n'est pas de la bonne longueur.";
    public static final String PATIENT_NOM_EXCEPTION = "Le nom est non valide.";
    public static final String PATIENT_PRENOM_EXCEPTION = "Le prenom est non valide.";
    public static final String PATIENT_NOM_PRENOM_LONGUEUR_EXCEPTION = "Le nom ou le prénom est soit trop grand soit trop petit.";
    public static final String PATIENT_DATE_ENTREE_EXCEPTION = "La date d'entrée est non valide.";
    public static final String PATIENT_DATE_ENTREE_FUTUR_EXCEPTION = "La date d'entrée ne peut être postérieure à la date actuelle.";
    public static final String PATIENT_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
    public static final String PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le repas du patient est invalide.";

    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION = "Le repas ne correspond pas au régime alimentaire du patient.";


    public static final String MSG_PATIENT_NOM_EXCEPTION = "Le nom est non renseigné.";
    public static final String MSG_PATIENT_PRENOM_EXCEPTION = "Le prenom est non renseigné.";
    public static final String MSG_PATIENT_DATE_ENTREE_EXCEPTION = "La date est non renseignée.";
    public static final String MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION = "La date d'entrée ne peut être postérieure à la date actuelle.";

    public static final String MSG_PATIENT_CREATION = "Le patient %s %s a été créé.";
    public static final String MSG_PATIENT_SUPPRESSION = "Le patient %s %s a été supprimé.";
    public static final String MSG_PATIENT_MISE_A_JOUR = "Le patient %s %s a été mis à jour.";
    public static final String MSG_PATIENT_CREATION_EXCEPTION = "La sauvegarde du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_SUPPRESSION_EXCEPTION = "La suppression du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_MISE_A_JOUR_EXCEPTION = "La mise à jour du patient %s %s n'a pas pu être effectuée.";

    public static final String MSG_AUCUN_PATIENT = "Aucun patient disponible.";
    public static final String MSG_AUCUN_REPAS = "Aucun repas.";
    public static final Object CARACTERE_SEPARATEUR = "-------------------------------------------------------------------------------------------------\n";
    public static final String MSG_PATIENT_RECHERCHE_EXCEPTION = "Le patient n'a pas été trouvé.";

    /**
     *
     */
    private C_MSG() {
    }

}
