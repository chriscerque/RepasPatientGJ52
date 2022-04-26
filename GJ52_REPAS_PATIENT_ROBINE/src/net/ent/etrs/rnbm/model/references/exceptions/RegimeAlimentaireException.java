package net.ent.etrs.rnbm.model.references.exceptions;

public class RegimeAlimentaireException extends Exception {
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
