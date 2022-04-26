package net.ent.etrs.ggef.vue.ihm;

public final class FabriqueIhm {

    /**
     * Méthode permettant de construire une Ihm JPANEL
     *
     * @return : Ihm
     */
    public static IhmPanel creerIhmPanel(){
      return new IhmPanel();
    }

    /**
     * Méthode permettant de construire une Ihm console
     *
     * @return : Ihm
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
