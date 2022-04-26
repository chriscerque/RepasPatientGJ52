package net.ent.etrs.sgr.view;

public class FacadeVueFactory {

    public static IFacadeVue fabriquerFacadeVue() {
        return new FacadeVueImpl();
    }

}
