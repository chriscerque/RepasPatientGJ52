package ent.etrs.pdi.hllf.ihm.ihmImpl;

import ent.etrs.pdi.hllf.ihm.IAffichage;

import java.util.List;

public class AffichageConsole implements IAffichage
{
    @Override
    public void afficherMenuEntoureAvecOptionSortie(List<String> list, String titre, String invite)
    {
        String menu = "";
        String tabul = "";
        menu += String.format("+-\t %s \t-+%n", titre);
        for (String option: list) {
            tabul = "\t";
            if(option.length()<20)
            {
                tabul += "\t";
            }
            menu += String.format("|%d) -%s %s | %n", list.indexOf(option)+1, option, tabul);
        }
        menu += String.format("|%d) -%s \t\t\t\t | %n", 0, "Quitter");
        menu += "+----------------------------+";
        menu += String.format("%s %n", invite);
        System.out.println(menu);
    }

    @Override
    public void afficherMenuSimple(List<String> entete, String titre, String invite)
    {
        String menu = "";
        menu += String.format("%s %n",titre.toUpperCase());
        for (String option: entete) {
            menu += String.format("%d) \t %s %n", entete.indexOf(option)+1, option);
        }
        menu += String.format("%d) \t %s %n", 0, "Quitter");
        menu += String.format("%s: %n", invite);
        System.out.println(menu);
    }

    @Override
    public void afficherMessageAvecSautLigne(String message)
    {
        System.out.println(String.format("%s %n", message));
    }

    @Override
    public void afficherString(String phrase)
    {
        System.out.println(phrase);
    }
}
