package net.ent.etrs.pdi.vbt.start;

import net.ent.etrs.pdi.vbt.model.facade.FacadeMetier;
import net.ent.etrs.pdi.vbt.model.facade.impl.FacadeMetierFactory;
import net.ent.etrs.pdi.vbt.presenter.Presenter;
import net.ent.etrs.pdi.vbt.presenter.impl.PresenterFactory;
import net.ent.etrs.pdi.vbt.view.FacadeVue;
import net.ent.etrs.pdi.vbt.view.impl.FacadeVueFactory;

public class Lanceur {

    public static void main(String[] args) {

        FacadeVue vue = FacadeVueFactory.createView();
        FacadeMetier metier = FacadeMetierFactory.createFacade();
        Presenter presenter = PresenterFactory.createPresenter(vue, metier);
        presenter.executer();

    }

}
