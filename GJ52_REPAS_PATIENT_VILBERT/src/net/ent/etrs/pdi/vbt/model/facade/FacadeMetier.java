package net.ent.etrs.pdi.vbt.model.facade;

import net.ent.etrs.pdi.vbt.model.dao.exceptions.DaoException;
import net.ent.etrs.pdi.vbt.model.entities.Patient;
import net.ent.etrs.pdi.vbt.model.entities.Repas;
import net.ent.etrs.pdi.vbt.model.facade.exceptions.BusinessException;

import java.util.List;

/**
 * Façade métier proposant les opérations utiles
 * à l'application.
 * @author christophe.cerqueira
 *
 */
public interface FacadeMetier {

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Renvoi la liste de tous les patients.
     * @return la liste de patients.
     */
    List<Patient> listerPatients();

    /**
     * Renvoi la liste de tous les repas.
     * @return la liste des repas.
     */
    List<Repas> listerRepas();

    /**
     * Sauvegarge un patient dans l'application.
     * @param patient le patient à sauvegarder.
     */
    void sauvegarderPatient(Patient patient) throws BusinessException;

    /**
     * Supprime un patient dans l'application;
     * @param patient le patient à supprimer
     */
    void supprimerPatient(Patient patient) throws BusinessException;

    /**
     * Met à jour un patient dans l'application.
     * @param patient le patient à mettre à jour.
     */
    void mettreAJourPatient(Patient patient) throws BusinessException;

    void init();

    Patient recupererPatientById(String patientId) throws BusinessException;

}
