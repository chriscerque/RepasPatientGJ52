package ent.etrs.pdi.hllf.model.entities;

import ent.etrs.pdi.hllf.model.exceptions.RepasException;
import ent.etrs.pdi.hllf.model.references.C_MODEL;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;
import ent.etrs.pdi.hllf.model.references.TypeRepas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas
{
    //attributs
    private LocalDate dateRepas;
    private List<RegimeAlimentaire> listRegimeAlimentaire;
    private String id;
    private TypeRepas typeRepas;

    //constructeur
    public Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        this.id = UUID.randomUUID().toString();
        listRegimeAlimentaire = new ArrayList<>();
        this.setDateRepas(dateRepas);
        this.setTypeRepas(typeRepas);
    }

    //accesseurs
    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if(Objects.isNull(dateRepas))
        {
            throw new RepasException(C_MODEL.ERR_REPAS_DATE_NULL);
        }
        this.dateRepas = dateRepas;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if(Objects.isNull(typeRepas))
        {
            throw new RepasException(C_MODEL.ERR_REPAS_TYPE_NULL);
        }
        this.typeRepas = typeRepas;
    }

    public String getId() {
        return id;
    }

    public List<RegimeAlimentaire> getListRegimeAlimentaire() {
        return listRegimeAlimentaire;
    }

    //methodes
    public void ajouterRegimeAlimentaire (RegimeAlimentaire regimeAlimentaire) throws RepasException {
        if(Objects.isNull(regimeAlimentaire))
        {
            throw new RepasException(C_MODEL.ERR_REPAS_REGIME_NULL);
        }
        if(this.listRegimeAlimentaire.contains(regimeAlimentaire))
        {
            throw new RepasException(C_MODEL.ERR_REPAS_REGIME_DOUBLE);
        }

        this.listRegimeAlimentaire.add(regimeAlimentaire);
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
}
