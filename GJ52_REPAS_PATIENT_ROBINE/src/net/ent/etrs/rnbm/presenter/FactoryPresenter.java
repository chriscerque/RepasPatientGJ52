package net.ent.etrs.rnbm.presenter;

import net.ent.etrs.rnbm.model.facades.FacadeMetier;
import net.ent.etrs.rnbm.view.FacadeVue;

public final class FactoryPresenter {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryPresenter(){}

    public static Presenter fabriquerPresenter(final FacadeVue vue, final FacadeMetier metier) throws Exception {
        return new Presenter(vue, metier);
    }


}
