package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.PatientException;
import net.ent.etrs.model.exceptions.RepasException;
import net.ent.etrs.model.references.C_MSG;

import java.time.LocalDate;
import java.util.*;

public class Patient {
    /////ATTRIBUTS/////
    private String nom;
    private String prenom;
    private String id;
    private String numSecu;
    List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    List<Repas> lstRepas = new ArrayList<>();
    private LocalDate dateNaissance;

    /////CONSTRUCTEUR/////
    public Patient(String nom, String prenom, String numSecu, LocalDate dateNaissance) {
        try {
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setNumSecu(numSecu);
            this.setDateNaissance(dateNaissance);
            this.id = String.valueOf(UUID.randomUUID());
        } catch (PatientException e) {
            System.out.println(e.getMessage());
        }
    }

    /////ACCESSEURS/////
    //GETTER//
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getId() {
        return id;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return lstRegimeAlimentaire;
    }

    public List<Repas> getLstRepas() {
        return lstRepas;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    //SETTER//
    public void setNom(String nom) throws PatientException {
        if(Objects.isNull(nom))
        {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if(nom.length() < 5 || nom.length() > 30)
        {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_LNG);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if(Objects.isNull(nom))
        {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if(nom.length() < 5 || nom.length() > 30)
        {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_LNG);
        }
        this.prenom = prenom;
    }

    public void setNumSecu(String numSecu) throws PatientException {
//        if(numSecu.length() < 9)
//        {
//            throw new PatientException(C_MSG.MSG_NUM_SECU_LNG_MIN);
//        }
        this.numSecu = numSecu;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws PatientException {
        if(Objects.isNull(dateNaissance))
        {
            throw new PatientException(C_MSG.MSG_DATE_ENTREE_NULL);
        }
        this.dateNaissance = dateNaissance;
    }

    /////IDENTITY/////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return numSecu.equals(patient.numSecu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSecu);
    }

    /////METHODES/////
    /**
     * Méthode permettant d'ajouter un régime alimentaire à la liste des régimes alimentaires du patient.
     * @param regimeAlimentaire: RegimeAlimentaire
     * @throws RepasException si le régime alimentaire est déjà présent dans la liste des régime alimentaires du patient.
     */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws PatientException {
        if(lstRegimeAlimentaire.contains(regimeAlimentaire))
        {
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        else
        {
            lstRegimeAlimentaire.add(regimeAlimentaire);
        }
    }

    /**
     * Méthode permettant d'ajouter un repas à la liste des repas du patient.
     * @param repas: Repas
     */
    public void ajouterRepas(Repas repas) {
        lstRepas.add(repas);
    }
}
