package marine.etrs.ihm_Vue.ihm;

import java.time.LocalDate;

public interface Ihm {

    /**
     * Méthode permettant la saisie d'un String.
     * @param invite: le message d'invite
     * @return String
     */
    public String saisirChaine(String invite);




    /**
     * Méthode permettant de réaliser la saisie d'un choix dans un menu.
     * @return int
     */
    public int saisirChoixMenu(String[] tabloStr) throws OutilsMenuException;




    /*
    int saisirChoixMenu(String msg);

    /**
     * Méthode chargée de réaliser la saisie d'un entier dans [min:max[
     * @param msg : String
     * @param min : int, le choix mini
     * @param max : int, le choix maxi
     * @return int
     */
    public int saisirEntier(String msg, int min, int max);




    /**
     *Méthode chargée de demander un INT
     * @param msg
     * @return int
     */
    public int saisirEntier(String msg);




    /**
     * Méthode chargée de réaliser l'affichage d'une chaîne, avec ou sans saut de ligne.
     * @param msg: String, le message à afficher
     * @param sautLigne: boolean
     */
    public void afficherChaine(String msg, boolean sautLigne);



    /**
     *Méthode chargée d'afficher un String
     * @param msg
     * @return
     */
    void afficherChaine(String msg);

    /**
     * Méthode permettant de réaliser la saisie d'un choix depuis un menu d'Enum.
     *
     * Ecrire nomEnum.values()
     * cela permettra de renvoyer les valeurs de l'enum sous forme de tableau
     * 0 sera automatiquement le choix de bas de menu pour quitter, recommencer,etc
     * L'entier max sera fourni automatiquement par le nb de valeur de l'enum
     *
     * @param titreMenu : String - le titre du menu
     * @param piedMenu : String - le pied du menu -> Quitter, recommencer,etc
     * @param nomEnumAvecValues : Object[] - nom de l'Enum qui contient les valeurs du menu
     * @return int
     */
    public int saisirChoixMenuEnum(String titreMenu, String piedMenu, Object[] nomEnumAvecValues);


    LocalDate saisirDate(String msg);


    /**
     *Méthode chargée d'afficher un Objet
     * @param obj
     * @return
     */
    void afficherObjet(Object obj);


}
