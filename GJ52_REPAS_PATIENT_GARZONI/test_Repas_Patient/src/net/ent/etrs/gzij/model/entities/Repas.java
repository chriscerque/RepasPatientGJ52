package net.ent.etrs.gzij.model.entities;

import net.ent.etrs.gzij.model.dao.commons.ID;
import net.ent.etrs.gzij.model.exceptions.RepasException;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;
import net.ent.etrs.gzij.model.references.enums.RegimeAlimentaire;
import net.ent.etrs.gzij.model.references.enums.TypeRepas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas implements ID<String> {
/*----------------------
Attributs +0+1
-----------------------*/
    private LocalDate dateRepas;
    private List<RegimeAlimentaire> lsRegimeAlimentaire;
    private String id;
    private TypeRepas typeRepas;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected Repas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {
        this.setDateRepas(dateRepas);
        this.setId(UUID.randomUUID().toString());
        this.setTypeRepas(typeRepas);
        this.lsRegimeAlimentaire = new ArrayList<>();
    }
    /*----------------------
GETTERS
-----------------------*/

    @Override
    public String getId() {
        return this.id;
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public List<RegimeAlimentaire> getLsRegimeAlimentaire() {
        return lsRegimeAlimentaire;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    /*----------------------
SETTERS
-----------------------*/

    public void setDateRepas(final LocalDate dateRepas) throws RepasException {
        if(Objects.isNull(dateRepas)) {
            throw new RepasException(C_MSG.REPAS_DATE_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public void setId(final String id) throws RepasException {
        if(Objects.isNull(id)) {
            throw new RepasException();
        }
        this.id = id;
    }

    public void setTypeRepas(final TypeRepas typeRepas) throws RepasException {
        if(Objects.isNull(typeRepas)) {
            throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }
    /*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repas)) return false;
        Repas repas = (Repas) o;
        return getId().equals(repas.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

/*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Repas{");
        sb.append("dateRepas=").append(dateRepas);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeRepas=").append(typeRepas);
        sb.append('}');
        return sb.toString();
    }

    /*----------------------
AUTRES METHODES
-----------------------*/
    public void ajouterRegimeAlimentaire(final RegimeAlimentaire regime) throws RepasException {
        if(Objects.isNull(regime)) {
            throw new RepasException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if(this.lsRegimeAlimentaire.contains(regime)) {
            throw new RepasException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lsRegimeAlimentaire.add(regime);
    }


}  // fin de classe
