package view.facade;

public final class FabriqueFacadeVue {
    private FabriqueFacadeVue() {}

    public static FacadeVue fabriquerFacadeVue() {
        return new FacadeVueImpl();
    }
}
