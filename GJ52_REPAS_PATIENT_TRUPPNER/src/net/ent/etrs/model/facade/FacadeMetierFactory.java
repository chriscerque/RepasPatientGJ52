package net.ent.etrs.model.facade;

public class FacadeMetierFactory {
    /////CONSTRUCTEUR/////
    private FacadeMetierFactory(){}

    public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetier();
    }
}
