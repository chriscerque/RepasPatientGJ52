package ent.etrs.pdi.pre.model.dao;

import ent.etrs.pdi.pre.model.dao.exceptions.DaoException;
import ent.etrs.pdi.pre.model.entities.Repas;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class RepasDaoImpl extends AbstractRepasDao {
    /*------- ATTRIBUTS -------*/
    private List<Repas> persistence = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    protected RepasDaoImpl(){}

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO
    @Override
    public void create(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (exist(repas)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
        }
        this.persistence.add(repas);
    }

    @Override
    public Repas read(final String id) throws DaoException {
        Repas m = null;
        for (Repas repas : this.persistence) {
            if (repas.getId().equals(id)) {
                m = repas;
            }
        }
        return m;
    }

    @Override
    public void delete(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (!exist(repas)){
            throw new DaoException(ConstantesModel.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        this.persistence.remove(repas);
    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        if (Objects.isNull(var1)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        for (int i = 0; i < persistence.size(); i++) {
            if (persistence.get(i).getId().equalsIgnoreCase(var1)){
                this.persistence.remove(persistence.get(i));
            }
        }
    }

    @Override
    public void update(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)){
            throw new DaoException(ConstantesModel.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        try {
            this.persistence.remove(repas);
            this.persistence.add(repas);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.MSG_REPAS_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Repas repas) throws DaoException {
        try {
            return this.persistence.contains(repas);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.MSG_DAO_UPDATE_REPAS_NULL);
        }
    }

    // ABSTRACT MODEL DAO
}
