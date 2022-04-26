package ent.etrs.pdi.pre.model.facades;

import ent.etrs.pdi.pre.model.entities.Patient;
import ent.etrs.pdi.pre.model.entities.Repas;
import ent.etrs.pdi.pre.model.facades.exceptions.BusinessException;

import java.util.List;

public interface FacadeMetier {

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
     * @throws BusinessException si le patient existe déjà ou une erreur est levée durant la sauvegarde.
     */
    void sauvegarderPatient(Patient patient) throws BusinessException;

    /**
     * Supprime un patient dans l'application;
     * @param patient le patient à supprimer
     * @throws BusinessException si le patient n'existe pas ou une erreur est levée durant la suppression.
     */
    void supprimerPatient(Patient patient) throws BusinessException;

    /**
     * Met à jour un patient dans l'application.
     * @param patient le patient à mettre à jour.
     * @throws BusinessException si le patient n'existe pas ou une erreur est levée durant la mise à jour.
     */
    void mettreAJourPatient(Patient patient) throws BusinessException;

    void init();

    Patient recupererPatientById(String patientId) throws BusinessException;
}
