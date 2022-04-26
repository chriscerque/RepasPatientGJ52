package net.ent.etrs.rnbm.view;

import net.ent.etrs.rnbm.model.commons.exceptions.ExceptionsConstructeur;
import net.ent.etrs.rnbm.model.entities.FactoryMetier;
import net.ent.etrs.rnbm.model.entities.Patient;
import net.ent.etrs.rnbm.model.entities.Repas;
import net.ent.etrs.rnbm.model.exceptions.PatientConstructionException;
import net.ent.etrs.rnbm.model.references.constantes.C_MSG;
import net.ent.etrs.rnbm.model.references.constantes.ConstanteMetier;
import net.ent.etrs.rnbm.model.references.enumerateds.RegimeAlimentaire;
import net.ent.etrs.rnbm.view.exceptions.ViewException;
import net.ent.etrs.rnbm.view.ihm.FactoryIhm;
import net.ent.etrs.rnbm.view.ihm.Ihm;
import net.ent.etrs.rnbm.view.ihm.commons.outilsIhm.MesOutilsIhm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FacadeVueImpl implements FacadeVue {
    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    /**
     * Pour une vue panel utiliser : fabriquerIhmJPanel();
     */
    private Ihm vue = FactoryIhm.fabriquerIhmConsole();

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected FacadeVueImpl(){}

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void afficherMessage( final String msg) {

    }

    @Override
    public void afficherMessageErreur( final String msg) {

    }

    @Override
    public int afficherMenu() {
        int choix = -1;
        try{
            choix = vue.saisirChoixMenu(ConstanteMetier.MENU,0,ConstanteMetier.MENU.length,true);
        } catch (ExceptionsConstructeur e) {
            vue.afficherChaine(e.getMessage());
        }
        return choix;
    }

    @Override
    public void afficherPatient( final Patient patient) {

    }

    @Override
    public void afficherPatients( final List<Patient> lstPatients) {
        vue.afficherChaine(lstPatients.toString());

    }

    @Override
    public Patient saisirPatient() throws ViewException {
        String numSecu = " ";
        String date = " ";
        String nom = " ";
        String prenom = " ";

        do {
            numSecu = vue.saisirChaine(C_MSG.MSG_SAISIE_NUM_SECU);
            nom = vue.saisirChaine(C_MSG.MSG_SAISIE_NOM);
            prenom = vue.saisirChaine(C_MSG.MSG_SAISIE_PRENOM);
            date = vue.saisirChaine(C_MSG.MSG_SAISIE_DATE_ENTREE);

        }while (numSecu.length() != ConstanteMetier.LENGTH_NUM_SECU || nom.length() <  ConstanteMetier.MIN_LENGTH_NOM
                || nom.length() > ConstanteMetier.MAX_LENGTH_NOM || prenom.length() < ConstanteMetier.MIN_LENGTH_PRENOM
                || prenom.length() > ConstanteMetier.MAX_LENGTH_PRENOM);

        LocalDate dateEntree = LocalDate.parse(date, DateTimeFormatter.ofPattern(ConstanteMetier.PATTERN_DATE_ENTREE));
        Patient patient = null;

        patient = choisirRegimeAlimentaire(numSecu, nom, prenom, dateEntree);



        return patient;
    }

    private Patient choisirRegimeAlimentaire( final String numSecu, final String nom, final String prenom, final LocalDate dateEntree) {
        Patient patient = null;

            int choix = -1;

            List<String> optionRegimeAlimentaire = new ArrayList<>();
            for (RegimeAlimentaire regime : RegimeAlimentaire.values()){
                optionRegimeAlimentaire.add(regime.getLibelle());
            }
            do {
                try {
                    choix = vue.saisirChoixMenu(MesOutilsIhm.creerMenuFromEnum(optionRegimeAlimentaire.toArray(),"-- Liste régime alimentaire --", ""),1,RegimeAlimentaire.values().length, false);
                RegimeAlimentaire regimeAli = RegimeAlimentaire.values()[choix-1];

                patient = FactoryMetier.fabriquerPatient(numSecu, nom, prenom, dateEntree);
                patient.ajouterRegimeAlimentaire(regimeAli);
                return patient;
                } catch (Exception e) {
                    vue.afficherChaine(e.getMessage());
                }
            }while (choix != RegimeAlimentaire.values().length);

            return null;

    }

    @Override
    public Patient selectionnerPatient( final List<Patient> lstPatients) {

        int choix = -1;

        String[] tabPatient = new String[lstPatients.size()+2];
        tabPatient[0] = "-- Liste des patients -- ";
        for (int i = 0; i < lstPatients.size(); i++){
                tabPatient[i+1] = lstPatients.get(i).toString();

        }

        try {
            choix = vue.saisirChoixMenu(tabPatient, 1, lstPatients.size()+2, false);

            Patient patient = lstPatients.get(choix-1);
            return patient;
        } catch (ExceptionsConstructeur e) {
            vue.afficherChaine(e.getMessage());
        }
        return null;
    }

    @Override
    public Repas selectionnerRepas( final List<Repas> lstRepas) {
        int choix =  -1;

        String[] tabRepas = new String[lstRepas.size()+2];
        tabRepas[0] = "-- Liste des repas";
        for (int i = 0; i< lstRepas.size(); i++){
            tabRepas[i+1] = lstRepas.get(i).toString();
        }
        try {
            choix = vue.saisirChoixMenu(tabRepas, 1, lstRepas.size()+2, false);

        } catch (ExceptionsConstructeur e) {
            vue.afficherChaine(e.getMessage());
        }
        return lstRepas.get(choix -1);
    }

    @Override
    public Patient modifierPatient( final Patient patient) throws ViewException {
        return null;
    }

    @Override
    public Patient ajouterRepasPatient( final List<Patient> lstPatients, final List<Repas> listRepas) {
        Patient patient = selectionnerPatient(lstPatients);

        Repas repas = selectionnerRepas(listRepas);

        patient.ajouterRepas(repas);

        return patient;
    }

    @Override
    public void affichageFinProgramme() {
        vue.afficherChaine(ConstanteMetier.MSG_FIN_PROGRAMME);
    }


}
