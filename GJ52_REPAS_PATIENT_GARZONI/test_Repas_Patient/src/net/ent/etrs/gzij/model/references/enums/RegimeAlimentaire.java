package net.ent.etrs.gzij.model.references.enums;

import net.ent.etrs.gzij.model.exceptions.RegimeAlimentaireException;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;

public enum RegimeAlimentaire {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
    VEGETARIEN("Végétarien"),
    MIXE("Mixe"),
    SANS_SEL("Sans sel"),
    DIABETIQUE("Diabétique"),
    VEGAN("Végan");


    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private String libelle;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/
    RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    /*----------------------
        ******** Getter ********
        ----------------------*/
    public String getLibelle() {
        return libelle;
    }
    
    /*------------------------------*
    ******** Autres methodes ********
    -------------------------------*/

    public static RegimeAlimentaire getRegimeAlimentaireByLibelle(final String unLibelle) throws RegimeAlimentaireException {

        for (RegimeAlimentaire enumRetour : RegimeAlimentaire.values()) {
            if (enumRetour.getLibelle().equals(unLibelle)) {
                return enumRetour;
            }
        }
        throw new RegimeAlimentaireException(C_MSG.REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION);
    }


}
