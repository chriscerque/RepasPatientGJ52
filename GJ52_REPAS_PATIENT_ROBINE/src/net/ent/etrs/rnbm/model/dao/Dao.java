package net.ent.etrs.rnbm.model.dao;


import net.ent.etrs.rnbm.model.dao.exceptions.DaoException;

import java.util.List;

public interface Dao<T, K> {
    /**
     * Méthode qui va permettre de créer, "d'ajouter" l'élément passé en paramettre à une persistence.
     * @param var1
     * @throws DaoException
     */
    void create(T var1) throws DaoException;

    /**
     * Méthode qui va permmettre d'afficher les elements d'une persistence.
     *
     * @param var1
     * @return le type de l'element choisi.
     * @throws DaoException
     */

    T read(K var1) throws DaoException;

    /**
     * Méthode qui va permettre de supprimer les elements d'une persistence.
     * L'element a supprimer est celui passé en parametre
     * @param var1
     * @throws DaoException
     */

    void delete(T var1) throws DaoException;

    /**
     * Méthode qui permet de remplacer un element de la persistence.
     * @param var1
     * @throws DaoException
     */

    void update(T var1) throws DaoException;

    /**
     * Méthode qui retourne la persitence.
     * @return la persistence
     */

    List<T> readAll();

    /**
     * Méthode qui vérifie si l'element passé en parametre existe déja dans la persistence.
     * @param var1
     * @return
     * @throws DaoException
     */
    boolean exist(T var1) throws DaoException;

    /**
     * Méthodes qui permet l'initialisation des differentes class.
     */

    default void init() {
        throw new UnsupportedOperationException();
    }

    void deleteByKey(K var1) throws DaoException;
}
