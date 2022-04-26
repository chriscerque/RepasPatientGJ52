package net.ent.etrs.ggef.vue.facades;

public final class FabriqueFacadeVue {

    /**
     * Méthode permettant de construire la facade Vue
     *
     * @return {@link FacadeVue}
     */
    public static FacadeVue fabriquerFacadeVue(){
        return new FacadeVueImpl();
    }


/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private FabriqueFacadeVue() {
    }

}  // fin de classe

