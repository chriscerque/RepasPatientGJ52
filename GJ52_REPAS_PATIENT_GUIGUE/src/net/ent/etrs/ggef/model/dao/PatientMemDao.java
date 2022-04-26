package net.ent.etrs.ggef.model.dao;//package net.ent.etrs.ggef.model.dao;

import net.ent.etrs.ggef.model.dao.exceptions.DaoException;
import net.ent.etrs.ggef.model.entities.Patient;
import net.ent.etrs.ggef.model.references.constantes.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PatientMemDao extends AbstractPatientDao {

    private List<Patient> persistence = new ArrayList();

    protected PatientMemDao(){}


    @Override
    public boolean exist(Patient var1) throws DaoException {
        try {
            return persistence.contains(var1);
        } catch (Exception e) {
            throw new DaoException(ConstantesMetier.MSG_AUCUN_PATIENT, e);
        }
    }

    @Override
    public void update(Patient var1) throws DaoException {
        int idx = this.persistence.indexOf(var1);
        if (idx == 1) {
            throw new DaoException(ConstantesMetier.MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT);
        } else {
            this.persistence.set(idx, var1);
        }
    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        int IDX = 0;
        if (Objects.isNull(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
//        if (persistence.indexOf(var1)) {
//            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
//        }
 //       this.persistence.get(IDX).remove();

    }

    @Override
    public void delete(Patient var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_PATIENT_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        this.persistence.remove(var1);
    }

    @Override
    public Patient read(String var1) throws DaoException {
        return null;
    }

    @Override
    public void create(Patient var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        if (exist(var1)) {
            throw new DaoException(ConstantesMetier.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
        }
        this.persistence.add(var1);
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

}
