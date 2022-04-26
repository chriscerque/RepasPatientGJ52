package net.ent.etrs.sgr.view;

//import ent.etrs.pdi.pndgV4.ihm.ihm.FabriqueIhm;
//import ent.etrs.pdi.pndgV4.ihm.ihm.Ihm;
//import ent.etrs.pdi.pndgV4.ihm.ihm.OutilsMenuException;

//import ent.etrs.pndg.ihm.FabriqueIhm;
//import ent.etrs.pndg.ihm.Ihm;

import net.ent.etrs.sgr.model.entities.EntitiesFactory;
import net.ent.etrs.sgr.model.entities.Patient;
import net.ent.etrs.sgr.model.entities.Repas;
import net.ent.etrs.sgr.model.exceptions.PatientConstructionException;
import net.ent.etrs.sgr.model.exceptions.VueException;
import net.ent.etrs.sgr.model.references.C;
import net.ent.etrs.sgr.view.ihm.Ihm;
import net.ent.etrs.sgr.view.ihm.IhmFactory;
import net.ent.etrs.sgr.view.ihm.exceptionsIhm.OutilsMenuException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FacadeVueImpl implements IFacadeVue {

    private Ihm vue = IhmFactory.creerIhmConsole();
    private Scanner scan = new Scanner(System.in);

    protected FacadeVueImpl() {
    }

    @Override
    public Patient saisirPatient() throws VueException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(C.PATTERN_DATE);
        Patient pat = null;
        String secu = null;
        vue.afficherChaine(String.format("Saisie des informations du patient %n"));

        String nom = vue.saisirChaine(C.SAISIR_NOM);

        String pre = vue.saisirChaine(C.SAISIR_PRENOM);

        do {
            secu = vue.saisirChaine(C.SAISIR_SECU);
        } while (secu.length() != 5);

        String date = vue.saisirChaine(C.SAISIR_DATE_ENTREE);

        try {
            pat = EntitiesFactory.fabriquerPatient(nom, pre, secu, LocalDate.parse(date, dtf));
        } catch (PatientConstructionException e) {
            throw new VueException(e.getMessage(), e);
        }

        return pat;
    }

    @Override
    public void afficherMessage(String str) {
        vue.afficherChaine(str);
    }

    /**
     * Formate l'affiche d'un patient fourni en paramètre.
     *
     * @param pat Patient.
     */
    @Override
    public void afficherPatient(Patient pat) {

        System.out.println(String.format("%s %s, num_sécu : %s", pat.getNom(), pat.getPrenom(), pat.getNumSecu()));

    }

    /**
     * Méthode permettant la sélection de un ou plusieurs repas dans la liste en mémoire.
     * L'utilisateur peut choisir d'ajouter des repas à la liste renvoyée tant qu'il ne quitte pas la sélection
     *
     * @param ls List de Repas;
     * @return List de Repas
     * @throws VueException;
     */
    @Override
    public List<Repas> selectionnerRepas(List<Repas> ls) throws VueException {

        List<Repas> rep = null;
        int chx = -1;
        String[] strTab = creerMenuList(ls);

        do {
            try {
                chx = saisirChoixMenu(strTab, "MENU", "TERMINER", 0, ls.size());
                rep.add(ls.get(chx));
            } catch (OutilsMenuException e) {
                throw new VueException(e.getMessage(), e);
            }
        } while (chx != 0);
        return rep;
    }

    @Override
    public void afficherMessageErreur(String st) {
        System.err.println(st);
    }

    @Override
    public int afficherMenu() throws VueException {
        int chx = -1;

        try {
            chx = saisirChoixMenuMain(C.MENU, "Repas patient", 0, 5);
        } catch (OutilsMenuException e) {
            throw new VueException(e.getMessage(), e);
        }

        return chx;
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lsP, List<Repas> lsR) throws VueException {

        Patient pat = null;
        List<Repas> repas = new ArrayList<>();

        pat = selectionnerPatient(lsP);

        afficherPatient(pat);

        repas = selectionnerRepas(lsR);

        for (Repas rep : repas) {
            pat.ajouterRepas(rep);
        }

        return pat;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> ls) throws VueException {
        int chx = -1;
        String[] tabMenu = creerMenuList(ls);
        Patient pat = null;

        try {
            chx = saisirChoixMenu(tabMenu, "Sélection d'un patient", "QUITTER", 0, ls.size());
            pat = ls.get(chx - 1);
        } catch (OutilsMenuException e) {
            throw new VueException(e.getMessage(), e);
        }

        return pat;
    }

    @Override
    public void afficherPatients(List<Patient> ls) {

        StringBuilder strb = new StringBuilder();

        for (Patient ob : ls) {
            strb.append("-----------------------------");
            strb.append(System.lineSeparator());
            strb.append(String.format("%s %s, num_sécu : %s", ob.getNom(), ob.getPrenom(), ob.getNumSecu()));
            strb.append(System.lineSeparator());
            strb.append(System.lineSeparator());
        }
        vue.afficherChaine(strb.toString());

    }

    @Override
    public Patient modifierPatient(Patient pat) {


        return pat;
    }

    ///////////////////////////////////// CREATION DES MENUS DE LISTES /////////////////////////////////////////////

    /**
     * Création d'un tableau de String à partir d'un liste.
     * Destinée a l'affichage et l'utilisation de menus
     *
     * @param ls List
     * @return String[]
     */
    private String[] creerMenuList(List ls) {
        String[] tabString = new String[ls.size() + 1];

        tabString[0] = "---- MENU ----";

        for (int j = 1; j < ls.size() + 1; ++j) {
            tabString[j] = ls.get(j - 1).toString();
        }

        return tabString;
    }

    /**
     * A utiliser uniquement avec un tableau de String créé par la méthode "creerMenuList", voir méthode "créerMenu".
     *
     * @param tabMenu String[]
     * @param titre   String
     * @param quitter String
     * @param min     int
     * @param max     int
     * @return int
     * @throws OutilsMenuException
     */
    public int saisirChoixMenu(String[] tabMenu, String titre, String quitter, int min, int max) throws OutilsMenuException {
        int chx = -1;
        vue.afficherChaine(creerMenu(tabMenu, titre, quitter));
        chx = this.saisirEntier("Votre choix ?", min, max);
        return chx;
    }

    /**
     * On commence la boucle d'assocation au tableau à 1 dans le cas de l'utilisation d'un tableau de String
     * créé par la méthode "crerMenuList" car cette méthode affecte à l'emplacement 0 du tableau créé "MENU"
     *
     * @param tabMenu String[]
     * @param titre   String
     * @param quitter String
     * @return String
     * @throws OutilsMenuException
     */
    public static String creerMenu(String[] tabMenu, String titre, String quitter) throws OutilsMenuException {
        if (Objects.isNull(tabMenu)) {
            throw new OutilsMenuException("Le tableau du menu est null");
        } else {
            StringBuilder strb = new StringBuilder(titre);
            strb.append(System.lineSeparator());

            for (int i = 1; i < tabMenu.length; ++i) {
                strb.append(String.format("%n %2d) %10s", i, tabMenu[i]));
            }

            strb.append(String.format("%n %2d) %10s", 0, quitter));
            strb.append(System.lineSeparator());
            return strb.toString();
        }
    }

    public int saisirEntier(String msg, int min, int max) {
        int saisie = 0;
        boolean ok = false;
        String strSaisie = null;

        do {
            vue.afficherChaine(msg + "dans [" + min + ":" + max + "] ?");
            strSaisie = this.scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);
                if (saisie >= min && saisie <= max) {
                    ok = true;
                } else {
                    vue.afficherChaine("ERR : entier saisi est en dehors des bornes autorisées [" + min + ":" + max + "]");
                }
            } catch (NumberFormatException var8) {
                vue.afficherChaine("ERR de type de donnée saisie");
            }
        } while (!ok);

        return saisie;
    }

    public int saisirChoixMenuMain(String[] TabMenu, String titre, int min, int max) throws OutilsMenuException {
        vue.afficherChaine(creerMenuMain(TabMenu, titre));
        int chx = this.saisirEntier("Votre choix ?", min, max);
        return chx;
    }

    public static String creerMenuMain(String[] tabMenu, String titre) throws OutilsMenuException {
        if (Objects.isNull(tabMenu)) {
            throw new OutilsMenuException("Le tableau du menu est null");
        } else {
            StringBuilder strb = new StringBuilder(titre);
            strb.append(System.lineSeparator());

            for (int i = 0; i < tabMenu.length; ++i) {
                strb.append(String.format("%n %2d) %10s", i + 1, tabMenu[i]));
            }

            strb.append(String.format("%n %2d) Quitter", 0));
            strb.append(System.lineSeparator());
            return strb.toString();
        }
    }

}

