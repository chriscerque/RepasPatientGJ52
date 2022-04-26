package ent.etrs.pdi.pre.model.facades;

import com.sun.source.tree.BreakTree;
import ent.etrs.pdi.pre.model.dao.AbstractPatientDao;
import ent.etrs.pdi.pre.model.dao.AbstractRepasDao;
import ent.etrs.pdi.pre.model.dao.DaoFactory;
import ent.etrs.pdi.pre.model.dao.exceptions.DaoException;
import ent.etrs.pdi.pre.model.entities.Patient;
import ent.etrs.pdi.pre.model.entities.Repas;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;
import ent.etrs.pdi.pre.model.facades.exceptions.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    /*------- ATTRIBUTS -------*/
    private AbstractPatientDao patientDao = DaoFactory.fabriquerPatientDao();
    private AbstractRepasDao repasDao = DaoFactory.fabriquerRepasDao();

    /*------- CONSTRUCTEUR(S) -------*/
    protected FacadeMetierImpl(){}

    /*------- METHODES IMPLEMENTEES -------*/
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
            throw new BusinessException(ConstantesModel.MSG_PATIENT_CREATION_EXCEPTION);
        }
    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesModel.MSG_PATIENT_SUPPRESSION_EXCEPTION);
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesModel.MSG_PATIENT_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public void init() {
        patientDao.init();
        repasDao.init();
    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        try {
            return patientDao.read(patientId);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesModel.MSG_AUCUN_PATIENT);
        }
    }
}
