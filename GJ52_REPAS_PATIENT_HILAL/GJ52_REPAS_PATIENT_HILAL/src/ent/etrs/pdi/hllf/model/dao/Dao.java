package ent.etrs.pdi.hllf.dao;

import ent.etrs.pdi.hllf.model.dao.exceptions.DaoException;

import java.util.List;

public interface Dao<T, K>
{
    public void create(T type) throws DaoException;

    public T read(K cle) throws DaoException;

    public void delete(T type) throws DaoException;

    public void update(T type);

    public List<T> readAll();

    public boolean exist(T type);

    public void init() throws DaoException;
}
