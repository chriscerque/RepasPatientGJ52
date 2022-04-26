package net.ent.etrs.rnbm.model.entities;

import net.ent.etrs.rnbm.model.exceptions.PatientConstructionException;
import net.ent.etrs.rnbm.model.exceptions.PatientException;
import net.ent.etrs.rnbm.model.exceptions.RepasConstructionException;
import net.ent.etrs.rnbm.model.exceptions.RepasException;
import net.ent.etrs.rnbm.model.references.enumerateds.TypeRepas;

import java.time.LocalDate;

public final class FactoryMetier {

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryMetier() {
    }

    /* ******************* */
    /* ***** FACTORY ***** */
    //Factory pour l'instanciation d'un patient
    public static Patient fabriquerPatient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) throws PatientConstructionException {
        return new Patient(nom, prenom, dateEntree, numSecu);
    }

    //Factory pour l'instanciaton d'un repas
    public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasConstructionException {
        return new Repas(dateRepas, typeRepas);
    }


}
