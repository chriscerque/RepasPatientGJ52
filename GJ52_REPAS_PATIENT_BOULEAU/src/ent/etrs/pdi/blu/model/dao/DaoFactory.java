package ent.etrs.pdi.blu.model.dao;

public final class DaoFactory {

    private RepasMemDao repasMemDaoInstance;
    private PatientMemDao patientMemDaoInstance;



    /*------- CONSTRUCTEUR(S) -------*/
    private DaoFactory() {
    }

    /*------- AUTRES METHODES -------*/

       public static AbstractRepasDao fabriquerRepaslDao(){
        return new RepasMemDao();
    }
       public static AbstractPatientDao fabriquerPatientDao(){
        return new PatientMemDao();
    }

}
