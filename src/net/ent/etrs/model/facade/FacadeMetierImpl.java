package net.ent.etrs.model.facade;


import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IPatientMemDao;
import net.ent.etrs.model.dao.IRepasMemDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.Repas;
import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.model.references.C_MSG;

import java.util.Collections;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    private IPatientMemDao patientDao = DaoFactory.fabriquerPatientDao();
    private IRepasMemDao repasDao = DaoFactory.fabriquerRepasDao();

    protected FacadeMetierImpl() {
    }

    @Override
    public List<Patient> listerPatients() {
        return Collections.unmodifiableList(this.patientDao.readAll());
    }

    @Override
    public List<Repas> listerRepas() {
        return Collections.unmodifiableList(this.repasDao.readAll());
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {
        try {
            patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_CREATION_EXCEPTION, patient.getNom(), patient.getPrenom()), e);
        }

    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_SUPPRESSION_EXCEPTION, patient.getNom(), patient.getPrenom()), e);
        }

    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR_EXCEPTION, patient.getNom(), patient.getPrenom()), e);
        }

    }


//    @Override
//    public List<String> listerRegimeAlimentaire() {
//        List<String> lst = new ArrayList<>();
//        for (RegimeAlimentaire ra : RegimeAlimentaire.values()) {
//            lst.add(ra.getLibelle());
//        }
//        return lst;
//    }

    @Override
    public void init() {
        patientDao.init();

    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        try {
            return this.patientDao.read(patientId);
        } catch (DaoException e) {
            throw new BusinessException(C_MSG.MSG_PATIENT_RECHERCHE_EXCEPTION);
        }
    }

}
