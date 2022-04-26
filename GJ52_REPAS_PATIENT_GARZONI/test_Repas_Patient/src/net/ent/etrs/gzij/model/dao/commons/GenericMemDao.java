package net.ent.etrs.gzij.model.dao.commons;

import net.ent.etrs.gzij.model.dao.exceptions.DaoException;
import net.ent.etrs.gzij.model.references.constantes.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Classe générique permettant de mettre en place un accès à une mémoire.
 *
 * L'objet gérer par cette classe doit implémenter l'interface {@link ID}
 *
 * @param <T> Objet gérer en mémoire
 * @param <K> Type de la clé permettant d'identifier, de façon unique, les objets en mémoire
 */
public class GenericMemDao<T extends ID<K>,K> implements  Dao<T, K> {
    protected List<T> persistence = new ArrayList<T>();

    @Override
    public void create(final T t) throws DaoException {
        if (Objects.isNull(t)) {
            throw new DaoException();
        }
        if (exist(t)) {
            throw new DaoException();
        }
        this.persistence.add(t);
    }

    @Override
    public void delete(final T t) throws DaoException {
        if (Objects.isNull(t)) {
            throw new DaoException();
        }
        if (!exist(t)) {
            throw new DaoException();
        }
        this.persistence.remove(t);
    }

    @Override
    public boolean exist(final T t) throws DaoException {
        try {
            return this.persistence.contains(t);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public T read(final K id) throws DaoException {
        T p = null;
        for (T t : this.persistence) {
            if (t.getId().equals(id)) {
                p = t;
            }
        }
        return p;
    }

    @Override
    public List<T> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }


    @Override
    public void update(final T t) throws DaoException {

        int idx = this.persistence.indexOf(t);
        if (idx == -1) {
            throw new DaoException(ConstantesMetier.FACADE_METIER_MAJ_LOGEMENT_EXCEPTION);
        }
        this.persistence.set(idx, t);
    }



}
