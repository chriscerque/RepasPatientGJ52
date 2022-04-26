package ent.etrs.pdi.blu.model.dao;

import ent.etrs.pdi.blu.model.dao.exceptions.DaoException;
import ent.etrs.pdi.blu.model.entities.EntitiesFactory;
import ent.etrs.pdi.blu.model.entities.Model;
import ent.etrs.pdi.blu.model.entities.exceptions.ModelException;

public abstract class AbstractIModelDao implements IModelDao {
    public void init(){
        try {
            Model model1 = EntitiesFactory.fabriquerModel("1");
            Model model2 = EntitiesFactory.fabriquerModel("2");

            this.create(model1);
            this.create(model2);

        } catch (ModelException | DaoException e) {
            e.printStackTrace();
        }

    }
}
