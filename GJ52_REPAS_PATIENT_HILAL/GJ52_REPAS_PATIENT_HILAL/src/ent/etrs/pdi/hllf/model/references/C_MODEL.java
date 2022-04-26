package ent.etrs.pdi.hllf.model.references;

public class C_MODEL
{
    //constantes pour regime alimentaire
    public static String ERR_REGIME_ALIMENTAIRE_LIBELLE_NULL = "ERR: le libelle est null";
    public static String ERR_REGIME_ALIMENTAIRE_NON_TROUVE = "ERR: le regime alimentaire n'existe pas";

    //constantes pour repas
    public static String ERR_REPAS_DATE_NULL = "ERR: la date du repas est null";
    public static String ERR_REPAS_TYPE_NULL = "ERR: le type repas est null";
    public static String ERR_REPAS_REGIME_NULL = "ERR: le regime alimentaire est null";
    public static String ERR_REPAS_REGIME_DOUBLE = "ERR: le regime alimentaire existe déjà dans la liste";

    //constantes pour patient
    public static String ERR_PATIENT_REPAS_NULL = "ERR: le repas est null et ne peut donc pas être ajouter";
    public static String ERR_PATIENT_REGIME_NON_CONVENABLE = "ERR: le repas n'a pas le bon regime alimentaire";
    public static String ERR_PATIENT_NOM_NULL = "ERR: le nom du patient est null";
    public static String ERR_PATIENT_NOM_LONGUEUR = "ERR: le nom du patient n'a pas une longueur convenable";
    public static String ERR_PATIENT_PRENOM_NULL = "ERR: le prénom du patient est null";
    public static String ERR_PATIENT_PRENOM_LONGUEUR = "ERR: le prénom du patient n'a pas une longueur convenable";
    public static String ERR_PATIENT_DATE_NULL = "ERR: la date d'entrée est null";
    public static String ERR_PATIENT_DATE_FUTURISTE = "ERR: la date n'est pas encore passée";
    public static String ERR_PATIENT_NUMSECU_NULL = "ERR: le numSecu du patient est null";
    public static String ERR_PATIENT_NUMSECU_LONGUEUR = "ERR: le numSecu doit contenir uniquement 5 caractères";
    public static String ERR_PATIENT_REGIME_NULL = "ERR: le regime est null et ne peut donc pas être ajouter";
    public static String ERR_PATIENT_REGIME_DEJA_CONNU = "ERR: le regime est déjà dans la liste du patient";
}
