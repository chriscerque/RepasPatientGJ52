package model.facade;

import model.entities.Patient;
import model.entities.Repas;
import model.facade.exceptions.MetierException;

import java.util.List;

public interface FacadeMetier {
    Patient recupererPatientById(String id) throws MetierException;
    void init();
    List<Repas> listerRepas();
    void supprimerPatient(Patient patient) throws MetierException;
    List<Patient> listerPatients();
    void sauvegarderPatient(Patient patient) throws MetierException;
    void mettreAJourPatient(Patient patient) throws MetierException;
}
