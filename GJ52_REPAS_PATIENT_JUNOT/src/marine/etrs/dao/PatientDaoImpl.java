package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PatientDaoImpl extends AbstractPatientDao {
    private List<Patient> persistence = new ArrayList<>();

    @Override
    public void create(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {
            throw new DaoException();
        }
        if (exist(patient)) {
            throw new DaoException();
        }
        this.persistence.add(patient);
    }

    @Override
    public void delete(final Patient patient) throws DaoException {
        if (Objects.isNull(patient)) {
            throw new DaoException();
        }
        if (!exist(patient)) {
            throw new DaoException();
        }
        this.persistence.remove(patient);
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
    public Patient read(final String id) throws DaoException {
        Patient p = null;
        for (Patient patient : this.persistence) {
            if(patient.getId().equals(id)) {
                p = patient;
            }
        }
        return p;
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }



    @Override
    public void update(final Patient patient) throws DaoException {

        try {
            this.persistence.remove(patient);
            this.persistence.add(patient);
        }catch (Exception e) {
            throw new DaoException();
        }
    }


//                             ICI CODER LES METODES CF AbstractPatientDao !!





}
