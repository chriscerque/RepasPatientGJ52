package ent.etrs.pdi.blu.model.entities;

import ent.etrs.pdi.blu.model.entities.exceptions.ModelException;
import ent.etrs.pdi.blu.model.entities.references.ConstantesModel;

import java.util.Objects;

public class Model {
    /*------- ATTRIBUTS -------*/
    private String id;

    /*------- CONSTRUCTEUR(S) -------*/
    public Model(String id) throws ModelException {
        this.setId(id);
    }

    /*------- ASCESSEURS -------*/
    // GETTER
    public String getId() {
        return id;
    }

    // SETTER
    public void setId(String id) throws ModelException {
        if (Objects.isNull(id)) {
            throw new ModelException(ConstantesModel.MSG_ID_NULL_EXCEPTION);
        }
        this.id = id;
    }

    /*------- EQUALS / HASH CODE -------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model entitie = (Model) o;
        return Objects.equals(getId(), entitie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /*------- TO STRING -------*/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entitie{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /*------- AUTRES METHODES -------*/
}
