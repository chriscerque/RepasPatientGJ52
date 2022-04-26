package net.ent.etrs.rnbm.model.dao;

public final class DaoFactory {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private static IPatientMemDao  patientMemDaoInstance;
    private static IRepasMemDao repasMemDaoInstance;


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private DaoFactory(){}

    /* ******************* */
    /* ***** FACTORY ***** */
    public static IRepasMemDao fabriquerRepasDao(){
        if (repasMemDaoInstance == null){
            repasMemDaoInstance = new RepasMemDaoImpl();
        }
        return  repasMemDaoInstance;
    }

    public static IPatientMemDao fabriquerPatientDao(){
        if (patientMemDaoInstance == null){
            patientMemDaoInstance = new PatientMemDaoImpl();
        }
        return new PatientMemDaoImpl();
    }





}
