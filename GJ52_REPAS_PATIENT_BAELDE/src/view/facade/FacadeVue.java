package view.facade;

import model.entities.Patient;
import model.entities.Repas;
import view.facade.exceptions.VueException;

import java.util.List;

public interface FacadeVue {
    Patient saisirPatient() throws VueException;
    void afficherMessage(String message);
    void afficherPatient(Patient patient);
    List<Repas> selectionnerRepas(List<Repas> lstRepas);
    void afficherMessageErreur(String message);
    int afficherMenu();
    Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> lstRepas);
    Patient selectionnerPatient(List<Patient> lstPatients);
    void afficherPatients(List<Patient> lstPatients);
}
