package net.ent.etrs.pdi.vbt.model.dao.impl;

import net.ent.etrs.pdi.vbt.model.dao.exceptions.DaoException;
import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.Repas;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private List<Repas> persistence = new ArrayList<>();

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected RepasMemDao() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void create(Repas object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        if (exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
        }
        this.persistence.add(object);
    }

    @Override
    public Repas read(String object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_LECTURE_REPAS_NULL);
        }
        for (Repas repas : this.persistence) {
            if (repas.getId().equals(object))
                return repas;
        }
        throw new DaoException(C_MSG.MSG_DAO_LECTURE_REPAS_INEXISTANT);
    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public void update(Repas object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_REPAS_NULL);
        }
        if (!exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_MISE_A_JOUR_REPAS_INEXISTANT);
        }
        int indexObject = this.persistence.indexOf(object);
        this.persistence.set(indexObject, object);
    }

    @Override
    public void delete(Repas object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_NULL);
        }
        if (!exist(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        this.persistence.remove(object);
    }

    @Override
    public void deleteByKey(String object) throws DaoException {
        if (Objects.isNull(object)) {
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_ID_NULL);
        }
        this.persistence.removeIf(patient -> patient.getId().equals(object));
        throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
    }

    @Override
    public boolean exist(Repas object) throws DaoException {
        try {
            return this.persistence.contains(object);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
