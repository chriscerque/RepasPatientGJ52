package net.ent.etrs.gzij.model.facades;

import net.ent.etrs.gzij.model.dao.DaoFactory;
import net.ent.etrs.gzij.model.dao.IPatientMemDao;
import net.ent.etrs.gzij.model.dao.IRepasMemDao;
import net.ent.etrs.gzij.model.dao.exceptions.DaoException;
import net.ent.etrs.gzij.model.entities.Patient;
import net.ent.etrs.gzij.model.entities.Repas;
import net.ent.etrs.gzij.model.exceptions.BusinessException;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;

import java.util.List;

public class FacadeMetierImpl implements IFacadeMetier{
/*----------------------
Attributs +0+1
-----------------------*/
    private IPatientMemDao patientDao;
    private IRepasMemDao repasDao;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected FacadeMetierImpl() {

    }

/*----------------------
AUTRES METHODES
-----------------------*/

    @Override
    public List<Patient> listerPatients() {
        return patientDao.readAll();
    }

    @Override
    public List<Repas> listerRepas() {
        return repasDao.readAll();
    }

    @Override
    public void sauvegarderPatient(final Patient patient) throws BusinessException {

    }

    @Override
    public void supprimerPatient(final Patient patient) throws BusinessException {
        try {
            patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_SUPPRESSION_EXCEPTION, patient.getPrenom(), patient.getNom()), e.getCause());
        }
    }

    @Override
    public void mettreAJourPatient(final Patient patient) throws BusinessException {
        try {
            patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(String.format(C_MSG.MSG_PATIENT_MISE_A_JOUR_EXCEPTION, patient.getPrenom(), patient.getNom()), e.getCause());
        }
    }

    @Override
    public void init() {
        repasDao = DaoFactory.fabriquerRepasDao();
        patientDao = DaoFactory.fabriquerPatientDao();

        repasDao.init();
        patientDao.init();
    }

    @Override
    public Patient recupererPatientById(final String patientId) throws BusinessException {
        try {
            return patientDao.read(patientId);
        } catch (DaoException e) {
            throw new BusinessException(C_MSG.MSG_PATIENT_RECHERCHE_EXCEPTION, e.getCause());
        }
    }
}  // fin de classe