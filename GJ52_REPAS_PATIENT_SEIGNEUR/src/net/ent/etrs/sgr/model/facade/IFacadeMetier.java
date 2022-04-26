package net.ent.etrs.sgr.model.facade;

import net.ent.etrs.sgr.model.entities.Patient;
import net.ent.etrs.sgr.model.entities.Repas;
import net.ent.etrs.sgr.model.exceptions.BusinessException;

import java.util.List;

public interface IFacadeMetier {

    Patient recupererPatientById(String id);

    void init();

    List<Repas> listerRepas();

    void supprimerPatient(Patient pat) throws BusinessException;

    List<Patient> listerPatients();

    void sauvegarderPatient(Patient pat) throws BusinessException;

    void mettreAJourPatient(Patient pat) throws BusinessException;
}
