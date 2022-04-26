package marine.etrs.model_Metier.entities_Class_Factory;

public enum RegimeAlimentaire {

    VEGETARIEN("vegetarien"),
    MIXE("mixe"),
    SANS_SEL("sans_sel"),
    DIABETIQUE("diabetique"),
    VEGAN("vegan");

    private final String libelle;


    RegimeAlimentaire(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }


     //METHODE TESTE SI UN LIBELLE EXISTE
    public static RegimeAlimentaire getByLibelle(String libelle){
        for (RegimeAlimentaire typeXx : RegimeAlimentaire.values()){
            if(typeXx.getLibelle().equals(libelle)){
                return typeXx;
            }
        }
        return null;
    }


}
