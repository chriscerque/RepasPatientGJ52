package net.ent.etrs.sgr.model.references;

public final class C {


    public static final String[] MENU = {
            "Lister les patients",
            "Céer un nouveau patient",
            "Modifier un patient",
            "Supprimer un patient",
            "Ajouter un repas à un patient"
    };

    public static final String MSG_NUM_SECU_LENGTH_EXCEPTION = String.format("Le numéro de série doit contenir %d caractères.", C.NUM_SECU_LENGTH);
    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String MSG_DATE_REPAS_NULL_EXCEPTION = "La date du repas doit être renseignée";
    public static final String MSG_DATE_ENTREE_FUTUR_EXCEPTION = "La date d'entrée du patient ne peut pas être unltérieur à la date du jour'";
    public static final String MSG_TYPE_REPAS_NULL_EXCEPTION = "LE type de repas ne peutp as être null et doit être renseigné";
    public static final String MSG_REPAS_REGIME_NULL = "Le régime alimentaire fourni au repas est null";
    public static final String MSG_NOM_PATIENT_NULL_EXCEPTION = "Le patient doit avoir un nom";
    public static final String MSG_PRENOM_PATIENT_NULL_EXCEPTION = "Le patient doit avoir un prénom";
    public static final String MSG_DATE_ENTREE_NULL_EXCEPTION = "LA date d'entrée du patient doit être renseignée";
    public static final int LONGUEUR_NOM_MIN = 3;
    public static final int LONGUEUR_NOM_MAX = 50;
    public static final String MSG_NOM_LENGTH_EXCEPTION = "Le taille du nom du patient est inadéquate";
    public static final String MSG_NUM_SECU_NULL_EXCEPTION = "le numéro de sécu du patient doit etre renseigné";
    public static final int NUM_SECU_LENGTH = 5;
    public static final String MSG_PATIENT_REGIME_NULL = "Le régime alimentaire fourni au patient est null";
    public static final String MSG_REPAS_NULL_EXCEPTION = "Le repas fourni au patient est null";
    public static final String MSG_REPAS_INCOMPATIBLE_PATIENT = "Le régime alimentaire du repas n'est pas adapté au patient";
    public static final String MSG_REGIME_PATIENT_DOUBLON = "Le patient possède déja ce régime alimentaire";
    public static final String MSG_REGIME_REPAS_DOUBLON = "Le repas possède déja ce régiem alimentaire";
    public static final String DAO_CREATION_REPAS_NULL = "Impossible de créer le repas car null";
    public static final String DAO_REPAS_EXIST_EXCEPTION = "Le repas existe déja en mémoire";
    public static final String SUPPRESSION_REPAS_NULL = "Impossible de supprimerle repas car null";
    public static final String SAISIR_NOM = "Veuillez saisir el nom du patient, entre 3 et 50 caractères";
    public static final String SAISIR_PRENOM = "Veuillez saisir el prénom du patient, entre 3 et 50 caractères";
    public static final String SAISIR_SECU = "Veuillez saisir le numéro de sécudu patient (5 caractères)";
    public static final String SAISIR_DATE_ENTREE = String.format("Veuillez saisir la date d'entrée du patient (au format : %s):",C.PATTERN_DATE);
}
