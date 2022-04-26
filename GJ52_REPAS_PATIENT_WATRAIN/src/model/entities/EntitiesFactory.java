package model.entities;

import model.entities.exceptions.PatientConstructionException;
import model.entities.exceptions.PatientException;
import model.entities.exceptions.RepasConstructionException;
import model.entities.exceptions.RepasException;
import model.references.TypeRepas;

import java.time.LocalDate;

/**
 * Regroupe les fabriques des entités métier.
 *
 */
public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Repas fabriquerRepas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasConstructionException {
        try {
            return new Repas(dateRepas, typeRepas);
        } catch (RepasException e) {
            throw new RepasConstructionException(e.getMessage());
        }
    }

    public static Patient fabriquerPatient(String numSecu, String nom, String prenom, LocalDate dateEntree) throws PatientConstructionException {
        try {
            return new Patient(nom, prenom, dateEntree, numSecu);
        } catch (PatientException e) {
            throw new PatientConstructionException(e.getMessage());
        }
    }
}
