package ent.etrs.pdi.hllf.model.entities;

import ent.etrs.pdi.hllf.model.exceptions.PatientException;
import ent.etrs.pdi.hllf.model.references.C_MODEL;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient
{
    //attributs
    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> listRegimeAlimentaire;
    private List<Repas> listRepas;
    private String id;
    private LocalDate dateEntree;
    private String numSecu;

    //constructeurs
    public Patient(String nom, String prenom, String numSecu, LocalDate dateEntree) throws PatientException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumSecu(numSecu);
        this.setDateEntree(dateEntree);
        this.listRegimeAlimentaire = new ArrayList<>();
        this.listRepas = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    //accesseurs
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<RegimeAlimentaire> getListRegimeAlimentaire() {
        return listRegimeAlimentaire;
    }

    public List<Repas> getListRepas() {
        return listRepas;
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
        if(Objects.isNull(nom))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_NOM_NULL);
        }
        if(nom.length()<3 || nom.length()>50)
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_NOM_LONGUEUR);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if(Objects.isNull(prenom))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_PRENOM_NULL);
        }
        if(prenom.length()<3 || prenom.length()>50)
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_PRENOM_LONGUEUR);
        }
        this.prenom = prenom;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if(Objects.isNull(dateEntree))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_DATE_NULL);
        }
        if(dateEntree.isAfter(LocalDate.now()))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_DATE_FUTURISTE);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(String numSecu) throws PatientException {
        if(Objects.isNull(numSecu))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_NUMSECU_NULL);
        }
        if(numSecu.length()!=5)
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_NUMSECU_LONGUEUR);
        }
        this.numSecu = numSecu;
    }

    //methodes
    private void controlerRegimeAlimentaire(Repas repas) throws PatientException {
        if(Objects.isNull(repas))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_REPAS_NULL);
        }
        for (RegimeAlimentaire r: this.listRegimeAlimentaire) {
            if(!repas.getListRegimeAlimentaire().contains(r))
            {
                throw new PatientException(C_MODEL.ERR_PATIENT_REGIME_NON_CONVENABLE);
            }
        }
    }

    public void ajouterRepas(Repas repas) throws PatientException {
        controlerRegimeAlimentaire(repas);
        this.listRepas.add(repas);
    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws PatientException {
        if(Objects.isNull(regimeAlimentaire))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_REGIME_NULL);
        }
        if (this.listRegimeAlimentaire.contains(regimeAlimentaire))
        {
            throw new PatientException(C_MODEL.ERR_PATIENT_REGIME_DEJA_CONNU);
        }
        this.listRegimeAlimentaire.add(regimeAlimentaire);
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
}
