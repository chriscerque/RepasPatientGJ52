package net.ent.etrs.ggef.model.facades;

import net.ent.etrs.ggef.model.dao.DaoFactory;
import net.ent.etrs.ggef.model.dao.IPatientMemDao;
import net.ent.etrs.ggef.model.dao.IRepasMemDao;
import net.ent.etrs.ggef.model.dao.exceptions.DaoException;
import net.ent.etrs.ggef.model.entities.Patient;
import net.ent.etrs.ggef.model.entities.Repas;
import net.ent.etrs.ggef.model.exceptions.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier{
/*----------------------
Attributs +0+1
-----------------------*/

    private IPatientMemDao patientDao = DaoFactory.fabriquerPatientDao();
    private IRepasMemDao repasDao = DaoFactory.fabriquerRepasDao();


/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected FacadeMetierImpl() {

    }

    @Override
    public List<Patient> listerPatients() {
        return this.patientDao.readAll();
    }

    @Override
    public List<Repas> listerRepas() {
        return this.repasDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    @Override
    public void init() {
    this.repasDao.init();
    this.patientDao.init();
    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
    return null;
    }




}  // fin de classe
