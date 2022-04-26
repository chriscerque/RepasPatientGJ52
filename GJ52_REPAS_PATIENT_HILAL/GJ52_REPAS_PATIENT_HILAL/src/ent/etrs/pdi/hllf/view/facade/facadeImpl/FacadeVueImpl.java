package ent.etrs.pdi.hllf.view.facade.facadeImpl;

import ent.etrs.pdi.hllf.ihm.FabriqueIhmOutils;
import ent.etrs.pdi.hllf.ihm.tools.IhmOutils;
import ent.etrs.pdi.hllf.model.entities.EntitiesFactory;
import ent.etrs.pdi.hllf.model.entities.Patient;
import ent.etrs.pdi.hllf.model.entities.Repas;
import ent.etrs.pdi.hllf.model.exceptions.PatientConstructionException;
import ent.etrs.pdi.hllf.model.exceptions.PatientException;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;
import ent.etrs.pdi.hllf.view.exceptions.ViewException;
import ent.etrs.pdi.hllf.view.facade.FacadeVue;
import ent.etrs.pdi.hllf.view.references.C_CONTAINERS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacadeVueImpl implements FacadeVue
{
    //attributs
    private IhmOutils ihm;

    //constructeur
    public FacadeVueImpl() {
        ihm = FabriqueIhmOutils.fabriquerIhmOutils();
    }

    //methodes
    @Override
    public Patient saisirPatient(List<RegimeAlimentaire> listRegime) throws ViewException {
        Patient retour= null;
        List<RegimeAlimentaire> regimes = new ArrayList<>();
        try {
            retour = EntitiesFactory.fabriquerPatient(
                    this.saisirString("saisissez numsécu (5 caracteres uniquement)"),
                    this.saisirString("saisissez le nom"),
                    this.saisirString("saisissez le prenom"),
                    this.saisirDateEntree("saisissez date")
            );
            regimes = selectionnerRegimeAlimentaire(listRegime);
            for (RegimeAlimentaire r: regimes) {
                retour.ajouterRegimeAlimentaire(r);
            }
        } catch (PatientConstructionException | PatientException e) {
            throw new ViewException(e.getMessage());
        }

        return retour;
    }

    private List<RegimeAlimentaire> selectionnerRegimeAlimentaire(List<RegimeAlimentaire> listRegime)
    {
        List<RegimeAlimentaire> retour = new ArrayList<>();
        int choix = -1;
        do {
            for (int i = 1; i < listRegime.size() - 1; i++) {
                this.afficherMessage(String.format("%d - %s %n", i, listRegime.get(i)));
            }
            this.afficherMessage("0 - Quitter");
            choix=this.saisirEntier("choisissez les regime alimentaire");
            retour.add(listRegime.get(choix));
        }while(choix != 0);

        return retour;
    }

    @Override
    public Patient modifierPatient(Patient cible) throws ViewException {
        try {
            cible.setNumSecu(this.saisirString("saisissez numsécu (5 caracteres uniquement)"));
            cible.setNom(this.saisirString("saisissez le nom"));
            cible.setPrenom(this.saisirString("saisissez le prenom"));
            cible.setDateEntree(this.saisirDateEntree("saisissez date"));
        } catch (PatientException e) {
            throw new ViewException(e.getMessage());
        }
        return cible;
    }

    private String saisirString(String invite)
    {
        this.afficherMessage(String.format("%s :%n", invite));
        return this.ihm.saisirChaine();
    }

    private LocalDate saisirDateEntree(String invite)
    {
        this.afficherMessage(String.format("%s la date doit être avant le %s :%n", invite, LocalDate.now()));
        return LocalDate.of(
                this.saisirEntier("saisissez annee"),
                this.saisirEntier("saisissez mois"),
                this.saisirEntier("saisissez jour")
        );
    }

    private int saisirEntier(String invite)
    {
        this.afficherMessage(String.format("%s :%n", invite));
        return this.ihm.saisirEntier();
    }

    @Override
    public void afficherMessage(String message) {
        this.ihm.afficherChaine(message);
    }

    @Override
    public void afficherPatient(Patient patient) {
        String regimeEntier = " ";
        for (RegimeAlimentaire r: patient.getListRegimeAlimentaire()) {
            if(!regimeEntier.equals(" "))
            {
                regimeEntier+= ", ";
            }
            regimeEntier += String.format("%s", r.getLibelle());
        }
        this.afficherMessage(String.format("le patient n°%s, entré le %s, se nomme %s %s, son regime alimentaire se compose de %s %n",
                patient.getNumSecu(), patient.getDateEntree(), patient.getNom(), patient.getPrenom(), regimeEntier));
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> listRepas) {
        List<Repas> retour = new ArrayList<>();
        int choix =-1;
        do{
            choix = this.ihm.lectureChoixInt(this.transformerListRepasEnListString(listRepas), "Repas", 0, listRepas.size(), "Choix:");
            if(choix != 0)
            {
                retour.add(listRepas.get(choix));
            }
        }while(choix != 0);
        return retour;
    }

    private List<String> transformerListRepasEnListString(List<Repas> listRepas)
    {
        List<String> tabRepas = new ArrayList<>();
        for (int i = 0; i < listRepas.size()-1; i++) {
            tabRepas.add(afficherRepas(listRepas.get(i)));
        }
        return tabRepas;
    }

    private String afficherRepas (Repas repas)
    {
        String regimeEntier = " ";
        for (RegimeAlimentaire r: repas.getListRegimeAlimentaire()) {
            if(!regimeEntier.equals(" "))
            {
                regimeEntier+= ", ";
            }
            regimeEntier += String.format("%s", r.getLibelle());
        }

        return String.format("le repas du %s est un repas de type %s et correspond au regime alimentaires: %s",
                repas.getDateRepas(), repas.getTypeRepas().toString(), regimeEntier);
    }

    @Override
    public void afficherMessageErreur(String erreur) {
        System.err.println(erreur);
    }

    @Override
    public int afficherMenu() {
        return this.saisirEntier(this.ihm.creerMenuAvecEnum(C_CONTAINERS.PATIENT_TAB, "Repas Patient", "Choix: "));
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> listPatient, List<Repas> listRepas) throws ViewException {
        Patient cible = null;
        List<Repas> listRepasEx = new ArrayList<>();
        cible = selectionnerPatient(listPatient);
        listRepasEx = selectionnerRepas(listRepas);
        for (Repas s:listRepasEx) {
            try {
                cible.ajouterRepas(s);
            } catch (PatientException e) {
                throw new ViewException(e.getMessage());
            }
        }
        return cible;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> listPatient) {
        afficherPatients(listPatient);
        return listPatient.get(saisirEntier("choisissez un patient")-1);
    }

    @Override
    public void afficherPatients(List<Patient> listPatient) {
        int count = 1;
        for (Patient p: listPatient) {
            System.out.printf("%s ", count);
            afficherPatient(p);
            count++;
        }
    }
}
