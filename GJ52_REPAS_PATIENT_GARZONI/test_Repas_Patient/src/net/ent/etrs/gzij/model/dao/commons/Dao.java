package net.ent.etrs.gzij.model.dao.commons;


import net.ent.etrs.gzij.model.dao.exceptions.DaoException;

import java.util.List;

// T = type et K = key -- convention de nommage...

/**
 * Interface générique permettant de mettre en place un accès à une mémoire.
 *
 * L'objet gérer par cette interface doit implémenter l'interface {@link ID}
 *
 * @param <T> Objet gérer en mémoire
 * @param <K> Type de la clé permettant d'identifier, de façon unique, les objets en mémoire
 */
public interface Dao<T, K> {

    /**
     * Méthode permettant la création d'éléments dans la mémoire.
     * @param var1 Objet à stocker
     * @throws DaoException En cas d'erreur lors du traitement, une exception est générée
     */
    void create(T var1) throws DaoException;

    /**
     * Méthode permettant de retourner un élément contenu en mémoire en fonction d'une clé/identifiant.
     *
     * @param var1 Clé ou identifiant permettant de retrouver l'objet. Le type de la clé dépend de l'implémentation de la classe Dao
     * @return Renvois un objet correspondant à la clé
     * @throws DaoException en cas d'erreur ou de non-correspondance, une exception est gfénérer
     */
    T read(K var1) throws DaoException;

    /**
     * Méthode permettant de supprimer un objet de la mémoire.
     *
     * @param var1 Objet à supprimer
     * @throws DaoException en cas d'erreur durant le traitement, une exception est levée
     */
    void delete(T var1) throws DaoException;

    /**
     * Méthode permettant de mettre à jour un objet en mémoire.
     *
     * @param var1 Objet à mettre à jour
     * @throws DaoException Durant letraitement, si une erreur survient, une exception sera levée
     */
    void update(T var1) throws DaoException;

    /**
     * Méthode permettant de renvoyer tout le contenu de la mémoire.
     *
     * @return retourne, sous forme d'objet de type {@link java.util.List}
     */
    List<T> readAll();

    /**
     * Méthode permettant de tester la présence d'un objet en mémoire.
     *
     * Lorsque la méthode renvoi true si l'objet passé en paramètre existe en mémoire
     * Sinon, renvoi false
     *
     * @param var1 Objet à tester
     * @return boolean
     * @throws DaoException en cas d'erreur de type ou de paramètre null, la méthode lève une exception
     */
    boolean exist(T var1) throws DaoException;

    /**
     * Méthode permettant d'initier la mémoire.
     */
    default void init() {
        throw new UnsupportedOperationException();
    }

} // fin d'Interface
