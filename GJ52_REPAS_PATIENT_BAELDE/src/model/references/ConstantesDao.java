package model.references;

public final class ConstantesDao {
    private ConstantesDao() {}

    public static final String MSG_OBJET_NULL_EXCEPTION = "L'objet n'est pas valide.";

    public static final String MSG_OBJET_EXISTE_EXCEPTION = "L'objet existe déjà.";

    public static final String MSG_OBJET_EXISTE_PAS_EXCEPTION = "L'objet n'existe pas.";

    //PATIENT
    public static final String MSG_DAO_PARAM_ID_NULL = "Dao : L'id de la recherche est non valide.";
    public static final String MSG_DAO_READ_NON_EXIST = "Dao : Le repas avec cet id n'existe pas.";

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
    public static final String MSG_DAO_PERSITANCE_REPAS_NULL = "Dao : tentative de persistance d'un repas à null";
}
