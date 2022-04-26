package ent.etrs.pdi.pre.model.entities.exceptions;

public class PatientException extends Exception {
    /*------- CONSTRUCTEUR(S) -------*/
    /**
     * Méthode qui permet de créer une nouvelle exception avec un message détaillé.
     * @param msg: String, correspond au message détaillé de l'exception.
     */
    public PatientException(String msg) {
        super(msg);
    }
}
