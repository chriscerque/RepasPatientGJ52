package ent.etrs.pdi.pre.view.facades;

import ent.etrs.pdi.pre.model.entities.EntitiesFactory;
import ent.etrs.pdi.pre.model.entities.Patient;
import ent.etrs.pdi.pre.model.entities.Repas;
import ent.etrs.pdi.pre.model.entities.exceptions.PatientException;
import ent.etrs.pdi.pre.model.entities.references.RegimeAlimentaire;
import ent.etrs.pdi.pre.model.entities.references.TypeRepas;
import ent.etrs.pdi.pre.view.exceptions.ViewException;
import ent.etrs.pdi.pre.view.ihm.FactoryIhm;
import ent.etrs.pdi.pre.view.ihm.Ihm;
import ent.etrs.pdi.pre.view.ihm.exceptions.IhmException;
import ent.etrs.pdi.pre.view.references.ConstantesView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class FacadeVueConsoleImpl implements FacadeVue {
    private Ihm ihm;

    protected FacadeVueConsoleImpl() {
        this.ihm = FactoryIhm.creerIhmconsole();
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
    public int afficherMenu() throws ViewException {
        try {
            return this.ihm.saisirChoixMenuEntier(ConstantesView.MENU);
        } catch (IhmException e) {
            throw new ViewException(e.getMessage());
        }
    }

    @Override
    public void afficherPatient(Patient patient) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Patient %s %s (%s)%n",patient.getNumSecu(), patient.getNom(), patient.getPrenom()));
        sb.append(String.format(ConstantesView.ENTETE_REGIME_ALIMENTAIRE_EXISTANT+"%n"));
        for (int i = 0; i < patient.getLstRegimeAlimentaire().size(); i++) {
            sb.append(String.format("\t\t%s%n",patient.getLstRegimeAlimentaire().get(i)));
        }
        ihm.afficherChaine(String.valueOf(sb));
    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        for (Patient patient : lstPatients) {
            afficherPatient(patient);
        }
    }

    @Override
    public Patient saisirPatient() {
        boolean rester;
        String numSecu = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "numero secu"));
        String nom = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "nom"));
        String prenom = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "prenom"));
        LocalDate dateEntree = ihm.saisirDate(String.format(ConstantesView.SAISIR_DATE_ENTREE + "(%s)", ConstantesView.PATTERN_DATE));
        Patient patient = null;
        try {
            patient = EntitiesFactory.fabriquerPatient(numSecu, nom, prenom, dateEntree);
        } catch (PatientException e) {
            this.ihm.afficherErreur(e.getMessage());
        }
        do {
            rester = ihm.saisirBoolean(ConstantesView.CONTINUER_SELECTION_REGIME_ALIMENTAIRE);
            if (rester){
                patient.ajouterRegimeAlimentaire(choisirRegimeAlimentaire());
            }
        } while (rester);
        return patient;
    }

    private RegimeAlimentaire choisirRegimeAlimentaire() {
        int chxRegime = 0;
        try {
            chxRegime = ihm.saisirChoixMenuEnum(RegimeAlimentaire.values());
        } catch (IhmException e) {
            e.printStackTrace();
        }
        return RegimeAlimentaire.values()[chxRegime-1];
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        for (int i = 0; i < lstPatients.size(); i++) {
            ihm.afficherChaine(i+1 + " - " + lstPatients.get(i).toString());
        }
        int chxPatient = ihm.saisirEntier(ConstantesView.MSG_CHOIX, 1, lstPatients.size()+1);
        return lstPatients.get(chxPatient-1);
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        List<Repas> lstTypeRepas = new ArrayList<>();
        try {
            int chxRegime = ihm.saisirChoixMenuEnum(RegimeAlimentaire.values());
            for (int i = 0; i < lstRepas.size(); i++) {
                if (lstRepas.get(i).getLstRegimeAlimentaire().contains(RegimeAlimentaire.values()[chxRegime-1])){
                    lstTypeRepas.add(lstRepas.get(i));
                }
            }
        } catch (IhmException e) {
            this.ihm.afficherErreur(e.getMessage());
        }
        return lstTypeRepas;
    }

    @Override
    public Patient modifierPatient(Patient patient) throws ViewException {
        int chx = 0;
        do {
            try {
                chx = ihm.saisirChoixMenuEntier(ConstantesView.MENU_MODIF);
            } catch (IhmException e) {
                e.printStackTrace();
            }
            patient = traiterModif(chx, patient);
        } while (chx != 0);
        return patient;
    }

    private Patient traiterModif(int choix, Patient patient) {
        switch (choix) {
            case 1: // Modif num secu
                String numSecu = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "numero secu"));
                try {
                    patient.setNumSecu(numSecu);
                } catch (PatientException e) {
                    ihm.afficherErreur(e.getMessage());
                }
                break;
            case 2: // Modif nom
                String nom = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "nom"));
                try {
                    patient.setNom(nom);
                } catch (PatientException e) {
                    ihm.afficherErreur(e.getMessage());
                }
                break;
            case 3: //Modif prenom
                String prenom = ihm.saisirChaine(String.format(ConstantesView.SAISIR_TYPE_MSG, "prenom"));
                try {
                    patient.setPrenom(prenom);
                } catch (PatientException e) {
                    ihm.afficherErreur(e.getMessage());
                }
                break;
            case 4: //Modif date entree
                LocalDate dateEntree = ihm.saisirDate(String.format(ConstantesView.SAISIR_DATE_ENTREE + "(%s)", ConstantesView.PATTERN_DATE));
                try {
                    patient.setDateEntree(dateEntree);
                } catch (PatientException e) {
                    ihm.afficherErreur(e.getMessage());
                }
                break;
            default:
                break;
        }
        return patient;
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        boolean rester;
        Patient patient = selectionnerPatient(lstPatients);
        List<Repas> lstRepas = selectionnerRepas(listRepas);
        do {
            for (int i = 0; i < lstRepas.size(); i++) {
                ihm.afficherChaine(i+1 + " - " + lstRepas.get(i).toString());
            }
            int chxPatient = ihm.saisirEntier(ConstantesView.MSG_CHOIX, 1, lstPatients.size()+1);
            try {
                patient.ajouterRepas(lstRepas.get(chxPatient-1));
            } catch (PatientException e) {
                ihm.afficherChaine(e.getMessage());
            }
            rester = ihm.saisirBoolean(ConstantesView.CONTINUER_SELECTION_REPAS);
        } while (rester);
        return patient;
    }
}
