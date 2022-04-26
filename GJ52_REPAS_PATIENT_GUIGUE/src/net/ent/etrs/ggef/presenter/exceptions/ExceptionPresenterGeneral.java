package net.ent.etrs.ggef.presenter.exceptions;

public class ExceptionPresenterGeneral extends Exception {

    public static final String ERR_METIER_NULL = "ERR: le métier ne peut pas être NULL";
    public static final String ERR_VUE_NULL = "ERR: la vue ne peut pas être NULL";

    public ExceptionPresenterGeneral() {super();}

    public ExceptionPresenterGeneral(final String message) {
        super(message);
    }

    public ExceptionPresenterGeneral(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ExceptionPresenterGeneral(final Throwable cause) {
        super(cause);
    }

    public ExceptionPresenterGeneral(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

} // fin de classe
