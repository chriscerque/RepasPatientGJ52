package net.ent.etrs.ggef.model.dao;

public final class DaoFactory {

    /**
     * Fabrique une DAO pour la gestion des Patients.
     *
     * @return l'instance de PatientMemDao
     */

    public static IPatientMemDao fabriquerPatientDao() {
        return new PatientMemDao();
    }

    /**
     * Fabrique une DAO pour la gestion des repas.
     *
     * @return l'instance de RepasMemDao
     */
    public static IRepasMemDao fabriquerRepasDao() {
        return new RepasMemDao();
    }

/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private DaoFactory() {
    }

} // fin de classe
