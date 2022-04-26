package view.ihm;

import view.ihm.outils.OutilsIhm;
import view.ihm.references.ConstanteIhm;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class IhmImpl implements Ihm {

    @Override
    public int saisirEntier(String msg) {
        int saisie = 0;
        boolean ok = false;
        do {
            String strSaisie = saisirChaine(msg);
            try {
                saisie = Integer.parseInt(strSaisie);
                ok = true;
            } catch (NumberFormatException nfe) {
                this.afficherChaine(ConstanteIhm.MSG_ERR_TYPESAISIE_ENTIER);
            }
        } while (!ok);
        return saisie;
    }
    @Override
    public int saisirEntier(String msg, int min) {
        int entier;
        boolean ok = false;
        do {
            entier = saisirEntier(msg);
            if (entier < min) {
                afficherChaine(String.format(ConstanteIhm.MSG_ERR_SAISIR_ENTIER_MIN_FORMAT, min));
            } else {
                ok = true;
            }
        } while (!ok);
        return entier;
    }
    @Override
    public int saisirEntier(String msg, int min, int max) {
        int entier;
        boolean ok = false;
        do {
            entier = saisirEntier(msg);
            if (entier < min || max < entier) {
                afficherChaine(String.format(ConstanteIhm.MSG_ERR_SAISIR_ENTIER_MIN_MAX_FORMAT, min, max));
            } else {
                ok = true;
            }
        } while (!ok);
        return entier;
    }

    @Override
    public double saisirDecimal(String msg) {
        double saisie = 0.0;
        boolean ok = false;
        do {
            String strSaisie = saisirChaine(msg);
            try {
                saisie = Double.parseDouble(strSaisie);
                ok = true;
            } catch (NumberFormatException nfe) {
                this.afficherChaine(ConstanteIhm.MSG_ERR_TYPESAISIE_DECIMAL);
            }
        } while (!ok);
        return saisie;
    }
    @Override
    public double saisirDecimal(String msg, double min) {
        double saisie;
        boolean ok = false;
        do {
            saisie = saisirDecimal(msg);
            if (saisie < min) {
                afficherChaine(String.format(ConstanteIhm.MSG_ERR_SAISIR_DECIMAL_MIN_FORMAT, min));
            } else {
                ok = true;
            }
        } while (!ok);
        return saisie;
    }
    @Override
    public double saisirDecimal(String msg, double min, double max) {
        double saisie;
        boolean ok = false;
        do {
            //0 saisir entier
            saisie = saisirDecimal(msg);
            //1 controler valeur
            if (saisie < min || max < saisie) {
                //2 msg erreur si mauvaise saisie
                afficherChaine(String.format(ConstanteIhm.MSG_ERR_SAISIR_DECIMAL_MIN_MAX_FORMAT, min, max));
            } else {
                ok = true;
            }
        } while (!ok);
        return saisie;
    }


    @Override
    public LocalDate saisirDate(String msg) {
        int[] nbJours = {31,29,31,30,31,30,31,31,30,31,30,31};
        int annee = saisirEntier(String.format("%s%nSaisissez l'annee", msg));
        int mois = saisirEntier(String.format("%s%nSaisissez le mois de %d", msg, annee), 1, 13);
        int jour = saisirEntier(String.format("%s%nSaisissez le jour de %2d/%d", msg, mois, annee), 1, nbJours[mois -1] +1);
        return LocalDate.of(annee, mois, jour);
    }



    @Override
    public <T> T saisirChoixElementEnum(T[] enumValues, boolean choixAnnuler) {
        int choix = this.saisirChoixMenu(OutilsIhm.creerMenuChoixElementEnum(enumValues, choixAnnuler), true, choixAnnuler);
        if (choix == 0) {
            return null;
        } else {
            return enumValues[choix -1];
        }
    }

    @Override
    public LocalDate saisirLocalDate(final String message, final String pattern) {
        String dateString;
        LocalDate date = null;
        boolean dateValide;
        do {
            try {
                dateValide = true;
                dateString = this.saisirChaine(String.format("%s (%s)", message, pattern));
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException e) {
                this.afficherChaine("Date erronée");
                dateValide = false;
            }
        } while (!dateValide);

        return date;
    }

}
