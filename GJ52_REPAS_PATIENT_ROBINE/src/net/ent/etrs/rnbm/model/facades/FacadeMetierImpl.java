package net.ent.etrs.rnbm.model.facades;

import net.ent.etrs.rnbm.model.dao.DaoFactory;
import net.ent.etrs.rnbm.model.dao.IPatientMemDao;
import net.ent.etrs.rnbm.model.dao.IRepasMemDao;
import net.ent.etrs.rnbm.model.dao.exceptions.DaoException;
import net.ent.etrs.rnbm.model.entities.Patient;
import net.ent.etrs.rnbm.model.entities.Repas;
import net.ent.etrs.rnbm.model.facades.exceptions.BusinessException;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {

    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private final IPatientMemDao patientDao;
    private final IRepasMemDao repasDao;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected FacadeMetierImpl(){
        this.patientDao = DaoFactory.fabriquerPatientDao();
        this.repasDao = DaoFactory.fabriquerRepasDao();
    }

    /* ****************** */
    /* ***** GETTER ***** */

    /* ****************** */
    /* ***** SETTER ***** */

    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */

    /* ********************* */
    /* ***** TO STRING ***** */

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public List<Patient> listerPatients() {

        return patientDao.readAll();
    }

    @Override
    public List<Repas> listerRepas() {

        return repasDao.readAll();
    }

    @Override
    public void sauvegarderPatient( final Patient patient) throws BusinessException {
        try{
            patientDao.create(patient);

        } catch (DaoException e) {
           throw new BusinessException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try{
            if (patientDao.exist(patient)){
                patientDao.delete(patient);
            }
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e.getCause());
        }


    }

    @Override
    public void initialiserApplication() {
        patientDao.init();
        repasDao.init();


    }

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {
        Patient patient = null;
        for (Patient pat : patientDao.readAll()){
            if (pat.getId().equals(patientId)){

                patient = pat;
            }
        }
        return patient;
    }

}
