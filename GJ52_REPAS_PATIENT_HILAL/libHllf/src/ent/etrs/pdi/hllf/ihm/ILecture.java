package ent.etrs.pdi.hllf.ihm;

import java.time.LocalDate;

public interface ILecture
{
    /**
     * saisir un entier librement
     * @return int
     */
    public int lectureEntier();

    /**
     * saisir une chaine de caractere
     * @return string
     */
    public String lectureChaineCaracteres();

    /**
     * saisir un double
     * @return double
     */
    public double lectureDouble();

    /**
     * saisir un entier borné
     * @param min: int
     * @param max: int
     * @return int
     */
    public int lectureEntierBornee(int min, int max);

    /**
     * saisir une LocalDate
     * @param annee: int
     * @param mois: int
     * @param jour: int
     * @return LocalDate
     */
    public LocalDate lectureDate(int annee, int mois, int jour);
}
