package net.ent.etrs.model.dao;


//@Log4j2(topic = "LoggerDAO")

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Repas;
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
public class RepasMemDao extends AbstractRepasDao {
    //    private static RepasMemDao INSTANCE;
    private List<Repas> persistence = new ArrayList<>();

    protected RepasMemDao() {
    }

    //    public static RepasMemDao getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new RepasMemDao();
//        }
//        return INSTANCE;
//    }

    @Override
    public void create(Repas arg0) throws DaoException {
        if (this.exist(arg0)) {
//			log.warn(C.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_EXISTANT);
        }
        this.persistence.add(arg0);
//		log.info(C.MSG_DAO_PERSITANCE_REPAS);

    }

    @Override
    public void delete(Repas arg0) throws DaoException {
        if (!this.exist(arg0)) {
//			log.warn(C.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
            throw new DaoException(C_MSG.MSG_DAO_SUPPRESSION_REPAS_INEXISTANT);
        }
        this.persistence.remove(arg0);
//		log.info(C.MSG_DAO_SUPPRESSION_REPAS);

    }

    @Override
    public void deleteByKey(String var1) throws DaoException {
        this.delete(this.read(var1));
    }

    @Override
    public boolean exist(Repas arg0) throws DaoException {
        if (Objects.isNull(arg0)) {
//			log.warn(C.MSG_DAO_PERSITANCE_REPAS_NULL);
            throw new DaoException(C_MSG.MSG_DAO_PERSITANCE_REPAS_NULL);
        }
        return this.persistence.contains(arg0);
    }

    @Override
    public Repas read(String arg0) throws DaoException {
        for (Repas repas : persistence) {
            if (repas.getId().equals(arg0)) {
                return repas;
            }
        }
        throw new DaoException("Contact inexistant");
    }

    @Override
    public List<Repas> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public void update(Repas arg0) throws DaoException {
        if (!this.exist(arg0)) {
//			log.warn(C.MSG_DAO_MISE_A_JOUR_REPAS_INEXISTANT);
        }

//		log.info(C.MSG_DAO_MISE_A_JOUR_REPAS);
        this.persistence.set(this.persistence.indexOf(arg0), arg0);

    }

}
