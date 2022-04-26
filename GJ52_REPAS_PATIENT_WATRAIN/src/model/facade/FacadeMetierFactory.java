package model.facade;

public final class FacadeMetierFactory {

    private FacadeMetierFactory() {}

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
