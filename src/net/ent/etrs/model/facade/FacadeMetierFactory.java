package net.ent.etrs.model.facade;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FacadeMetierFactory {
    private FacadeMetierFactory() {
    }

    public static FacadeMetier fabriquerContactModelFacade() {
        return new FacadeMetierImpl();
    }
}
