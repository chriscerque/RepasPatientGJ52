package net.ent.etrs.sgr.model.entities;

import net.ent.etrs.sgr.model.exceptions.PatientConstructionException;
import net.ent.etrs.sgr.model.exceptions.PatientException;
import net.ent.etrs.sgr.model.exceptions.RepasConstructionException;
import net.ent.etrs.sgr.model.exceptions.RepasException;

import java.time.LocalDate;

public class EntitiesFactory {

    public EntitiesFactory() {
    }

    public static Repas fabriquerRepas(LocalDate date, TypeRepas repas) throws RepasConstructionException {
        try {
            return new Repas(date, repas);
        } catch (RepasException e) {
            throw new RepasConstructionException(e.getMessage(),e);
        }
    }

    public static Patient fabriquerPatient(String num, String nom, String pre, LocalDate entree) throws PatientConstructionException {
        try {
            return new Patient(num, nom, pre, entree);
        } catch (PatientException e) {
            throw new PatientConstructionException(e.getMessage(), e);
        }
    }
}
