package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.entities.exceptions.PatientException;
import ent.etrs.pdi.pre.model.entities.references.ConstantesModel;
import ent.etrs.pdi.pre.model.entities.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient {
    /*------- ATTRIBUTS -------*/
    private String id;
    private String nom;
    private String prenom;
    private String numSecu;
    private LocalDate dateEntree;
    private List<Repas> lstRepas = new ArrayList<>();
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    public Patient(String nom, String prenom, String numSecu, LocalDate dateEntree) throws PatientException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumSecu(numSecu);
        this.setDateEntree(dateEntree);
        this.id = UUID.randomUUID().toString();
    }
    /*------- ASCESSEURS -------*/
    // GETTER
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public List<Repas> getLstRepas() {
        return lstRepas;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return lstRegimeAlimentaire;
    }

    // SETTER
    public void setNom(String nom) throws PatientException {
        if (Objects.isNull(nom)){
            throw new PatientException(ConstantesModel.MSG_PATIENT_NOM_EXCEPTION);
        }
        if (nom.length() < 3 || nom.length() > 50){
            throw new PatientException(ConstantesModel.MSG_PATIENT_NOM_INCORRECT_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if (Objects.isNull(prenom)){
            throw new PatientException(ConstantesModel.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if (prenom.length() < 3 || prenom.length() > 50){
            throw new PatientException(ConstantesModel.MSG_PATIENT_PRENOM_INCORRECT_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public void setNumSecu(String numSecu) throws PatientException {
        if (Objects.isNull(numSecu)){
            throw new PatientException(ConstantesModel.MSG_PATIENT_NUM_SECU_EXCEPTION);
        }
        if (numSecu.length() != 5){
            throw new PatientException(ConstantesModel.MSG_PATIENT_NUM_SECU_INCORRECT_EXCEPTION);
        }
        this.numSecu = numSecu;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if (Objects.isNull(dateEntree)){
            throw new PatientException(ConstantesModel.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if (dateEntree.isAfter(LocalDate.now())){
            throw new PatientException(ConstantesModel.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    /*------- EQUALS / HASH CODE -------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getNumSecu(), patient.getNumSecu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumSecu());
    }

    /*------- TO STRING -------*/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", numSecu='").append(numSecu).append('\'');
        sb.append(", dateEntree=").append(dateEntree);
        sb.append('}');
        return sb.toString();
    }

    /*------- AUTRES METHODES -------*/
    private void controlerRegimeAlimentaire(Repas repas) throws PatientException {
        boolean contient = true;
        for (int i = 0; i < lstRegimeAlimentaire.size(); i++) {
            if (!repas.getLstRegimeAlimentaire().contains(lstRegimeAlimentaire.get(i))){
                contient = false;
            }
        }
        if (!contient){
            throw new PatientException(ConstantesModel.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }
    }

    public void ajouterRepas(Repas repas) throws PatientException {
        try {
            controlerRegimeAlimentaire(repas);
        } catch (PatientException patientException) {
            throw new PatientException(ConstantesModel.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire){
        if (!lstRegimeAlimentaire.contains(regimeAlimentaire)){
            lstRegimeAlimentaire.add(regimeAlimentaire);
        }
    }
}
