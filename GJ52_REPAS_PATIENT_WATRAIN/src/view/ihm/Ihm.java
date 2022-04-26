package view.ihm;

import view.ihm.exceptions.IhmException;

import java.time.LocalDate;
import java.util.List;

public interface Ihm {

	/**
	 * Méthode permettant la saisie d'une chaîne.
	 *
	 * @param invite: le message d'invite
	 * @return String
	 */
	String saisirChaine(final String invite);

	/**
	 * Méthode permettant de réaliser la saisie d'un choix dans un menu.
	 *
	 * @param menu: String[], le contenu du menu sous forme de tableau
	 * @return int: le choix
	 * @throws IhmException levée si le tableau est NULL
	 */
	int saisirChoixMenu(final String[] menu) throws IhmException;

	/**
	 * Méthode permettant de réaliser la saisie d'un choix dans un menu.
	 *
	 * @param array: T[], le contenu du menu sous forme de tableau
	 * @return T: le choix
	 * @throws IhmException levée si le tableau est NULL
	 */
	<T> T saisirChoixMenu(final T[] array) throws IhmException;

	/**
	 * Méthode permettant de réaliser la saisie d'un choix dans un menu.
	 *
	 * @param list: List<T>, le contenu du menu sous forme de tableau
	 * @return T: le choix
	 * @throws IhmException levée si le tableau est NULL
	 */
	<T> T saisirChoixMenu(final List<T> list) throws IhmException;

	/**
	 * Méthode permettant de réaliser la saisie d'un choix dans un menu.
	 * ATTENTION : le choix doit appartenir à [min:max[
	 *
	 * @param strMenu: String, le menu au format chaine de car
	 * @param min: int, le choix mini
	 * @param max: int, le choix maxi
	 * @return int
	 */
	int saisirChoixMenu(final String strMenu, final int min, final int max);

	/**
	 * Méthode chargée de réaliser la saisie d'un entier dans [min:max[
	 *
	 * @param msg : String
	 * @param min : int, le choix mini
	 * @param max : int, le choix maxi
	 * @return int
	 */
	int saisirEntier(final String msg, final int min, final int max);

	/**
	 * Méthode chargée de réaliser la saisie d'un entier dans [min:max[
	 *
	 * @param min : int, le choix mini
	 * @param max : int, le choix maxi
	 * @return int
	 */
	int saisirEntier(final int min, final int max);

	/**
	 * Méthode chargée de réaliser la saisie d'un entier dans [min:max[
	 *
	 * @param msg : String
	 * @return int
	 */
	int saisirEntier(final String msg);

	/**
	 * Méthode chargée de réaliser l'affichage d'une chaîne, avec ou sans saut de ligne.
	 *
	 * @param msg:       String, le message à afficher
	 * @param sautLigne: boolean
	 */
	void afficherChaine(final String msg, final boolean sautLigne);

	void afficherChaine(final String msg);

	void afficherTableau(final String titre, final String[] tabEntetes, final String[][] tablo, final TypeAlignement[] tabTa, final boolean withNoLine);


	void afficherErreur(final String msg);

	double lectureDouble(final String entete);

	double lectureDouble();

	/**
	 * Demande à l'utilisateur la saisie une date.
	 * @return la date de garantie saisie
	 */
	LocalDate saisirDate(final String entete);
}
