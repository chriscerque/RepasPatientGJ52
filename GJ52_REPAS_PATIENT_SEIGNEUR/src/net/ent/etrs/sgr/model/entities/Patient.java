package net.ent.etrs.sgr.model.entities;

import net.ent.etrs.sgr.model.exceptions.PatientException;
import net.ent.etrs.sgr.model.references.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> lsRegimeAlimentaire = new ArrayList<>();
    private List<Repas> lsRepas = new ArrayList<>();
    private String id;
    private LocalDate dateEntree;
    private String numSecu;

    public Patient(String num, String nom, String pre, LocalDate entree) throws PatientException {
        setNumSecu(num);
        setNom(nom);
        setPrenom(pre);
        setDateEntree(entree);

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<RegimeAlimentaire> getLsRegimeAlimentaire() {
        return lsRegimeAlimentaire;
    }

    public List<Repas> getLsRepas() {
        return lsRepas;
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

    public void setNom(String nom) throws PatientException {
        if (Objects.isNull(nom)){
            throw new PatientException(C.MSG_NOM_PATIENT_NULL_EXCEPTION);
        }
        if (nom.length() < C.LONGUEUR_NOM_MIN || nom.length() > C.LONGUEUR_NOM_MAX){
            throw new PatientException(C.MSG_NOM_LENGTH_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if (Objects.isNull(prenom)){
            throw new PatientException(C.MSG_PRENOM_PATIENT_NULL_EXCEPTION);
        }
        if (prenom.length() < C.LONGUEUR_NOM_MIN || prenom.length() > C.LONGUEUR_NOM_MAX){
            throw new PatientException(C.MSG_NOM_LENGTH_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if (Objects.isNull(dateEntree)){
            throw new PatientException(C.MSG_DATE_ENTREE_NULL_EXCEPTION);
        }
        if (dateEntree.isAfter(LocalDate.now())){
            throw new PatientException(C.MSG_DATE_ENTREE_FUTUR_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(String numSecu) throws PatientException {
        if (Objects.isNull(numSecu)){
            throw new PatientException(C.MSG_NUM_SECU_NULL_EXCEPTION);
        }
        if (numSecu.length() != C.NUM_SECU_LENGTH){
            throw new PatientException(C.MSG_NUM_SECU_LENGTH_EXCEPTION);
        }
        this.numSecu = numSecu;
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire reg) throws PatientException {
        if (Objects.isNull(reg))
        {
            throw new PatientException(C.MSG_PATIENT_REGIME_NULL);
        }
        if (this.lsRegimeAlimentaire.contains(reg)){
            throw new PatientException(C.MSG_REGIME_PATIENT_DOUBLON);
        }
    this.lsRegimeAlimentaire.add(reg);
    }

    public void ajouterRepas(Repas rep){
        try {
            controlerRegimeAlimentaire(rep);
            this.lsRepas.add(rep);
        } catch (PatientException e) {
            System.out.println(e.getMessage());
        }

    }

    private void controlerRegimeAlimentaire(Repas rep) throws PatientException {
        if (Objects.isNull(rep)) {
            throw new PatientException(C.MSG_REPAS_NULL_EXCEPTION);
        }
        for (RegimeAlimentaire reg : this.getLsRegimeAlimentaire()){
            if (!rep.getLsRegimeAlimentaire().contains(reg)){
                throw new PatientException(C.MSG_REPAS_INCOMPATIBLE_PATIENT);
            }
        }
    }

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

    @Override
    public String toString() {
        String st = String.format("%s %s, num_sécu : %s", this.getNom(), this.getPrenom(), this.getNumSecu());
        return st;
    }
}
