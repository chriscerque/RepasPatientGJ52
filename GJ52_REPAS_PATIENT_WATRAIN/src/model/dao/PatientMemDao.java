package model.dao;

import model.entities.Patient;

import java.util.*;

public final class PatientMemDao extends AbstractPatientMemDao {
	//<editor-fold desc="Attributs">
	private List<Patient> persistencePatient;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	protected PatientMemDao() {
		super();
		this.persistencePatient = new ArrayList<>();
	}

	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	//</editor-fold>
}