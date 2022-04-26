package ent.etrs.pdi.hllf.model.entities;

import ent.etrs.pdi.hllf.model.exceptions.PatientConstructionException;
import ent.etrs.pdi.hllf.model.exceptions.PatientException;
import ent.etrs.pdi.hllf.model.exceptions.RepasConstructionException;
import ent.etrs.pdi.hllf.model.exceptions.RepasException;
import ent.etrs.pdi.hllf.model.references.TypeRepas;

import java.time.LocalDate;

public class EntitiesFactory
{
    private EntitiesFactory() {}
    public static Repas fabriquerRepas(LocalDate date, TypeRepas typeRepas) throws RepasConstructionException {
        try {
            return new Repas(date, typeRepas);
        } catch (RepasException e) {
            throw new RepasConstructionException(e.getMessage());
        }
    }

    public static Patient fabriquerPatient(String numsecu, String nom, String prenom, LocalDate date) throws PatientConstructionException {
        try {
            return new Patient(nom, prenom, numsecu, date);
        } catch (PatientException e) {
            throw new PatientConstructionException(e.getMessage());
        }
    }
}
