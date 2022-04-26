package net.ent.etrs.rnbm.model.entities;

import net.ent.etrs.rnbm.model.exceptions.PatientConstructionException;
import net.ent.etrs.rnbm.model.exceptions.PatientException;
import net.ent.etrs.rnbm.model.exceptions.RepasConstructionException;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;
import net.ent.etrs.rnbm.model.references.constantes.ConstanteMetier;
import net.ent.etrs.rnbm.model.references.enumerateds.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.*;

public class Patient {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    private List<Repas> lstRepas = new ArrayList<>();
    private String id = UUID.randomUUID().toString();
    private LocalDate dateEntree;
    private String numSecu;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected Patient(final String nom, final String prenom, final LocalDate dateEntree, final String numSecu) throws PatientConstructionException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateEntree(dateEntree);
        this.setNumSecu(numSecu);
    }

    /* ****************** */
    /* ***** GETTER ***** */
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

    public String getId() {
        return id;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public String getNumSecu() {
        return numSecu;
    }

    /* ****************** */
    /* ***** SETTER ***** */
    public void setNom(final String nom) throws PatientConstructionException {
        if (Objects.isNull(nom)) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if (nom.length() < ConstanteMetier.MIN_LENGTH_NOM || nom.length() > ConstanteMetier.MAX_LENGTH_NOM) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_NOM_LENGTH_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setPrenom(final String prenom) throws PatientConstructionException {
        if (Objects.isNull(prenom)) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if (prenom.length() < ConstanteMetier.MIN_LENGTH_PRENOM || prenom.length() > ConstanteMetier.MAX_LENGTH_PRENOM) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_PRENOM_LENGTH_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public void setLstRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) {

        //TODO revoir setter list regime alimentaire

        this.lstRegimeAlimentaire = lstRegimeAlimentaire;
    }

    public void setLstRepas(final List<Repas> lstRepas) {
        this.lstRepas = lstRepas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateEntree(final LocalDate dateEntree) throws PatientConstructionException {
        if (Objects.isNull(dateEntree)) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if (dateEntree.isAfter(LocalDate.now())) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(final String numSecu) throws PatientConstructionException {
        if (Objects.isNull(numSecu)) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_NUMSECU_EXCEPTION);
        }
        if (numSecu.length() != ConstanteMetier.LENGTH_NUM_SECU) {
            throw new PatientConstructionException(C_MSG.MSG_PATIENT_LENGTH_NUMSECU);
        }
        this.numSecu = numSecu;
    }

    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getNumSecu().equals(patient.getNumSecu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumSecu());
    }

    /* ********************* */
    /* ***** TO STRING ***** */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(C_MSG.CARACTERE_SEPARATEUR).append("\n");
        sb.append("Patient ").append(getNumSecu()).append(" ").append(getNom()).append(" ( ").append(getPrenom()).append(" )");
        sb.append("\n");
        sb.append("\t").append("Liste des régimes alimentaires :").append("\n");
        for (RegimeAlimentaire regime : getLstRegimeAlimentaire()) {
            sb.append("\t").append("\t").append(regime.getLibelle()).append("\n");
        }
        return sb.toString();
    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    public void ajouterRegimeAlimentaire(final RegimeAlimentaire regime) throws Exception {
        for (RegimeAlimentaire regimeAli : lstRegimeAlimentaire) {
            if (regimeAli.equals(regime)) {
                throw new Exception(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
            }
        }
        this.lstRegimeAlimentaire.add(regime);
    }

    public void ajouterRepas(final Repas repas) {
        this.lstRepas.add(repas);
    }

}
