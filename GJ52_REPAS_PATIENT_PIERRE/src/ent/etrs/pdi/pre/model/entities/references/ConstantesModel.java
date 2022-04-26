package ent.etrs.pdi.pre.model.entities.references;

import ent.etrs.pdi.pre.view.ihm.references.ConstantesIhm;

public final class ConstantesModel {
    /*------- CONSTRUCTEUR(S) -------*/
    private ConstantesModel(){}

    /*------- FACADE METIER EXCEPTION -------*/
    // Facade Métier
    public static final String MSG_PATIENT_MISE_A_JOUR_EXCEPTION = "La mise à jour du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_SUPPRESSION_EXCEPTION = "La suppression du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_PATIENT_CREATION_EXCEPTION = "La sauvegarde du patient %s %s n'a pas pu être effectuée.";
    public static final String MSG_AUCUN_PATIENT = "Aucun patient disponible.";

    public static final String MSG_AUCUN_REPAS = "Aucun repas.";
    public static final String MSG_REPAS_SUPPRESSION_EXCEPTION = "Une erreur est survenue lors de la suppression du repas.";
    public static final String MSG_REPAS_CREATION_EXCEPTION = "Une erreur est survenue lors de l'enregistrement du repas.";
    public static final String MSG_REPAS_MISE_A_JOUR_EXCEPTION = "Une erreur est survenue lors de la mise à jour des données du repas.";


    /*------- DAO EXCEPTION -------*/
    // DAO Patient
    // CREATE
    public static final String MSG_DAO_PERSITANCE_PATIENT_NULL= "Dao : tentative de persistance d'un patient à null";
    public static final String MSG_DAO_PERSITANCE_PATIENT_EXISTANT = "Dao : tentative de création d'un patient déjà existant";
    // DELETE
    public static final String MSG_DAO_SUPPRESSION_PATIENT_NULL = "Dao : tentative de suppression d'un patient à null";
    public static final String MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT = "Dao : tentative de suppression d'un patient inexistant";
    // MODIFICATION
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_NULL = "Dao : tentative de modification d'un patient à null";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT = "Dao : tentative de modification d'un patient inexistant";
    // EXIST

    // DAO Repas
    // CREATE
    public static final String MSG_DAO_PERSITANCE_REPAS_EXISTANT = "Dao : tentative de création d'un repas déjà existant";
    // DELETE
    public static final String MSG_DAO_SUPPRESSION_REPAS_INEXISTANT = "Dao : tentative de suppression d'un repas inexistant";
    // MODIFICATION
    public static final String MSG_DAO_UPDATE_REPAS_NULL = "Dao : tentative de modification de persistance d'un repas";
    // EXIST
    public static final String MSG_DAO_PERSITANCE_REPAS_NULL = "Dao : tentative de persistance d'un repas à null";


    /*------- MODEL EXCEPTION -------*/
    // ENTITIE Model
    // ID
    public static final String MSG_ID_NULL_EXCEPTION = "L'id doit être renseigné.";

    // ENTITIE Repas
    // DateRepas
    public static final String REPAS_DATE_EXCEPTION = "La date du repas est non valide.";
    // TypeRepas
    public static final String REPAS_TYPE_REPAS_EXCEPTION = "Le type du repas est non valide.";

    // ENTITIE Patient
    // Nom
    public static final String MSG_PATIENT_NOM_EXCEPTION = "Le nom est non renseigné.";
    public static final String MSG_PATIENT_NOM_INCORRECT_EXCEPTION = "Le numéro de sécu est incorrecte.";
    // Prenom
    public static final String MSG_PATIENT_PRENOM_EXCEPTION = "Le prenom est non renseigné.";
    public static final String MSG_PATIENT_PRENOM_INCORRECT_EXCEPTION = "Le numéro de sécu est incorrecte.";
    // NumSecu
    public static final String MSG_PATIENT_NUM_SECU_EXCEPTION = "Le numéro de sécu est non renseigné.";
    public static final String MSG_PATIENT_NUM_SECU_INCORRECT_EXCEPTION = "Le numéro de sécu est incorrecte.";
    //DateEntree
    public static final String MSG_PATIENT_DATE_ENTREE_EXCEPTION = "La date est non renseignée.";
    public static final String MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION = "La date de naissance ne peut être postérieure à la date actuelle.";
    // Controle
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION = "Le repas ne correspond pas au régime alimentaire du patient.";
    // Repas
    public static final String PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION = "Le repas du patient est invalide.";




    //////////////////////// NULL
    public static final String REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION = "Le régime alimentaire n'a pas été trouvé.";

    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION = "Le régime alimentaire est invalide.";
    public static final String MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION = "Le régime alimentaire existe déjà.";

    public static final String MSG_PATIENT_CREATION = "Le patient %s %s a été créé.";
    public static final String MSG_PATIENT_SUPPRESSION = "Le patient a été supprimé.";
    public static final String MSG_PATIENT_MISE_A_JOUR = "Le patient %s %s a été mis à jour.";



    public static final String MSG_DAO_PERSITANCE_PATIENT = "Dao : persistance d'un patient";
    public static final String MSG_DAO_SUPPRESSION_PATIENT = "Dao : suppression d'un patient";
    public static final String MSG_DAO_MISE_A_JOUR_PATIENT = "Dao : mise à jour d'un patient";
    public static final Object CARACTERE_SEPARATEUR = "-------------------------------------------------------------------------------------------------\n";
    public static final String MSG_PATIENT_RECHERCHE_EXCEPTION = "Le patient n'a pas été trouvé.";
}
