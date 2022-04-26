package ent.etrs.pdi.blu.model.facades.exceptions;

public class BusinessExceptionNus extends Exception {
    /*------- CONSTRUCTEUR(S) -------*/
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public BusinessExceptionNus(String msg) {
        super(msg);
    }
}
