package model.dao;

import model.dao.exceptions.DaoException;
import model.entities.Repas;

public interface IRepasMemDao extends Dao<Repas, String> {
    void deleteByKey(String id) throws DaoException;
}
