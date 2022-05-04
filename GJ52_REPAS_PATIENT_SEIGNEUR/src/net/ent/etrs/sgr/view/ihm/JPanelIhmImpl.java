package net.ent.etrs.sgr.view.ihm;

//Import de swing pour pouvoir afficher ou saisir dans des fenêtres!

//import net.ent.etrs.view.ihm.exceptionsIhm.BooleanException;
//import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;
//import net.ent.etrs.view.ihm.outils.MesOutils;
//import net.ent.etrs.view.ihm.references.ConstantesIhm;

import net.ent.etrs.sgr.view.ihm.exceptionsIhm.BooleanException;
import net.ent.etrs.sgr.view.ihm.exceptionsIhm.OutilsMenuException;
import net.ent.etrs.sgr.view.ihm.outils.MesOutils;
import net.ent.etrs.sgr.view.ihm.references.ConstantesIhm;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class JPanelIhmImpl implements Ihm {


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                     SAISIE                      ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public String saisirChaine(String msg) {

        //1: Initialisation d'une chaine de caractère avec pour valeur la saisie utilisateur swing
        String strSaisie = JOptionPane.showInputDialog(null, msg);

        //2: Retourner la saisie utilisateur (dans une fenêtre du coup)
        return strSaisie;
    }

    /////////////////////////////////////////////////////////
    @Override
    public char saisirCaractere(String msg) {

        //1:Initialisation d'une chaine de caractère pour le caractère à saisir
        String charSaisiStr;

        //2: Boucler sur a saisie du caractère si l'utilisateur entre une chaîne
        do {

            charSaisiStr = JOptionPane.showInputDialog(null, msg);

            if (charSaisiStr.length() != 1) {
                afficherChaine("Veuillez ne saisir qu'UN caractère!");
            }
        } while (charSaisiStr.length() != 1);

        //3: Initialisation char et affectation de la saisie
        char charSaisi = charSaisiStr.charAt(0);

        //4: Retourner le caractère saisi
        return charSaisi;
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int saisirChoixMenuTabString(String[] tabStr, String titreMenu) throws OutilsMenuException {

        //1: Stocker la saisie du choix utilisateur par appel de la méthode saisirEntier(String msg, int min, int max)
        //2: creerStrMenu(String[] tablo) dans MesOutils va créer le menu en retournant un tableau de String fourni en chaine String
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab(tabStr, titreMenu), ConstantesIhm.MENU_CHOIX_MIN, tabStr.length);

        return choix;
    }

    @Override
    public int saisirChoixMenuTabString2(String[] tabStr, String titreMenu) throws OutilsMenuException {
        //1: Stocker la saisie du choix utilisateur par appel de la méthode saisirEntier(String msg, int min, int max)
        //2: creerStrMenu(String[] tablo) dans MesOutils va créer le menu en retournant un tableau de String fourni en chaine String
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab2(tabStr, titreMenu), 1, tabStr.length);

        return choix;
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int saisirChoixMenuTabObject(Object[] tableau, String titreMenu) throws OutilsMenuException {

        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerTableauStringFromAnything(tableau);

        //Afficher menu (en le créant) à partir du tableau de String et saisie du choix du menu par l'utilisateur
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab(tableauStr, titreMenu), 0, tableau.length);

        return choix;
    }

    @Override
    public int saisirChoixMenuTabObject2(Object[] tableau, String titreMenu) throws OutilsMenuException {

        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerTableauStringFromAnything(tableau);

        //Afficher menu (en le créant) à partir du tableau de String et saisie du choix du menu par l'utilisateur
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab2(tableauStr, titreMenu), 1, tableau.length);

        return choix;
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int saisirChoixMenuListObject(List liste, String titreMenu) throws OutilsMenuException {
        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerTableauStringFromList(liste);

        //Afficher menu (en le créant) à partir du tableau de String et saisie du choix du menu par l'utilisateur
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab(tableauStr, titreMenu), 0, liste.size());

        return choix;
    }

    @Override
    public int saisirChoixMenuListObject2(List liste, String titreMenu) throws OutilsMenuException {
        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerTableauStringFromList(liste);

        //Afficher menu (en le créant) à partir du tableau de String et saisie du choix du menu par l'utilisateur
        int choix = this.saisirEntierMinMax(MesOutils.creerStrMenuFromStrTab2(tableauStr, titreMenu), 1, liste.size());

        return choix;
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int saisirEntierMinMax(String msg, int min, int max) {
        //1: Initialisation de "saisie" (pour entier), de "strSaisie" (pour une chaine), de "ok" (pour boucler)
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        //2: Boucle tant que saisie en dehors des bornes min/max
        do {

            //3: Saisir l'entier (en chaine caractère), avec invite de saisie(msg)
            strSaisie = JOptionPane.showInputDialog(msg);

            try {

                //4: Convertir la saisie en entier
                saisie = Integer.parseInt(strSaisie);

                //5: Controler la valeur saisie entre [min:max[
                if (!(saisie >= min && saisie <= max)) {

                    //6: Si valeur en dehors des bornes min/max, afficher msg erreur + resaisir (car "ok" tjrs à false)
                    JOptionPane.showMessageDialog(null, "ERR: entier saisi hors intervalle [" + min + ":" + max + "]");
                } else {

                    //7: Stopper la boucle
                    ok = true;
                }
            } catch (NumberFormatException nfe) {

                //Exception attrapée, on affiche un msg d'erreur
                afficherChaine("ERR: erreur de type de données saisies");
            }
        } while (!ok);

        //8: Retourner l'entier saisi
        return saisie;
    }

    /////////////////////////////////////////////////////////
    @Override
    public int saisirEntier(String msg) {
        //1: Initialisation de "saisie" (pour entier), de "strSaisie" (pour une chaine), de "ok" (pour boucler)
        int saisie = 0;
        String strSaisie = null;

        //2: Saisir l'entier (en chaine caractère), avec invite de saisie(msg)
        strSaisie = JOptionPane.showInputDialog(msg);

        try {

            //3: Convertir la saisie en entier
            saisie = Integer.parseInt(strSaisie);

        } catch (NumberFormatException nfe) {

            //Exception attrapée, on affiche un msg d'erreur
            afficherChaine("ERR: erreur de type de données saisies");
        }

        //4: Retourner l'entier saisi
        return saisie;
    }

    /////////////////////////////////////////////////////////
    @Override
    public boolean saisirBooleen() throws BooleanException {
        //Initialisation d'un booléen
        boolean boolRetour = false;

        //Saisie du booléen
        int boolSaisi = this.saisirEntierMinMax("1 = Oui | 2 = Non", 1, 2);

        if (boolSaisi == 1) {
            boolRetour = true;
        }

        return boolRetour;
    }

    /////////////////////////////////////////////////////////
    @Override
    public LocalDate saisirDateJMA() {
        int jour = this.saisirEntierMinMax("Saisir un jour: ", 1, 31);
        int mois = this.saisirEntierMinMax("Saisir un mois: ", 1, 12);
        int annee = this.saisirEntierMinMax("Saisir une année: ", 1, 9999);

        return LocalDate.of(annee, mois, jour);
    }
    /////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                    AFFICHAGE                    ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public void afficherChaine(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    /////////////////////////////////////////////////////////
    @Override
    public void afficherTabObject(Object[] tableau, String titre) throws OutilsMenuException {

        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerAffichageStringFromAnything(tableau, titre);

        //Afficher tableau (en le créant) à partir du tableau de String et saisie du choix du menu par l'utilisateur
        this.afficherChaine(MesOutils.creerAffichageStrFromStrTab(tableauStr));

    }

    /////////////////////////////////////////////////////////
    @Override
    public void afficherList(List liste, String titre) throws OutilsMenuException {
        //Caster la List<Object> en tableau de String
        String[] tableauStr = MesOutils.creerAffichageStringFromList(liste, titre);

        //Afficher tableau (en le créant) à partir du tableau de String
        this.afficherChaine(MesOutils.creerAffichageStrFromStrTab(tableauStr));
    }
    /////////////////////////////////////////////////////////


}
