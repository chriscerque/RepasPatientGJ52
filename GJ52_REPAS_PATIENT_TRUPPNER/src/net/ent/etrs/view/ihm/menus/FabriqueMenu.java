package net.ent.etrs.view.ihm.menus;

public final class FabriqueMenu {
    private FabriqueMenu() {
    }

    /**
     * Méthode chargée de créer un menu, où le choix sera saisi sous la forme d'un entier.
     *
     * @param titre:       String, le titre du menu
     * @param lesLibelles: Object[] les libellés de choix du menu
     * @return Saisissable interface de ceux qui font saisir
     * @throws Exception levée en cas de pbm
     */
    public static Saisissable creerMenuInt(String titre, Object[] lesLibelles) throws Exception {
        return new MenuInt(titre, lesLibelles);

    }

    /**
     * Méthode chargée de créer un menu, où le choix sera saisi sous la forme d'un car.
     *
     * @param titre:       String, le titre du menu
     * @param lesLibelles: Object[] les libellés de choix du menu
     * @return Saisissable interface de ceux qui font saisir
     * @throws Exception levée en cas de pbm
     */
    public static Saisissable creerMenuChar(String titre, Object[] lesLibelles) throws Exception {
        return new MenuChar(titre, lesLibelles);

    }
}
