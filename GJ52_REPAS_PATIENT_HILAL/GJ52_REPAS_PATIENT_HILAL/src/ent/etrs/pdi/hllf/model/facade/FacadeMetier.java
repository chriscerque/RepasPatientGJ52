package ent.etrs.pdi.hllf.model.facade;

import ent.etrs.pdi.hllf.business.exceptions.BusinessException;
import ent.etrs.pdi.hllf.model.entities.Patient;
import ent.etrs.pdi.hllf.model.entities.Repas;
import ent.etrs.pdi.hllf.model.references.RegimeAlimentaire;

import java.util.List;

public interface FacadeMetier
{
    /**
     * methode permettant de recuperer un patient en passant par son id
     * @param id String
     * @return Patient
     */
    public Patient recupererPatientById(String id) throws BusinessException;

    /**
     * methode permettant d'initialiser la facade metier
     */
    public void init() throws BusinessException;

    /**
     * methode permettant de recuprer la liste des repas
     * @return List<Repas>
     */
    public List<Repas> listerRepas();

    /**
     * methode permettant de supprimer un patient
     * @param patient void
     */
    public void supprimerPatient(Patient patient) throws BusinessException;

    /**
     * methode permettant de recuperer la liste des patients
     * @return List<Patient>
     */
    public List<Patient> listerPatient();

    /**
     * methode permettant de sauver un patient dans la liste de patient
     * @param patient Patient
     */
    public void sauvegarderPatient(Patient patient) throws BusinessException;

    /**
     * methode permettant de mettre a jour un patient directement dans la liste
     * @param patient Patient
     */
    public void mettreAJourPatient(Patient patient);

    /**
     * methode permettant de lister les regimes alimentaire
     * @return List<RegimeAlimentaire>
     */
    public List<RegimeAlimentaire> listerRegimes();
}
