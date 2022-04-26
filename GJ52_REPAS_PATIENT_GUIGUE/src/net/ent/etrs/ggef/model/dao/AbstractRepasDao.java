package net.ent.etrs.ggef.model.dao;//package net.ent.etrs.ggef.model.dao;

import net.ent.etrs.ggef.model.dao.exceptions.DaoException;
import net.ent.etrs.ggef.model.entities.EntitiesFactory;
import net.ent.etrs.ggef.model.entities.Repas;
import net.ent.etrs.ggef.model.exceptions.RepasException;
import net.ent.etrs.ggef.model.references.enumeration.RegimeAlimentaire;
import net.ent.etrs.ggef.model.references.enumeration.TypeRepas;

import java.time.LocalDate;

public abstract class AbstractRepasDao implements IRepasMemDao {

        public AbstractRepasDao() {
        }

        public void init() {

                try {
                        Repas r1 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.PETIT_DEJEUNER);
                        r1.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r1.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas r2 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DEJEUNER);
                        r2.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
                        r2.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas r3 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DINER);
                        r3.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        Repas r4 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.PETIT_DEJEUNER);
                        r4.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas r5 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DEJEUNER);
                        r5.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r5.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        Repas r6 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DINER);
                        r6.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
                        r6.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas r7 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.PETIT_DEJEUNER);
                        r7.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
                        Repas r8 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.DEJEUNER);
                        r8.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);

                        this.create(r1);
                        this.create(r2);
                        this.create(r3);
                        this.create(r4);
                        this.create(r5);
                        this.create(r6);
                        this.create(r7);
                        this.create(r8);

                } catch (DaoException | RepasException e) {
                        e.printStackTrace();
                }

        }
}
