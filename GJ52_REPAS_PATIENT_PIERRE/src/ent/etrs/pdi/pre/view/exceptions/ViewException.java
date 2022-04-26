package ent.etrs.pdi.pre.view.exceptions;

public class ViewException extends Exception {
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public ViewException(String msg) {
        super(msg);
    }
}
