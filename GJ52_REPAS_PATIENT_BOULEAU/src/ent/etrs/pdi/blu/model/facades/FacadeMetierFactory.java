package ent.etrs.pdi.blu.model.facades;

public final class FacadeMetierFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private FacadeMetierFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
    }
}
