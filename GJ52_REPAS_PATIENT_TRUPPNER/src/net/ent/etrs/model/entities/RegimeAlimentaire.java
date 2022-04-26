package net.ent.etrs.model.entities;

public enum RegimeAlimentaire {
    VEGETARIEN("Végétarien"), MIXE("Mixé"), SANS_SEL("Sans sel"), DIABETIQUE("Diabétique"), VEGAN("Végan");

    /////ATTRIBUTS/////
    private String libelle;

    /////CONSTRUCTEUR/////
    RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    /////GETTER//////
    public String getLibelle() {
        return libelle;
    }

    public RegimeAlimentaire getByLibelle(String libelle)
    {
        for (RegimeAlimentaire ra: RegimeAlimentaire.values()) {
            if(ra.getLibelle().equals(libelle))
            {
                return ra;
            }
        }
        return null;
    }
}
