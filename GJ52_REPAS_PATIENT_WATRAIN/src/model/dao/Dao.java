package model.dao;


import model.dao.exceptions.DaoException;

import java.util.List;

public interface Dao<T, K> {

    /**
     * Ajoute l'argument dans la persistence.
     *
     * @param var1: T - l'objet à ajouter
     * @throws DaoException - si l'objet existe déjà
     */
    void create(T var1) throws DaoException;

    /**
     * Retourne l'objet correspondant à l'argument.
     * @param var1 : K - l'identifiant de l'objet
     * @return T - l'objet correspondant à l'identifiant
     * @throws DaoException - si l'objet n'existe pas
     */
    T read(K var1) throws DaoException;

    /**
     * Supprime l'argument de la persistence.
     *
     * @param var1 : T - l'objet à supprimer
     * @throws DaoException - si l'objet n'existe pas
     */
    void delete(T var1) throws DaoException;

    /**
     * Met à jour l'argument dans la persistence.
     *
     * @param var1 : T - l'objet à mettre à jour
     * @throws DaoException - si l'objet n'existe pas
     */
    void update(T var1) throws DaoException;

    /**
     * Retourne la liste des objets de la persistence.
     *
     * @return List<T> - la liste des objets
     */
    List<T> readAll();

    /**
     * Return true si l'objet existe dans la persistence, false sinon.
     *
     * @param var1 : K - l'identifiant de l'objet
     * @return boolean - true si l'objet existe, false sinon
     */
    boolean exist(T var1);

    /**
     * Initialise la persistence.
     */
    default void init() {
        throw new UnsupportedOperationException();
    }

    void deleteByKey(K var1) throws DaoException;
}
