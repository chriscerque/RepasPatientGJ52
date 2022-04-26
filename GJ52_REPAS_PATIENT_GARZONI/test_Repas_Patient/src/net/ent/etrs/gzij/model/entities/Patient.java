package net.ent.etrs.gzij.model.entities;

import net.ent.etrs.gzij.model.dao.commons.ID;
import net.ent.etrs.gzij.model.exceptions.PatientException;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;
import net.ent.etrs.gzij.model.references.enums.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient implements ID<String> {
/*----------------------
Attributs +0+1
-----------------------*/
    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> lsRegimeAlimentaire;
    private List<Repas> lsRepas;
    private String id;
    private LocalDate dateEntree;
    private String numSecu;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected Patient(final String nom, final String prenom, final LocalDate dateEntree, final String numSecu) throws PatientException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setId(UUID.randomUUID().toString());
        this.setDateEntree(dateEntree);
        this.setNumSecu(numSecu);
        this.lsRegimeAlimentaire = new ArrayList<>();
        this.lsRepas = new ArrayList<>();
    }

    /*----------------------
    GETTERS
    -----------------------*/
    @Override
    public String getId() {
        return id;
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

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public String getNumSecu() {
        return numSecu;
    }

/*----------------------
SETTERS
-----------------------*/

    public void setNom(final String nom) throws PatientException {
        if(Objects.isNull(nom)) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if(nom.length() < 3 || nom.length() > 50) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_TAILLE_INCORRECT);
        }
        this.nom = nom;
    }

    public void setPrenom(final String prenom) throws PatientException {
        if(Objects.isNull(prenom)) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if(prenom.length() < 3 || prenom.length() > 50) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_TAILLE_INCORRECT);
        }
        this.prenom = prenom;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setDateEntree(final LocalDate dateEntree) throws PatientException {
        if(Objects.isNull(dateEntree)) {
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }

        if (LocalDate.now().isBefore(dateEntree)) {
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(final String numSecu) throws PatientException {
        if(Objects.isNull(numSecu)){
            throw new PatientException(C_MSG.MSG_PATIENT_NUMSECU_EXCEPTION);
        }

        if(numSecu.length() != 5) {
            throw new PatientException(C_MSG.MSG_PATIENT_NUMSECU_TAILLE_INCORRECT);
        }

        this.numSecu = numSecu;
    }
    /*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId().equals(patient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    /*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Patient{");
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
    public void ajouterRepas(final Repas repas) throws PatientException {
        if(Objects.isNull(repas)) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        try{
            controlerRegimeAlimentaire(repas);
        } catch(PatientException e) {
            throw new PatientException(e.getMessage(), e.getCause());
        }

        this.lsRepas.add(repas);
    }

    public void ajouterRegimeAlimentaire(final RegimeAlimentaire regime) throws PatientException {
        if(Objects.isNull(regime)) {
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if(this.lsRegimeAlimentaire.contains(regime)) {
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        }
        this.lsRegimeAlimentaire.add(regime);
    }

    /**
     * Méthode permettant controler le régime alimentaire du repas avce celui du patient.
     *
     * @param repas Repas à tester
     * @throws PatientException si le régime ne correcspond pas, lève une exception
     */
    private void controlerRegimeAlimentaire(final Repas repas) throws PatientException {
        int contient = 0;

       for (RegimeAlimentaire regime : this.lsRegimeAlimentaire) {
            if(repas.getLsRegimeAlimentaire().contains(regime)) {
                contient++;
            }
        }

        if(contient != this.lsRegimeAlimentaire.size()) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }
    }


}  // fin de classe
