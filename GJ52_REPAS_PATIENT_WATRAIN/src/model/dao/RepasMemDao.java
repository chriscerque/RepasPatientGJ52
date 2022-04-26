package model.dao;

import model.entities.Repas;

import java.util.*;

public final class RepasMemDao extends AbstractRepasMemDao {
	//<editor-fold desc="Attributs">
	private List<Repas> persistenceRepas;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	protected RepasMemDao() {
		super();
		this.persistenceRepas = new ArrayList<>();
	}

	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	//</editor-fold>
}