package net.ent.etrs.ggef.model.entities;

import net.ent.etrs.ggef.model.exceptions.RepasException;
import net.ent.etrs.ggef.model.references.constantes.ConstantesMetier;
import net.ent.etrs.ggef.model.references.enumeration.RegimeAlimentaire;
import net.ent.etrs.ggef.model.references.enumeration.TypeRepas;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {
/*----------------------
Attributs +0+1
-----------------------*/
private LocalDate dateRepas;
private List<RegimeAlimentaire> lstRegimeAlimentaire;
private String id;
private TypeRepas typeRepas;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    public Repas(LocalDate dateRepas, TypeRepas typeRepas) {
        id = UUID.randomUUID().toString();
        setDateRepas(dateRepas);
        setTypeRepas(typeRepas);
    }
/*----------------------
GETTERS
-----------------------*/

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return lstRegimeAlimentaire;
    }

    public String getId() {
        return id;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }
/*----------------------
SETTERS
-----------------------*/

    public void setDateRepas(LocalDate dateRepas) {
        this.dateRepas = dateRepas;
    }

    private void setId(String id) {
        this.id = id;
    }

    public void setTypeRepas(TypeRepas typeRepas) {
        this.typeRepas = typeRepas;
    }
/*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
        final StringBuilder sb = new StringBuilder("Repas{");
        sb.append("dateRepas=").append(dateRepas);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeRepas=").append(typeRepas);
        sb.append('}');
        return sb.toString();
    }
/*----------------------
AUTRES METHODES
-----------------------*/

    public void ajouterRegimeAlimentaire(RegimeAlimentaire unRegimeAlimentaire) throws RepasException {
        if (this.lstRegimeAlimentaire.contains(unRegimeAlimentaire)) {
            throw new RepasException(ConstantesMetier.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lstRegimeAlimentaire.add(unRegimeAlimentaire);
    }




}  // fin de classe

//TODO: Création Class Repas
// 1-Attributs
// 2-GETTERS
// 3-SETTERS + REGLES DE GESTION
// 4-CONSTRUCTEUR - utiliser les SETTERS
// 5-EQUALS&HASHCODE
// 6-TOSTRING() - avec StringBuilder