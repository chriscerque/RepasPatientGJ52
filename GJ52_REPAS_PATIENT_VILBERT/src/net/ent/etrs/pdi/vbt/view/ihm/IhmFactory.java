package net.ent.etrs.pdi.vbt.view.ihm;

public class IhmFactory {

    public static Ihm createViewConsole() {
        return new ConsoleIhmImpl();
    }

}
