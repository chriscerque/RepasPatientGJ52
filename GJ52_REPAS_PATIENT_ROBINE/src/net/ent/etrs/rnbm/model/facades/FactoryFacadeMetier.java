package net.ent.etrs.rnbm.model.facades;

public final class FactoryFacadeMetier {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryFacadeMetier(){}

    public static FacadeMetier fabriquerFacadeMetier(){ return new FacadeMetierImpl();}

}
