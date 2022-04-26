package net.ent.etrs.ggef.model.dao;

import net.ent.etrs.ggef.model.dao.exceptions.DaoException;
import net.ent.etrs.ggef.model.entities.EntitiesFactory;
import net.ent.etrs.ggef.model.entities.Patient;
import net.ent.etrs.ggef.model.entities.Repas;
import net.ent.etrs.ggef.model.exceptions.RepasException;
import net.ent.etrs.ggef.model.references.enumeration.RegimeAlimentaire;
import net.ent.etrs.ggef.model.references.enumeration.TypeRepas;

import java.time.LocalDate;
import java.time.Month;


public abstract class AbstractPatientDao implements IPatientMemDao {

        private IRepasMemDao repasMemDao;

        public AbstractPatientDao() {
        }

        public void init() {

                try {
                        Patient miney = EntitiesFactory.fabriquerPatient("123456789", "Miney", "Bernard", LocalDate.of(1970, Month.DECEMBER, 12));
                        Patient haddock = EntitiesFactory.fabriquerPatient("124566789", "HADDOCK", "Archibald", LocalDate.of(1970, Month.APRIL, 1));
                        Patient tintin = EntitiesFactory.fabriquerPatient("123488889", "TINTIN", "Mar", LocalDate.of(1970, Month.FEBRUARY, 10));
                        Patient tournesol = EntitiesFactory.fabriquerPatient("127756789", "TOURNESOL", "Tryphon", LocalDate.of(1970, Month.MAY, 20));


                        Repas r1 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.PETIT_DEJEUNER);
                        r1.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        Repas r2 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DEJEUNER);
                        r2.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r2.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas r3 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DINER);
                        r3.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r3.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        Repas r4 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.PETIT_DEJEUNER);
                        r4.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r4.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
                        Repas r5 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DEJEUNER);
                        r5.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r5.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
                        Repas r6 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DINER);
                        r6.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        r6.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        Repas r7 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.PETIT_DEJEUNER);
                        r7.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r7.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        r7.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
                        Repas r8 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.DEJEUNER);
                        r8.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        r8.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
                        r8.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);

                        repasMemDao.create(r1);
                        repasMemDao.create(r2);
                        repasMemDao.create(r3);
                        repasMemDao.create(r4);
                        repasMemDao.create(r5);
                        repasMemDao.create(r6);
                        repasMemDao.create(r7);
                        repasMemDao.create(r8);

                        miney.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
//            miney.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
//            miney.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
//            miney.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
//            miney.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);

                        miney.ajouterRepas(r1);
                        miney.ajouterRepas(r2);
                        miney.ajouterRepas(r3);
                        miney.ajouterRepas(r4);
                        miney.ajouterRepas(r5);
                        miney.ajouterRepas(r6);
                        miney.ajouterRepas(r7);
                        miney.ajouterRepas(r8);


                        Repas c3 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(4), TypeRepas.DEJEUNER);
                        c3.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        c3.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        Repas c4 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(4), TypeRepas.DINER);
                        c4.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
                        c4.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        c4.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        Repas c5 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(5), TypeRepas.PETIT_DEJEUNER);
                        c5.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        Repas c6 = EntitiesFactory.fabriquerRepas(LocalDate.now().plusDays(5), TypeRepas.DINER);
                        c6.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);

                        repasMemDao.create(c3);
                        repasMemDao.create(c4);
                        repasMemDao.create(c5);
                        repasMemDao.create(c6);

                        haddock.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXTE);
                        haddock.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);

                        haddock.ajouterRepas(c3);
                        haddock.ajouterRepas(c4);

                        tintin.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
                        tintin.ajouterRepas(c5);
                        tournesol.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
                        tournesol.ajouterRepas(c6);
                        this.create(miney);
                        this.create(haddock);
                        this.create(tintin);
                        this.create(tournesol);
                } catch (DaoException | RepasException e) {
                        e.printStackTrace();
                }

        }
}
