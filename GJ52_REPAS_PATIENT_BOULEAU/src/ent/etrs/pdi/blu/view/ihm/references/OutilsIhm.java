package ent.etrs.pdi.blu.view.ihm.references;

import ent.etrs.pdi.blu.view.ihm.exceptions.IhmException;

public final class OutilsIhm {
    /*------- CONSTRUCTEUR(S) -------*/
    private OutilsIhm() {
    }


    //---------------------------------------MENUS
    /**
     * Méthode chargée de créer un menu sous la forme d'une chaîne.
     * Ajoute le choix 0] Quitter et l'invite de saisie
     * @param strMenu: String, le titre
     * @param tabloDesOptions: Object[], les options du menu (choix)
     * @return String
     */
    public static String construireMenu(String strMenu,Object[] tabloDesOptions){
        StringBuilder strbMenu = new StringBuilder();

        strbMenu.append(strMenu);
        strbMenu.append(System.lineSeparator());

        for(int i = 0; i< tabloDesOptions.length; i++) {
            strbMenu.append(String.format("%n %d %s",(i+1), tabloDesOptions[i].toString()));
        }
        //MEP du choix QUITTER
        strbMenu.append(String.format("%n  %d] Quitter", 0,ConstantesIhm.CHOIX_QUITTER));
        strbMenu.append(System.lineSeparator());
        //MEP de l'invite de saisie
        strbMenu.append(String.format("%n %s", ConstantesIhm.INVITE));

        return strbMenu.toString();
    }
    /*------- AUTRES METHODES -------*/

    /**
     * Méthode qui permet de creer et styliser le menu à partir d'un tableau de string.
     * @param tabStr: String[], correspond au tableau qui contient le menu
     * @return String, retourne la chaîne du menu stylisé
     * @throws IhmException
     */
    public static String creerStrMenu(final String[] tabStr){
        // Création des variables
        StringBuilder str = new StringBuilder();
        // Ajout du titre du menu
        str.append(tabStr[0]);
        str.append(System.lineSeparator());
        // Ajout des elements du menus (sauf quitter)
        for (int i = 1; i < tabStr.length - 1; i++) {
            str.append(String.format("%n %2d) %s",i ,tabStr[i]));
        }
        // Ajout de l'élément quitter
        str.append(String.format("%n %4d] %s",0 ,tabStr[tabStr.length-1]));
        str.append(System.lineSeparator());
        // Retourne la chaîne
        return str.toString();
    }

    /**
     * Méthode qui permet de creer et styliser le menu à partir d'un tableau d'enum.
     * @param nomEnumAvecValues: Object[], correspond au tableau d'objet (ici utilisé pour les enums)
     * @return String, retourne la chaîne de l'enum stylisé
     * @throws IhmException
     */
    public static String creerMenuFromEnum(final Object[] nomEnumAvecValues){
        // Création des variable
        StringBuilder strb = new StringBuilder();
        // Ajout du titre du menu
        strb.append("/*------- MENU : "+nomEnumAvecValues[0].getClass().getSimpleName()+" -------*/");
        strb.append(System.lineSeparator());
        // Ajout des elements du menus (enum)
        for (int i = 0 ; i < nomEnumAvecValues.length; i++) {
            strb.append(String.format("%n %2d) %s", (i+1), nomEnumAvecValues[i]));
        }
        // Ajout de l'élément quitter
        strb.append(String.format("%n %4d] %s", 0, "Quitter"));
        strb.append(System.lineSeparator());
        // Retourne la chaîne
        return strb.toString();

    }
}
