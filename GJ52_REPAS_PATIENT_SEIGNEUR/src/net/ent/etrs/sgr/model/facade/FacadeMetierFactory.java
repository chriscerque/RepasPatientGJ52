package net.ent.etrs.sgr.model.facade;

public class FacadeMetierFactory {

    public static IFacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
    }
}
