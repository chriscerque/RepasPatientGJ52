package net.ent.etrs.model.dao;

import java.util.Objects;

public class DaoFactory {
    //SINGLETON
    private static RepasMemDao repasMemDaoInstance;
    private static PatientMemDao patientMemDaoInstance;

    /////CONSTRUCTEUR/////
    private DaoFactory() {
    }

    /////METHODES/////
    public static AbstractRepasDao fabriquerDaoRepas()
    {
        //Singleton
        if(Objects.isNull(repasMemDaoInstance))
        {
            repasMemDaoInstance = new RepasMemDao();
        }
        return new RepasMemDao();
    }

    public static AbstractPatientDao fabriquerDaoPatient()
    {
        //Singleton
        if(Objects.isNull(patientMemDaoInstance))
        {
            patientMemDaoInstance = new PatientMemDao();
        }
        return new PatientMemDao();
    }
}
