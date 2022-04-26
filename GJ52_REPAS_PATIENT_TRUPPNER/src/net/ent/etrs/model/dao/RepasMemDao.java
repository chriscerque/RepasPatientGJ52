package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Repas;

import java.util.*;

public class RepasMemDao extends AbstractRepasDao implements IRepasMemDao {

    private List<Repas> persistenceRepas = new ArrayList<>();

    /////CONSTRUCTEUR/////
    protected RepasMemDao() {
    }

    /////METHODES/////
    @Override
    public void create(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {
            throw new DaoException();
        }
        if (exist(repas)) {
            throw new DaoException();
        }
        this.persistenceRepas.add(repas);
    }

    @Override
    public void delete(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {
            throw new DaoException();
        }
        if (!exist(repas)) {
            throw new DaoException();
        }
        this.persistenceRepas.remove(repas);
    }

    @Override
    public void deleteByKey(String id) throws DaoException {
        for (Repas r: this.persistenceRepas) {
            if(r.getId().equals(id))
            {
                this.persistenceRepas.remove(r);
            }
        }
    }

    @Override
    public boolean exist(final Repas repas) throws DaoException {
        try {
            return this.persistenceRepas.contains(repas);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Repas read(String id) throws DaoException {
        Repas repas = null;

        for (Repas r: this.persistenceRepas) {
            if(r.getId().equals(id))
            {
                repas = r;
            }
        }

        return repas;
    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistenceRepas);
    }

    @Override
    public void update(final Repas repas) throws DaoException {
        try {
            this.persistenceRepas.remove(repas);
            this.persistenceRepas.add(repas);
        } catch (Exception e) {
            throw new DaoException();
        }
    }
}
