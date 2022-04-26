package model.dao;

import java.util.Objects;

public final class DaoFactory {

    private static RepasMemDao repasMemDaoInstance;
    private static PatientMemDao patientMemDaoInstance;

    private DaoFactory() {
    }

    public static IPatientMemDao fabriquerPatientDao() {
        if(Objects.isNull(patientMemDaoInstance)) {
            patientMemDaoInstance = new PatientMemDao();
        }
        return patientMemDaoInstance;
    }

    public static IRepasMemDao fabriquerRepasDao() {
        if(Objects.isNull(repasMemDaoInstance)) {
            repasMemDaoInstance = new RepasMemDao();
        }
        return repasMemDaoInstance;
    }
}
