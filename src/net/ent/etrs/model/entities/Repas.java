package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.RepasException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.model.references.RegimeAlimentaire;
import net.ent.etrs.model.references.TypeRepas;

import java.time.LocalDate;
import java.util.*;

public class Repas {

    private final String id = UUID.randomUUID().toString();


    private LocalDate dateRepas;


    private TypeRepas typeRepas;

    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();

    protected Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        this.setDateRepas(dateRepas);
        this.setTypeRepas(typeRepas);
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return Collections.unmodifiableList(lstRegimeAlimentaire);
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) {
        this.lstRegimeAlimentaire.add(regimeAlimentaire);
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if (Objects.isNull(dateRepas)) {
            throw new RepasException(C_MSG.REPAS_DATE_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if (Objects.isNull(typeRepas)) {
            throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repas)) return false;
        Repas repas = (Repas) o;
        return Objects.equals(id, repas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
