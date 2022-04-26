package model.dao;

import java.util.Objects;

public final class DaoFactory {
    private DaoFactory() {}



    private static RepasMemDao repasMemDaoInstance;

    public static IRepasMemDao fabriquerRepasDao() {
        if (Objects.isNull(repasMemDaoInstance)) {
            repasMemDaoInstance = new RepasMemDao();
        }
        return repasMemDaoInstance;
    }



    private static PatientMemDao patientMemDaoInstance;

    public static IPatientMemDao fabriquerPatientDao() {
        if (Objects.isNull(patientMemDaoInstance)) {
            patientMemDaoInstance = new PatientMemDao();
        }
        return patientMemDaoInstance;
    }
}
