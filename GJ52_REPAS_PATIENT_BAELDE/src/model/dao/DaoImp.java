package model.dao;

import model.dao.exceptions.DaoException;
import model.references.ConstantesDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class DaoImp<T, K> implements Dao<T, K> {

    protected List<T> persistence = new ArrayList<>();

    @Override
    public void create(T var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_OBJET_NULL_EXCEPTION);
        }
        if (this.persistence.contains(var)) {
            throw new DaoException(ConstantesDao.MSG_OBJET_EXISTE_EXCEPTION);
        }
        this.persistence.add(var);
    }

    @Override
    public void update(T var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_OBJET_NULL_EXCEPTION);
        }
        if (this.persistence.contains(var)) {
            int index = this.persistence.indexOf(var);
            this.persistence.set(index, var);
        } else {
            throw new DaoException(ConstantesDao.MSG_OBJET_EXISTE_PAS_EXCEPTION);
        }
    }

    @Override
    public void delete(T var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_OBJET_NULL_EXCEPTION);
        }
        if (this.persistence.contains(var)) {
            this.persistence.remove(var);
        } else {
            throw new DaoException(ConstantesDao.MSG_OBJET_EXISTE_PAS_EXCEPTION);
        }
    }

    @Override
    public List<T> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(T var) throws DaoException {
        if (Objects.isNull(var)) {
            throw new DaoException(ConstantesDao.MSG_OBJET_NULL_EXCEPTION);
        }
        if (this.persistence.contains(var)) {
            return true;
        } else {
            return false;
        }
    }
}
