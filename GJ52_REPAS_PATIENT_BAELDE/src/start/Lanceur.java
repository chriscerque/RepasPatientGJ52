package start;

import model.facade.FabriqueFacadeMetier;
import model.facade.FacadeMetier;
import presenter.Presenter;
import view.facade.FabriqueFacadeVue;
import view.facade.FacadeVue;

public class Lanceur {
    public static void main(String[] args) {

        FacadeMetier metier = FabriqueFacadeMetier.fabriquerFacadeMetier();

        FacadeVue vue = FabriqueFacadeVue.fabriquerFacadeVue();

        Presenter presenter = new Presenter(metier, vue);

        presenter.exec();

    }
}
