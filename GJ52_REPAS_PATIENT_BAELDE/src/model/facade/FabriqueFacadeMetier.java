package model.facade;

public final class FabriqueFacadeMetier {
    private FabriqueFacadeMetier() {}

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
