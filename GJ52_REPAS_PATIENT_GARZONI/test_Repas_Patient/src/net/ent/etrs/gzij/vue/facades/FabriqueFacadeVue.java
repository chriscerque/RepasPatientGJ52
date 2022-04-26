package net.ent.etrs.gzij.vue.facades;

public final class FabriqueFacadeVue {

    /**
     * Méthode permettant de construire la facade Vue
     *
     * @return {@link IFacadeVue}
     */
    public static IFacadeVue fabriquerFacadeVue(){
        return new FacadeVueImpl();
    }


/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private FabriqueFacadeVue() {
    }

}  // fin de classe

