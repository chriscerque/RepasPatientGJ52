package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.entities.exceptions.RepasException;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;
import ent.etrs.pdi.pre.model.entities.references.RegimeAlimentaire;
import ent.etrs.pdi.pre.model.entities.references.TypeRepas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {
    /*------- ATTRIBUTS -------*/
    private String id;
    private LocalDate dateRepas;
    private TypeRepas typeRepas;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    public Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        this.setDateRepas(dateRepas);
        this.setTypeRepas(typeRepas);
        this.id = UUID.randomUUID().toString();
    }

    /*------- ASCESSEURS -------*/
    // GETTER
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

    // SETTER
    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if (Objects.isNull(dateRepas)){
            throw new RepasException(ConstantesModel.REPAS_DATE_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if (Objects.isNull(typeRepas)){
            throw new RepasException(ConstantesModel.REPAS_TYPE_REPAS_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }

    /*------- EQUALS / HASH CODE -------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repas repas = (Repas) o;
        return Objects.equals(getId(), repas.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /*------- TO STRING -------*/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repas{");
        sb.append("id='").append(id).append('\'');
        sb.append(", dateRepas=").append(dateRepas);
        sb.append(", typeRepas=").append(typeRepas);
        sb.append('}');
        return sb.toString();
    }

    /*------- AUTRES METHODES -------*/
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regime){
        if (!lstRegimeAlimentaire.contains(regime)){
            lstRegimeAlimentaire.add(regime);
        }
    }
}
