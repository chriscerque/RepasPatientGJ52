package ent.etrs.pdi.pre.start;

import ent.etrs.pdi.pre.model.facades.FacadeMetier;
import ent.etrs.pdi.pre.model.facades.FacadeMetierFactory;
import ent.etrs.pdi.pre.presenter.Presenter;
import ent.etrs.pdi.pre.presenter.exceptions.PresenterException;
import ent.etrs.pdi.pre.view.facades.FacadeVue;
import ent.etrs.pdi.pre.view.facades.FacadeVueFactory;

public class Lanceur {
    public static void main(String[] args) {
        FacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
        FacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();

//        try {
            metier.init();
            Presenter presenter = new Presenter(metier, vue);
            presenter.executer();
//        } catch (PresenterException e) {
//            System.out.println("L'application n'a pu être lancée...");
//        }
    }
}
