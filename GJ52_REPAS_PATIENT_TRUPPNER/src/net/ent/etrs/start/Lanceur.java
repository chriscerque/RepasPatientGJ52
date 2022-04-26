package net.ent.etrs.start;

import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.FacadeMetierFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.exceptions.PresenterException;
import net.ent.etrs.view.facade.FacadeVue;
import net.ent.etrs.view.facade.FacadeVueFactory;
import net.ent.etrs.view.ihm.exceptionsIhm.OutilsMenuException;

public class Lanceur {
    //Constructeur en privé pour ne pas instancier
    private Lanceur() {
    }

    public static void main(String[] args) throws OutilsMenuException {
        //Instanciation des 2 façades
        FacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
        FacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();

        try {
            //Instanciation du presenter
            Presenter presenter = new Presenter(metier, vue);

            presenter.exec();

        } catch (OutilsMenuException | PresenterException e) {
            System.out.println("L'application n'a pu être lancée...");
        }
    }
}
