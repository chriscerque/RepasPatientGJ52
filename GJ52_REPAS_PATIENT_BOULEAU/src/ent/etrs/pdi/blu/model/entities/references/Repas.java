package ent.etrs.pdi.blu.model.entities.references;

import ent.etrs.pdi.blu.model.entities.exceptions.PatientException;
import ent.etrs.pdi.blu.model.entities.exceptions.RepasException;
import ent.etrs.pdi.blu.model.references.C_MSG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {

////////////////////////////////////////////////////////////////////////////
//----------------------------- ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////


    private LocalDate dateRepas;
    private List<RegimeAlimentaire> listRegimeAlimentaires = new ArrayList<>();
    private String id;
    private TypeRepas typeRepas;



////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////

    public Repas(final LocalDate dateRepas, final TypeRepas typeRepas) {
        setDateRepas(dateRepas);
        setTypeRepas(typeRepas);
    }


////////////////////////////////////////////////////////////////////////////
//---------------------------- GETTER SETTER -----------------------------//
////////////////////////////////////////////////////////////////////////////



    public String getId() {
        return String.valueOf(UUID.randomUUID());
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public List<RegimeAlimentaire> getListRegimeAlimentaires() {
        return listRegimeAlimentaires;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }




    public void setDateRepas(LocalDate dateRepas) {
        this.dateRepas = dateRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) {
        this.typeRepas = typeRepas;
    }


    ////////////////////////////////////////////////////////////////////////////
//----------------------------- EQUAL H-CODE -----------------------------//
////////////////////////////////////////////////////////////////////////////

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


////////////////////////////////////////////////////////////////////////////
//-------------------------- AUTRES METHODES -----------------------------//
////////////////////////////////////////////////////////////////////////////


    /**
     * methode permettant d'ajouter un RegimeAlimentaire a la liste RegimeAlimentaire REPAS
     * @param regAlim
     * @throws PatientException
     */

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regAlim) throws RepasException {
        if(this.listRegimeAlimentaires.contains(regAlim)) {
            throw new RepasException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
            if (Objects.isNull(regAlim)){
            throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }

        this.listRegimeAlimentaires.add(regAlim);

    }

}

////////////////////////////////////////////////////////////////////////////
//----------------------------- TO STRING --------------------------------//
////////////////////////////////////////////////////////////////////////////

