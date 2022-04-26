package marine.etrs.ihm_Vue.ihm;


import java.util.Objects;

public final class MesOutils {

    private MesOutils(){}

    /**
     * Methode chargée de tansformer le tableau de chaine d'un Menu
     * en une seule chaine.
     * @param tabloStr :String[]
     * @return String
     */

    public static String creerStrMenu(String[] tabloStr) throws OutilsMenuException {
        if(Objects.isNull(tabloStr)){
            throw new OutilsMenuException(ConstanteIHM.MSG_ERR_TABLEAU_MENU_VAUT_NULL);
        }

        StringBuilder strb = new StringBuilder();
        strb.append(tabloStr[0]);
        strb.append(System.lineSeparator());

        for (int i = 1; i < tabloStr.length-1; i++) {
            strb.append(String.format("%n %2d %10s", i, tabloStr[i]));
        }
        strb.append(String.format("%n %2d %9s", 0, tabloStr[tabloStr.length-1]));
        strb.append(System.lineSeparator());
        return strb.toString();
    }


    // création d'une méthode qui génère un menu : entête + valeurs Enum + Quitter:
    public static String creerMenuFromEnum(String titreMenu, String piedMenu, Object[] UnMenuEnum) {

        // 0 car la première ligne c'est l'en-tête :
        StringBuilder strb = new StringBuilder(titreMenu);
        strb.append(System.lineSeparator());

        // 1 et -1 car je ne traite pas la première et dernière ligne :
        for (int i = 0 ; i < UnMenuEnum.length; i++) {
            strb.append(String.format("%n %2d) %s", (i+1), UnMenuEnum[i]));
            // Menu avec A/B/C/D...
            //strb.append(String.format("%n %s) %10s", Character.toChars(65+i)[0], UnMenuEnum[i]));
        }

        // -1 car je traite la dernière ligne qui est quitter :
        strb.append(String.format("%n %2d] %s", 0, piedMenu));
        strb.append(System.lineSeparator());

        return strb.toString();

    }


}