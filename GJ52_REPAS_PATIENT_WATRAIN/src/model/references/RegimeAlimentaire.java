package model.references;

import model.references.exceptions.RegimeAlimentaireException;

public enum RegimeAlimentaire {
	VEGETARIEN("Végétarien"),
	MIXE("Mixe"),
	SANS_SEL("Sans sel"),
	DIABETIQUE("Diabétique"),
	VEGAN("végan");

	private String libelle;

	private RegimeAlimentaire(String libelle) {
		this.setLibelle(libelle);
	}

	public String getLibelle() {
		return this.libelle;
	}

	private void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public RegimeAlimentaire getByLibelle(String libelle) throws RegimeAlimentaireException {
		for(RegimeAlimentaire regime : RegimeAlimentaire.values()) {
			if(regime.getLibelle().equals(libelle)) {
				return regime;
			}
		}
		throw new RegimeAlimentaireException(C.REGIME_ALIMENTAIRE_GET_BY_LIBELLE_EXCEPTION);
	}

}
