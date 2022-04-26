package model.dao;

import model.dao.exceptions.DaoException;
import model.entities.Patient;
import model.references.ConstantesDao;

import java.util.Objects;

public class PatientMemDao extends AbstractPatientDao {

    protected PatientMemDao() {
        super();
    }

    @Override
    public Patient read(String var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_DAO_PARAM_ID_NULL);
        }
        for (Patient patient : this.persistence) {
            if (var.equals(patient.getId())) {
                return patient;
            }
        }
        throw new DaoException(ConstantesDao.MSG_DAO_READ_NON_EXIST);
    }

    @Override
    public void deleteByKey(String id) throws DaoException {
        if (Objects.isNull(id)) {
            throw new DaoException(ConstantesDao.MSG_DAO_PARAM_ID_NULL);
        }
        for (Patient patient : this.persistence) {
            if (id.equals(patient.getId())) {
                this.delete(patient);
            }
        }
        throw new DaoException(ConstantesDao.MSG_DAO_READ_NON_EXIST);
    }
}
