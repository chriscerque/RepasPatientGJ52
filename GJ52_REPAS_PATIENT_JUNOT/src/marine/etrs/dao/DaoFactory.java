package marine.etrs.dao;

//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DaoFactory {

    private DaoFactory() {}

    /**
     * Fabrique une DAO pour la gestion des entités.
     */
                                // CHANGER Xx par
    public static AbstractRepasDao fabriquerRepasDao() {
        return new RepasDaoImpl();
    }

    public static AbstractPatientDao fabriquerPatientDao() {
        return new PatientDaoImpl();
    }


}
