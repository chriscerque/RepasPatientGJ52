package net.ent.etrs.pdi.vbt.model.dao.impl;

import net.ent.etrs.pdi.vbt.model.dao.exceptions.DaoException;
import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PatientMemDao extends AbstractPatientDao {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private List<Patient> persistence = new ArrayList<>();

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected PatientMemDao() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void create(Patient object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        if (exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
        }
        this.persistence.add(object);
    }

    @Override
    public Patient read(String object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_LECTURE_PATIENT_NULL);
        }
        for (Patient patient : this.persistence) {
            if (patient.getNumSecu().equals(object))
                return patient;
        }
        throw new DaoException(C_MSG.MSG_DAO_LECTURE_PATIENT_INEXISTANT);
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public void update(Patient object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_PATIENT_NULL);
        }
        if (!exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT);
        }
        int indexObject = this.persistence.indexOf(object);
        this.persistence.set(indexObject, object);
    }

    @Override
    public void delete(Patient object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
        if (!exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        this.persistence.remove(object);
    }

    @Override
    public void deleteByKey(String object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_NUMSECU_NULL);
        }
        this.persistence.removeIf(patient -> patient.getNumSecu().equals(object));
        throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
    }

    @Override
    public boolean exist(Patient object) throws DaoException {
        try {
            return this.persistence.contains(object);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
