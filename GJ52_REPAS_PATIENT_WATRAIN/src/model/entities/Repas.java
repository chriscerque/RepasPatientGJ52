package model.entities;

import model.dao.Identifiable;
import model.entities.exceptions.RepasException;
import model.references.C;
import model.references.RegimeAlimentaire;
import model.references.TypeRepas;
import model.references.exceptions.RegimeAlimentaireException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Repas implements Identifiable<String> {
	//<editor-fold desc="Attributs">
	private LocalDate dateRepas;
	private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
	private String id = UUID.randomUUID().toString();
	private TypeRepas typeRepas;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">

	protected Repas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {
		this.setDateRepas(dateRepas);
		this.setTypeRepas(typeRepas);
	}

	//</editor-fold>

	//<editor-fold desc="Getters">

	public LocalDate getDateRepas() {
		return dateRepas;
	}

	public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
		return lstRegimeAlimentaire;
	}

	public String getId() {
		return id;
	}

	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	//</editor-fold>

	//<editor-fold desc="Setters">

	public void setDateRepas(final LocalDate dateRepas) throws RepasException {
		if(Objects.isNull(dateRepas)) { throw new RepasException(C.REPAS_DATE_EXCEPTION); }
		if(dateRepas.isBefore(LocalDate.now())) { throw new RepasException(C.REPAS_DATE_EXCEPTION); }
		this.dateRepas = dateRepas;
	}

	public void setTypeRepas(final TypeRepas typeRepas) throws RepasException {
		if(Objects.isNull(typeRepas)) { throw new RepasException(C.REPAS_TYPE_REPAS_EXCEPTION); }
		this.typeRepas = typeRepas;
	}
	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Repas repas = (Repas) o;
		return getId().equals(repas.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	//</editor-fold>

	//<editor-fold desc="ToString">

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Repas{");
		sb.append("dateRepas=").append(dateRepas);
		sb.append(", lstRegimeAlimentaire=").append(lstRegimeAlimentaire);
		sb.append(", typeRepas=").append(typeRepas);
		sb.append('}');
		return sb.toString();
	}

	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	public void ajouterRegimeAlimentaire(final RegimeAlimentaire regimeAlimentaire) throws RegimeAlimentaireException {
		if(Objects.isNull(regimeAlimentaire)) { throw new RegimeAlimentaireException(C.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION); }
		if(!lstRegimeAlimentaire.contains(regimeAlimentaire)) {
			lstRegimeAlimentaire.add(regimeAlimentaire);
		} else {
			throw new RegimeAlimentaireException(C.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
		}
	}
	//</editor-fold>
} 