package marine.etrs.ihm_Vue.ihm;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {
    private final Scanner scan = new Scanner(System.in);

    @Override
    public String saisirChaine(String invite) {
        String str = null;
        //0 afficher le message
        afficherChaine(invite, true);
        //1 saisir la chaine demandée
        str = scan.nextLine();
        return str;
    }

    @Override
    public int saisirChoixMenu(String[] menu) throws OutilsMenuException {
        int chxMenu = -1;

        afficherChaine(MesOutils.creerStrMenu(menu), true);

        chxMenu = saisirEntier(ConstanteIHM.MSG_INVITE,
                ConstanteIHM.MENU1_CHX_MINI,
                menu.length);

        return chxMenu;
    }

    @Override
    public int saisirEntier(String msg, int min, int max) {
        int saisie = 0;
        String strSaisie = null;
        boolean ok = false;

        do {
            //0 afficher le message
            afficherChaine(msg, false);
            //1 faire saisir l'entier
            //   saisie = scan.nextInt(); // pb avec mismatch exception
            strSaisie = scan.nextLine();

            try {
                saisie = Integer.parseInt(strSaisie);

                //2 controler valeur ds [min : max]
                if (saisie >= min && saisie <= max) {
                    ok = true;
                } else {
                    //2.a si pb => afficher msg erreur + ressaisie
                    afficherChaine("ERR : entier saisi hors intervalle demandé [" + min + " : " + max + "]", true);
                }
            } catch (NumberFormatException nfe) {
                afficherChaine("ERR: erreur de type de données saisie", true);
            }

        } while (!ok);
        //2.b renvoyer l'entier saisi
        return saisie;
    }

    @Override
    public int saisirEntier(String msg) {
        // 0 afficher msg
        afficherChaine(msg, true);
        //1 saisir un entier
        return scan.nextInt();
    }


    @Override
    public void afficherChaine(String msg, boolean sautLigne) {
        if(sautLigne) {
            System.out.println(msg);
        }else{
            System.out.print(msg);
        }
    }

    @Override
    public void afficherChaine(String msg) {
        System.out.print(msg);
    }


    @Override
    public int saisirChoixMenuEnum(String titreMenu, String piedMenu, Object[] nomEnumAvecValues) {
        int chx = saisirEntier(MesOutils.creerMenuFromEnum(titreMenu, piedMenu, nomEnumAvecValues), 0, nomEnumAvecValues.length);
        return chx;
    }

    @Override
    public LocalDate saisirDate(String msg) {
        int[] nbJours = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int annee = saisirEntier(String.format("%s%nSaisissez l'annee", msg));
        int mois = saisirEntier(String.format("%s%nSaisissez le mois de %d", msg, annee), 1, 13);
        int jour = saisirEntier(String.format("%s%nSaisissez le jour de %2d/%d", msg, mois, annee), 1, nbJours[mois - 1] + 1);
        return LocalDate.of(annee, mois, jour);
    }

    @Override
    public void afficherObjet(Object obj) {

    }


}