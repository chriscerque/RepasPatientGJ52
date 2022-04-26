package ent.etrs.pdi.hllf.ihm.tools;

import ent.etrs.pdi.hllf.ihm.IOutilsIhm;
import ent.etrs.pdi.hllf.ihm.ihmImpl.AffichageConsole;
import ent.etrs.pdi.hllf.ihm.ihmImpl.FabriqueConsole;
import ent.etrs.pdi.hllf.ihm.ihmImpl.LectureConsole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IhmOutils implements IOutilsIhm
{
    private final AffichageConsole afficheur;
    private final LectureConsole lecteur;

    public IhmOutils() {
        this.afficheur = FabriqueConsole.fabriquerAffichageConsole();
        this.lecteur = FabriqueConsole.fabriquerLectureConsole();
    }

    @Override
    public void afficherSautLigne(String phrase)
    {
        afficheur.afficherMessageAvecSautLigne(phrase);
    }

    @Override
    public int lectureChoixInt(List<String> menu, String titre, int min, int max, String invite) throws NumberFormatException
    {
        int saisie = min-1;
        afficheur.afficherMenuEntoureAvecOptionSortie(menu, titre, invite);
        saisie = lecteur.lectureEntierBornee(min, max);
        return saisie;
    }

    @Override
    public int lectureChoixIntSurChaine(String menu, int min, int max) throws NumberFormatException
    {
        int saisie = min-1;
        afficheur.afficherString(menu);
        saisie = lecteur.lectureEntierBornee(min, max);
        return saisie;
    }

    @Override
    public void afficherChaine(String phrase)
    {
        afficheur.afficherString(phrase);
    }

    @Override
    public double saisirDouble()
    {
        double retour = 0.0;
        retour = lecteur.lectureDouble();
        return retour;
    }

    @Override
    public int saisirEntierBorne(int min, int max) throws NumberFormatException
    {
        int retour = min - 1;
        retour = lecteur.lectureEntierBornee(min, max);
        return retour;
    }

    @Override
    public int saisirEntier() throws NumberFormatException
    {
        int retour = 0;
        retour = lecteur.lectureEntier();
        return retour;
    }

    @Override
    public String saisirChaine()
    {
        String retour = "";
        retour = lecteur.lectureChaineCaracteres();
        return retour;
    }

    @Override
    public LocalDate saisirDate(int annee, int mois, int jour)
    {
        return lecteur.lectureDate(annee, mois, jour);
    }

    @Override
    public List<String> creerListStringAvecListObjet(List<Object> objs)
    {
        List<String> listRetour = new ArrayList<>();
        for (Object log: objs) {
            listRetour.add(log.toString());
        }
        return listRetour;
    }

    @Override
    public String creerMenuAvecEnum(Object[] enumData, String titre, String invite)
    {
        String retour = "";
        retour+= String.format("%s %n",titre.toUpperCase());
        for (int i = 0; i < enumData.length; i++) {
            retour += String.format("%d) %s %n", i+1, enumData[i].toString());
        }
        retour += String.format("%d) %s %n", 0, "Quitter");
        retour += String.format("%s: %n", invite);
        return retour;
    }
}
