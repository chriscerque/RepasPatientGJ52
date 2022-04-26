package model.entities;

import model.entities.exceptions.PatientException;
import model.entities.exceptions.RepasException;
import model.references.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {}

    public static Repas fabriquerRepas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        return new Repas(dateRepas, typeRepas);
    }

    public static Patient fabriquerPatient(String numSecu, String nom, String prenom, LocalDate dateEntree) throws PatientException {
        return new Patient(nom, prenom, numSecu, dateEntree);
    }
}
