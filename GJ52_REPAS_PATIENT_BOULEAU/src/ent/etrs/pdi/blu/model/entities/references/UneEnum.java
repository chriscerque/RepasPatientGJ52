package ent.etrs.pdi.blu.model.entities.references;

import javax.management.relation.Role;

public enum UneEnum {

    //exemple enum

    UN,
    DEUX,
    TROIS,
    QUATRE,
    CINQ;


    //exemple enum complexe

    /**
     * Liste des types de reseau
     * comprend un type string pour libelle et un type int pour code.
     */

    public enum TypeReseau {
        INTERNET("Intradef",01),
        INTERNUS("IntraNUS",02),
        INTRADEF("Internet",03);


        private final String libelle;
        private final int code;

        TypeReseau(String libelle, int code) {
            this.libelle = libelle;
            this.code = code;
        }

    }

}
