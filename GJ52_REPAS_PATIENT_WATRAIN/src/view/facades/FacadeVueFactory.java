package view.facades;

public final class FacadeVueFactory {

    private FacadeVueFactory() {
    }

    public static FacadeVue fabriquerFacadeVue() {
        return new FacadeVueImpl();
    }
}
