package net.ent.etrs.start;

import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.FacadeMetierFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.view.FacadeVue;
import net.ent.etrs.view.Viewfactory;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Lanceur {

    private Lanceur() {
    }

    public static void main(String[] args) {
        FacadeMetier metier = FacadeMetierFactory.fabriquerContactModelFacade();
        FacadeVue vue = Viewfactory.fabriquerContactView();
        metier.init();
        Presenter presenter = new Presenter(metier, vue);
        presenter.exec();
    }

}
