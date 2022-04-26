package net.ent.etrs.pdi.vbt.model.entities;

import net.ent.etrs.pdi.vbt.model.entities.exceptions.PatientException;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.RegimeAlimentaireException;
import net.ent.etrs.pdi.vbt.model.entities.exceptions.RepasException;
import net.ent.etrs.pdi.vbt.model.entities.references.C_MSG;
import net.ent.etrs.pdi.vbt.model.entities.references.RegimeAlimentaire;

import java.time.LocalDate;
import java.util.*;

public class Patient {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private String nom;
    private String prenom;
    private List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    private List<Repas> lstRepas = new ArrayList<>();
    private String id;
    private LocalDate dateEntree;
    private String numSecu;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected Patient(String numSecu, String nom, String prenom, LocalDate dateEntree) throws PatientException {
        this.id = UUID.randomUUID().toString();
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateEntree(dateEntree);
        this.setNumSecu(numSecu);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    SETTERS	                         				//
    //////////////////////////////////////////////////////////////////////////////////////////

    public void setNom(String nom) throws PatientException {
        if (Objects.isNull(nom)) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if (nom.length()<C_MSG.PATIENT_NOM_TAILLE_MINIMUM || nom.length()>C_MSG.PATIENT_NOM_TAILLE_MAXIMUM ) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_INVALIDE_EXCEPTION);
        }
        this.nom = nom.toUpperCase();
    }

    public void setPrenom(String prenom) throws PatientException {
        if (Objects.isNull(nom)) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        if (nom.length()<C_MSG.PATIENT_NOM_TAILLE_MINIMUM || nom.length()>C_MSG.PATIENT_NOM_TAILLE_MAXIMUM ) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_INVALIDE_EXCEPTION);
        }
        this.prenom = prenom.substring(0,1).toUpperCase() + prenom.substring(1).toLowerCase();;
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

    public void setNumSecu(String numSecu) throws PatientException {
        if (Objects.isNull(numSecu)) {
            throw new PatientException(C_MSG.MSG_PATIENT_NUMSECU_EXCEPTION);
        }
        if (numSecu.length()!=C_MSG.PATIENT_NUMSECU_TAILLE) {
            throw new PatientException(C_MSG.MSG_PATIENT_NUMSECU_INVALIDE_EXCEPTION);
        }
        this.numSecu = numSecu;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    GETTERS					                      	//
    //////////////////////////////////////////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////SPECIFICS/////////////////////////////////////////

    //                                      TO STRING                                       //

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

    //			                        EQUALS & HASH CODE					                //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(numSecu, patient.numSecu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSecu);
    }

    //////////////////////////////////////////OTHERS//////////////////////////////////////////

    /**
     * Méthode qui permet d'ajouter un régime alimentaire au patient
     * @param regimeAlimentaire : le régime alimentaire à ajouter
     * @throws RegimeAlimentaireException : retourne une erreur si le régime alimentaire est null ou s'il existe déjà
     */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) throws RegimeAlimentaireException {
        if (Objects.isNull(regimeAlimentaire)) {
            throw new RegimeAlimentaireException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        if (this.lstRegimeAlimentaire.contains(regimeAlimentaire)) {
            throw new RegimeAlimentaireException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);
        } else {
            this.lstRegimeAlimentaire.add(regimeAlimentaire);
        }
    }

    public void ajouterRepas(Repas repas) throws RegimeAlimentaireException, PatientException {
        if (Objects.isNull(repas)) {
            throw new RegimeAlimentaireException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        //controlerRegimeAlimentaire(repas);
        this.lstRepas.add(repas);
    }

    private void controlerRegimeAlimentaire(Repas repas) throws RegimeAlimentaireException, PatientException {
        if (Objects.isNull(repas)) {
            throw new RegimeAlimentaireException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_EXCEPTION);
        }
        boolean controleRegime = true;
        for (RegimeAlimentaire regimeAlimentaireRepas : repas.getLstRegimeAlimentaire()) {
            if (!this.lstRegimeAlimentaire.contains(regimeAlimentaireRepas)) {
                controleRegime = false;
            }
        }
        if (!controleRegime) {
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }
    }

}
