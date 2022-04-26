package net.ent.etrs.pdi.vbt.model.dao;

import net.ent.etrs.pdi.vbt.model.dao.exceptions.DaoException;

import java.util.List;

public interface Dao<T, K> {

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    void create(T object) throws DaoException;

    T read(K object) throws DaoException;

    List<T> readAll();

    void update(T object) throws DaoException;

    void delete(T object) throws DaoException;

    void deleteByKey(K object) throws DaoException;

    boolean exist(T object) throws DaoException;

    default void init() {
        throw new UnsupportedOperationException();
    }

}
