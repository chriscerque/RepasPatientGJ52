package ent.etrs.pdi.pre.model.entities.references;

public enum RegimeAlimentaire {
    /*------- ENUMS -------*/
    VEGETARIEN ("végétarien"),
    MIXE("mixé"),
    SANS_SEL("sans sel"),
    DIABETIQUE("diabétique"),
    VEGAN("végan");

    /*------- ATTRIBUTS -------*/
    private String libelle;

    /*------- CONSTRUCTEUR(S) -------*/
    private RegimeAlimentaire(String regimeAlim) {}

    /*------- ASCESSEURS -------*/
    // GETTER
    public String getLibelle() {
        return libelle;
    }

    /*------- AUTRES METHODES -------*/
    public RegimeAlimentaire getByLibelle(String saisie){
        RegimeAlimentaire regime = null;
        for (int i = 0; i < RegimeAlimentaire.values().length; i++) {
            if (RegimeAlimentaire.values()[i].getLibelle().equalsIgnoreCase(saisie)){
                regime = RegimeAlimentaire.values()[i];
            }
        }
        return regime;
    }
}
