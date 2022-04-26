package net.ent.etrs.gzij.model.facades;

public final class FabriqueFacadeMetier {

    /*--------------------------------
    Methodes permettant de faire appel 
    aux constructeurs des différentes 
    classes métier la construction
    --------------------------------*/

    /**
     * Méthode permettant de construire la facade métier.
     *
     * @return {@link IFacadeMetier}
     */
    public static IFacadeMetier creerFacadeMetier(){
        return new FacadeMetierImpl();
    }


    /*----------------------
    ** Constructeur privé **
    -----------------------*/
    private FabriqueFacadeMetier() {
    }

}  // fin de classe
