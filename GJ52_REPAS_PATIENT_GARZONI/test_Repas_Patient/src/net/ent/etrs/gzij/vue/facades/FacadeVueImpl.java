package net.ent.etrs.gzij.vue.facades;

import net.ent.etrs.gzij.model.entities.EntitiesFactory;
import net.ent.etrs.gzij.model.entities.Patient;
import net.ent.etrs.gzij.model.entities.Repas;
import net.ent.etrs.gzij.model.exceptions.PatientException;
import net.ent.etrs.gzij.model.references.constantes.C_MSG;
import net.ent.etrs.gzij.model.references.enums.RegimeAlimentaire;
import net.ent.etrs.gzij.vue.ihm.FabriqueIhm;
import net.ent.etrs.gzij.vue.ihm.Ihm;
import net.ent.etrs.gzij.vue.ihm.ModeAffichage;
import net.ent.etrs.gzij.vue.ihm.exceptions.ExceptionsIhm;
import net.ent.etrs.gzij.vue.ihm.exceptions.ViewException;
import net.ent.etrs.gzij.vue.ihm.referencies.C_VIEW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static net.ent.etrs.gzij.vue.ihm.referencies.IhmConstantes.TABLO_STR_MENU_PRINCIPAL;
import static net.ent.etrs.gzij.vue.ihm.referencies.IhmConstantes.TITRE_MENU_PRINCIPAL;

public class FacadeVueImpl implements IFacadeVue {

/*----------------------
Attributs +0+1
-----------------------*/

    private Ihm ihm;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected FacadeVueImpl() {

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
    public int afficherMenuPrincipal() {
        return this.ihm.saisirChoixMenuPrincipal(TITRE_MENU_PRINCIPAL, TABLO_STR_MENU_PRINCIPAL);
    }

    @Override
    public void afficherMessage(final String msg) {
        this.ihm.afficherChaine(msg);
    }

    @Override
    public void afficherMessageErreur(final String msg) {
        this.ihm.afficherErreur(msg);
    }

    @Override
    public int afficherMenu() {
        return 0;
    }

    @Override
    public void afficherPatient(final Patient patient) {

    }

    @Override
    public void afficherPatients(final List<Patient> lstPatients) {
        for (Patient patient : lstPatients) {
            StringBuilder sb = new StringBuilder();

            sb.append(C_MSG.CARACTERE_SEPARATEUR);
            sb.append("Patient ").append(patient.getNumSecu());
            sb.append(" ").append(patient.getNom());
            sb.append(" (").append(patient.getNom()).append(")").append(System.lineSeparator());
            sb.append(C_VIEW.ENTETE_REGIME_ALIMENTAIRE_EXISTANT).append(System.lineSeparator());
            if(patient.getLsRegimeAlimentaire().size() != 0) {
                for (RegimeAlimentaire regime : patient.getLsRegimeAlimentaire()) {
                    sb.append("\t\t").append(regime.getLibelle()).append(System.lineSeparator());
                }
            }
            else {
                sb.append(C_VIEW.AUCUN_REGIME_ALIMENTAIRE);
            }

            this.ihm.afficherChaine(sb.toString());
        }
    }

    @Override
    public Patient saisirPatient() throws ViewException {
        Patient patient;

        String numSecu = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "Numéro de sécurité"));
        String nom = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "nom"));
        String prenom = this.ihm.saisirChaine(String.format(C_VIEW.SAISIR_TYPE_MSG, "prénom"));
        LocalDate dateEntree = this.ihm.saisirLocalDate(C_VIEW.SAISIR_DATE_ENTREE);
        try {
            boolean quitter = false;
            patient = EntitiesFactory.fabriquerPatient(numSecu, nom, prenom, dateEntree);
            do {
                if (this.ihm.saisirChoixMenu(C_VIEW.CONTINUER_SELECTION_REGIME_ALIMENTAIRE + " (0 pour oui et 1 pour non) ", 0, 1) == 0) {
                    int choixMenu = this.ihm.saisirChoixMenu(C_VIEW.MSG_SELECTIONNER_REGIME_ALIMENTAIRE, "Annuler", RegimeAlimentaire.values());
                    patient.ajouterRegimeAlimentaire(RegimeAlimentaire.values()[choixMenu - 1]);
                }
                else {
                    quitter = true;
                }
            } while(!quitter);

        } catch (PatientException e) {
            throw new ViewException(e.getMessage(), e.getCause());
        }

        return patient;
    }

    @Override
    public Patient selectionnerPatient(final List<Patient> lstPatients) {
        String[] lsPatient = new String[lstPatients.size()];

        for (int i = 0; i < lstPatients.size(); i++) {
            lsPatient[i] = String.format("%s %s", lstPatients.get(i).getNom(), lstPatients.get(i).getNom());
        }

        int choixMenu = this.ihm.saisirChoixMenu("Sélectionner un contact", "Annuler", lsPatient);

        if(choixMenu != 0) {
            return lstPatients.get(choixMenu - 1);
        } else {
            return null;
        }
    }

    @Override
    public List<Repas> selectionnerRepas(final List<Repas> lstRepas) {
        boolean quitter = false;
        List<Repas> repas = new ArrayList<>();

        do {
            String[] lsRepas = new String[lstRepas.size()];

            for (int i = 0; i < lstRepas.size(); i++) {
                lsRepas[i] = String.format("%s %s :%n", lstRepas.get(i).getDateRepas().toString(), lstRepas.get(i).getTypeRepas());
                for(RegimeAlimentaire regime : lstRepas.get(i).getLsRegimeAlimentaire()) {
                    lsRepas[i] += String.format("| %s\t", regime.getLibelle());
                }
            }

            int choixMenu = this.ihm.saisirChoixMenu("Sélectionner un repas", "Annuler", lsRepas);

            if(choixMenu == 0) {
                quitter = true;
            } else {
                repas.add(lstRepas.get(choixMenu - 1));

                if(this.ihm.saisirChoixMenu(C_VIEW.CONTINUER_SELECTION_REPAS + " (0 pour oui et 1 pour non) ", 0, 1) == 1) {
                    quitter = true;
                }
            }

        } while(!quitter);

        return repas;
    }

    @Override
    public Patient modifierPatient(final Patient patient) throws ViewException {
        Patient newPatient = patient;
        try {
            if (this.ihm.saisirChoixMenu(String.format(C_VIEW.MSG_MODIF_QUESTION, "nom") + " (0 pour oui et 1 pour non) ", 0, 1) == 0) {
                newPatient.setNom(this.ihm.saisirChaine(String.format(C_VIEW.MSG_ACTUEL, newPatient.getNom())));
            }

            if (this.ihm.saisirChoixMenu(String.format(C_VIEW.MSG_MODIF_QUESTION, "prénom") + " (0 pour oui et 1 pour non) ", 0, 1) == 0) {
                newPatient.setPrenom(this.ihm.saisirChaine(String.format(C_VIEW.MSG_ACTUEL, newPatient.getPrenom())));
            }

            if (this.ihm.saisirChoixMenu(String.format(C_VIEW.MSG_MODIF_QUESTION, "Date d'entrée") + " (0 pour oui et 1 pour non) ", 0, 1) == 0) {
                newPatient.setDateEntree(this.ihm.saisirLocalDate(String.format(C_VIEW.MSG_ACTUEL, newPatient.getDateEntree())));
            }

        } catch(PatientException e) {
            throw new ViewException(e.getMessage(), e.getCause());
        }
        return newPatient;
    }

    @Override
    public Patient ajouterRepasPatient(final List<Patient> lstPatients, List<Repas> listRepas) throws ViewException {
        Patient patient = selectionnerPatient(lstPatients);
        List<Repas> lsRepas = selectionnerRepas(listRepas);
        try {
            if (Objects.nonNull(patient) && Objects.nonNull(lsRepas)) {
                for (Repas repas : lsRepas) {
                    patient.ajouterRepas(repas);
                }
            }
        } catch(PatientException e) {
            throw new ViewException(e.getMessage(), e.getCause());
        }

        return patient;
    }
}  // fin de classe

