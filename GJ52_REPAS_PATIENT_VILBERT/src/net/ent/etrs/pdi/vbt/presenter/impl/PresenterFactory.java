package net.ent.etrs.pdi.vbt.presenter.impl;

import net.ent.etrs.pdi.vbt.model.facade.FacadeMetier;
import net.ent.etrs.pdi.vbt.presenter.Presenter;
import net.ent.etrs.pdi.vbt.view.FacadeVue;

public final class PresenterFactory {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private PresenterFactory() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public static Presenter createPresenter(final FacadeVue vue, final FacadeMetier metier) {
        return new PresenterImpl(vue, metier);
    }

}
