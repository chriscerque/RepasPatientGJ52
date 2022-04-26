package net.ent.etrs.rnbm.model.dao;

import net.ent.etrs.rnbm.model.dao.exceptions.DaoException;
import net.ent.etrs.rnbm.model.entities.Patient;
import net.ent.etrs.rnbm.model.entities.Repas;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PatientMemDaoImpl extends AbstractPatientDao {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private List<Patient> persistence = new ArrayList<>();

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected PatientMemDaoImpl() {

    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void create(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {

            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        if (exist(patient)) {

            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
        }
        this.persistence.add(patient);
    }

    @Override
    public Patient read(final String str) throws DaoException {
        Patient p = null;
        for (Patient patient : this.persistence) {
            if (patient.getId().equals(str)) {
                p = patient;
            }
        }
        return p;
    }

    @Override
    public void delete(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {

            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
        if (!exist(patient)) {

            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        this.persistence.remove(patient);

    }

    @Override
    public void update(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {

            throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_PATIENT_NULL);
        }
        for (Patient pat : persistence){
            if (pat.equals(patient)) {
                int index = this.persistence.indexOf(patient);
                this.persistence.set(index, patient);
            } else {
                throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT);
            }
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
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByKey(String str) throws DaoException {
        for (Patient patient : persistence){
            if(patient.getId().equals(str)){
                this.persistence.remove(str);
            }
            else {
                throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
            }
        }

    }

}  

