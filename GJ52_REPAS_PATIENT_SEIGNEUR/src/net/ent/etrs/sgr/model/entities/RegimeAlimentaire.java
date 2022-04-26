package net.ent.etrs.sgr.model.entities;

public enum RegimeAlimentaire {

    VEGETARIEN("vegetarien"),
    MIXE("mixe"),
    SANS_SEL("sans sel"),
    DIABETIQUE("diabetique"),
    VEGAN("vegan");

    private String libelle;

    private RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public RegimeAlimentaire getByLibelle(String lib) {

        RegimeAlimentaire reg = null;

        for (RegimeAlimentaire ra : RegimeAlimentaire.values()){
            if (ra.getLibelle().equals(lib)){
                reg = ra;
            }
        }
        return reg;
    }
}
