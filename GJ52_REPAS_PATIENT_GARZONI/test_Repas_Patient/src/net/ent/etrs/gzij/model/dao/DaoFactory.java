package net.ent.etrs.gzij.model.dao;

public final class DaoFactory {
    private static PatientMemDao patientMemDaoInstance;
    private static RepasMemDao repasMemDaoInstance;

    /**
     * Fabrique une DAO pour la gestion des entités {@link net.ent.etrs.gzij.model.entities.Patient}.
     *
     * @return l'instance de {@link net.ent.etrs.gzij.model.entities.Patient}
     */
    public static IPatientMemDao fabriquerPatientDao() {
        if(patientMemDaoInstance == null) {
            patientMemDaoInstance = new PatientMemDao();
        }
        return patientMemDaoInstance;
    }

    /**
     * Fabrique une DAO pour la gestion des entités {@link net.ent.etrs.gzij.model.entities.Repas}.
     *
     * @return l'instance de {@link net.ent.etrs.gzij.model.entities.Repas}
     */
    public static IRepasMemDao fabriquerRepasDao() {
        if(repasMemDaoInstance == null) {
            repasMemDaoInstance = new RepasMemDao();
        }
        return repasMemDaoInstance;
    }

/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private DaoFactory() {

    }

} // fin de classe
