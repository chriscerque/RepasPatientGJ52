package marine.etrs.model_Metier.entities_Class_Factory;

import net.ent.etrs.model.references.C_MSG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Repas {


	private LocalDate dateRepas;
	private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
	private String id = UUID.randomUUID().toString();
	private TypeRepas typeRepas;

	public Repas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {

		setDateRepas(dateRepas);
		setTypeRepas(typeRepas);
	}

	public LocalDate getDateRepas() {
		return dateRepas;
	}

	public void setDateRepas(LocalDate dateRepas) throws RepasException {
		if(Objects.isNull(dateRepas)){

			throw new RepasException(C_MSG.REPAS_DATE_EXCEPTION);
		}

		this.dateRepas = dateRepas;
	}

	public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
		return lstRegimeAlimentaire;
	}

	public void setLstRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) throws RepasException {
		if (lstRegimeAlimentaire.isEmpty()){
			throw new RepasException(C_MSG.MSG_AUCUN_REPAS);
		}

		this.lstRegimeAlimentaire = lstRegimeAlimentaire;
	}

	public String getId() {
		return id;
	}


	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	public void setTypeRepas(TypeRepas typeRepas) throws RepasException {
		if(!typeRepas.equals(typeRepas))
			throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);

		if(Objects.isNull(typeRepas)){
			throw new RepasException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
		}
		this.typeRepas = typeRepas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Repas)) return false;
		Repas repas = (Repas) o;
		return getId().equals(repas.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	/*
	AJOUT D'UN REGIME DANS LA LISTE REGIME ALIMENTAIRE
	 */
	public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire){
		// TODO RECHECK LA METHODE
		lstRegimeAlimentaire.add(regimeAlimentaire);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Repas{");
		sb.append("dateRepas=").append(dateRepas);
		sb.append(", id='").append(id).append('\'');
		sb.append(", typeRepas=").append(typeRepas);
		sb.append('}');
		return sb.toString();
	}
}