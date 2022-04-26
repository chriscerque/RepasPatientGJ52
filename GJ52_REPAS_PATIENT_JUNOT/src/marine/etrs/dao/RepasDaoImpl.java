package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Repas;

import java.util.ArrayList;
import java.util.Collections;


import java.util.List;
import java.util.Objects;

public class RepasDaoImpl extends AbstractRepasDao {
    private List<Repas> persistence = new ArrayList<>();

    @Override
    public void create(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {
            throw new DaoException();
        }
        if (exist(repas)) {
            throw new DaoException();
        }
        this.persistence.add(repas);
    }

    @Override
    public void delete(final Repas repas) throws DaoException {
        if (Objects.isNull(repas)) {
            throw new DaoException();
        }
        if (!exist(repas)) {
            throw new DaoException();
        }
        this.persistence.remove(repas);
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
    public Repas read(final String id) throws DaoException {
        Repas p = null;
        for (Repas repas : this.persistence) {
            if(repas.getId().equals(id)) {
                p = repas;
            }
        }
        return p;
    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }



    @Override
    public void update(final Repas repas) throws DaoException {

        try {
            this.persistence.remove(repas);
            this.persistence.add(repas);
        }catch (Exception e) {
            throw new DaoException();
        }
    }


//                             ICI CODER LES METODES CF AbstractRepasDao !!





}
