package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.*;

import java.time.LocalDate;

/**
 * CLASSE POUR UNE INSERTION DE DONNEE :
 */

public abstract class AbstractRepasDao implements RepasDao { // CHANGER Xx par l'objet
                                                        // FAIRE LA MEME CHOSE POUR LE DEUXIEME ECT.


    /*-------------------------------------------------
     * Initialisations dans la persistance mémoire.
     */

    public void init() {

        try {
            Repas r1 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.PETIT_DEJEUNER);
            r1.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r1.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r2 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DEJEUNER);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGAN);
            r2.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r3 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(2), TypeRepas.DINER);
            r3.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas r4 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.PETIT_DEJEUNER);
            r4.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r5 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DEJEUNER);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.MIXE);
            r5.ajouterRegimeAlimentaire(RegimeAlimentaire.VEGETARIEN);
            Repas r6 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(1), TypeRepas.DINER);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            r6.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);
            Repas r7 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.PETIT_DEJEUNER);
            r7.ajouterRegimeAlimentaire(RegimeAlimentaire.DIABETIQUE);
            Repas r8 = FabriqueMetier.fabriquerRepas(LocalDate.now().plusDays(3), TypeRepas.DEJEUNER);
            r8.ajouterRegimeAlimentaire(RegimeAlimentaire.SANS_SEL);

            this.create(r1);
            this.create(r2);
            this.create(r3);
            this.create(r4);
            this.create(r5);
            this.create(r6);
            this.create(r7);
            this.create(r8);

        } catch (RepasException | DaoException e) {
            e.printStackTrace();
        }


    }

    /* EXEMPLE DE METHODE PRESENTE DANS L'ABSTRACT :
    public abstract Article rechercherArticleParNom(String libelle);
    A CODER DANS XXXDaoImpl
    *  */



}
