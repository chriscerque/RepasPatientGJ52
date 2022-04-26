package model.dao;

import model.dao.exceptions.DaoException;
import model.entities.Repas;
import model.references.ConstantesDao;

import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao {

    protected RepasMemDao() {}

    @Override
    public Repas read(String var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_DAO_PARAM_ID_NULL);
        }
        for (Repas repas : this.persistence) {
            if (var.equals(repas.getId())) {
                return repas;
            }
        }
        throw new DaoException(ConstantesDao.MSG_DAO_READ_NON_EXIST);
    }

    @Override
    public void deleteByKey(String id) throws DaoException {
        if (Objects.isNull(id)) {
            throw new DaoException(ConstantesDao.MSG_DAO_PARAM_ID_NULL);
        }
        for (Repas repas : this.persistence) {
            if (id.equals(repas.getId())) {
                this.delete(repas);
            }
        }
        throw new DaoException(ConstantesDao.MSG_DAO_READ_NON_EXIST);
    }
}
