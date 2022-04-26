package net.ent.etrs.view.ihm;

public final class FabriqueIhm {
    private FabriqueIhm() {
    }

    public static Ihm creerIhmconsole() {
        return new ConsoleIhmImpl();
    }

    public static Ihm creerJPanel() {
        return new JPanelIhmImpl();
    }

    public static Ihm creerIhm(TypeIhm ti) {
        Ihm ihmt = null;
        switch (ti) {
            case CONSOLE:
                ihmt = creerIhmconsole();
                break;
            case JPANEL:
                ihmt = creerJPanel();
                break;
        }
        return ihmt;
    }
}
