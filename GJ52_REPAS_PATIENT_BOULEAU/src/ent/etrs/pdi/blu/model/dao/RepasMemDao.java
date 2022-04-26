package ent.etrs.pdi.blu.model.dao;

import ent.etrs.pdi.blu.model.dao.exceptions.DaoException;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.model.references.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao {


    /*------- ATTRIBUTS -------*/
    //private List<Repas> persistence = new ArrayList<>();
    private List<Repas> persistenceRepas = new ArrayList<>();


    /*------- CONSTRUCTEUR(S) -------*/
    protected RepasMemDao(){}

    @Override
    public void create(Repas r1) throws DaoException {
        if (Objects.isNull(r1)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (exist(r1)) {
            throw new DaoException(C_MSG.MSG_REPAS_CREATION_EXCEPTION);
        }
        persistenceRepas.add(r1);

    }

    @Override
    public Repas read(String r1) throws DaoException {
        return null;
    }

    @Override
    public void delete(Repas r1) throws DaoException {

        if (Objects.isNull(r1)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (exist(r1)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        persistenceRepas.add(r1);

    }

    @Override
    public void deleteByKey(Repas r1) throws DaoException {
        int key = Integer.parseInt(r1.getId());

        persistenceRepas.remove(key);
    }

    @Override
    public void update(Repas r1) throws DaoException {
        try {
            persistenceRepas.remove(r1);
            persistenceRepas.add(r1);
        } catch (Exception e) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }

    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(persistenceRepas);
    }

    @Override
    public boolean exist(Repas r1) throws DaoException {
        try {
            return persistenceRepas.contains(r1);
        } catch (Exception e) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_EXISTANT, e);
        }
    }

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO

}
