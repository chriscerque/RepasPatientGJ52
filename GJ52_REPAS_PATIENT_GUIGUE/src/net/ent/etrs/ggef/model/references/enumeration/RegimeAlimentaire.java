package net.ent.etrs.ggef.model.references.enumeration;

import net.ent.etrs.ggef.model.exceptions.RegimeAlimentaireException;
import net.ent.etrs.ggef.model.references.constantes.ConstantesMetier;

public enum RegimeAlimentaire {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
    VEGETARIEN("Végétarien"),
    MIXTE("Mixte"),
    SANS_SEL("Sans sel"),
    DIABETIQUE("Diabetique"),
    VEGAN("Végan");


    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private String libelle;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/

    private RegimeAlimentaire(final String libelle) {
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

    public static RegimeAlimentaire getByLibelle(final String unLibelle) throws RegimeAlimentaireException {

        for (RegimeAlimentaire enumRetour : RegimeAlimentaire.values()) {
            if (enumRetour.getLibelle().equals(unLibelle)) {
                return enumRetour;
            }
        }
        throw new RegimeAlimentaireException(ConstantesMetier.REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION);
    }




}
