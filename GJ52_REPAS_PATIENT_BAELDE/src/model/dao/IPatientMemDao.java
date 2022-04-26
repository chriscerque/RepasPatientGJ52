package model.dao;

import model.dao.exceptions.DaoException;
import model.entities.Patient;

public interface IPatientMemDao extends Dao<Patient, String> {
    void deleteByKey(String id) throws DaoException;
}
