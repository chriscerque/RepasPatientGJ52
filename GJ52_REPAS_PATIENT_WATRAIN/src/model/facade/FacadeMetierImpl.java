package model.facade;

import model.dao.DaoFactory;
import model.dao.IPatientMemDao;
import model.dao.IRepasMemDao;
import model.dao.exceptions.DaoException;
import model.entities.Patient;
import model.entities.Repas;
import model.facade.exceptions.BusinessException;
import model.references.C;

import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {

    private IPatientMemDao patientDao = DaoFactory.fabriquerPatientDao();
    private IRepasMemDao repasDao = DaoFactory.fabriquerRepasDao();


    public void initialiser() {
        repasDao.init();
        patientDao.init();
    }

    @Override
    public List<Patient> listerPatients() {
        return patientDao.readAll();
    }

    @Override
    public List<Repas> listerRepas() {
        return repasDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {
        try {
            patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException(C.MSG_PATIENT_CREATION_EXCEPTION);
        }
    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(C.MSG_PATIENT_SUPPRESSION_EXCEPTION);
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(C.MSG_PATIENT_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public void init() {
        repasDao.init();
        patientDao.init();
    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        if(Objects.isNull(patientId)){ throw new BusinessException(C.MSG_PATIENT_ID_NULL); }
        try {
            return patientDao.read(patientId);
        } catch (DaoException e) {
            throw new BusinessException(C.MSG_PATIENT_RECHERCHE_EXCEPTION);
        }
    }
}
