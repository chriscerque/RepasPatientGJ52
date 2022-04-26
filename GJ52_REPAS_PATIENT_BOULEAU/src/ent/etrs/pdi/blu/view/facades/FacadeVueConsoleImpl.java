package ent.etrs.pdi.blu.view.facades;

import ent.etrs.pdi.blu.model.entities.EntitiesFactory;
import ent.etrs.pdi.blu.model.entities.Patient;
import ent.etrs.pdi.blu.model.entities.references.Repas;
import ent.etrs.pdi.blu.model.references.C_MSG;
import ent.etrs.pdi.blu.view.exceptions.ViewException;
import ent.etrs.pdi.blu.view.ihm.FactoryIhm;
import ent.etrs.pdi.blu.view.ihm.Ihm;
import ent.etrs.pdi.blu.view.ihm.exceptions.IhmException;
import ent.etrs.pdi.blu.view.references.ConstantesView;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FacadeVueConsoleImpl implements FacadeVue {

    private Ihm ihm;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ConstantesView.PATTERN_DATE);

    protected FacadeVueConsoleImpl() {
        this.ihm = FactoryIhm.creerIhmconsole();
    }


    @Override
    public void afficherMessage(String msg) {
        this.ihm.afficherChaine(msg);
    }

    @Override
    public void afficherMessageErreur(String msg) {
        this.ihm.afficherChaine(msg);

    }

    @Override
    public int afficherMenu() throws ViewException {
        try {

            return this.ihm.saisirChoixMenu(ConstantesView.MENU_CHOIX);
        } catch (IhmException e) {
            throw new ViewException(e.getMessage());
        }
    }

    @Override
    public void afficherPatient(Patient patient) {
        StringBuilder sb = new StringBuilder();
        //String date = ConstantesView.PATTERN_DATE(patient.getDateEntree());

        // todo defaut format
        //sb.append(String.format("patient %s %s %s %d",patient.getNumSecu(), patient.getNom(),patient.getPrenom(), patient.getDateEntree());

        this.ihm.afficherChaine(sb.toString());

    }

    @Override
    public void afficherPatients(List<Patient> lstPatients) {
        List<Patient> patients = new ArrayList<>(lstPatients);
        for (Patient p : patients) {
            afficherPatient(p);
        }
    }

    @Override
    public Patient saisirPatient() throws ViewException {
        String secu = this.ihm.saisirChaine("Saisir num SECU Patient");
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
