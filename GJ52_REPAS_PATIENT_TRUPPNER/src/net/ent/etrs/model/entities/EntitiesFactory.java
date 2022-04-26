package net.ent.etrs.model.entities;

import java.time.LocalDate;

public class EntitiesFactory {
    /////CONSTRUCTEUR/////
    private EntitiesFactory(){}

    /////METHODES/////
    public static Repas fabriquerRepas(LocalDate dateRepas, TypeRepas typeRepas)
    {
        return new Repas(dateRepas, typeRepas);
    }

    public static Patient fabriquerPatient(String numSecu, String nom, String prenom, LocalDate dateEntree)
    {
        return new Patient(nom, prenom, numSecu, dateEntree);
    }
}
