package net.ent.etrs.ggef.model.dao;


import net.ent.etrs.ggef.model.dao.exceptions.DaoException;

import java.util.List;

// T = type et K = key -- convention de nommage...

public interface Dao<T, K> {

    boolean exist(T var1) throws DaoException;

    void update(T var1) throws DaoException;

    default void init() {
        throw new UnsupportedOperationException();
    }

    void deleteByKey(K var1) throws DaoException;

    void delete(T var1) throws DaoException;

    T read(K var1) throws DaoException;

    void create(T var1) throws DaoException;

    List<T> readAll();

} // fin d'Interface
