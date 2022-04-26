package marine.etrs.model_Metier.entities_Class_Factory;
/*
-------------------------- TIPS -----------------------------------------

- UUID : private String id = UUID.randomUUID().toString();

- Exemple si 0..* pas de besoin mettre le constructeur juste en paramètre d'une classe
List<LigneCommande> listeLignesCommande = new ArrayList<>();

- Exemple de LocalDate en paramètre d'une classe : private LocalDate dateCommande = LocalDate.now();

- Dans les setters TOUJOURS TESTER SI NUL ! :
if (Objects.isNull(dateCommande) || dateCommande.isBefore(LocalDate.now()))
OU
if (Objects.isNull(libelle) || libelle.isEmpty())

- LE PAR DEFAUT exemple : private int quantite = 1;

- Le design pattern Singleton permet de s'assurer qu'une classe ne puisse produire qu'une seule et unique instance.
*/


import net.ent.etrs.model.references.C_MSG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient {

    private String nom;
    private String prenom;
    private String id = UUID.randomUUID().toString();
    private LocalDate dateEntree;
    private String numSecu;


    List<RegimeAlimentaire> lstRegimeAlimentaire = new ArrayList<>();
    List<Repas> lstRapas = new ArrayList<>();

    public Patient(final String numSecu, final String nom,final String prenom,final LocalDate dateEntree) throws PatientException {
        setNom(nom);
        setPrenom(prenom);
        setDateEntree(dateEntree);
        setNumSecu(numSecu);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PatientException {
        if (nom.length() < 3 || nom.length() > 50) {
            throw new PatientException(C_MSG.MSG_PATIENT_NOM_EXCEPTION);

        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws PatientException {
        if (prenom.length() < 3 || prenom.length() > 50) {
            throw new PatientException(C_MSG.MSG_PATIENT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }


    public LocalDate getDateEntree() {

        return dateEntree;
    }

    public void setDateEntree(LocalDate dateEntree) throws PatientException {
        if (Objects.isNull(dateEntree) || dateEntree.isAfter(LocalDate.now())) {
            throw new PatientException(C_MSG.MSG_PATIENT_DATE_ENTREE_INVALIDE_EXCEPTION);
        }
        this.dateEntree = dateEntree;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) throws PatientException {
//        if (numSecu.length() != 5) {
//            throw new PatientException(C_MSG.MSG_AUCUN_PATIENT);
//        }
        this.numSecu = numSecu;
    }

    public List<RegimeAlimentaire> getLstRegimeAlimentaire() {
        return lstRegimeAlimentaire;
    }

    public void setLstRegimeAlimentaire(List<RegimeAlimentaire> lstRegimeAlimentaire) {
        this.lstRegimeAlimentaire = lstRegimeAlimentaire;
    }

    public List<Repas> getLstRapas() {
        return lstRapas;
    }

    public void setLstRapas(List<Repas> lstRapas) {
        this.lstRapas = lstRapas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getNumSecu().equals(patient.getNumSecu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumSecu());
    }


    /*
    CONTROLE SI LE REGIME EST DEJA PRESENT
     */

    private void controleRegimeAlimentaire(Repas repas) {
        //TODO A FAIRE
    }

    /*
    AJOUTE UN REPAS DANS LA LSITE REPAS
     */
    public void ajouterRepas(Repas repas) {

        if (!Objects.isNull(repas)) {
            lstRapas.add(repas);
        }
        //TODO TEST SI LE REPAS EST DEJA PRESENT:
    }

    /*
    AJOUT D'UN REGIME DANS LA LISTE REGIME ALIMENTAIRE
     */
    public void ajouterRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) {

        if (!Objects.isNull(regimeAlimentaire)) {
            lstRegimeAlimentaire.add(regimeAlimentaire);
        }
        // TODO FAIRE PLUS DE COMTROLE
        //TODO TEST SI LE REGIME EST DEJA PRESENT:
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", dateEntree=").append(dateEntree);
        sb.append(", numSecu='").append(numSecu).append('\'');
        sb.append('}');
        return sb.toString();
    }

    ///METHODES

    //LISTE LES ARTICLE DE LA LISTE listeLignesCommande de type LigneCommande
//    public List<Article> getListeArticles() {
//        List<Article> lst = new ArrayList<>();
//        for (LigneCommande ligneCommande : this.listeLignesCommande) {
//            lst.add(ligneCommande.getArticle());
//        }
//        return Collections.unmodifiableList(lst);
//    }


//    private LigneCommande retournerLigneCommande(final Article article) {
//        //on parcourt la liste de ligne de commande
//        //afin de recherche si l'une d'elle correspond à l'article passé en paramètre.
//        for (LigneCommande ligneCommande : listeLignesCommande) {
//            if (ligneCommande.getArticle().equals(article)) {
//                //une ligne de commande existe avec l'article passé en paramètre
//                //on renvoie la ligne de commande.
//                return ligneCommande;
//            }
//        }
//        //aucune ligne de commande n'existe avec l'article passé en paramètre
//        //on renvoie null.
//        return null;


}