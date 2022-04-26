package net.ent.etrs.sgr.view.ihm;

//import net.ent.etrs.view.ihm.exceptionsIhm.BooleanException;
//import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;
//import net.ent.etrs.view.ihm.outils.MesOutils;
//import net.ent.etrs.view.ihm.references.ConstantesIhm;

import net.ent.etrs.sgr.view.ihm.exceptionsIhm.BooleanException;
import net.ent.etrs.sgr.view.ihm.exceptionsIhm.OutilsMenuException;
import net.ent.etrs.sgr.view.ihm.outils.MesOutils;
import net.ent.etrs.sgr.view.ihm.references.ConstantesIhm;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {

    //Initialisation du scan(Scanner) en final = no redéfinitions in childs classes
    private final Scanner scan = new Scanner(System.in); //Permet saisie au clavier


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////                                                 ////
    ////                     SAISIE                      ////
    ////                                                 ////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public String saisirChaine(String msg) {

        //1: Initialisation chaine caractère
        String strSaisie = null;

        //2: Afficher message(msg), avec(true) saut de ligne, via l'appel de la méthode afficherChaine (plus bas)
        afficherChaine(msg);

        //3: Saisir la chaine (demandée dans le message plus haut)
        strSaisie = scan.nextLine(); //nextLine permet saisie avec espaces, on stocke dans str

        //4: Retourner str
        return strSaisie;
    }

    /////////////////////////////////////////////////////////
    @Override
    public char saisirCaractere(String msg) {

        //1:Initialisation d'une chaine de caractère pour le caractère à saisir
        String charSaisiStr;

        //2: Afficher message(msg) via l'appel de la méthode afficherChaine (plus bas)
        afficherChaine(msg);

        //3: Boucler sur a saisie du caractère si l'utilisateur entre une chaîne
        do {

            charSaisiStr = scan.nextLine();

            if (charSaisiStr.length() != 1) {
                afficherChaine("Veuillez ne saisir qu'UN caractère!");
            }
        } while (charSaisiStr.length() != 1);

        //4: Initialisation char et affectation de la saisie
        char charSaisi = charSaisiStr.charAt(0);

        //5: Retourner le caractère saisi
        return charSaisi;
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    @Override
    public int saisirChoixMenuTabString(String[] tabStr, String titreMenu) throws OutilsMenuException {
        int choix = -1;

        //Afficher menu (en le créant)
        afficherChaine(MesOutils.creerStrMenuFromStrTab(tabStr, titreMenu));

        //Faire choisir
        choix = saisirEntierMinMax(ConstantesIhm.MSG_INVITE, ConstantesIhm.MENU_CHOIX_MIN, tabStr.length);

        return choix;
    }

    @Override
    public int saisirChoixMenuTabString2(String[] tabStr, String titreMenu) throws OutilsMenuException {
        int choix = -1;

        //Afficher menu (en le créant)
        afficherChaine(MesOutils.creerStrMenuFromStrTab2(tabStr, titreMenu));

        //Faire choisir
        choix = saisirEntierMinMax(ConstantesIhm.MSG_INVITE, 1, tabStr.length);

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
            //3: Afficher message invite de saisie
            afficherChaine(msg);

            //4: Saisie utilisateur, on va ensuite convertir la saisie en entier
            strSaisie = scan.nextLine();

            try {
                //5: Transformer la saisie chaine caractères en int
                //Si ce n'est pas un entier, on attrape une exception, si ça en est un, parseInt arrivera à transformer
                saisie = Integer.parseInt(strSaisie);

                //6: Controler la valeur saisie entre [min:max[
                if (!(saisie >= min && saisie <= max)) {

                    //7: Si valeur en dehors des bornes min/max, afficher msg erreur + resaisir (car "ok" tjrs à false)
                    afficherChaine("ERR: entier saisi hors intervalle [" + min + ":" + max + "]");
                } else {
                    //8: Stopper la boucle
                    ok = true;
                }
            } catch (NumberFormatException nfe) {

                //Exception attrapée, on affiche un msg d'erreur
                afficherChaine("ERR: erreur de type de données saisies");
            }
        } while (!ok);

        //9: Retourner l'entier saisi
        return saisie;
    }

    /////////////////////////////////////////////////////////
    @Override
    public int saisirEntier(String msg) {
        //1: Initialisation de "saisie" (pour entier), de "strSaisie" (pour une chaine), de "ok" (pour boucler)
        int saisie = 0;
        String strSaisie = null;

        //2: Afficher message invite de saisie
        afficherChaine(msg);

        //3: Saisie utilisateur, on va ensuite convertir la saisie en entier
        strSaisie = scan.nextLine();

        try {
            //4: Transformer la saisie chaine caractères en int
            //Si ce n'est pas un entier, on attrape une exception, si ça en est un, parseInt arrivera à transformer
            saisie = Integer.parseInt(strSaisie);

        } catch (NumberFormatException nfe) {

            //Exception attrapée, on affiche un msg d'erreur
            afficherChaine("ERR: erreur de type de données saisies");
        }

        //5: Retourner l'entier saisi
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
        System.out.println(msg);
    }

    /////////////////////////////////////////////////////////
    @Override
    public void afficherTabObject(Object[] tableau, String titre) throws OutilsMenuException {
        //Caster le tableau de n'importe quel type en tableau de String
        String[] tableauStr = MesOutils.creerAffichageStringFromAnything(tableau, titre);

        //Afficher tableau (en le créant) à partir du tableau de String
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
