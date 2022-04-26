package model.dao;

import model.dao.exceptions.DaoException;

import java.util.List;

public interface Dao <T, K> {

    /**
     * Methode permettant d'ajouter un objet aux donnees.
     * @param var objet a ajouter.
     * @throws DaoException si l'objet en parametre est null ou s'il existe deja dans les donnees.
     */
    void create(T var) throws DaoException;

    /**
     * Methode permettant de recuperer un objet situe dans les donnees dont la cle est donnee en parametre.
     * @param var cle permettant permettant d'acceder a l'objet.
     * @return un objet de type T.
     * @throws DaoException si la cle est null ou si l'objet n'a pas ete trouve avec cette cle.
     */
    T read(K var) throws DaoException;

    /**
     * Methode permettant d'ecraser un objet situe dans les donnees.
     * Recherche l'objet et remplace l'ancien par le nouveau.
     * @param var objet a mettre a jour.
     * @throws DaoException si l'objet en parametre est null ou s'il n'existe pas dans les donnees.
     */
    void update(T var) throws DaoException;

    /**
     * Methode permettant de supprimer un objet, des donnees.
     * @param var objet a supprimer.
     * @throws DaoException si l'objet en parametre est null ou s'il n'existe pas dans les donnees.
     */
    void delete(T var) throws DaoException;

    /**
     * Methode permettant de lister toutes les donnees.
     * @return la liste des donnees.
     */
    List<T> readAll();

    /**
     * Methode permettant de savoir si un objet existe dans les donnees.
     * @param var objet a chercher.
     * @return vrai si l'objet est dans les donnees et faux si l'objet n'est pas dedans.
     * @throws DaoException si l'objet en parametre est null.
     */
    boolean exist(T var) throws DaoException;

    /**
     * Methode permettant d'effectuer une initialisation de la dao.
     * default throw UnsupportedOperationException
     */
    default void init() {
        throw new UnsupportedOperationException();
    }
}
