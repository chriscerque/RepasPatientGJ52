package net.ent.etrs.sgr.model.exceptions;

public class BusinessException extends Exception {
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
