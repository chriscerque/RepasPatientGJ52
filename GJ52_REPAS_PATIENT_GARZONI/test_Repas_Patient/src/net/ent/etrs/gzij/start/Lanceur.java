package net.ent.etrs.gzij.start;

import net.ent.etrs.gzij.model.facades.FabriqueFacadeMetier;
import net.ent.etrs.gzij.model.facades.IFacadeMetier;
import net.ent.etrs.gzij.presenter.PresenterGeneral;
import net.ent.etrs.gzij.presenter.exceptions.ExceptionPresenterGeneral;
import net.ent.etrs.gzij.vue.facades.FabriqueFacadeVue;
import net.ent.etrs.gzij.vue.facades.IFacadeVue;
import net.ent.etrs.gzij.vue.ihm.ModeAffichage;

public final class Lanceur {

    private static final String MSG_ANOMALIE_LANCEUR = "Une erreur est survenue ! Veuillez contacter le service client !";

    public static void main(String[] args) {

        try {

            IFacadeMetier metier = FabriqueFacadeMetier.creerFacadeMetier();
            IFacadeVue vue = FabriqueFacadeVue.fabriquerFacadeVue();
            //vue.definirModeAffichage(ModeAffichage.PANEL);
            vue.definirModeAffichage(ModeAffichage.CONSOLE);


            PresenterGeneral presenter = new PresenterGeneral(metier, vue);
            presenter.executer();

        } catch (Exception e) {
            System.out.println(MSG_ANOMALIE_LANCEUR);
        }

    } // fin de main

} // fin de classe
