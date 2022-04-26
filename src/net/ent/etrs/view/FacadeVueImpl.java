package net.ent.etrs.view;


import net.ent.etrs.commons.utils.AffichageConsole;
import net.ent.etrs.commons.utils.LectureConsole;
import net.ent.etrs.model.entities.EntitiesFactory;
import net.ent.etrs.model.entities.Patient;
import net.ent.etrs.model.entities.Repas;
import net.ent.etrs.model.exceptions.PatientConstructionException;
import net.ent.etrs.model.exceptions.PatientException;
import net.ent.etrs.model.references.C_MSG;
import net.ent.etrs.model.references.RegimeAlimentaire;
import net.ent.etrs.model.references.exceptions.RegimeAlimentaireException;
import net.ent.etrs.view.exceptions.ViewException;
import net.ent.etrs.view.references.C_VIEW;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FacadeVueImpl implements FacadeVue {

    protected FacadeVueImpl() {
    }

    @Override
    public void afficherMessage(String msg) {
        AffichageConsole.afficherMessageAvecSautLigne(msg);

    }

    @Override
    public void afficherMessageErreur(String msg) {
        AffichageConsole.afficherErreur(msg);
    }

    @Override
    public int afficherMenu() {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(C_VIEW.MENU), "Repas patient");
        return LectureConsole.lectureChoixInt(0, C_VIEW.MENU.length);
    }

    @Override
    public void afficherPatient(Patient patient) {
        StringBuilder sb = new StringBuilder();
        sb.append(C_MSG.CARACTERE_SEPARATEUR);
        sb.append(String.format("Patient %s %s (%s) %n", patient.getNumSecu(), patient.getNom(), patient.getPrenom(),
                patient.getDateEntree().format(DateTimeFormatter.ofPattern(C_VIEW.PATTERN_DATE))));
        AffichageConsole.afficherMessageSansSautLigne(sb.toString());
        this.afficherLstRegimeAlimentaire(patient.getLstRegimeAlimentaire());

    }


    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        for (Patient patient : lstPatients) {
            this.afficherPatient(patient);
        }

    }

    @Override
    public Patient saisirPatient() throws ViewException {

        try {
            String numSecu = saisirString(null, "numéro de sécurité", false);
            String nom = saisirString(null, "nom", false);
            String prenom = saisirString(null, "prénom", false);
            LocalDate dateEntree = saisirDateEntree(null, false);
            List<RegimeAlimentaire> lstRegimeAlimentaireSelectionnes = null;

            lstRegimeAlimentaireSelectionnes = selectionnerRegimeAlimentaire(null, false);

////TODO sout
//        System.out.println("lstRegimeAlimentaireSelectionnes : " + lstRegimeAlimentaireSelectionnes);
//        patient.tabRegimeAlimentaire = new String[lstRegimeAlimentaireSelectionnes.size()];
//        lstRegimeAlimentaireSelectionnes.toArray(patient.tabRegimeAlimentaire);
////        patient.tabRegimeAlimentaire = lstRegimeAlimentaireSelectionnes.toArray(new String[0]);
////TODO sout
//        System.out.println("patient.tabRegimeAlimentaire : " + patient.tabRegimeAlimentaire);
//        for (String s : patient.tabRegimeAlimentaire) {
//            System.out.println("s ->" + s);
//        }
//        Arrays.stream(patient.tabRegimeAlimentaire).forEach(System.out::println);
//        System.out.println("-----");
            Patient patient = EntitiesFactory.fabriquerPatient(numSecu, nom, prenom, dateEntree);
            for (RegimeAlimentaire regimeAlimentaire : lstRegimeAlimentaireSelectionnes) {
                patient.ajouterRegimeAlimentaire(regimeAlimentaire);
            }

            return patient;
        } catch (ViewException | PatientConstructionException | PatientException e) {
            throw new ViewException(e.getMessage(), e);
        }
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner un contact : ");
        List<String> option = new ArrayList<>();
        for (Patient patient : lstPatients) {
            option.add(String.format("%s %s", patient.getNom(), patient.getPrenom()));
        }
        AffichageConsole.afficherMenuSimple(option);
        return lstPatients.get(LectureConsole.lectureChoixInt(1, option.size()) - 1);
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        List<Repas> lstRepasSelectionnes = new ArrayList<>();
        do {
            AffichageConsole.afficherMessageAvecSautLigne("Sélectionner un repas : ");
            List<String> lstRepasAffichage = new ArrayList<>();
            for (Repas repas : lstRepas) {
                lstRepasAffichage.add(String.format("%s %s %s", repas.getDateRepas(), repas.getTypeRepas(), this.formatterRegimeAlimentaireRepas(repas.getLstRegimeAlimentaire())));
            }
            AffichageConsole.afficherMenuSimple(lstRepasAffichage);
            lstRepasSelectionnes.add(lstRepas.get(LectureConsole.lectureChoixInt(1, lstRepasAffichage.size()) - 1));
        } while (LectureConsole.lectureBoolean(C_VIEW.CONTINUER_SELECTION_REPAS));


        return lstRepasSelectionnes;
    }

    private String formatterRegimeAlimentaireRepas(List<RegimeAlimentaire> tabRegimeAlimentaire) {
        StringBuilder sb = new StringBuilder("regime alimentaire : ");
        sb.append(System.lineSeparator());
        for (RegimeAlimentaire str : tabRegimeAlimentaire) {
            sb.append("\t | ").append(String.format("%-20s", str.getLibelle()));
        }
        return sb.toString();
    }

    @Override
    public Patient modifierPatient(Patient patient) throws ViewException {
        try {
            String numSecu = saisirString(patient.getNumSecu(), "numéro de sécurité", true);
            String nom = saisirString(patient.getNom(), "nom", true);
            String prenom = saisirString(patient.getPrenom(), "prénom", true);
            LocalDate dateEntree = saisirDateEntree(patient.getDateEntree(), true);
            List<RegimeAlimentaire> lstRegimeAlimentaireSelectionnes = null;

            lstRegimeAlimentaireSelectionnes = selectionnerRegimeAlimentaire(patient.getLstRegimeAlimentaire(), true);

            if (lstRegimeAlimentaireSelectionnes.size() != 0) {
                for (RegimeAlimentaire regimeAlimentaire : lstRegimeAlimentaireSelectionnes) {
                    patient.ajouterRegimeAlimentaire(regimeAlimentaire);
                }
            }

            patient.setNumSecu(numSecu);
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setDateEntree(dateEntree);
            return patient;
        } catch (ViewException | PatientException e) {
            throw new ViewException(e.getMessage(), e);
        }
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        Patient patient = this.selectionnerPatient(lstPatients);
        for (Repas repas : this.selectionnerRepas(listRepas)) {
            try {
                patient.ajouterRepas(repas);
            } catch (PatientException e) {
                this.afficherMessageErreur(e.getMessage());
//                //TODO stack
//                e.printStackTrace();
            }
        }

        return patient;
    }


//    private void afficherRepas(Patient c) {
//        if (!c.getLstRepas().isEmpty()) {
//            for (Coordonnee coord : c.classerCoordonnee()) {
//                AffichageConsole.afficherMessageSansSautLigne("\t\t");
//                if (coord instanceof Mail) {
//                    mailVue.afficherCoordonnee((Mail) coord);
//                } else {
//                    telephoneVue.afficherCoordonnee((Telephone) coord);
//                }
//            }
//        } else {
//            AffichageConsole.afficherMessageAvecSautLigne("\t\t Aucune Coordonnées.");
//        }

//    }


    private LocalDate saisirDateEntree(LocalDate dateNaissanceOld, boolean modif) {
        if (modif) {
            AffichageConsole.afficherMessageAvecSautLigne(String.format(C_VIEW.MSG_ACTUEL, dateNaissanceOld));
            boolean choix = LectureConsole.lectureBoolean(C_VIEW.MSG_MODIF_QUESTION);
            if (choix) {
                return LectureConsole.lectureLocalDate(C_VIEW.PATTERN_DATE);
            }
            return dateNaissanceOld;
        }
        return LectureConsole.lectureLocalDate(C_VIEW.SAISIR_DATE_ENTREE, C_VIEW.PATTERN_DATE);

    }


    private String saisirString(String strOld, String typeMsg, boolean modif) {
        if (modif) {
            AffichageConsole.afficherMessageAvecSautLigne(String.format(C_VIEW.MSG_ACTUEL, strOld));
            boolean choix = LectureConsole.lectureBoolean(C_VIEW.MSG_MODIF_QUESTION);
            if (choix) {
                return LectureConsole.lectureChaineCaracteres("nouveau :");
            }
            return strOld;
        }
        return LectureConsole.lectureChaineCaracteres(String.format(C_VIEW.SAISIR_TYPE_MSG, typeMsg));

    }

    private List<RegimeAlimentaire> selectionnerRegimeAlimentaire(List<RegimeAlimentaire> regimeAlimentaireOld, boolean modif) throws ViewException {
        List<RegimeAlimentaire> lst = new ArrayList<>();
        List<RegimeAlimentaire> lstRegimeAlimentaireDispo = new ArrayList<>(Arrays.asList(RegimeAlimentaire.values()));
        if (regimeAlimentaireOld != null && regimeAlimentaireOld.size() != 0) {
//            for (RegimeAlimentaire reg : regimeAlimentaireOld) {
//                try {
//                    lst.add(RegimeAlimentaire.getByLibelle(reg));
//                } catch (RegimeAlimentaireException e) {
//                    this.afficherMessageErreur(e.getMessage());
//                }
//            }
//            lst.addAll(regimeAlimentaireOld);
//            //TODO sout
//            System.out.println("regimeAlimentaireOld " + regimeAlimentaireOld);
//            System.out.println("lstRegimeAlimentaireDispo " + lstRegimeAlimentaireDispo);
            lstRegimeAlimentaireDispo.removeAll(regimeAlimentaireOld);
        }

        if (modif) {

            this.afficherLstRegimeAlimentaire(regimeAlimentaireOld);


        }
        if (lstRegimeAlimentaireDispo.size() != 0) {
            while (LectureConsole.lectureBoolean(C_VIEW.CONTINUER_SELECTION_REGIME_ALIMENTAIRE)) {

                lst.add(selectionnerRegimeAlimentaireSimple(lstRegimeAlimentaireDispo));

            }

        } else {
            this.afficherMessage(C_VIEW.AUCUN_REGIME_ALIMENTAIRE);
        }

        return lst;

    }

    private void afficherLstRegimeAlimentaire(List<RegimeAlimentaire> regimeAlimentaireOld) {
        StringBuilder sb = new StringBuilder(C_VIEW.ENTETE_REGIME_ALIMENTAIRE_EXISTANT);
        if (Objects.isNull(regimeAlimentaireOld) || regimeAlimentaireOld.size() == 0) {
            sb.append(C_VIEW.AUCUN_REGIME_ALIMENTAIRE);
        } else {
            for (RegimeAlimentaire regimeAlimenaire : regimeAlimentaireOld) {
                sb.append(System.lineSeparator());
                sb.append("\t\t");
                sb.append(regimeAlimenaire.getLibelle());
            }
        }

        AffichageConsole.afficherMessageAvecSautLigne(sb.toString());
    }

    private RegimeAlimentaire selectionnerRegimeAlimentaireSimple(List<RegimeAlimentaire> lstRegimeAlimentaire) throws ViewException {
        try {
            AffichageConsole.afficherMessageAvecSautLigne(C_VIEW.MSG_SELECTIONNER_REGIME_ALIMENTAIRE);
            List<String> lstRegimeAlimentaireAff = new ArrayList<>();
            for (RegimeAlimentaire r : lstRegimeAlimentaire) {
                lstRegimeAlimentaireAff.add(r.getLibelle());
            }
            AffichageConsole.afficherMenuSimple(lstRegimeAlimentaireAff);
            int choix = LectureConsole.lectureChoixInt(1, lstRegimeAlimentaireAff.size());

            return RegimeAlimentaire.getByLibelle(lstRegimeAlimentaireAff.get(choix - 1));
        } catch (RegimeAlimentaireException e) {
            this.afficherMessageErreur(e.getMessage());
            throw new ViewException(e.getMessage(), e);
        }
    }

}
