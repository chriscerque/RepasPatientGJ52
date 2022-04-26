package ent.etrs.pdi.blu.start;

import ent.etrs.pdi.blu.model.facades.FacadeMetierNus;
import ent.etrs.pdi.blu.model.facades.FacadeMetierFactory;
import ent.etrs.pdi.blu.presenter.Presenter;
import ent.etrs.pdi.blu.view.exceptions.ViewException;
import ent.etrs.pdi.blu.view.facades.FacadeVueFactory;

public class Lanceur {
    public static void main(String[] args) throws ViewException {


        try {
            //-------------------------------------------------------------------//
            //----------------------------- METIER ------------------------------//
            //-------------------------------------------------------------------//

            FacadeMetierNus metier = FacadeMetierFactory.fabriquerFacadeMetier();
            metier.initialiserApplication();

            //-------------------------------------------------------------------//
            //------------------------------- VUE -------------------------------//
            //-------------------------------------------------------------------//


            FacadeVue vueConsole = FacadeVueFactory.fabriquerVueConsole();
            //ou
            FacadeVue vuePanel = FacadeVueFactory.fabriquerVuePanel();


            //-------------------------------------------------------------------//
            //---------------------------- PRESENTER ----------------------------//
            //-------------------------------------------------------------------//

            //a changer si besoin
            Presenter presenter = new Presenter(metier, vuePanel);

            presenter.executer();
        } catch (ViewException e) {
        //} catch (BusinessExceptionNus | ViewException e) {
            e.printStackTrace();
        }
    }
}
