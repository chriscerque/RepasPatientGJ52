package net.ent.etrs.rnbm.model.dao;


import net.ent.etrs.rnbm.model.dao.exceptions.DaoException;
import net.ent.etrs.rnbm.model.entities.FactoryMetier;
import net.ent.etrs.rnbm.model.entities.Repas;
import net.ent.etrs.rnbm.model.exceptions.RepasConstructionException;

import net.ent.etrs.rnbm.model.references.enumerateds.RegimeAlimentaire;
import net.ent.etrs.rnbm.model.references.enumerateds.TypeRepas;

import java.time.LocalDate;

public abstract class AbstractIRepasMemDao implements IRepasMemDao {

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public AbstractIRepasMemDao() {

    }


    /* *************************** */
    /* ***** AUTRES METHODES ***** */

    /**
     * Méthode permettant l'initialisation de l'implémentation Dao.
     */
    public void init() {
        try {
            Repas r1 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.PETIT_DEJEUNER);
            r1.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r1.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r2 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DEJEUNER);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r3 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DINER);
            r3.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas r4 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.PETIT_DEJEUNER);
            r4.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r5 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DEJEUNER);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas r6 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DINER);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r7 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.PETIT_DEJEUNER);
            r7.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            Repas r8 = FactoryMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.DEJEUNER);
            r8.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);

            this.create(r1);
            this.create(r2);
            this.create(r3);
            this.create(r4);
            this.create(r5);
            this.create(r6);
            this.create(r7);
            this.create(r8);

        } catch (RepasConstructionException | DaoException e) {
            e.printStackTrace();
        }

    }


} 

