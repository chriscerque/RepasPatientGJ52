package view.ihm;

public final class FabriqueIhm {
    private FabriqueIhm() {}

    public static Ihm fabriquerIhmConsole() {
        return new ConsoleIhmImpl();
    }
    public static Ihm fabriquerIhmJPanel() {
        return new JPanelIhmImpl();
    }
}
