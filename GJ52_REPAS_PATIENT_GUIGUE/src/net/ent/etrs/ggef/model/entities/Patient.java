package net.ent.etrs.ggef.model.entities;

import net.ent.etrs.ggef.model.exceptions.PatientException;
import net.ent.etrs.ggef.model.references.constantes.ConstantesMetier;
import net.ent.etrs.ggef.model.references.enumeration.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Patient {
/*----------------------
Attributs +0+1
-----------------------*/
private String nom;
private String prenom;
private List<RegimeAlimentaire> lstRegimeAlimentaire;
private List<Repas> lstRepas;
private String id;
private LocalDate dateEntree;
private String numSecu;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    public Patient(String nom, String prenom, LocalDate dateEntree, String numSecu) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.numSecu = numSecu;
    }
/*----------------------
GETTERS
-----------------------*/

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
/*----------------------
SETTERS
-----------------------*/

    public void setNom(String unNom) throws PatientException {
        if(unNom == null){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_NOM_NULL);
        }
        if(unNom.length() <3 || unNom.length() > 50){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_NOM_LONGUEUR);
        }
        this.nom = unNom;
    }

    public void setPrenom(String unPrenom) throws PatientException {
        if(unPrenom == null){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if(unPrenom.length() <3 || unPrenom.length() > 50){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_PRENOM_LONGUEUR);
        }
        this.prenom = unPrenom;
    }

    public void setLstRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) {
        this.lstRegimeAlimentaire = lstRegimeAlimentaire;
    }

    public void setLstRepas(List<Repas> lstRepas) {
        this.lstRepas = lstRepas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateEntree(LocalDate uneDateEntree) throws PatientException {
        if(uneDateEntree == null){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if(uneDateEntree.isAfter(ConstantesMetier.DATE_JOUR)){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_DATE_FUTURE);
        }
        this.dateEntree = uneDateEntree;
    }

    public void setNumSecu(String unNumSecu) throws PatientException {
        if(unNumSecu == null){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_NUM_SECU_NULL);
        }
        if(unNumSecu.length() != 5){
            throw new PatientException(ConstantesMetier.MSG_PATIENT_NUM_SECU_LONGUEUR);
        }
        this.numSecu = unNumSecu;
    }
/*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getNumSecu().equals(patient.getNumSecu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumSecu());
    }
/*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", dateEntree=").append(dateEntree);
        sb.append(", numSecu='").append(numSecu).append('\'');
        sb.append('}');
        return sb.toString();
    }
/*----------------------
AUTRES METHODES
-----------------------*/

    private void controlerRegimerAlimentaire(Repas unRepas){


    }

    public void ajouterRepas(Repas unRepas){

    }

    public void ajouterRegimeAlimentaire(RegimeAlimentaire unRegimeAlimentaire){


    }



}  // fin de classe

//TODO: Création Class Patient
// 1-Attributs
// 2-GETTERS
// 3-SETTERS + REGLES DE GESTION
// 4-CONSTRUCTEUR - utiliser les SETTERS
// 5-EQUALS&HASHCODE
// 6-TOSTRING() - avec StringBuilder