package ent.etrs.pdi.hllf.model.dao.daoImpl;

import ent.etrs.pdi.hllf.model.dao.AbstractRepasDao;
import ent.etrs.pdi.hllf.model.dao.exceptions.DaoException;
import ent.etrs.pdi.hllf.model.dao.references.C_DAO;
import ent.etrs.pdi.hllf.model.entities.Repas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepasMemDao extends AbstractRepasDao
{
    //attributs
    private List<Repas> persistence;

    //constructeurs
    public RepasMemDao() {
        this.persistence = new ArrayList<>();
    }

    //methodes
    @Override
    public void create(Repas type) throws DaoException {
        if(Objects.isNull(type))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_CREATION);
        }
        if(this.exist(type))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_DEJA_PRESENT);
        }
        this.persistence.add(type);
    }

    @Override
    public Repas read(String cle) throws DaoException {
        Repas retour = null;
        if(Objects.isNull(cle))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_LECTURE);
        }
        for (Repas r: this.persistence) {
            if(r.getId().equals(cle))
            {
                retour = r;
            }
        }
        if(Objects.isNull(retour))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_LECTURE_NON_TROUVE);
        }
        return retour;
    }

    @Override
    public void delete(Repas type) throws DaoException {
        if(Objects.isNull(type))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_SUPPRESSION);
        }
        if(!this.exist(type))
        {
            throw new DaoException(C_DAO.ERR_REPAS_DAO_SUPPRESSION_OBJET_INTROUVABLE);
        }
        this.persistence.remove(type);
    }

    @Override
    public void update(Repas type) {
        this.persistence.set(this.persistence.indexOf(type), type);
    }

    @Override
    public List<Repas> readAll() {
        return persistence;
    }

    @Override
    public boolean exist(Repas type) {
        return this.persistence.contains(type);
    }
}
