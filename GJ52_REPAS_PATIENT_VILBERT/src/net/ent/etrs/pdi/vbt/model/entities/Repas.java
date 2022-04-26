package net.ent.etrs.pdi.vbt.model.entities;

import net.ent.etrs.pdi.vbt.model.entities.exceptions.RegimeAlimentaireException;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.RepasException;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;
import net.ent.etrs.pdi.vbt.model.entities.references.RegimeAlimentaire;
import net.ent.etrs.pdi.vbt.model.entities.references.TypeRepas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private LocalDate dateRepas;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    private String id;
    private TypeRepas typeRepas;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected Repas(LocalDate dateRepas, TypeRepas typeRepas) throws RepasException {
        this.id = UUID.randomUUID().toString();
        this.setDateRepas(dateRepas);
        this.setTypeRepas(typeRepas);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    SETTERS	                         				//
    //////////////////////////////////////////////////////////////////////////////////////////

    public void setDateRepas(LocalDate dateRepas) throws RepasException {
        if (Objects.isNull(dateRepas)) {
            throw new RepasException(C_MSG.REPAS_DATE_EXCEPTION);
        }
        this.dateRepas = dateRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
        if (Objects.isNull(typeRepas)) {
            throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }
        this.typeRepas = typeRepas;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    GETTERS					                      	//
    //////////////////////////////////////////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////SPECIFICS/////////////////////////////////////////

    //                                      TO STRING                                       //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repas{");
        sb.append("dateRepas=").append(dateRepas);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeRepas=").append(typeRepas);
        sb.append('}');
        return sb.toString();
    }


    //			                        EQUALS & HASH CODE					                //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repas repas = (Repas) o;
        return Objects.equals(id, repas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //////////////////////////////////////////OTHERS//////////////////////////////////////////

    /**
     * Méthode qui permet d'ajouter un régime alimentaire au repas
     * @param regimeAlimentaire : le régime alimentaire à ajouter
     * @throws RegimeAlimentaireException : retourne une erreur si le régime alimentaire est null ou s'il existe déjà
     */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws RegimeAlimentaireException {
        if (Objects.isNull(regimeAlimentaire)) {
            throw new RegimeAlimentaireException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if (this.lstRegimeAlimentaire.contains(regimeAlimentaire)) {
            throw new RegimeAlimentaireException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        } else {
            this.lstRegimeAlimentaire.add(regimeAlimentaire);
        }
    }
}
