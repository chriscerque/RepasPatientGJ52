package model.entities;

import model.entities.exceptions.PatientException;
import model.references.C;
import model.references.C_MSG;
import model.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.*;

public class Patient {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> lstRegimeAlimentaire;
    private List<Repas> lstRepas;
    private String id;
    private LocalDate dateEntree;
    private String numSecu;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected Patient(String nom, String prenom, String numSecu, LocalDate dateEntree) throws PatientException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumSecu(numSecu);
        this.setDateEntree(dateEntree);
        this.lstRegimeAlimentaire = new ArrayList<>();
        this.lstRepas = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    // +-------------------------------------------+
    // |              GETTERS SETTERS              |
    // +-------------------------------------------+

    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return Collections.unmodifiableList(this.lstRegimeAlimentaire);
    }
    public List<Repas> getLstRepas() {
        return Collections.unmodifiableList(this.lstRepas);
    }
    public String getId() {
        return this.id;
    }
    public LocalDate getDateEntree() {
        return this.dateEntree;
    }
    public String getNumSecu() {
        return this.numSecu;
    }

    public void setNom(String nom) throws PatientException {
        if (Objects.isNull(nom)) {
            throw new PatientException(C_MSG.PATIENT_NOM_EXCEPTION);
        }
        if (nom.length() < C.PATIENT_LONGUEUR_NOM_PRENOM_MIN || C.PATIENT_LONGUEUR_NOM_PRENOM_MAX < nom.length()) {
            throw new PatientException(C_MSG.PATIENT_NOM_PRENOM_LONGUEUR_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if (Objects.isNull(prenom)) {
            throw new PatientException(C_MSG.PATIENT_PRENOM_EXCEPTION);
        }
        if (prenom.length() < C.PATIENT_LONGUEUR_NOM_PRENOM_MIN || C.PATIENT_LONGUEUR_NOM_PRENOM_MAX < prenom.length()) {
            throw new PatientException(C_MSG.PATIENT_NOM_PRENOM_LONGUEUR_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if (Objects.isNull(dateEntree)) {
            throw new PatientException(C_MSG.PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if (dateEntree.isAfter(LocalDate.now())) {
            throw new PatientException(C_MSG.PATIENT_DATE_ENTREE_FUTUR_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(String numSecu) throws PatientException {
        if (Objects.isNull(numSecu)) {
            throw new PatientException(C_MSG.PATIENT_NUMSECU_EXCEPTION);
        }
        if (numSecu.length() != C.PATIENT_LONGUEUR_NUMSECU) {
            throw new PatientException(C_MSG.PATIENT_NUMSECU_LONGUEUR_EXCEPTION);
        }
        this.numSecu = numSecu;
    }

    // +-------------------------------------------+
    // |                HASH EQUALS                |
    // +-------------------------------------------+

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(this.numSecu, patient.numSecu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numSecu);
    }

    // +-------------------------------------------+
    // |                 TO STRING                 |
    // +-------------------------------------------+

    // +-------------------------------------------+
    // |              AUTRES METHODES              |
    // +-------------------------------------------+

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regime) throws PatientException {
        if (Objects.isNull(regime)) {
            throw new PatientException(C_MSG.PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if (this.lstRegimeAlimentaire.contains(regime)) {
            throw new PatientException(C_MSG.PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lstRegimeAlimentaire.add(regime);
    }

    public void ajouterRepas(Repas repas) throws PatientException {
        if (Objects.isNull(repas)) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        this.controlerRegimeAlimentaire(repas);
        this.lstRepas.add(repas);
    }

    private void controlerRegimeAlimentaire(Repas repas) throws PatientException {
        if (!repas.getLstRegimeAlimentaire().containsAll(this.lstRegimeAlimentaire)) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }
    }
}
