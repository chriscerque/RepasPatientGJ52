package ent.etrs.pdi.blu.model.facades;

import ent.etrs.pdi.blu.model.dao.AbstractPatientDao;
import ent.etrs.pdi.blu.model.dao.AbstractRepasDao;
import ent.etrs.pdi.blu.model.dao.DaoFactory;
import ent.etrs.pdi.blu.model.dao.exceptions.DaoException;
import ent.etrs.pdi.blu.model.entities.Patient;
import ent.etrs.pdi.blu.model.entities.references.ConstantesModel;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.model.facades.exceptions.BusinessException;
import ent.etrs.pdi.blu.model.facades.exceptions.BusinessExceptionNus;

import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    /*------- ATTRIBUTS -------*/

    private AbstractPatientDao patientDao = DaoFactory.fabriquerPatientDao();
    private AbstractRepasDao repasDao = DaoFactory.fabriquerRepaslDao();

    /*------- CONSTRUCTEUR(S) -------*/
    protected FacadeMetierImpl(){}

    /*------- METHODES IMPLEMENTEES -------*/

    /**
     * init de l'application avec les données enregisrée
     */

    @Override
    public void init() {
        patientDao.init();
        repasDao.init();
    }

    /**
     * methode permettant recup du patient par son id
     * @param patientId
     * @return
     * @throws BusinessException
     */

    @Override
    public Patient recupererPatientById(String patientId) throws BusinessException {

        try {
            return patientDao.read(patientId);
        } catch (DaoException e) {
            throw new BusinessException("ERR");
        }
    }

    /**
     * methode permettant de lister les patients
     * @return
     */


    @Override
    public List<Patient> listerPatients() {
        return this.patientDao.readAll();
    }

    /**
     * methode permettant de lister les repas
     * @return
     */

    @Override
    public List<Repas> listerRepas() {
        return this.repasDao.readAll();
    }

    @Override
    public void sauvegarderPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.create(patient);
        } catch (DaoException e) {
            throw new BusinessException("ERR");
        }
    }

    @Override
    public void supprimerPatient(Patient patient) throws BusinessException {
        try {
            this.patientDao.delete(patient);
        } catch (DaoException e) {
            throw new BusinessException("ERR");
        }
    }

    @Override
    public void mettreAJourPatient(Patient patient) throws BusinessException{
        try {
            this.patientDao.update(patient);
        } catch (DaoException e) {
            throw new BusinessException("ERR");
        }
    }


}
