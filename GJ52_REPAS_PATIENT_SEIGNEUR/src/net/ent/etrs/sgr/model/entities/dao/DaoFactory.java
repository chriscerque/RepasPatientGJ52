package net.ent.etrs.sgr.model.entities.dao;

public class DaoFactory {

    private DaoFactory() {
    }

    private static PatientMemDao patientMemDaoInstance;
    private static RepasMemDao repasMemDaoInstance;

    public static AbstractPatientDao fabriquerPatientDao() {
        if (patientMemDaoInstance == null) {
            patientMemDaoInstance = new PatientMemDao();
        }
        return patientMemDaoInstance;
    }
    public static AbstractRepasDao fabriquerRepasDao() {
        if (repasMemDaoInstance == null) {
            repasMemDaoInstance = new RepasMemDao();
        }
        return repasMemDaoInstance;
    }
}
