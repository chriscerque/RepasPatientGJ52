package net.ent.etrs.sgr.view;

import net.ent.etrs.sgr.model.entities.Patient;
import net.ent.etrs.sgr.model.entities.Repas;
import net.ent.etrs.sgr.model.exceptions.VueException;

import java.util.List;

public interface IFacadeVue {

    Patient saisirPatient() throws VueException;

    void afficherMessage(String str);

    void afficherPatient( Patient pat);

    List<Repas> selectionnerRepas(List<Repas> ls) throws VueException;

    void afficherMessageErreur(String st);

    int afficherMenu() throws VueException;

    Patient ajouterRepasPatient(List<Patient> lsP, List<Repas> lsR) throws VueException;

    Patient selectionnerPatient(List<Patient> ls) throws VueException;

    void afficherPatients(List<Patient> ls);

    Patient modifierPatient(Patient pat);
}
