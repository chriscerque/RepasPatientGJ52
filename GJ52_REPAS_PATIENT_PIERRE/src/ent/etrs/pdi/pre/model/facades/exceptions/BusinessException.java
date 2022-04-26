package ent.etrs.pdi.pre.model.facades.exceptions;

public class BusinessException extends Exception {
    /*------- CONSTRUCTEUR(S) -------*/
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public BusinessException(String msg) {
        super(msg);
    }
}
