package net.ent.etrs.ggef.vue.facades.exceptions;

public class DisplayException extends Exception {
    
    /*-----------------------
    ***** Constructeurs *****
    -----------------------*/

    /**
     * Constructeur permettant de lever une exception simple.
     *
     * @param msg: String - Message pà personnaliser dans les constantes
     **/
    public DisplayException(String msg) {
        super(msg);
    }

    /**
     * Constructeur permettant de lever une exception en passant la cause d'origine.
     *
     * @param msg:   String - Message à personnaliser dans les constantes
     * @param cause: Throwable - Exception causant l'arrêt du traitement en cours
     **/
    public DisplayException(String msg, Throwable cause) {
        super(msg, cause);
    }
}