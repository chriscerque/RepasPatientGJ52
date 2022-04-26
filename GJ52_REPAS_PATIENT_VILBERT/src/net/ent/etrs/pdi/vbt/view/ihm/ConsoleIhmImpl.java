package net.ent.etrs.pdi.vbt.view.ihm;

import net.ent.etrs.pdi.vbt.view.ihm.exceptions.references.CExceptionIhm;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private final Scanner scan;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected ConsoleIhmImpl() {
        this.scan = new Scanner(System.in);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String saisir(String invite) {
        //Affiche un message d'invitation à saisir
        afficher(invite, false);
        //Retourne la saisie
        return scan.nextLine();
    }

    @Override
    public int saisirEntier(String invite) {
        //Initialise l'entier
        int entier = 0;
        //Initialise le contrôle de la saisie
        boolean entierValide = false;
        do {
            try {
                //Saisie de l'entier
                entier = Integer.parseInt(saisir(invite));
                //Valide la saisie
                entierValide = true;
            } catch (Exception exception) {
                //Affiche un message d'erreur en cas de mauvaise saisie
                afficherErreur(CExceptionIhm.MSG_ERR_TYPE_INPUT);
            }
        } while (!entierValide);
        //Retourne l'entier
        return entier;
    }

    @Override
    public int saisirEntier(String invite, int minimum, int maximum) {
        //Initialise l'entier
        int entier;
        //Initialise le contrôle de la saisie
        boolean entierValide = false;
        do {
            //Saisie de l'entier
            entier = saisirEntier(invite);
            //Contrôle des bornes de saisie
            if (entier >= minimum && entier <= maximum) {
                //Valide la saisie
                entierValide = true;
            } else {
                //Affiche un message si l'entier est en dehors des bornes de saisie
                afficher(String.format("L'entier doit être entre %d et %d.", minimum, maximum));
            }
        } while (!entierValide);
        //Retourne l'entier
        return entier;
    }

    @Override
    public double saisirReel(String invite) {
        //Initialise le réel
        double reel = 0;
        //Initialise le contrôle de la saisie
        boolean reelValide = false;
        do {
            try {
                //Saisie du réel
                reel = Double.parseDouble(saisir(invite));
                //Valide le réel
                reelValide = true;
            } catch (Exception exception) {
                //Affiche un message d'erreur en cas de mauvaise saisie
                afficherErreur(CExceptionIhm.MSG_ERR_TYPE_INPUT);
            }
        } while (!reelValide);
        //Retourne le réel
        return reel;
    }

    @Override
    public double saisirReel(String invite, double minimum, double maximum) {
        //Initialise le réel
        double reel;
        //Initialise le contrôle de la saisie
        boolean reelValide = false;
        do {
            //Saisie du réel
            reel = saisirReel(invite);
            //Contrôle des bornes de saisie
            if (reel >= minimum && reel <= maximum) {
                //Valide la saisie
                reelValide = true;
            } else {
                //Affiche un message si le réel est en dehors des bornes de saisie
                afficher(String.format("L'entier doit être entre %.0f et %.0f.", minimum, maximum));
            }
        } while (!reelValide);
        //Retourne le réel
        return reel;
    }

    @Override
    public BigDecimal saisirGrandReel(String invite) {
        //Initialise le grand réel
        BigDecimal grandReel = new BigDecimal(0);
        //Initialise le contrôle de la saisie
        boolean grandReelValide = false;
        do {
            try {
                //Saisie du grand réel
                grandReel = BigDecimal.valueOf(saisirReel(invite));
                //Valide le grand réel
                grandReelValide = true;
            } catch (Exception exception) {
                //Affiche un message d'erreur en cas de mauvaise saisie
                afficherErreur(CExceptionIhm.MSG_ERR_TYPE_INPUT);
            }
        } while (!grandReelValide);
        //Retourne le grand réel
        return grandReel;
    }

    @Override
    public BigDecimal saisirGrandReel(String invite, BigDecimal minimum, BigDecimal maximum) {
        //Initialise le grand réel
        BigDecimal grandReel;
        //Initialise le contrôle de la saisie
        boolean grandReelValide = false;
        do {
            //Saisie du grand réel
            grandReel = saisirGrandReel(invite);
            //Contrôle des bornes de saisie
            if (grandReel.compareTo(minimum) < 0 && grandReel.compareTo(maximum) > 0) {
                //Valide le grand réel
                grandReelValide = true;
            } else {
                //Affiche un message si le grand réel est en dehors des bornes de saisie
                afficher(String.format("L'entier doit être entre %.0f et %.0f.", minimum, maximum));
            }
        } while (!grandReelValide);
        //Retourne le grand réel
        return grandReel;
    }

    @Override
    public boolean saisirBooleen(String invite) {
        //Invite l'utilisateur à l'aide d'un menu à répondre oui ou non
        int choixMenu = saisirChoixMenu(invite, CExceptionIhm.CHOIX_BOOLEAN, CExceptionIhm.CHOIX);
        //Retourne le choix de l'utilisateur sous la forme d'un booléen
        return choixMenu==1;
    }

    @Override
    public int saisirChoixMenu(String title, List<Object> list, String invite) {
        //Affiche un menu et demande à l'utilisateur de choisir une option
        return saisirEntier(Tools.creerMenu(title, list, invite), 0, list.size());
    }

    @Override
    public int saisirChoixMenu(String title, String[] table, String invite) {
        //Affiche un menu et demande à l'utilisateur de choisir une option
        return saisirEntier(Tools.creerMenu(title, table, invite), 0, table.length);
    }

    @Override
    public int saisirChoixTableau(String title, List<Object> list, String invite) {
        //Affiche un tableau et demande à l'utilisateur de choisir un tuple
        return 0;
    }

    @Override
    public int saisirChoixTableau(String title, String[] table, String invite) {
        //Affiche un tableau et demande à l'utilisateur de choisir un tuple
        return 0;
    }

    @Override
    public void afficher(String message) {
        //Affiche le message avec un saut de ligne
        System.out.println(message);
    }

    @Override
    public void afficher(String message, boolean lineBreak) {
        if (lineBreak) {
            //Affiche le message avec un saut de ligne
            afficher(message);
        } else {
            //Affiche le message sans saut de ligne
            System.out.printf("%s", message);
        }
    }

    @Override
    public void afficherListe(String title, List<Object> list) {
        //Affiche la liste
        afficher(Tools.creerListe(title, list));
    }

    @Override
    public void afficherListe(String title, String[] table) {
        //Affiche la liste
        afficher(Tools.creerListe(title, table));
    }

    @Override
    public void afficherTableau(String title, List<Object> list) {
        //Affiche le tableau

    }

    @Override
    public void afficherTableau(String title, String[] table) {
        //Affiche le tableau

    }

    @Override
    public void afficherErreur(String message) {
        //Affiche le message d'erreur
        System.err.println(message);
    }
}
