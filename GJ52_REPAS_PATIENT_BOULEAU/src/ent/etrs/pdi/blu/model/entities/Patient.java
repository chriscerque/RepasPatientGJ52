package ent.etrs.pdi.blu.model.entities;

import ent.etrs.pdi.blu.model.entities.exceptions.PatientException;
import ent.etrs.pdi.blu.model.entities.references.RegimeAlimentaire;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.model.references.C_MSG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient {

////////////////////////////////////////////////////////////////////////////
//----------------------------- ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////

    private String nom;
    private String Prenom;
    private List<RegimeAlimentaire> listRegimeAlimentaires = new ArrayList<>();
    private List<Repas> listRepas = new ArrayList<>();
    private String id = UUID.randomUUID().toString();
    private LocalDate dateEntree;
    private String numSecu;


////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////

    public Patient(final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) throws PatientException {
        setNom(nom);
        setPrenom(prenom);
        setDateEntree(dateEntree);
        setNumSecu(numSecu);
    }


////////////////////////////////////////////////////////////////////////////
//---------------------------- GETTER SETTER -----------------------------//
////////////////////////////////////////////////////////////////////////////

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public List<RegimeAlimentaire> getRegimeAlimentaires() {
        return listRegimeAlimentaires;
    }

    public List<Repas> getRepas() {
        return listRepas;
    }

    public String getId() {
        return String.valueOf(UUID.randomUUID());
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public String getNumSecu() {
        return numSecu;
    }




    public void setNom(String nom) throws PatientException {
        if(Objects.isNull(nom)){
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if(this.nom.length() < 3 || this.nom.length() < 50){
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_LG_EXCEPTION);
        }
        this.nom = nom;
    }



    public void setPrenom(String prenom) throws PatientException {
        if(Objects.isNull(prenom)){
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);
        }
        if(this.Prenom.length() < 3 || this.nom.length() < 50){
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_LG_EXCEPTION);
        }
        Prenom = prenom;
    }



    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if(Objects.isNull(dateEntree)){
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_EXCEPTION);
        }
        if (this.dateEntree.isBefore(LocalDate.now())){
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public void setNumSecu(String numSecu) throws PatientException {
        if(Objects.isNull(numSecu)){
            throw new PatientException(C_MSG.MSG_PATIENT_SECU_EXCEPTION);
        }
        if(numSecu.length() != 5 ){
            throw new PatientException(C_MSG.MSG_PATIENT_SECU_LG_EXCEPTION);
        }
        boolean isNumber = false;
        try {
            Float f = Float.parseFloat(numSecu);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        this.numSecu = numSecu;
    }


    ////////////////////////////////////////////////////////////////////////////
//----------------------------- EQUAL H-CODE -----------------------------//
////////////////////////////////////////////////////////////////////////////

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


////////////////////////////////////////////////////////////////////////////
//-------------------------- AUTRE METHODES ------------------------------//
////////////////////////////////////////////////////////////////////////////


    /**
     * methode permettant de controler qu'il n'y ai pas plusieurs fois le même regime alimentaire
     * @param repas
     * @throws PatientException
     */

    private void controlerRegimeAlimentaire(Repas repas) throws PatientException {
        if(this.listRegimeAlimentaires.contains(repas)){
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXIST_EXCEPTION);

            //TODO controler que la liste regime Alim repas contienne au moins la liste regime Alim patient

        }
    }

    /**
     * methode permettant d'ajouter un repas a la liste repas du patient
     * @param repas
     * @throws PatientException
     */

    public void ajouterRepas(Repas repas) throws PatientException {
        if (Objects.isNull(repas)){
            throw new PatientException(C_MSG.REPAS_TYPE_REPAS_EXCEPTION);
        }

        // verification compatibilité avec list regime alim repas

        if(!repas.getListRegimeAlimentaires().equals(this.listRegimeAlimentaires)){
            throw new PatientException(C_MSG.PATIENT_REPAS_REGIME_ALIMENTAIRE_NON_COMPATIBLE_EXCEPTION);
        }

        this.listRepas.add(repas);
    }


    /**
     * methode permettant d'ajouter un RegimeAlimentaire a la liste RegimeAlimentaire du patient
     * @param regAlim
     * @throws PatientException
     */

    public void ajouterRegimeAlimentaire(RegimeAlimentaire regAlim) throws PatientException {
        if (Objects.isNull(regAlim)){
            throw new PatientException(C_MSG.MSG_PATIENT_REGIME_ALIMENTAIRE_EXCEPTION);
        }

        this.listRegimeAlimentaires.add(regAlim);

    }

}
