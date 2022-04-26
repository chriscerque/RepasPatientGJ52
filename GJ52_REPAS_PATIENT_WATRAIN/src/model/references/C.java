package model.references;

import model.entities.Patient;

/**
 * Les constantes de l'application
 */
public final class C {

	// ENTITIES
	public static final String REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION = "Le régime alimentaire n'a pas été trouvé.";
	public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le repas du patient est invalide.";
	public static final String REPAS_DATE_EXCEPTION = "La date du repas est non valide.";
	public static final String REPAS_TYPE_REPAS_EXCEPTION = "Le type du repas est non valide.";
	public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
	public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";
	public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION = "Le repas ne correspond pas au régime alimentaire du patient.";
	public static final String MSG_PATIENT_NOM_EXCEPTION = "Le nom est non renseigné.";
	public static final String MSG_PATIENT_ID_NULL = "L'id du patient est null.";

	//pattern
	public static final String MSG_PATIENT_PRENOM_EXCEPTION = "Le prénom est non renseigné.";

	public static final String MSG_PATIENT_PRENOM_LENGTH_EXCEPTION = "Le prénom et le nom doivent faire entre " + C.PRENOM_MIN_LENGTH + " et " + C.PRENOM_MAX_LENGTH + " caractères.";
	public static final String MSG_PATIENT_DATE_ENTREE_EXCEPTION = "La date est non renseignée.";
	public static final String MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION = "La date de naissance ne peut être postérieure à la date actuelle.";
	public static final String MSG_PATIENT_NUM_SECU_INVALID = "Le numéro de sécurité sociale est invalide.";
	public static final String MSG_PATIENT_CREATION = "Le patient %s %s a été créé.";
	public static final String MSG_PATIENT_SUPPRESSION = "Le patient %s %s a été supprimé.";
	public static final String MSG_PATIENT_MISE_A_JOUR = "Le patient %s %s a été mis à jour.";
	////////////////////////
	//DAO
	//PATIENT
	public static final String MSG_PATIENT_CREATION_EXCEPTION = "La sauvegarde du patient %s %s n'a pas pu être effectuée.";
	public static final String MSG_PATIENT_SUPPRESSION_EXCEPTION = "La suppression du patient %s %s n'a pas pu être effectuée.";
	public static final String MSG_PATIENT_MISE_A_JOUR_EXCEPTION = "La mise à jour du patient %s %s n'a pas pu être effectuée.";
	public static final String MSG_DAO_PERSISTANCE_PATIENT_NULL = "Dao : tentative de persistance d'un patient à null";
	public static final String MSG_DAO_PERSISTANCE_PATIENT_EXISTANT = "Dao : tentative de création d'un patient déjà existant";
	public static final String MSG_DAO_SUPPRESSION_PATIENT_NULL = "Dao : tentative de suppression d'un patient à null";
	public static final String MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT = "Dao : tentative de suppression d'un patient inexistant";
	public static final String MSG_DAO_MISE_A_JOUR_PATIENT_NULL = "Dao : tentative de modification d'un patient à null";
	public static final String MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT = "Dao : tentative de modification d'un patient inexistant";
	public static final String MSG_DAO_PERSITANCE_PATIENT = "Dao : persistance d'un patient";
	public static final String MSG_DAO_SUPPRESSION_PATIENT = "Dao : suppression d'un patient";
	public static final String MSG_DAO_MISE_A_JOUR_PATIENT = "Dao : mise à jour d'un patient";
	//REPAS
	public static final String MSG_DAO_PERSISTANCE_REPAS_EXISTANT = "Dao : tentative de création d'un repas déjà existant";
	public static final String MSG_DAO_SUPPRESSION_REPAS_INEXISTANT = "Dao : tentative de suppression d'un repas inexistant";
	public static final String MSG_DAO_PERSISTANCE_REPAS_NULL = "Dao : tentative de persistance d'un repas à null";
	public static final String MSG_AUCUN_PATIENT = "Aucun patient disponible.";
	public static final String MSG_AUCUN_REPAS = "Aucun repas.";
	public static final Object CARACTERE_SEPARATEUR = "-------------------------------------------------------------------------------------------------\n";
	public static final String MSG_PATIENT_RECHERCHE_EXCEPTION = "Le patient n'a pas été trouvé.";

	// DAO
	public static final String DAO_EXIST_EXCEPTION = "L'objet existe déjà";
	public static final String DAO_EXIST_PAS_EXCEPTION = "L'objet n'existe pas";

	public static final int NUM_SECU_LENGTH = 9;
	public static final int PRENOM_MIN_LENGTH = 3;
	public static final int PRENOM_MAX_LENGTH = 50;


	private C() {
	}
}
