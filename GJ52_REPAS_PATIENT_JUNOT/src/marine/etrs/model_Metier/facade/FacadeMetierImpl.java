package marine.etrs.model_Metier.facade;

import marine.etrs.dao.AbstractPatientDao;
import marine.etrs.dao.AbstractRepasDao;
import marine.etrs.dao.DaoFactory;
import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Patient;
import marine.etrs.model_Metier.entities_Class_Factory.Repas;
import marine.etrs.model_Metier.facade.exceptions_business.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier{

    //IL PEUT Y AVOIR PLUSIEURS OBJETS ! :
    private AbstractRepasDao daoRepas = DaoFactory.fabriquerRepasDao();
    private AbstractPatientDao daoPatient = DaoFactory.fabriquerPatientDao();


    protected FacadeMetierImpl() {}


    @Override
    public List<Patient> listerPatients() {
        return this.daoPatient.readAll();
    }

    @Override
    public List<Repas> listerRepas() {
        return this.daoRepas.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {

        //TODO A FAIRE

    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.daoPatient.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {

        //TODO A FAIRE
    }

    @Override
    public void init() {
        this.daoRepas.init();
        this.daoPatient.init();
    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        //TODO A FAIRE
        return null;
    }




}