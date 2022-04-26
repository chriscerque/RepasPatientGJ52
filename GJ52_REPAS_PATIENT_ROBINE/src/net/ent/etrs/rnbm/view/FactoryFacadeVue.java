package net.ent.etrs.rnbm.view;

public final class FactoryFacadeVue {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryFacadeVue(){}

    public static FacadeVue fabriquerFacadeVue(){ return new FacadeVueImpl();}


}
