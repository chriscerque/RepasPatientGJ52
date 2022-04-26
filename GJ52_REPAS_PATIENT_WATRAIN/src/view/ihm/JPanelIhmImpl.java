package view.ihm;

import view.ihm.exceptions.IhmException;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class JPanelIhmImpl implements Ihm {

	@Override
	public String saisirChaine(String invite) {
		return JOptionPane.showInputDialog(null, invite);
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
	public <T> T saisirChoixMenu(T[] array) throws IhmException {
		if(Objects.isNull(array)){ throw new IhmException("Array is null"); }
		String strMenu = OutilsIhm.construireMenu(ConstantesIhm.TITRE_MENU_DFLT, array);

		int choix = saisirEntier(strMenu, 0, array.length + 1) - 1;
		return choix == -1 ? null : array[choix];
	}

	@Override
	public <T> T saisirChoixMenu(List<T> list) throws IhmException {
		if (Objects.isNull(list)) {
			throw new IhmException("Array is null");
		}
		String strMenu = OutilsIhm.construireMenu(ConstantesIhm.TITRE_MENU_DFLT, list.toArray());

		int choix = saisirEntier(strMenu, 0, list.size() + 1) - 1;
		return choix == -1 ? null : list.get(choix);
	}

	@Override
	public int saisirChoixMenu(String strMenu, int min, int max) {
		String strMenu2 = strMenu + "\n Votre choix ?";
		return saisirEntier(strMenu, min, max);
	}

	@Override
	public int saisirEntier(String msg, int min, int max) {
		int sai = -1;
		do {
			String strSaisie = JOptionPane.showInputDialog(msg);
			try {
				sai = Integer.parseInt(strSaisie);
				if (sai < min || sai > max) {
					sai = -1;
					afficherChaine(ConstantesIhm.MSG_ERR_CHOIX_INCORRECT, true);
				}
			} catch (Exception ex) {
				afficherChaine(ConstantesIhm.MSG_ERR_SAISIE_INCORRECT, true);
			}
		} while (sai == -1);
		return sai;
	}

	@Override
	public int saisirEntier(int min, int max) {
		return 0;
	}

	@Override
	public int saisirEntier(String msg) {
		return saisirEntier(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	@Override
	public void afficherChaine(String msg, boolean sautLigne) {
		JOptionPane.showMessageDialog(null, msg);
	}

	@Override
	public void afficherChaine(String msg) {
		afficherChaine(msg, true);
	}

	/**
	 * Méthode chargée de créer la ligne des entêtes de colonne.
	 *
	 * @param tabEntetes : String[]
	 * @param withNoLine : boolean, avec un no de ligne
	 * @return String
	 */
	private String creerEntetes(String[] tabEntetes, boolean withNoLine) {
		//MEP entetes

		StringBuilder strb = new StringBuilder("<tr>");
		if (withNoLine) {
			strb.append("<th style='background-color:gray; color:white'><i>.no.</i></th>");
		}

		for (int i = 0; i < tabEntetes.length; i++) {
			strb.append("<th style='background-color:gray; color:white'><i>").append(tabEntetes[i]).append("</i></th>");
		}
		strb.append("</tr>");

		return strb.toString();
	}

	@Override
	public void afficherTableau(String titre, String[] tabEntetes, String[][] tablo, TypeAlignement[] tabTa, boolean withNoLine) {
		StringBuilder strb = new StringBuilder("<html>");
		strb.append("<h2>" + titre + "</h2>");
		strb.append("<table border='1'>");

		//MEP entêtes
		strb.append(creerEntetes(tabEntetes, withNoLine));

		//les données
		for (int l = 0; l < tablo.length; l++) {
			if (Objects.nonNull(tablo[l][0])) {
				strb.append("<tr>");
				if (withNoLine) {
					strb.append("<td>").append(String.format("%02d", l)).append("</td>");
				}

				for (int c = 0; c < tablo[l].length; c++) {
					strb.append("<td align='" + (tabTa[c].name().toLowerCase() + "'>")).append(tablo[l][c]).append("</td>");
				}
				strb.append("</tr>");

			}
		}
		strb.append("</table></html>");

		afficherChaine(strb.toString(), true);
	}

	@Override
	public void afficherErreur(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public double lectureDouble(String entete) {
		return 0;
	}

	@Override
	public double lectureDouble() {
		return 0;
	}

	@Override
	public LocalDate saisirDate(String entete) {
		return null;
	}

}
