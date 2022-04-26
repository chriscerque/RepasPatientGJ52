package net.ent.etrs.sgr.model.entities.dao;

import net.ent.etrs.sgr.model.entities.dao.exceptions.DaoException;

import java.util.List;

public interface DAO<T, K> {
    void create(T var1) throws DaoException;

    T read(K var1) throws DaoException;

    void delete(T var1) throws DaoException;

    void update(T var1) throws DaoException;

    List<T> readAll();

    boolean exist(T var1) throws DaoException;

    void deleteByKey(K var1) throws DaoException;

    default void init() {
        throw new UnsupportedOperationException();
    }
}