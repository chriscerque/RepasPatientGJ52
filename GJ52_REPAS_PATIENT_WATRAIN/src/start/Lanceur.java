package start;

import model.facade.FacadeMetier;
import model.facade.FacadeMetierFactory;
import presenter.Presenter;
import presenter.exceptions.PresenterException;
import view.facades.FacadeVue;
import view.facades.FacadeVueFactory;

/**
 * Lanceur de l'application
 */
public final class Lanceur {

    private Lanceur() {
    }

    public static void main(String[] args) {
        FacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
        FacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();

        try {
            Presenter presenter = new Presenter(metier, vue);
            presenter.exec();
        } catch (PresenterException e) {
            System.out.println("L'application n'a pu être lancée...");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue...");
        }


    }
}
