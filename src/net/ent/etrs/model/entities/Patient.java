package net.ent.etrs.model.entities;


import net.ent.etrs.model.exceptions.PatientException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.model.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.*;

/**
 * Definie un contact.
 * identité basé sur l'uuid
 * un contact à un nom, prenom date de naissance et une liste de coordonnees
 *
 * @author christophe.cerqueira
 */

public class Patient {

    private final String id = UUID.randomUUID().toString();

    private String numSecu;
    private String nom;
    private String prenom;

    private LocalDate dateEntree;

    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();

    private List<Repas> lstRepas = new ArrayList<>();

    protected Patient(String numSecu, String nom, String prenom, LocalDate dateEntree) throws PatientException {
        this.setNumSecu(numSecu);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateEntree(dateEntree);
    }


    public List<Repas> getLstRepas() {
        return Collections.unmodifiableList(lstRepas);
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws PatientException {
        if (Objects.isNull(regimeAlimentaire)) {
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if (this.lstRegimeAlimentaire.contains(regimeAlimentaire)) {
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lstRegimeAlimentaire.add(regimeAlimentaire);
    }

    public void ajouterRepas(final Repas repas) throws PatientException {
        this.controlerRegimeAlimentaire(repas);
        this.lstRepas.add(repas);
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return Collections.unmodifiableList(lstRegimeAlimentaire);
    }

    private void controlerRegimeAlimentaire(Repas repas) throws PatientException {
        if (Objects.isNull(repas)) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
//        //TODO sout
//        System.out.println("this.lstRegimeAlimentaire : " + this.lstRegimeAlimentaire);
//        System.out.println("repas.getLstRegimeAlimentaire() : " + repas.getLstRegimeAlimentaire());
        if (!repas.getLstRegimeAlimentaire().containsAll(this.lstRegimeAlimentaire)) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }
    }

    public String getId() {
        return id;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        //TODO
        this.numSecu = numSecu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PatientException {
        if (Objects.isNull(nom) || nom.isBlank()) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        this.nom = nom.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if (Objects.isNull(prenom) || prenom.isBlank()) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if (Objects.isNull(dateEntree)) {
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if (dateEntree.isAfter(LocalDate.now())) {
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(numSecu, patient.numSecu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSecu);
    }
}
