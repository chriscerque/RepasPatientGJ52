package ent.etrs.pdi.pre.model.dao;

public final class DaoFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private DaoFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static AbstractPatientDao fabriquerPatientDao(){
        return new PatientDaoImpl();
    }
    public static AbstractRepasDao fabriquerRepasDao(){
        return new RepasDaoImpl();
    }
}
