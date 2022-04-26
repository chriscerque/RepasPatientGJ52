package model.entities;

import model.dao.Identifiable;
import model.entities.exceptions.PatientException;
import model.references.C;
import model.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Patient implements Identifiable<String> {
	//<editor-fold desc="Attributs">
	private String nom;
	private String prenom;
	private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
	private List<Repas> lstRepas = new ArrayList<>();
	private String id = UUID.randomUUID().toString();
	private LocalDate dateEntree;
	private String numSecu;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	protected Patient(final String nom, final String prenom, final LocalDate dateEntree, final String numSecu) throws PatientException {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateEntree(dateEntree);
		this.setNumSecu(numSecu);
	}
	//</editor-fold>

	//<editor-fold desc="Getters">

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
		return lstRegimeAlimentaire;
	}

	public List<Repas> getLstRepas() {
		return lstRepas;
	}

	@Override
	public String getId() {
		return id;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public String getNumSecu() {
		return numSecu;
	}

	//</editor-fold>

	//<editor-fold desc="Setters">
	public void setNumSecu(final String numSecu) throws PatientException {
		if(Objects.isNull(numSecu)) throw new PatientException(C.MSG_PATIENT_NUM_SECU_INVALID);
		if(numSecu.length() != C.NUM_SECU_LENGTH) throw new PatientException(C.MSG_PATIENT_NUM_SECU_INVALID);

		this.numSecu = numSecu;
	}

	public void setNom(final String nom) throws PatientException {
		if(Objects.isNull(nom)) throw new PatientException(C.MSG_PATIENT_NOM_EXCEPTION);
		if(nom.length() < C.PRENOM_MIN_LENGTH || nom.length() > C.PRENOM_MAX_LENGTH) throw new PatientException(C.MSG_PATIENT_PRENOM_LENGTH_EXCEPTION);

		this.nom = nom;
	}

	public void setPrenom(final String prenom) throws PatientException {
		if(Objects.isNull(prenom)) throw new PatientException(C.MSG_PATIENT_PRENOM_EXCEPTION);
		if(prenom.length() < C.PRENOM_MIN_LENGTH || prenom.length() > C.PRENOM_MAX_LENGTH) throw new PatientException(C.MSG_PATIENT_PRENOM_LENGTH_EXCEPTION);

		this.prenom = prenom;
	}

	public void setDateEntree(final LocalDate dateEntree) throws PatientException {
		if(Objects.isNull(dateEntree)) throw new PatientException(C.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
		if(dateEntree.isAfter(LocalDate.now())) throw new PatientException(C.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);

		this.dateEntree = dateEntree;
	}

	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patient patient = (Patient) o;
		return getId().equals(patient.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	//</editor-fold>

	//<editor-fold desc="ToString">

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Patient{");
		sb.append("nom='").append(nom).append('\'');
		sb.append(", prenom='").append(prenom).append('\'');
		sb.append(", numSecu='").append(numSecu).append('\'');
		sb.append('}');
		return sb.toString();
	}

	//</editor-fold>²

	//<editor-fold desc=
	public void ajouterRepas(final Repas repas) throws PatientException {
		if(Objects.isNull(repas)) throw new PatientException(C.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
		if(lstRepas.contains(repas)) throw new PatientException(C.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);

		controlerRegimeAlimentaire(repas);
		lstRepas.add(repas);
	}

	public void ajouterRegimeAlimentaire(final RegimeAlimentaire regimeAlimentaire) throws PatientException {
		if(Objects.isNull(regimeAlimentaire)) throw new PatientException(C.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
		if(lstRegimeAlimentaire.contains(regimeAlimentaire)) throw new PatientException(C.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);

		lstRegimeAlimentaire.add(regimeAlimentaire);
	}

	private void controlerRegimeAlimentaire(final Repas repas) throws PatientException {
		if(Objects.isNull(repas)) throw new PatientException(C.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
		if(!repas.getLstRegimeAlimentaire().containsAll(repas.getLstRegimeAlimentaire())) throw new PatientException(C.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);

	}
	//</editor-fold>
} 