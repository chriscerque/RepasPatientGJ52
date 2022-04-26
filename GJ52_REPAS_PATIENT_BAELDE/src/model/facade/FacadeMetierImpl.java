package model.facade;

import model.dao.DaoFactory;
import model.dao.IPatientMemDao;
import model.dao.IRepasMemDao;
import model.dao.exceptions.DaoException;
import model.entities.Patient;
import model.entities.Repas;
import model.facade.exceptions.MetierException;
import model.references.C_MSG;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private IPatientMemDao patientDao;
    private IRepasMemDao repasDao;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected FacadeMetierImpl() {
        this.patientDao = DaoFactory.fabriquerPatientDao();
        this.repasDao = DaoFactory.fabriquerRepasDao();
    }

    // +-------------------------------------------+
    // |                 METHODES                  |
    // +-------------------------------------------+

    @Override
    public void init() {
        this.repasDao.init();
        this.patientDao.init();
    }

    @Override
    public Patient recupererPatientById(String id) throws MetierException {
        try {
            return this.patientDao.read(id);
        } catch (DaoException e) {
            throw new MetierException(e.getMessage());
        }
    }

    @Override
    public List<Repas> listerRepas() {
        return this.repasDao.readAll();
    }

    @Override
    public List<Patient> listerPatients() {
        return this.patientDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws MetierException {
        try {
            this.patientDao.create(patient);
        } catch (DaoException e) {
            throw new MetierException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws MetierException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new MetierException(e.getMessage());
        }
    }

    @Override
    public void supprimerPatient(Patient patient) throws MetierException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new MetierException(e.getMessage());
        }
    }
}
