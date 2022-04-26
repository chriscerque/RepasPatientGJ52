package net.ent.etrs.view;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Viewfactory {

    private Viewfactory() {
    }

    public static FacadeVue fabriquerContactView() {
        return new FacadeVueImpl();
    }


}
