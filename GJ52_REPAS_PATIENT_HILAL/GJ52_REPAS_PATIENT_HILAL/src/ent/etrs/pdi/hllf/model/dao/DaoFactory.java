package ent.etrs.pdi.hllf.model.dao;

import ent.etrs.pdi.hllf.model.dao.daoImpl.PatientMemDao;
import ent.etrs.pdi.hllf.model.dao.daoImpl.RepasMemDao;

public class DaoFactory
{

    private DaoFactory() {
    }

    public static IPatientMemDao fabriquerPatientDao()
    {
        return new PatientMemDao();
    }

    public static IRepasMemDao fabriquerRepasDao()
    {
        return new RepasMemDao();
    }
}
