package presenter.exceptions;

public class PresenterException extends Exception {
    public PresenterException() {
    }

    public PresenterException(String message) {
        super(message);
    }

    public PresenterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PresenterException(Throwable cause) {
        super(cause);
    }

    public PresenterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
