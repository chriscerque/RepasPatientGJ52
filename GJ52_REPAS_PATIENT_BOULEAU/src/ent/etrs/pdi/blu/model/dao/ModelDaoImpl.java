package ent.etrs.pdi.blu.model.dao;

import ent.etrs.pdi.blu.model.dao.exceptions.DaoException;
import ent.etrs.pdi.blu.model.entities.Model;
import ent.etrs.pdi.blu.model.entities.references.ConstantesModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ModelDaoImpl extends AbstractIModelDao {
    /*------- ATTRIBUTS -------*/
    private List<Model> persistence = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    protected ModelDaoImpl(){}

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO
    @Override
    public void create(final Model model) throws DaoException {
        if (Objects.isNull(model)){
            throw new DaoException(ConstantesModel.DAO_MODEL_CREATION_EXCEPTION);
        }
        if (exist(model)){
            throw new DaoException(ConstantesModel.DAO_MODEL_EXIST_EXCEPTION);
        }
        this.persistence.add(model);
    }

    @Override
    public Model read(final String id) throws DaoException {
        Model m = null;
        for (Model model : this.persistence) {
            if (model.getId().equals(id)) {
                m = model;
            }
        }
        return m;
    }

    @Override
    public void delete(final Model model) throws DaoException {
        if (Objects.isNull(model)){
            throw new DaoException(ConstantesModel.DAO_MODEL_SUPPRESSION_EXCEPTION);
        }
        if (!exist(model)){
            throw new DaoException(ConstantesModel.DAO_MODEL_EXIST_PAS_EXCEPTION);
        }
    }

    @Override
    public void update(final Model model) throws DaoException {
        try {
            this.persistence.remove(model);
            this.persistence.add(model);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.DAO_MODEL_MODIFICATION_EXCEPTION);
        }
    }

    @Override
    public List<Model> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Model model) throws DaoException {
        try {
            return this.persistence.contains(model);
        } catch (Exception e) {
            throw new DaoException(ConstantesModel.DAO_MODEL_EXIST_NULL_EXCEPTION);
        }
    }

    // ABSTRACT MODEL DAO
}
