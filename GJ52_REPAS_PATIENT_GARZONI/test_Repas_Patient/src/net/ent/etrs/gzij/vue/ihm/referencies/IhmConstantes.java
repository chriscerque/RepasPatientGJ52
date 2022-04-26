package net.ent.etrs.gzij.vue.ihm.referencies;

public final class IhmConstantes {

    /**
     * Sert pour générer un menu à partir d'un tableau manuel.
     *
     * Utilisable depuis la classe JPanelIhmImpl avec la fonction :
     * public int saisirChoixMenu(String[] tabloStr, int min, int max)
     *
     * Utilisable depuis la classe ConsoleIhmImpl avec la fonction :
     * public int saisirChoixMenu(String[] tabloStr, int min, int max)
     *
     */

    public final static String[] TABLO_STR_MENU_PRINCIPAL =
            {
                    " Lister les patients",
                    " Créer un nouveau patient",
                    " Modifier un patient",
                    " Supprimer un patient",
                    " Ajouter un repas à un patient"
            };


    public static final String TITRE_MENU_PRINCIPAL = "Repas patient";

    /**
     * CONSTANTE pour les Menus IHM sous forme String:
     *
     *
     */
    public static final String MSG_INVITE = "Votre choix ?";

    /**
     * création des 3 tableaux à afficher au format HTML en console ou panel.
     *
     * fonctionnement dans un lanceur :
     *
     * Ihm panel = FabriqueIhm.creerIhmPanel();
     * panel.afficherTableauEnHtml("Tableau des Z'humouristes",TABLO_HTML_ENTETES, TABLO_HTML_DONNEES,TABLO_HTML_ALIGNEMENT ,true);
     *
     * Ihm console = FabriqueIhm.creerIhmConsole();     *
     * console.afficherTableauEnHtml("Tableau des Z'humouristes",TABLO_HTML_ENTETES, TABLO_HTML_DONNEES,TABLO_HTML_ALIGNEMENT ,true);
     */
    // tableau1D contenant les en-têtes :
    public final static String[] TABLO_HTML_ENTETES =
            {
                    " Nom",
                    " Prénom"
            };
    // tableau2D de données :
    public final static String[][] TABLO_HTML_DONNEES =
            {
                    {"Beliveau","Marcel"},
                    {"Collucci","Michel"},
                    {"Bigard","Jean-Marie"},
                    {"Boon","Dany"},
                    {"Zumourist","Eric"}

            };
    // gère l'alignement de chaque colonne :
    public static final TypeAlignement[] TABLO_HTML_ALIGNEMENT =
            {
                    TypeAlignement.LEFT, // colonne1
                    TypeAlignement.LEFT // colonne2
            };


    public static final String METHODE_NON_TERMINEE = "La méthode n'est pas encore terminée";







/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private IhmConstantes() { }

} // fin de classe
