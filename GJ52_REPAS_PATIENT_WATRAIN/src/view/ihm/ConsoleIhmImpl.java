package view.ihm;

import model.references.C;
import view.ihm.exceptions.IhmException;
import view.references.C_VIEW;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleIhmImpl implements Ihm {
	public static final int NB_CAR = 2;
	private final Scanner scan = new Scanner(System.in);

	/**
	 * Lecture d'un double. Si la valeur saisie n'est pas un double, le message
	 * "Choix invalide" est affiché et la méthode attend une nouvelle saisie.
	 *
	 * @return le double.
	 */
	public double lectureDouble() {
		double retour = -1;
		boolean boucle = true;
		do {
			boucle = false;
			try {
				String chaine = scan.nextLine();
				retour = Double.parseDouble(chaine);
			} catch (NumberFormatException e) {
				System.out.println("Choix invalide");
				boucle = true;
			}
		} while (boucle);

		return retour;
	}

	@Override
	public LocalDate saisirDate(String message) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(C_VIEW.PATTERN_DATE);
		formatter = formatter.withLocale(Locale.FRANCE );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		return LocalDate.parse(saisirChaine(message), formatter);
	}

	/**
	 * Lecture d'un double. Si la valeur saisie n'est pas un double, le message
	 * "Choix invalide" est affiché et la méthode attend une nouvelle saisie.
	 *
	 * @param entete Libellé affiché avant la saisie.
	 * @return le double.
	 */
	public double lectureDouble(final String entete) {
		System.out.println(entete);
		return lectureDouble();
	}

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
	public int saisirChoixMenu(final String[] menu) throws IhmException {
		if (Objects.isNull(menu)) {
			throw new IhmException("Array is null");
		}
		String strMenu = OutilsIhm.construireMenu(ConstantesIhm.TITRE_MENU_DFLT, menu);

		return saisirEntier(strMenu, 0, menu.length + 1) - 1;
	}

	@Override
	public <T> T saisirChoixMenu(T[] menu) throws IhmException {
		if (Objects.isNull(menu)) {
			throw new IhmException("Array is null");
		}
		String strMenu = OutilsIhm.construireMenu(ConstantesIhm.TITRE_MENU_DFLT, menu);

		int choix = saisirEntier(strMenu, 0, menu.length + 1) - 1;
		return choix == -1 ? null : menu[choix];
	}

	@Override
	public <T> T saisirChoixMenu(List<T> menu) throws IhmException {
		if (Objects.isNull(menu)) {
			throw new IhmException("Array is null");
		}
		String strMenu = OutilsIhm.construireMenu(ConstantesIhm.TITRE_MENU_DFLT, menu.toArray());

		int choix = saisirEntier(strMenu, 0, menu.size() + 1) - 1;
		return choix == -1 ? null : menu.get(choix);
	}

	@Override
	public int saisirChoixMenu(String strMenu, int min, int max) {
		int chx = -1;

		//afficher menu

		afficherChaine(strMenu, true);
		//faire choisir
		chx = saisirEntier(ConstantesIhm.MSG_INVITE, min, max);
		return chx;
	}

	@Override
	public int saisirEntier(String msg, int min, int max) {
		int saisie = 0;
		String strSaisie = null;
		boolean ok = false;
		do {
			//0) afficher message
			afficherChaine(msg + " ds [" + min + ":" + (max) + "[  ?", false);
			//1 faire saisir entier
			//saisie = scan.nextInt(); //1ere solution mais pbm InputMismatchException
			strSaisie = scan.nextLine();
			try {
				saisie = Integer.parseInt(strSaisie);

				//2 contrôler valeur ds [min:max[
				if (saisie >= min && saisie < max) {
					ok = true;
				} else {
					//2.a si pbm => afficher msg erreur + ressaisir
					afficherChaine("ERR: entier saisi hors intervalle demandé [" + min + ":" + max + "[", true);
				}
			} catch (NumberFormatException nfe) {
				afficherChaine("ERR: erreur de type de donnée saisi", true);
			}
		} while (!ok);
		//2.b renvoyer l'entier saisi
		return saisie;
	}

	@Override
	public int saisirEntier(int min, int max) {
		return this.saisirEntier("", Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@Override
	public int saisirEntier(String msg) {
		return this.saisirEntier(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@Override
	public void afficherChaine(String msg, boolean sautLigne) {
		if (sautLigne) {
			System.out.println(msg);
		} else {
			System.out.print(msg);
		}
	}

	@Override
	public void afficherChaine(String msg) {
		afficherChaine(msg, true);
	}

	private int[] rechercherMaxDsColonne(String[][] tab2) {
		int[] tablow = new int[tab2.length];
		int idxColonne = 0;
		int c = 0;
		for (c = 0; c < tab2[0].length; c++) {
			int l = 0;
			int max = 0;
			for (l = 0; l < tab2.length; l++) {
				if (tab2[l][c].length() >= max) {
					max = tab2[l][c].length();
				}
			}
			//Traitement tablo 1 colonne
			tablow[idxColonne] = max;
			idxColonne++;
		}

		return tablow;
	}

	public int getLargeurTotale(int[] tabloLg, boolean withNoLine) {
		int total = 0;
		for (int i = 0; i < tabloLg.length; i++) {
			total += tabloLg[i];
		}
		if (withNoLine) {
			total += 2;
		}

		return total;
	}

	private String creerLigne(int lg, int lgEntete) {
		StringBuilder strb = new StringBuilder();

		String str = "";
		while (str.length() < (lg + (NB_CAR * lgEntete))) {
			str += "-";
		}
		strb.append(str);
		return strb.toString();
	}

	private String creerLigne2(int totalLongueurs, int nbColonne, boolean withNoLine) {
		StringBuilder strb = new StringBuilder();
		int maxi = totalLongueurs + (nbColonne * 3);
		if (withNoLine) {
			maxi += 3;
		}
		maxi += 1; //Pour le dernier !
		while (strb.length() < maxi) {
			strb.append("-");
		}
		strb.append(System.lineSeparator());
		return strb.toString();
	}

	private int[] rechercherMaxLargeur(String[] tabEntetes, String[][] tabDonnees) {

		String[][] tabDonnes2 = new String[tabDonnees.length + 1][tabDonnees[0].length];
		//recopie des donnees
		int l = 0;
		for (l = 0; l < tabDonnees.length; l++) {
			for (int c = 0; c < tabDonnees[l].length; c++) {
				if (Objects.nonNull(tabDonnees[l][c])) {
					tabDonnes2[l][c] = tabDonnees[l][c];
				} else {
					tabDonnes2[l][c] = "@";
				}
			}
		}

		//ajout des entêtes
		for (int i = 0; i < tabEntetes.length; i++) {
			tabDonnes2[l][i] = tabEntetes[i];
		}

		// Recherche du max
		return rechercherMaxDsColonne(tabDonnes2);
	}

	private void afficher(String[][] tablo) {

		System.out.println("contenu tableau");
		for (int l = 0; l < tablo.length; l++) {
			for (int c = 0; c < tablo[l].length; c++) {
				if (Objects.nonNull(tablo[l][c])) {
					System.out.printf("y:%02d x=%02d valeur=%S, lg=%02d%n",
							l, c, tablo[l][c], tablo[l][c].length());
				}
			}
		}
	}

	private String creerEntetes(String[] tabEntetes, TypeAlignement[] tabTa, int[] tabLargeursMax, int lgTot, boolean withNoLine) {
		StringBuilder strb = new StringBuilder();
		strb.append(creerLigne2(lgTot, tabEntetes.length, withNoLine));

		//entêtes
		if (withNoLine) {
			strb.append("! no ");
		}

		for (int e = 0; e < tabEntetes.length; e++) {
			strb.append(OutilsIhm.alignerTexte(tabTa[e], tabEntetes[e], tabLargeursMax[e]));
		}
		strb.append("!");
		strb.append(System.lineSeparator());
		return strb.toString();
	}

	@Override
	public void afficherTableau(String titre, String[] tabEntetes, String[][] tablo, TypeAlignement[] tabTa, boolean withNoLine) {
		//le titre
		StringBuilder strb = new StringBuilder();
		strb.append("\n").append(Objects.isNull(titre) ? "Contenu" : titre).append(System.lineSeparator());

		//autres
		int[] tabLargeursMax = rechercherMaxLargeur(tabEntetes, tablo);
		int largeurTotale = getLargeurTotale(tabLargeursMax, withNoLine);

		strb.append(creerEntetes(tabEntetes, tabTa, tabLargeursMax, largeurTotale, withNoLine));

		//Données
		strb.append(creerLigne2(largeurTotale, tabEntetes.length, withNoLine));

		for (int y = 0; y < tablo.length; y++) {
			if (Objects.nonNull(tablo[y])) {
				if (withNoLine && Objects.nonNull(tablo[y][0])) {
					strb.append(String.format("! %02d ", y));
				}
				if (Objects.nonNull(tablo[y][0])) {
					for (int x = 0; x < tablo[0].length; x++) {

						strb.append(OutilsIhm.alignerTexte(tabTa[x], tablo[y][x], tabLargeursMax[x]));
					}
					strb.append("!");
					strb.append(System.lineSeparator());
				}
			}
		}

		strb.append(creerLigne2(largeurTotale, tabEntetes.length, withNoLine));


		afficherChaine(strb.toString(), true);
	}

	@Override
	public void afficherErreur(String msg) {
		System.err.println(msg);
	}
}
