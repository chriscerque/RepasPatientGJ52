package view.ihm;

public final class FabriqueIhm {
    private FabriqueIhm(){}

    public static Ihm creerIhmconsole(){
        return new ConsoleIhmImpl();
    }
    public static Ihm creerJPanel(){
        return new JPanelIhmImpl();
    }
}
