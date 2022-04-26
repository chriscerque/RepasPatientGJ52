package ent.etrs.pdi.hllf.model.facade.facadeImpl;

import ent.etrs.pdi.hllf.business.exceptions.BusinessException;
import ent.etrs.pdi.hllf.model.dao.DaoFactory;
import ent.etrs.pdi.hllf.model.dao.IPatientMemDao;
import ent.etrs.pdi.hllf.model.dao.IRepasMemDao;
import ent.etrs.pdi.hllf.model.dao.exceptions.DaoException;
import ent.etrs.pdi.hllf.model.entities.Patient;
import ent.etrs.pdi.hllf.model.entities.Repas;
import ent.etrs.pdi.hllf.model.facade.FacadeMetier;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;

import java.util.ArrayList;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    //attributs
    private IPatientMemDao patientDao;
    private IRepasMemDao repasDao;

    //constructeurs
    public FacadeMetierImpl() {
        patientDao = DaoFactory.fabriquerPatientDao();
        repasDao = DaoFactory.fabriquerRepasDao();
    }

    //methodes
    @Override
    public Patient recupererPatientById(String id) throws BusinessException {
        Patient retour = null;
        try {
            retour = patientDao.read(id);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
        return retour;
    }

    @Override
    public void init() throws BusinessException {
        try {
            patientDao.init();
            repasDao.init();
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Repas> listerRepas() {
        return repasDao.readAll();
    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Patient> listerPatient() {
        return patientDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {
        try {
            patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) {
        patientDao.update(patient);
    }

    public List<RegimeAlimentaire> listerRegimes()
    {
        List<RegimeAlimentaire> retour = new ArrayList<>();
        for (int i = 0; i < RegimeAlimentaire.values().length-1; i++) {
            retour.add(RegimeAlimentaire.values()[i]);
        }
        return retour;
    }
}
