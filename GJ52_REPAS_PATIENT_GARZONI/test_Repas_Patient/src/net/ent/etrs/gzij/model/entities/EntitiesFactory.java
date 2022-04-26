package net.ent.etrs.gzij.model.entities;

import net.ent.etrs.gzij.model.exceptions.PatientException;
import net.ent.etrs.gzij.model.exceptions.RepasException;
import net.ent.etrs.gzij.model.references.enums.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {

    /*--------------------------------
    Methodes permettant de faire appel 
    aux constructeurs des différentes 
    classes métierla construction
    --------------------------------*/
    public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {
        return new Repas(dateRepas, typeRepas);
    }


    /*----------------------
    ** Constructeur privé **
    -----------------------*/
    private EntitiesFactory() {
    }

    public static Patient fabriquerPatient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) throws PatientException {
        return new Patient(nom, prenom, dateEntree, numSecu);
    }
}  // fin de classe
