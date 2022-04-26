package net.ent.etrs.ggef.start;

import net.ent.etrs.ggef.model.facades.FabriqueFacadeMetier;
import net.ent.etrs.ggef.model.facades.FacadeMetier;
import net.ent.etrs.ggef.presenter.PresenterGeneral;
import net.ent.etrs.ggef.vue.facades.FabriqueFacadeVue;
import net.ent.etrs.ggef.vue.facades.FacadeVue;
import net.ent.etrs.ggef.vue.ihm.ModeAffichage;

public final class Lanceur {

    private static final String MSG_ANOMALIE_LANCEUR = "Une erreur est survenue ! Veuillez contacter le service client !";

    public static void main(String[] args) {

        try {

            FacadeMetier metier = FabriqueFacadeMetier.creerFacadeMetier();
            // la methode init ne fonctionne pas alors je la commente pour au moins pouvoir afficher le menu...
            // metier.init();
            FacadeVue vue = FabriqueFacadeVue.fabriquerFacadeVue();
            //vue.definirModeAffichage(ModeAffichage.PANEL);
            vue.definirModeAffichage(ModeAffichage.CONSOLE);


            PresenterGeneral presenter = new PresenterGeneral(metier, vue);
            presenter.exec();

        } catch (Exception e) {
            System.out.println(MSG_ANOMALIE_LANCEUR);
        }

    } // fin de main

} // fin de classe
