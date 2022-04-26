package net.ent.etrs.model.entities;


import net.ent.etrs.model.exceptions.RepasException;
import net.ent.etrs.model.references.C_MSG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {
    /////ATTRIBUTS/////
    private String id;
    private LocalDate dateRepas;
    private TypeRepas typeRepas;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();

    /////CONSTRUCTEUR/////
    public Repas(LocalDate dateRepas, TypeRepas typeRepas) {
        try {
            this.setDateRepas(dateRepas);
            this.setTypeRepas(typeRepas);
            this.id = String.valueOf(UUID.randomUUID());
        } catch (RepasException e) {
            System.out.println(e.getMessage());
        }
    }

    /////ACCESSEURS/////
    //GETTER//
    public String getId() {
        return id;
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return lstRegimeAlimentaire;
    }

    //SETTER//
    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if(Objects.isNull(dateRepas))
        {
            throw new RepasException(C_MSG.MSG_DATE_REPAS_NULL);
        }
        this.dateRepas = dateRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if(Objects.isNull(typeRepas))
        {
            throw new RepasException(C_MSG.MSG_TYPE_REPAS_NULL);
        }
        this.typeRepas = typeRepas;
    }

    /////IDENTITY/////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repas repas = (Repas) o;
        return id.equals(repas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /////METHODES/////
    /**
     * Méthode permettant d'ajouter un régime alimentaire à la liste des régimes alimentaires du repas.
     * @param regimeAlimentaire: RegimeAlimentaire
     * @throws RepasException si le régime alimentaire est déjà présent dans la liste des régime alimentaires du repas.
     */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws RepasException {
        if(lstRegimeAlimentaire.contains(regimeAlimentaire))
        {
            throw new RepasException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
            this.lstRegimeAlimentaire.add(regimeAlimentaire);
    }
}
