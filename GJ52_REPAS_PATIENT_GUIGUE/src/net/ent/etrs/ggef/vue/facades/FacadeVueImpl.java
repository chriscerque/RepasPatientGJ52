package net.ent.etrs.ggef.vue.facades;

import net.ent.etrs.ggef.model.entities.Patient;
import net.ent.etrs.ggef.model.entities.Repas;
import net.ent.etrs.ggef.model.references.enumeration.RegimeAlimentaire;
import net.ent.etrs.ggef.vue.facades.exceptions.DisplayException;
import net.ent.etrs.ggef.vue.ihm.FabriqueIhm;
import net.ent.etrs.ggef.vue.ihm.Ihm;
import net.ent.etrs.ggef.vue.ihm.ModeAffichage;
import net.ent.etrs.ggef.vue.ihm.referencies.IhmConstantes;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class FacadeVueImpl implements FacadeVue {

/*----------------------
Attributs +0+1
-----------------------*/

    private Ihm ihm;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected FacadeVueImpl() {
        this.ihm = FabriqueIhm.creerIhmConsole();
    }

/*----------------------
AUTRES METHODES
-----------------------*/

    @Override
    public void definirModeAffichage(final ModeAffichage modeAffichage) {
        if(modeAffichage.equals(ModeAffichage.PANEL)){
            this.ihm = FabriqueIhm.creerIhmPanel();
        }else {
            this.ihm = FabriqueIhm.creerIhmConsole();
        }
    }

    @Override
    public void definirModeAffichage(final String modeAffichage) {
        if(modeAffichage.equalsIgnoreCase(ModeAffichage.PANEL.name())){
            this.ihm = FabriqueIhm.creerIhmPanel();
        }else {
            this.ihm = FabriqueIhm.creerIhmConsole();
        }
    }

    @Override
    public void afficherMessage(String msg) {
        this.ihm.afficherChaine(msg);
    }

    @Override
    public void afficherMessageErreur(String msg) {
        this.ihm.afficherErreur(msg);
    }

    @Override
    public int afficherMenu() {
        int choixMenu = 0;

        choixMenu = this.ihm.saisirChoixMenu("Repas patient","sortir",IhmConstantes.MENU);

        return choixMenu;
    }

    @Override
    public void afficherPatient(Patient patient) {
        this.ihm.afficherChaine(patient.toString());
    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        this.ihm.afficherTableau1D("Liste des patients", lstPatients.toArray());
    }

    @Override
    public Patient saisirPatient() throws DisplayException {
        return null;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        int choixMenu = 0;
        Patient unPatient = null;
        choixMenu = this.ihm.saisirChoixMenu("Sélectionnez un patient", "retour",lstPatients.toArray() );
        unPatient = lstPatients.get(choixMenu-1);

        return unPatient;
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        return null;
    }

    @Override
    public Patient modifierPatient(Patient patient) throws DisplayException {
        return null;
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        return null;
    }


    private RegimeAlimentaire selectionnerRegimeAlimentaireSimple(List<RegimeAlimentaire> uneListeRegimeAlimentaire){
        return null;
    }

    private void afficherLstRegimeAlimentaireSimple(List<RegimeAlimentaire> uneListeRegimeAlimentaire){

    }

    private List<RegimeAlimentaire> selectionnerRegimeAlimentaire(List<RegimeAlimentaire> uneListeRegimeAlimentaire, boolean vrai_faux){
    return null;
    }

    private LocalDate saisirDateEntree(LocalDate uneDateEntree, boolean vrai_faux){

        return uneDateEntree;
    }

    private String  formatterRegimeAlimentaireRepas(List<RegimeAlimentaire> uneListeRegimeAlimentaire){
        return null;
    }

    private String  saisirString(String chaine1, String chaine2, boolean vrai_faux){
        return null;
    }



}  // fin de classe

