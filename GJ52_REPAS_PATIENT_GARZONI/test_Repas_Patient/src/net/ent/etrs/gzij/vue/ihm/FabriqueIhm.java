package net.ent.etrs.gzij.vue.ihm;

/**
 * Classe regroupant les différentes méthodes afin de construire les objets de vue.
 */
public final class FabriqueIhm {

    /**
     * Méthode permettant de construire une Ihm JPANEL
     *
     * @return : IhmPanel
     */
    public static IhmPanel creerIhmPanel(){
      return new IhmPanel();
    }

    /**
     * Méthode permettant de construire une Ihm console
     *
     * @return : IhmConsole
     */
    public static IhmConsole creerIhmConsole(){
        return new IhmConsole();
    }

    /*----------------------
    CONSTRUCTEURS BLOQUE
    -----------------------*/
    private FabriqueIhm() {
    }

}  // fin de classe
