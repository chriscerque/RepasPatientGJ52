package ent.etrs.pdi.blu.view.facades;


import ent.etrs.pdi.blu.model.entities.Patient;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.view.exceptions.ViewException;
import ent.etrs.pdi.blu.view.ihm.FactoryIhm;
import ent.etrs.pdi.blu.view.ihm.Ihm;
import ent.etrs.pdi.blu.view.ihm.exceptions.IhmException;
import ent.etrs.pdi.blu.view.references.ConstantesView;
import java.time.format.DateTimeFormatter;
import java.util.List;


public final class FacadeVuePanelmpl implements FacadeVue {

    private Ihm ihm;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ConstantesView.PATTERN_DATE);

    protected FacadeVuePanelmpl() {
        this.ihm = FactoryIhm.creerJPanel();
    }

    @Override
    public void afficherMessage(final String msg) {
        this.ihm.afficherChaine(msg);
    }

    @Override
    public void afficherMessageErreur(String msg) {

    }

    @Override
    public int afficherMenu() throws ViewException {
//		AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(C.MENU), "POPOTTE");
        try {

            return this.ihm.saisirChoixMenu(ConstantesView.MENU_CHOIX);
        } catch (IhmException e) {
            throw new ViewException(e.getMessage());
        }

    }

    @Override
    public void afficherPatient(Patient patient) {

    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {

    }

    @Override
    public Patient saisirPatient() throws ViewException {
        return null;
    }

    @Override
    public Patient selectionnerPatient(List<Patient> lstPatients) {
        return null;
    }

    @Override
    public List<Repas> selectionnerRepas(List<Repas> lstRepas) {
        return null;
    }

    @Override
    public Patient modifierPatient(Patient patient) throws ViewException {
        return null;
    }

    @Override
    public Patient ajouterRepasPatient(List<Patient> lstPatients, List<Repas> listRepas) {
        return null;
    }

}
