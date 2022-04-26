package net.ent.etrs.sgr.start;

import net.ent.etrs.sgr.model.facade.FacadeMetierFactory;
import net.ent.etrs.sgr.model.facade.IFacadeMetier;
import net.ent.etrs.sgr.presenter.Presenter;
import net.ent.etrs.sgr.view.FacadeVueFactory;
import net.ent.etrs.sgr.view.IFacadeVue;

public final class Lanceur {

    private Lanceur(){}

    public static void main(String[] args) {

        IFacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
        metier.init();
        IFacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();

        Presenter presenter = new Presenter(metier, vue);
        presenter.executer();
    }
}
