package ent.etrs.pdi.hllf.ihm;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public interface IOutilsIhm
{
    /**
     * utilise une methode pour afficher une chaine de caractere
     * @param phrase String
     */
    public void afficherSautLigne(String phrase);

    /**
     * lis un choix pour un tableau
     * @param menu: List<String>
     * @param titre: String
     * @param min: int
     * @param max: int
     * @return int
     * @throws NumberFormatException
     */
    public int lectureChoixInt(List<String> menu, String titre, int min, int max, String invite) throws NumberFormatException;

    /**
     * lis un choix pour un tableau en forme de chaine
     * @param menu: String
     * @param min: int
     * @param max: int
     * @return int
     * @throws NumberFormatException
     */
    public int lectureChoixIntSurChaine(String menu, int min, int max) throws NumberFormatException;

    /**
     * utilise une methode pour afficher une chaine
     * @param phrase: String
     */
    public void afficherChaine(String phrase);

    /**
     * utilise une methode pour saisir un double
     * @return double
     */
    public double saisirDouble();

    /**
     * utilise une methode pour saisir un entier soumis a une intervalle
     * @param min: int
     * @param max: int
     * @return int
     * @throws NumberFormatException
     */
    public int saisirEntierBorne(int min, int max) throws NumberFormatException;

    /**
     * utilise une methode pour saisir un entier
     * @return int
     * @throws NumberFormatException
     */
    public int saisirEntier() throws NumberFormatException;

    /**
     * utilise une methode pour saisir une chaine
     * @return String
     */
    public String saisirChaine();

    /**
     * utilise une methode pour saisir une LocalDate
     * @param annee: int
     * @param mois: int
     * @param jour: int
     * @return LocalDate
     */
    public LocalDate saisirDate(int annee, int mois, int jour);

    /**
     * methode permettant de creer une liste de chaine de caracteres a partir d'une liste d'objets
     * @param objs: List<Objects>
     * @return List<String>
     */
    public List<String> creerListStringAvecListObjet(List<Object> objs);

    /**
     * methode permettant de creer un menu a partir d'une enum
     * @param enumData: Object[]
     * @return String
     */
    public String creerMenuAvecEnum(Object[] enumData, String titre, String invite);
}
