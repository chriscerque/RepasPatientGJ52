package model.entities;

import model.entities.exceptions.RepasException;
import model.references.C_MSG;
import model.references.RegimeAlimentaire;
import model.references.TypeRepas;

import java.time.LocalDate;
import java.util.*;

public class Repas {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private LocalDate dateRepas;
    private List<RegimeAlimentaire> lstRegimeAlimentaire;
    private String id;
    private TypeRepas typeRepas;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        this.setDateRepas(dateRepas);
        this.lstRegimeAlimentaire = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
        this.setTypeRepas(typeRepas);
    }

    // +-------------------------------------------+
    // |              GETTERS SETTERS              |
    // +-------------------------------------------+

    public LocalDate getDateRepas() {
        return this.dateRepas;
    }

    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if (Objects.isNull(dateRepas)) {
            throw new RepasException(C_MSG.REPAS_DATE_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return Collections.unmodifiableList(this.lstRegimeAlimentaire);
    }

    public String getId() {
        return this.id;
    }

    public TypeRepas getTypeRepas() {
        return this.typeRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if (Objects.isNull(typeRepas)) {
            throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }

    // +-------------------------------------------+
    // |                HASH EQUALS                |
    // +-------------------------------------------+

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repas repas = (Repas) o;
        return Objects.equals(this.id, repas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // +-------------------------------------------+
    // |                 TO STRING                 |
    // +-------------------------------------------+

    // +-------------------------------------------+
    // |              AUTRES METHODES              |
    // +-------------------------------------------+

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regime) throws RepasException {
        if (Objects.isNull(regime)) {
            throw new RepasException(C_MSG.REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if (this.lstRegimeAlimentaire.contains(regime)) {
            throw new RepasException(C_MSG.REPAS_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lstRegimeAlimentaire.add(regime);
    }
}
