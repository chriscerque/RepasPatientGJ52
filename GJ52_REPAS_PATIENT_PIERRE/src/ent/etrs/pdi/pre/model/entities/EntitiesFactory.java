package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.entities.exceptions.ModelException;
import ent.etrs.pdi.pre.model.entities.exceptions.PatientException;
import ent.etrs.pdi.pre.model.entities.exceptions.RepasException;
import ent.etrs.pdi.pre.model.entities.references.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private EntitiesFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static Model fabriquerModel(final String id) throws ModelException {
        return new Model(id);
    }

    public static Patient fabriquerPatient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) throws PatientException {
        return new Patient(nom, prenom, numSecu, dateEntree);
    }

    public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {
        return new Repas(dateRepas, typeRepas);
    }
}
