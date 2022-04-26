package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.AbstractRepasDao;
import net.ent.etrs.model.dao.AbstractPatientDao;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.Repas;
import net.ent.etrs.model.facade.exceptions.BusinessException;

import java.util.List;

public class FacadeMetier implements IFacadeMetier{
    /////ATTRIBUTS/////
    private AbstractRepasDao repasDao = DaoFactory.fabriquerDaoRepas();
    private AbstractPatientDao patientDao = DaoFactory.fabriquerDaoPatient();

    /////CONSTRUCTEUR/////
    protected FacadeMetier(){}

    /////METHODES/////
    @Override
    public void init() {
        repasDao.init();
        patientDao.init();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Patient recupererPatientById(String id) throws BusinessException {
        return null;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void creerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Patient> listerPatients() {
        return this.patientDao.readAll();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Repas> listerRepas() {
        return this.repasDao.readAll();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {

    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
}
