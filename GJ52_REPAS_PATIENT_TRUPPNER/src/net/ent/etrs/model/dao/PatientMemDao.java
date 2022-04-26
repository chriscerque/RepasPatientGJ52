package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.Repas;

import java.util.*;

public class PatientMemDao extends AbstractPatientDao implements IPatientMemDao {

    private List<Patient> persistencePatient = new ArrayList<>();

    /////CONSTRUCTEUR/////
    protected PatientMemDao() {
    }

    /////METHODES/////
    @Override
    public void create(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {
            throw new DaoException();
        }
        if (exist(patient)) {
            throw new DaoException();
        }
        this.persistencePatient.add(patient);
    }

    @Override
    public void delete(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {
            throw new DaoException();
        }
        if (!exist(patient)) {
            throw new DaoException();
        }
        this.persistencePatient.remove(patient);
    }

    @Override
    public void deleteByKey(String numSecu) throws DaoException {
        for (Patient p: this.persistencePatient) {
            if(p.getNumSecu().equals(numSecu))
            {
                this.persistencePatient.remove(p);
            }
        }
    }

    @Override
    public boolean exist(final Patient patient) throws DaoException {
        try {
            return this.persistencePatient.contains(patient);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Patient read(String numSecu) throws DaoException {
        Patient patient = null;

        for (Patient p: this.persistencePatient) {
            if(p.getNumSecu().equals(numSecu))
            {
                patient = p;
            }
        }

        return patient;
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistencePatient);
    }

    @Override
    public void update(final Patient patient) throws DaoException {
        try {
            this.persistencePatient.remove(patient);
            this.persistencePatient.add(patient);
        } catch (Exception e) {
            throw new DaoException();
        }
    }

}