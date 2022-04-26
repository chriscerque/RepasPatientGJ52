package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Repas;

import java.util.List;

public interface IRepasMemDao extends IDao<Repas, String> {
    /**
     * Méthode permettant de créer un repas et de l'ajouter dans la liste persistenceRepas.
     * @param repas: Repas
     * @throws DaoException
     */
    void create(Repas repas) throws DaoException;

    /**
     * Méthode permettant de supprimer un repas s'il existe bien dans la liste persistenceRepas.
     * @param repas: Repas
     * @throws DaoException
     */
    void delete(Repas repas) throws DaoException;

    /**
     * Méthode permettant de supprimer un repas par son id s'il existe bien dans la liste persistenceRepas.
     * @param id: String
     * @throws DaoException
     */
    void deleteByKey(String id) throws DaoException;

    /**
     * Méthode permettant de vérifier si un repas existe bien dans la liste persistenceRepas, si oui renvoit True sinon False.
     * @param repas: Repas
     * @return boolean
     * @throws DaoException
     */
    boolean exist(Repas repas) throws DaoException;

    /**
     * Méthode permettant de retourner un repas contenu dans la liste persistenceRepas par son id.
     * @param id: String
     * @return Repas
     * @throws DaoException
     */
    Repas read(String id) throws DaoException;

    /**
     * Méthode permettant de retourner le contenu de la liste des repas de persistenceRepas.
     * @return List<Repas>
     */
    List<Repas> readAll();

    /**
     * Méthode permettant de mettre à jour les propriétés d'un repas contenu dans persistenceRepas.
     * @param repas: Repas
     * @throws DaoException
     */
    void update(Repas repas) throws DaoException;
}
