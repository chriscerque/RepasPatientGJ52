package ent.etrs.pdi.hllf.ihm.ihmImpl;

import ent.etrs.pdi.hllf.ihm.ILecture;

import java.time.LocalDate;
import java.util.Scanner;

public class LectureConsole implements ILecture
{
    private Scanner scan;

    public LectureConsole() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public int lectureEntier() throws NumberFormatException
    {
        int saisie = -1;
        saisie = Integer.parseInt(scan.nextLine());
        return saisie;
    }

    @Override
    public String lectureChaineCaracteres()
    {
        String saisie = "";
        saisie = scan.nextLine();
        return saisie;
    }

    @Override
    public double lectureDouble()
    {
        double saisie = 0.0;
        saisie = scan.nextDouble();
        return saisie;
    }

    @Override
    public int lectureEntierBornee(int min, int max) throws NumberFormatException
    {
        int retour = min-1;
        do {
            retour = Integer.parseInt(scan.nextLine());
        }while(retour<min || retour>max);
        return retour;
    }

    @Override
    public LocalDate lectureDate(int annee, int mois, int jour) {
        LocalDate date = null;
        date = LocalDate.of(annee, mois, jour);
        return date;
    }
}
