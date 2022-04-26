package ent.etrs.pdi.blu.presenter;

import ent.etrs.pdi.blu.model.facades.FacadeMetierNus;
import ent.etrs.pdi.blu.view.exceptions.ViewException;
import ent.etrs.pdi.blu.view.facades.FacadeVue;

public class Presenter {


    private FacadeMetierNus metier;
    private FacadeVue vue;


    //-------------------------------------------------------------------//
    //--------------------------- CONSTRUCTEUR --------------------------//
    //-------------------------------------------------------------------//

    public Presenter(FacadeMetierNus metier, FacadeVue vue) {
        this.metier = metier;
        this.vue = vue;
    }

    //-------------------------------------------------------------------//
    //--------------------------- LANCEMENT -----------------------------//
    //-------------------------------------------------------------------//

    public void executer() throws ViewException {

        int choix = 0;
        do {
            // afficher le menu
            choix = this.vue.afficherMenu();
            // traiter les options du menu
            traiterOptions(choix);

        } while (choix != 0);
    }

    //-------------------------------------------------------------------//
    //----------------------- TRAITEMENT CHOIX --------------------------//
    //-------------------------------------------------------------------//

    private void traiterOptions(int choix) {
        switch (choix) {
            case 1: // xxxxxxxxxxxxxxxxxxxxxx
                //lister..........();
                break;
            case 2: // xxxxxxxxxxxxxxxxxxxxxx
                //creer.............();
                break;
            case 3: // xxxxxxxxxxxxxxxxxxxxxx
                //modifier..........();
                break;
            case 4: // xxxxxxxxxxxxxxxxxxxxxx
                //supprimer.............();
                break;
            case 5: // xxxxxxxxxxxxxxxxxxxxxx
                //ajout repas.............();
                break;

            default:
                break;
        }

    }

    //-------------------------------------------------------------------//
    //---------------------------- ACTIONS ------------------------------//
    //-------------------------------------------------------------------//


}
