package net.ent.etrs.sgr.model.entities.dao;

import net.ent.etrs.sgr.model.entities.Repas;
import net.ent.etrs.sgr.model.entities.dao.exceptions.DaoException;
import net.ent.etrs.sgr.model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao{
    
    private List<Repas> persistence = new ArrayList<>();

    protected RepasMemDao() {
    }

    @Override
    public void create(Repas var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.DAO_CREATION_REPAS_NULL);
        }
        if (exist(var1)) {
            throw new DaoException(C.DAO_REPAS_EXIST_EXCEPTION);
        }
        this.persistence.add(var1);
    }

    @Override
    public Repas read(String var1) throws DaoException {
        Repas p = null;
        for (Repas var1i : this.persistence) {
            if (var1i.getId().equals(var1)) {
                p = var1i;
            }
        }
        return p;
    }

    @Override
    public void delete(final Repas var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.SUPPRESSION_REPAS_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(C.DAO_REPAS_EXIST_EXCEPTION);
        }
        this.persistence.remove(var1);
    }

    @Override
    public void update(final Repas var1) throws DaoException {

        int idx = this.persistence.indexOf(var1);
        if (idx == -1) {
            throw new DaoException(C.DAO_REPAS_EXIST_EXCEPTION);
        }
        this.persistence.set(idx, var1);

    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Repas var1) throws DaoException {
        try {
            return this.persistence.contains(var1);
        } catch (Exception e) {
            throw new DaoException(C.DAO_REPAS_EXIST_EXCEPTION);
        }
    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        Repas rep = null;
        rep = read(var1);
        delete(rep);
    }
}
