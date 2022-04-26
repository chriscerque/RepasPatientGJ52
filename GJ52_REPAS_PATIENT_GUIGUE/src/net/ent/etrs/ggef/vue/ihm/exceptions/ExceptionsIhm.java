package net.ent.etrs.ggef.vue.ihm.exceptions;

public class ExceptionsIhm extends Exception {
    
    /*-----------------------
    ***** Constructeurs *****
    -----------------------*/

    /**
     * Constructeur permettant de lever une exception simple.
     *
     * @param msg String - Message à personnaliser dans les constantes
     **/
    public ExceptionsIhm(final String msg) {
        super(msg);
    }

    /**
     * Constructeur permettant de lever une exception en passant la cause d'origine.
     *
     * @param msg String - Message à personnaliser dans les constantes
     * @param cause Throwable - Exception causant l'arrêt du traitement en cours
     **/
    public ExceptionsIhm(final String msg, final Throwable cause) {
        super(msg, cause);
    }

} // fin de classe