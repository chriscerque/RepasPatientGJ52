package net.ent.etrs.rnbm.model.references.enumerateds;

import net.ent.etrs.rnbm.model.commons.references.constantes.ConstantesMetier;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;
import net.ent.etrs.rnbm.model.references.exceptions.RegimeAlimentaireException;

public enum RegimeAlimentaire {

    /* *********************** */
    /* ****** List ENUM ****** */
    VEGETARIEN("Vegetarien"),
    MIXE("Mixe"),
    SANS_SEL("Sans_sel"),
    DIABETIQUE("Diabetique"),
    VEGAN("Vegan");


    /* *********************** */
    /* ****** Attributs ****** */
   private final String libelle;

    /* *************************** */
    /* ****** Constructeurs ****** */
    RegimeAlimentaire( final String libelle) {
        this.libelle = libelle;
    }

    /* ******************** */
    /* ****** Getter ****** */
    public String getLibelle() {
        return libelle;
    }

    /* ***************************** */
    /* ****** AUTRES METHODES ****** */

    public static RegimeAlimentaire getRegimeAlimentaireByLibelle(final String unLibelle) throws RegimeAlimentaireException {

        for (RegimeAlimentaire enumRetour : RegimeAlimentaire.values()) {
            if (enumRetour.getLibelle().equals(unLibelle)) {
                return enumRetour;
            }
        }
        throw new RegimeAlimentaireException(C_MSG.REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION);
    }


}
