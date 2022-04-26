package ent.etrs.pdi.blu.model.dao;

import ent.etrs.pdi.blu.model.dao.exceptions.DaoException;
import ent.etrs.pdi.blu.model.entities.Patient;
import ent.etrs.pdi.blu.model.references.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PatientMemDao extends AbstractPatientDao {
    /*------- ATTRIBUTS -------*/
    //private List<Repas> persistence = new ArrayList<>();
    private List<Patient> persistencePatient = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    protected PatientMemDao(){}

    @Override
    public void create(Patient p1) throws DaoException {
        if (Objects.isNull(p1)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        if (exist(p1)) {
            throw new DaoException(C_MSG.MSG_PATIENT_CREATION_EXCEPTION);
        }
        persistencePatient.add(p1);

    }

    @Override
    public Patient read(String p1) throws DaoException {
        Patient p = null;
        for (Patient patient : persistencePatient) {
            if (patient.getId().equals(p1)) {
                p = patient;
            }
        }
        return p;
    }

    @Override
    public void delete(Patient p1) throws DaoException {
        if (Objects.isNull(p1)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
        if (!exist(p1)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        persistencePatient.remove(p1);
    }

    @Override
    public void deleteByKey(Patient p1) throws DaoException {
        int key = Integer.parseInt(p1.getId());

        persistencePatient.remove(key);
    }


    @Override
    public void update(Patient p1) throws DaoException {
        try {
            persistencePatient.remove(p1);
            persistencePatient.add(p1);
        } catch (Exception e) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }

    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(persistencePatient);
    }

    @Override
    public boolean exist(Patient p1) throws DaoException {
        try {
            return persistencePatient.contains(p1);
        } catch (Exception e) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_EXISTANT, e);
        }
    }

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO


}
