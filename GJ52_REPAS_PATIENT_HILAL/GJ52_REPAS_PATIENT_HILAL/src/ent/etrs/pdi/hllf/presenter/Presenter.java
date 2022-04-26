package ent.etrs.pdi.hllf.presenter;

import ent.etrs.pdi.hllf.FacadeFactory;
import ent.etrs.pdi.hllf.business.exceptions.BusinessException;
import ent.etrs.pdi.hllf.model.facade.FacadeMetier;
import ent.etrs.pdi.hllf.view.exceptions.ViewException;
import ent.etrs.pdi.hllf.view.facade.FacadeVue;

public class Presenter
{
    private FacadeVue vue;
    private FacadeMetier metier;

    public Presenter() {
        vue = FacadeFactory.fabriquerFacadeVue();
        metier = FacadeFactory.fabriquerFacadeMetier();
    }

    public void exec() {
        try {
            int choix = -1;
            metier.init();
            do {
                choix = vue.afficherMenu();

                switch (choix) {
                    case 1:
                        vue.afficherPatients(metier.listerPatient());
                        break;
                    case 2:
                        metier.sauvegarderPatient(vue.saisirPatient(metier.listerRegimes()));
                        break;
                    case 3: metier.mettreAJourPatient(vue.modifierPatient(vue.selectionnerPatient(metier.listerPatient())));
                        break;
                    case 4:
                        metier.supprimerPatient(vue.selectionnerPatient(metier.listerPatient()));
                        break;
                    case 5:
                        metier.mettreAJourPatient(vue.ajouterRepasPatient(metier.listerPatient(), metier.listerRepas()));
                }
            } while (choix != 0);
        }catch(BusinessException | ViewException e)
        {
            vue.afficherMessageErreur(e.getMessage());
        }
    }
}
