package ent.etrs.pdi.blu.model.entities;

import ent.etrs.pdi.blu.model.entities.exceptions.*;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.model.entities.references.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private EntitiesFactory() {
    }

    /*------- AUTRES METHODES -------*/

      public static Patient fabriquerPatient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) throws PatientException, PatientConstructionException {
        return new Patient(numSecu, nom, prenom, dateEntree);
    }

          public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas)  throws RepasException, RepasConstructionException {
        return new Repas(dateRepas, typeRepas);
    }


}
