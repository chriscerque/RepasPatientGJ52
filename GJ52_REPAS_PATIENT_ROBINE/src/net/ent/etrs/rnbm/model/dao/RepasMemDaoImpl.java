package net.ent.etrs.rnbm.model.dao;

import net.ent.etrs.rnbm.model.dao.exceptions.DaoException;
import net.ent.etrs.rnbm.model.entities.Repas;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RepasMemDaoImpl extends AbstractIRepasMemDao {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private List<Repas> persistence = new ArrayList<>();

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected RepasMemDaoImpl() {

    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void create(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {

            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_NULL);
        }

        if (exist(repas)) {

            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
        }
        this.persistence.add(repas);
    }

    @Override
    public Repas read(final String str) throws DaoException {
        Repas r = null;
        for (Repas repas : this.persistence) {
            if (repas.getId().equals(str)) {
                r = repas;
            }
        }
        return r;
    }

    @Override
    public void delete(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {

            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_NULL);
        }
        if (!exist(repas)) {

            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        this.persistence.remove(repas);

    }

    @Override
    public void update(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {

            throw new DaoException(C_MSG.MSG_DAO_REPAS_EXCEPTION_NULL);
        }
        int index = this.persistence.indexOf(repas);
        this.persistence.set(index, repas);
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
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByKey(String str) throws DaoException {
        for (Repas repas : persistence){
            if(repas.getId().equals(str)){
                this.persistence.remove(str);
            }
            else {
                throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
            }
        }

    }


}  

