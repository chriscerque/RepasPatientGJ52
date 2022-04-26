package ent.etrs.pdi.pre.model.dao;

import ent.etrs.pdi.pre.model.dao.exceptions.DaoException;
import ent.etrs.pdi.pre.model.entities.Patient;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PatientDaoImpl extends AbstractPatientDao {
    /*------- ATTRIBUTS -------*/
    private List<Patient> persistence = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    protected PatientDaoImpl(){}

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO
    @Override
    public void create(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        if (exist(patient)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
        }
        this.persistence.add(patient);
    }

    @Override
    public Patient read(final String numSecu) throws DaoException {
        Patient m = null;
        for (Patient patient : this.persistence) {
            if (patient.getNumSecu().equals(numSecu)) {
                m = patient;
            }
        }
        return m;
    }

    @Override
    public void delete(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)){
            throw new DaoException(ConstantesModel.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
        if (!exist(patient)){
            throw new DaoException(ConstantesModel.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        this.persistence.remove(patient);
    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        if (Objects.isNull(var1)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        for (int i = 0; i < persistence.size(); i++) {
            if (persistence.get(i).getNumSecu().equalsIgnoreCase(var1)){
                this.persistence.remove(persistence.get(i));
            }
        }
    }

    @Override
    public void update(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)){
            throw new DaoException(ConstantesModel.MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT);
        }
        try {
            this.persistence.remove(patient);
            this.persistence.add(patient);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.MSG_DAO_MISE_A_JOUR_PATIENT_NULL);
        }
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Patient patient) throws DaoException {
        try {
            return this.persistence.contains(patient);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
    }

    // ABSTRACT MODEL DAO
}
