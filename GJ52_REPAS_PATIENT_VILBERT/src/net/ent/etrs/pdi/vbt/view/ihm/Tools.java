package net.ent.etrs.pdi.vbt.view.ihm;

import java.util.List;

public final class Tools {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private Tools() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode qui permet de créer un menu à partir d'un tableau
     * @param title : le titre du menu
     * @param list : le contenu du menu
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return le menu sous la forme d'une chaîne de caractères
     */
    public static String creerMenu(String title, List<Object> list, String invite) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", title));
        for (int i=0; i< list.size(); i++) {
            sb.append(String.format("%d - %s%n", i+1, list.get(i).toString()));
        }
        sb.append(String.format("0 - Sortir%n"));
        sb.append(invite);
        return sb.toString();
    }

    /**
     * Méthode qui permet de créer un menu à partir d'un tableau
     * @param title : le titre du menu
     * @param table : le contenu du menu
     * @param invite : le message qui invite l'utilisateur à faire un choix
     * @return le menu sous la forme d'une chaîne de caractères
     */
    public static String creerMenu(String title, String[] table, String invite) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", title));
        for (int i=0; i< table.length; i++) {
            sb.append(String.format("%d - %s%n", i+1, table[i]));
        }
        sb.append(String.format("0 - Sortir%n"));
        sb.append(invite);
        return sb.toString();
    }

    /**
     * Méthode qui permet de créer une liste verticale à partir d'une liste
     * @param title : le titre de la liste
     * @param list : le contenu de la liste
     * @return la liste sous la forme d'une chaîne de caractères
     */
    public static String creerListe(String title, List<Object> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", title));
        for (int i=0; i< list.size(); i++) {
            sb.append(String.format("%d - %s%n", i+1, list.get(i).toString()));
        }
        return sb.toString();
    }

    /**
     * Méthode qui permet de créer une liste verticale à partir d'un tableau
     * @param title : le titre de la liste
     * @param table : le contenu de la liste
     * @return la liste sous la forme d'une chaîne de caractères
     */
    public static String creerListe(String title, String[] table) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", title));
        for (int i=0; i< table.length; i++) {
            sb.append(String.format("%d - %s%n", i+1, table[i]));
        }
        return sb.toString();
    }
}
