package net.ent.etrs.pdi.vbt.model.facade.impl;

import net.ent.etrs.pdi.vbt.model.dao.exceptions.DaoException;
import net.ent.etrs.pdi.vbt.model.dao.impl.DaoFactory;
import net.ent.etrs.pdi.vbt.model.dao.impl.IPatientMemDao;
import net.ent.etrs.pdi.vbt.model.dao.impl.IRepasMemDao;
import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.Repas;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;
import net.ent.etrs.pdi.vbt.model.facade.FacadeMetier;
import net.ent.etrs.pdi.vbt.model.facade.exceptions.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private IPatientMemDao patientDao;
    private IRepasMemDao repasDao;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected FacadeMetierImpl() {
        this.patientDao = DaoFactory.fabriquerPatient();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////


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
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_CREATION_EXCEPTION, patient.getNom(), patient.getPrenom()));
        }
    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_SUPPRESSION_EXCEPTION, patient.getNom(), patient.getPrenom()));
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR_EXCEPTION, patient.getNom(), patient.getPrenom()));
        }
    }

    @Override
    public void init() {
        this.patientDao.init();
    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        for (Patient patient : patientDao.readAll()) {
            if (patient.getNumSecu().equals(patientId)) {
                return patient;
            }
        }
        throw new BusinessException(C_MSG.MSG_PATIENT_RECHERCHE_EXCEPTION);
    }
}
