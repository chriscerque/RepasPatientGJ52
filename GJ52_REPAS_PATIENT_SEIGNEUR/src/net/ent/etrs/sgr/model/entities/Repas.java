package net.ent.etrs.sgr.model.entities;

import net.ent.etrs.sgr.model.exceptions.RepasException;
import net.ent.etrs.sgr.model.references.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {

    private LocalDate dateRepas;
    private List<RegimeAlimentaire> lsRegimeAlimentaire = new ArrayList<>();
    private String id = UUID.randomUUID().toString();
    private TypeRepas typeRepas;

    public Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        setDateRepas(dateRepas);
        setTypeRepas(typeRepas);
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public List<RegimeAlimentaire> getLsRegimeAlimentaire() {
        return lsRegimeAlimentaire;
    }

    public String getId() {
        return id;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    public void setDateRepas(LocalDate dateRepas) throws RepasException {

        if (Objects.isNull(dateRepas)){
            throw new RepasException(C.MSG_DATE_REPAS_NULL_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if (Objects.isNull(typeRepas)){
            throw new RepasException(C.MSG_TYPE_REPAS_NULL_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire reg) throws RepasException {

        RegimeAlimentaire newReg = null;

        if (Objects.isNull(reg)){
            throw new RepasException(C.MSG_REPAS_REGIME_NULL);
        }
        if (this.lsRegimeAlimentaire.contains(reg)){
            throw new RepasException(C.MSG_REGIME_REPAS_DOUBLON);
        }

        this.lsRegimeAlimentaire.add(reg);
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repas{");
        sb.append("dateRepas=").append(dateRepas);
        sb.append(", lsRegimeAlimentaire=").append(lsRegimeAlimentaire);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeRepas=").append(typeRepas);
        sb.append('}');
        return sb.toString();
    }
}
