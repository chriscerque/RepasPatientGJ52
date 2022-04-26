package ent.etrs.pdi.blu.model.entities.references;

public enum RegimeAlimentaire {


        VEGETARIEN("vegetarien"),
        MIXE("mixe"),
        SANS_SEL("sans sel"),
        DIABETIQUE("diabetique"),
        VEGAN("vegan");


        private final String libelle;


    private RegimeAlimentaire(String libelle) {
            this.libelle = libelle;
            //this.code = code;
        }

    public String getLibelle() {
        return libelle;
    }
    public String getByLibelle() {
        String regimeLib = null;
        for (int i = 0; i < RegimeAlimentaire.values().length; i++) {
            regimeLib = String.valueOf(RegimeAlimentaire.valueOf(String.valueOf(i)));
        }
        return regimeLib;
    }

}

