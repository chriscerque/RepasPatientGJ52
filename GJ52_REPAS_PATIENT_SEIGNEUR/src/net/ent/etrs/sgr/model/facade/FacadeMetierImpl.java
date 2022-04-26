package net.ent.etrs.sgr.model.facade;

import net.ent.etrs.sgr.model.entities.Patient;
import net.ent.etrs.sgr.model.entities.Repas;
import net.ent.etrs.sgr.model.entities.dao.DaoFactory;
import net.ent.etrs.sgr.model.entities.dao.IPatientMemDao;
import net.ent.etrs.sgr.model.entities.dao.IRepasMemDao;
import net.ent.etrs.sgr.model.entities.dao.exceptions.DaoException;
import net.ent.etrs.sgr.model.exceptions.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements IFacadeMetier{

    private IPatientMemDao patientDao;
    private IRepasMemDao repasDao;

    protected FacadeMetierImpl() {
        this.patientDao = DaoFactory.fabriquerPatientDao();
        this.repasDao = DaoFactory.fabriquerRepasDao();
    }

    @Override
    public Patient recupererPatientById(String id) {

        Patient pat = null;

        for (Patient each : patientDao.readAll()){
            if (each.getId().equals(id)){
                pat = each;
            }
        }
        return pat;
    }

    @Override
    public void init() {
        repasDao.init();
        patientDao.init();


    }

    @Override
    public List<Repas> listerRepas() {
        return this.repasDao.readAll();
    }

    @Override
    public void supprimerPatient(Patient pat) throws BusinessException {
        try {
            this.patientDao.delete(pat);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    public List<Patient> listerPatients() {
        return this.patientDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient pat) throws BusinessException {
        try {
            this.patientDao.create(pat);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    public void mettreAJourPatient(Patient pat) throws BusinessException {
        try {
            this.patientDao.update(pat);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }
}
