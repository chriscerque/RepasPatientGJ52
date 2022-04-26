package model.dao;

import model.dao.exceptions.DaoException;
import model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DaoGeneric<T extends Identifiable<K>, K> implements Dao<T, K> {
	//<editor-fold desc="Attributs">
	private final List<T> persistence;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	public DaoGeneric() {
		super();
		this.persistence = new ArrayList<>();
	}

	//</editor-fold>

	//<editor-fold desc="Getters">
	//</editor-fold>

	//<editor-fold desc="Setters">
	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">
	//</editor-fold>

	//<editor-fold desc="ToString">
	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	@Override
	public void create(T var1) throws DaoException {
		if (Objects.isNull(var1)) {
			throw new DaoException("");
		}
		if (persistence.contains(var1)) {
			throw new DaoException(C.DAO_EXIST_EXCEPTION);
		}

		persistence.add(var1);
	}

	@Override
	public T read(K var1) throws DaoException {
		if (Objects.isNull(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}
		for (T element : persistence) {
			if (element.getId().equals(var1)) {
				return element;
			}
		}
		throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
	}

	@Override
	public void delete(T var1) throws DaoException {
		if (Objects.isNull(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}
		if (!persistence.contains(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}

		persistence.remove(var1);
	}

	@Override
	public void update(T var1) throws DaoException {
		if (Objects.isNull(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}
		if (!persistence.contains(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}

		// On récupère l'index de l'article dans la liste et on le remplace
		int idx = persistence.indexOf(var1);
		persistence.set(idx, var1);
	}

	@Override
	public List<T> readAll() {
		return Collections.unmodifiableList(persistence);
	}

	@Override
	public boolean exist(T var1) {
		if (Objects.isNull(var1)) { return false; }
		return persistence.contains(var1);
	}

	@Override
	public void deleteByKey(K var1) throws DaoException {
		if (Objects.isNull(var1)) {
			throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
		}
		for (T element : persistence) {
			if (element.getId().equals(var1)) {
				persistence.remove(element);
				return;
			}
		}
		throw new DaoException(C.DAO_EXIST_PAS_EXCEPTION);
	}
	//</editor-fold>

} 