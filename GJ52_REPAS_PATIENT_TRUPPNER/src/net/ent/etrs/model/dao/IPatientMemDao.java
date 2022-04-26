package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Patient;

import java.util.List;

//TODO: Fini javadoc IPatienMemDao

public interface IPatientMemDao extends IDao<Patient, String> {
    /**
     * Méthode permettant de créer un patient et de l'ajouter dans la liste persistencePatient.
     * @param patient: Patient
     * @throws DaoException
     */
    void create(Patient patient) throws DaoException;

    void delete(Patient patient) throws DaoException;

    boolean exist(Patient patient) throws DaoException;

    Patient read(String numSecu) throws DaoException;

    List<Patient> readAll();

    void update(Patient patient) throws DaoException;
}
