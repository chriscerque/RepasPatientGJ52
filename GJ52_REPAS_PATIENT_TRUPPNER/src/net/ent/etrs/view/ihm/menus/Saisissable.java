package net.ent.etrs.view.ihm.menus;

//import ent.etrs.pndg.ihm.Ihm;

import net.ent.etrs.view.ihm.Ihm;

public interface Saisissable {
    /**
     * Méthode dont le rôle est de construire la représenttaion sous forme de chaîne du Menu.
     *
     * @return String
     */
    String getStrMenu();

    /**
     * Méthode chargée de réaliser la saisie d'un choix dans un menu, sous la forme d'un entier.
     *
     * @param vue: Ihm
     * @return int, le choix saisi
     * @throws Exception en cas de pbm
     */
    int saisirChoixEntierMenu(Ihm vue) throws Exception;
}
