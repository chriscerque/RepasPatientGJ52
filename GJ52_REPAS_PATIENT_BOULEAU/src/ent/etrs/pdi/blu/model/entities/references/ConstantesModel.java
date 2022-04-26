package ent.etrs.pdi.blu.model.entities.references;

public final class ConstantesModel {
    /*------- CONSTRUCTEUR(S) -------*/
    private ConstantesModel(){}

    /*------- DAO EXCEPTION -------*/
    // DAO Model
    // CREATE
    public static final String DAO_MODEL_CREATION_EXCEPTION = "Une erreur est survenue lors de l'enregistrement du model.";
    public static final String DAO_MODEL_EXIST_EXCEPTION = "Le model existe déjà.";
    // DELETE
    public static final String DAO_MODEL_SUPPRESSION_EXCEPTION = "Une erreur est survenue lors de la suppression du model.";
    public static final String DAO_MODEL_EXIST_PAS_EXCEPTION = "Le model n'existe pas.";
    // MODIFICATION
    public static final String DAO_MODEL_MODIFICATION_EXCEPTION = "Une erreur est survenue lors de la mise à jour des données du model.";
    // EXIST
    public static final String DAO_MODEL_EXIST_NULL_EXCEPTION = "Une erreur est survenue lors de la recherche du bâtiment.";


    /*------- MODEL EXCEPTION -------*/
    // ENTITIE Model
    // ID
    public static final String MSG_ID_NULL_EXCEPTION = "L'id doit être renseigné.";


}
