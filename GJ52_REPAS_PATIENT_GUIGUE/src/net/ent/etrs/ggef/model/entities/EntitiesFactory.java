package net.ent.etrs.ggef.model.entities;

import net.ent.etrs.ggef.model.references.enumeration.TypeRepas;

import java.time.LocalDate;

public final class EntitiesFactory {

    /*--------------------------------
    Methodes permettant de faire appel 
    aux constructeurs des différentes 
    classes métierla construction
    --------------------------------*/

    public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas){
        return new Repas(dateRepas, typeRepas);
    }

    public static Patient fabriquerPatient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree ) {
       return new Patient(nom, prenom, dateEntree, numSecu);
    }

    /*----------------------
    ** Constructeur privé **
    -----------------------*/
    private EntitiesFactory() {
    }

}  // fin de classe
