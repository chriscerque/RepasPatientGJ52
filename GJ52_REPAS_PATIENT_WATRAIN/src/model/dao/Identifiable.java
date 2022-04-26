package model.dao;

public interface Identifiable<K> {

	/**
	 * return l'identifiant de l'objet.
	 *
	 * @return l'identifiant de l'objet.
	 */
	K getId();
}
