package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.*;

import java.time.LocalDate;
import java.time.Month;

/**
 * CLASSE POUR UNE INSERTION DE DONNEE :
 */

public abstract class AbstractPatientDao implements PatientDao{ // CHANGER Xx par l'objet
                                                        // FAIRE LA MEME CHOSE POUR LE DEUXIEME ECT.


    /*-------------------------------------------------
     * Initialisations dans la persistance mémoire.
     */

    public void init() {
        try {

            AbstractRepasDao RepasDaoImpl = DaoFactory.fabriquerRepasDao();

            Patient miney = FabriqueMetier.fabriquerPatient("123456789", "Miney", "Bernard", LocalDate.of(1970, Month.DECEMBER, 12));
            Patient haddock = FabriqueMetier.fabriquerPatient("124566789", "HADDOCK", "Archibald", LocalDate.of(1970, Month.APRIL, 1));
            Patient tintin = FabriqueMetier.fabriquerPatient("123488889", "TINTIN", "Mar", LocalDate.of(1970, Month.FEBRUARY, 10));
            Patient tournesol = FabriqueMetier.fabriquerPatient("127756789", "TOURNESOL", "Tryphon", LocalDate.of(1970, Month.MAY, 20));


            Repas r1 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.PETIT_DEJEUNER);
            r1.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            Repas r2 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DEJEUNER);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r3 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DINER);
            r3.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r3.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas r4 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.PETIT_DEJEUNER);
            r4.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r4.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
            Repas r5 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DEJEUNER);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            Repas r6 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DINER);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            Repas r7 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.PETIT_DEJEUNER);
            r7.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r7.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            r7.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
            Repas r8 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.DEJEUNER);
            r8.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r8.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            r8.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);




            RepasDaoImpl.create(r1);
            RepasDaoImpl.create(r2);
            RepasDaoImpl.create(r3);
            RepasDaoImpl.create(r4);
            RepasDaoImpl.create(r5);
            RepasDaoImpl.create(r6);
            RepasDaoImpl.create(r7);
            RepasDaoImpl.create(r8);

            miney.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
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


            Repas c3 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(4), TypeRepas.DEJEUNER);
            c3.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            c3.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas c4 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(4), TypeRepas.DINER);
            c4.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            c4.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            c4.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas c5 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(5), TypeRepas.PETIT_DEJEUNER);
            c5.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas c6 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(5), TypeRepas.DINER);
            c6.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);

            RepasDaoImpl.create(c3);
            RepasDaoImpl.create(c4);
            RepasDaoImpl.create(c5);
            RepasDaoImpl.create(c6);

            haddock.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
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


        } catch ( PatientException | DaoException e) {
            e.printStackTrace();
        } catch (RepasException e) {
            e.printStackTrace();
        }


    }

    /* EXEMPLE DE METHODE PRESENTE DANS L'ABSTRACT :
    public abstract Article rechercherArticleParNom(String libelle);
    A CODER DANS XXXDaoImpl
    *  */



}
