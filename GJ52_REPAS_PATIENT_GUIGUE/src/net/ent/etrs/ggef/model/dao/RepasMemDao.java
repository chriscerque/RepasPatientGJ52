package net.ent.etrs.ggef.model.dao;

import net.ent.etrs.ggef.model.dao.exceptions.DaoException;
import net.ent.etrs.ggef.model.entities.Repas;
import net.ent.etrs.ggef.model.references.constantes.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao {

    private List<Repas> persistence = new ArrayList();


    protected RepasMemDao() {}


    @Override
    public boolean exist(Repas var1) throws DaoException {
        try {
            return persistence.contains(var1);
        } catch (Exception e) {
            throw new DaoException(ConstantesMetier.MSG_AUCUN_REPAS, e);
        }
    }

    @Override
    public void update(Repas var1) throws DaoException {
        int idx = this.persistence.indexOf(var1);
        if (idx == 1) {
            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        } else {
            this.persistence.set(idx, var1);
        }

    }

    @Override
    public void deleteByKey(String var1) throws DaoException {

    }

    @Override
    public void delete(Repas var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        this.persistence.remove(var1);
    }

    @Override
    public Repas read(String var1) throws DaoException {
        return null;
    }

    @Override
    public void create(Repas var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (exist(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
        }
        this.persistence.add(var1);

    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

}
