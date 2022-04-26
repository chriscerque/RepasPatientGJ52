package model.references;

import model.references.exceptions.RegimeAlimentaireException;

public enum RegimeAlimentaire {
    VEGETARIEN("Végétarien"), MIXE("Mixé"), SANS_SEL("Sans sel"), DIABETIQUE("Diabétique"), VEGAN("Végan");

    private String libelle;

    private RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public static RegimeAlimentaire getByLibelle(String libelle) throws RegimeAlimentaireException {
        for (RegimeAlimentaire regime : RegimeAlimentaire.values()) {
            if (libelle.equals(regime.getLibelle())) {
                return regime;
            }
        }
        throw new RegimeAlimentaireException(C_MSG.REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION);
    }
}
