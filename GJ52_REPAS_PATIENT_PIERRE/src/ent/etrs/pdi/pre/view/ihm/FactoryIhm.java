package ent.etrs.pdi.pre.view.ihm;

public final class FactoryIhm {
    /*------- CONSTRUCTEUR(S) -------*/
    private FactoryIhm(){}

    /*------- AUTRES METHODES -------*/
    public static Ihm creerIhmconsole(){
        return new ConsoleIhm();
    }
    public static Ihm creerJPanel(){
        return new JPanelIhm();
    }

}
