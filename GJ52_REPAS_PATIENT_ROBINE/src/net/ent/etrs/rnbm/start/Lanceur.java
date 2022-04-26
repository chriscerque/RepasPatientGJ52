package net.ent.etrs.rnbm.start;

import net.ent.etrs.rnbm.model.facades.FacadeMetier;
import net.ent.etrs.rnbm.model.facades.FactoryFacadeMetier;
import net.ent.etrs.rnbm.presenter.FactoryPresenter;
import net.ent.etrs.rnbm.presenter.IPresentable;
import net.ent.etrs.rnbm.view.FacadeVue;
import net.ent.etrs.rnbm.view.FactoryFacadeVue;

public class Lanceur {

    /* *************** */
    /* ***** VUE ***** */
    //Création d'une vue.
    private static final FacadeVue VUE = FactoryFacadeVue.fabriquerFacadeVue();


    /* ****************** */
    /* ***** METIER ***** */
    //Création d'un metier.
    private static final FacadeMetier METIER = FactoryFacadeMetier.fabriquerFacadeMetier();


    public static void main(String[] args) {

        try {
            //Instanciation d'un presentable via la fabrique presenter
            IPresentable presenter = FactoryPresenter.fabriquerPresenter(VUE, METIER);

            //Lancement de la méthode d'initialisation
            presenter.initialiser();

            //Lancement de la méthode d'execution
            presenter.executer();
        } catch (Exception e) {
            //Affichage du message d'erreur.
            System.out.println(e.getMessage() + " L'application n'a pu être lancée..");
        }

    }

}
