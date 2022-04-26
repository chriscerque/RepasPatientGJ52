package net.ent.etrs.pdi.vbt.model.entities;

import net.ent.etrs.pdi.vbt.model.entities.exceptions.PatientException;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.RepasException;
import net.ent.etrs.pdi.vbt.model.entities.references.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private EntitiesFactory() {}

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public static Repas fabriquerRepas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        return new Repas(dateRepas, typeRepas);
    }

    public static Patient fabriquerPatient(String numsec, String nom, String prenom, LocalDate dateEntree) throws PatientException {
        return new Patient(numsec, nom, prenom, dateEntree);
    }
}

