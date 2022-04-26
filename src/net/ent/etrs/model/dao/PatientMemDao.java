package net.ent.etrs.model.dao;


//@Log4j2(topic = "LoggerDAO")

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.references.C_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Implementation memoire de la dao.
 *
 * @author christophe.cerqueira
 */
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatientMemDao extends AbstractPatientDao {
    //    private static PatientMemDao INSTANCE;
    private List<Patient> persistence = new ArrayList<>();

    protected PatientMemDao() {
    }

    //    public static PatientMemDao getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new PatientMemDao();
//        }
//        return INSTANCE;
//    }


    @Override
    public void create(Patient arg0) throws DaoException {
        if (this.exist(arg0)) {
//			log.warn(C.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_EXISTANT);
        }
        this.persistence.add(arg0);
//		log.info(C.MSG_DAO_PERSITANCE_PATIENT);

    }

    @Override
    public void delete(Patient arg0) throws DaoException {
        if (!this.exist(arg0)) {
//			log.warn(C.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_PATIENT_INEXISTANT);
        }
        this.persistence.remove(arg0);
//		log.info(C.MSG_DAO_SUPPRESSION_PATIENT);

    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        this.delete(this.read(var1));
    }

    @Override
    public boolean exist(Patient arg0) throws DaoException {
        if (Objects.isNull(arg0)) {
//			log.warn(C.MSG_DAO_PERSITANCE_PATIENT_NULL);
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_PATIENT_NULL);
        }
        return this.persistence.contains(arg0);
    }

    @Override
    public Patient read(String arg0) throws DaoException {
        for (Patient contact : persistence) {
            if (contact.getId().equals(arg0)) {
                return contact;
            }
        }
        throw new DaoException("Contact inexistant");
    }

    @Override
    public List<Patient> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public void update(Patient arg0) throws DaoException {
        if (!this.exist(arg0)) {
//			log.warn(C.MSG_DAO_MISE_A_JOUR_PATIENT_INEXISTANT);
        }

//		log.info(C.MSG_DAO_MISE_A_JOUR_PATIENT);
        this.persistence.set(this.persistence.indexOf(arg0), arg0);

    }

}
