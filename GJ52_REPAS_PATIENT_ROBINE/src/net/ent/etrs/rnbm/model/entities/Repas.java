package net.ent.etrs.rnbm.model.entities;

import net.ent.etrs.rnbm.model.exceptions.RepasConstructionException;
import net.ent.etrs.rnbm.model.exceptions.RepasException;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;
import net.ent.etrs.rnbm.model.references.enumerateds.RegimeAlimentaire;
import net.ent.etrs.rnbm.model.references.enumerateds.TypeRepas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private LocalDate dateRepas;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    private String id = UUID.randomUUID().toString();
    private TypeRepas typeRepas;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected Repas( final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasConstructionException {
        this.setDateRepas(dateRepas);
        this.setTypeRepas(typeRepas);
    }

    /* ****************** */
    /* ***** GETTER ***** */
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
    /* ****************** */
    /* ***** SETTER ***** */

    public void setDateRepas(LocalDate dateRepas) throws RepasConstructionException {
        if (Objects.isNull(dateRepas)){
            throw new RepasConstructionException(C_MSG.REPAS_DATE_EXCEPTION_NULL);
        }
        this.dateRepas = dateRepas;
    }

    public void setLstRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) {
        //TODO setter list regime alimentaire repas
        this.lstRegimeAlimentaire = lstRegimeAlimentaire;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasConstructionException {
        if (Objects.isNull(typeRepas)){
            throw new RepasConstructionException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION_NULL);
        }
        this.typeRepas = typeRepas;
    }
    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */
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
    /* ********************* */
    /* ***** TO STRING ***** */

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regime){

        lstRegimeAlimentaire.add(regime);
    }

}
