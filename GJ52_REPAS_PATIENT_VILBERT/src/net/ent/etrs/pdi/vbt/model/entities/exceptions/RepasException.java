package net.ent.etrs.pdi.vbt.model.entities.exceptions;

public class RepasException extends Exception {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    public RepasException() {
    }

    public RepasException(String message) {
        super(message);
    }

    public RepasException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepasException(Throwable cause) {
        super(cause);
    }

    public RepasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
