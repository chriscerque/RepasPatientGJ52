package ent.etrs.pdi.hllf.model.dao.daoImpl;

import ent.etrs.pdi.hllf.model.dao.AbstractPatientDao;
import ent.etrs.pdi.hllf.model.dao.exceptions.DaoException;
import ent.etrs.pdi.hllf.model.dao.references.C_DAO;
import ent.etrs.pdi.hllf.model.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientMemDao extends AbstractPatientDao
{
    //attributs
    private List<Patient> persistence;

    //constructeurs
    public PatientMemDao() {
        this.persistence = new ArrayList<>();
    }

    //methodes
    @Override
    public void create(Patient type) throws DaoException {
        if(Objects.isNull(type))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_CREATION);
        }
        if(this.exist(type))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_DEJA_PRESENT);
        }
        this.persistence.add(type);
    }

    @Override
    public Patient read(String cle) throws DaoException {
        Patient retour = null;
        if(Objects.isNull(cle))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_LECTURE);
        }
        for (Patient r: this.persistence) {
            if(r.getId().equals(cle))
            {
                retour = r;
            }
        }
        if(Objects.isNull(retour))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_LECTURE_NON_TROUVE);
        }
        return retour;
    }

    @Override
    public void delete(Patient type) throws DaoException {
        if(Objects.isNull(type))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_SUPPRESSION);
        }
        if(!this.exist(type))
        {
            throw new DaoException(C_DAO.ERR_PATIENT_DAO_SUPPRESSION_OBJET_INTROUVABLE);
        }
        this.persistence.remove(type);
    }

    @Override
    public void update(Patient type) {
        this.persistence.set(this.persistence.indexOf(type), type);
    }

    @Override
    public List<Patient> readAll() {
        return persistence;
    }

    @Override
    public boolean exist(Patient type) {
        return this.persistence.contains(type);
    }
}
