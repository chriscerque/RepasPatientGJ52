package ent.etrs.pdi.blu.model.entities.exceptions;

public class ModelException extends Exception {
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public ModelException(String msg) {
        super(msg);
    }
}
