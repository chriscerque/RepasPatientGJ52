package net.ent.etrs.pdi.vbt.model.entities.exceptions;

public class RegimeAlimentaireException extends Exception {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    public RegimeAlimentaireException() {
    }

    public RegimeAlimentaireException(String message) {
        super(message);
    }

    public RegimeAlimentaireException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegimeAlimentaireException(Throwable cause) {
        super(cause);
    }

    public RegimeAlimentaireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
