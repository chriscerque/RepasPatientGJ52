package ent.etrs.pdi.pre.presenter.exceptions;

public class PresenterException extends Exception {
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public PresenterException(String msg) {
        super(msg);
    }
}
