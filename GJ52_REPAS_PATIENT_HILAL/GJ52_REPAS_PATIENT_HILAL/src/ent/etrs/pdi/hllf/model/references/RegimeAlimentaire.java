package ent.etrs.pdi.hllf.model.references;

import ent.etrs.pdi.hllf.model.exceptions.RegimeAlimentaireException;

import java.util.Objects;

public enum RegimeAlimentaire
{
    VEGETARIEN("vegetarien"),
    MIXE("mixe"),
    SANS_SEL("sans sel"),
    DIABETIQUE("diabetique"),
    VEGAN("vegan");

    private String libelle;

    RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    /**
     * methode permettant de recuperer le regime alimentaire en passant par le libelle
     * @param libelle: String
     * @return RegimeAlimentaire
     * @throws RegimeAlimentaireException
     */
    public RegimeAlimentaire getByLibelle(String libelle) throws RegimeAlimentaireException {
        RegimeAlimentaire retour = null;
        if(Objects.isNull(libelle))
        {
            throw new RegimeAlimentaireException(C_MODEL.ERR_REGIME_ALIMENTAIRE_LIBELLE_NULL);
        }
        for (RegimeAlimentaire r:RegimeAlimentaire.values()) {
            if(r.libelle.equals(libelle))
            {
                retour = r;
            }
        }
        if(Objects.isNull(retour))
        {
            throw new RegimeAlimentaireException(C_MODEL.ERR_REGIME_ALIMENTAIRE_NON_TROUVE);
        }
        return retour;
    }
}
