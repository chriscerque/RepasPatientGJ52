package ent.etrs.pdi.hllf;

import ent.etrs.pdi.hllf.model.facade.FacadeMetier;
import ent.etrs.pdi.hllf.model.facade.facadeImpl.FacadeMetierImpl;
import ent.etrs.pdi.hllf.view.facade.FacadeVue;
import ent.etrs.pdi.hllf.view.facade.facadeImpl.FacadeVueImpl;

public class FacadeFactory
{
    public static FacadeMetier fabriquerFacadeMetier()
    {
        return new FacadeMetierImpl();
    }

    public static FacadeVue fabriquerFacadeVue()
    {
        return new FacadeVueImpl();
    }
}
