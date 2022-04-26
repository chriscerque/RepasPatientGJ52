package marine.etrs.model_Metier.entities_Class_Factory;
import marine.etrs.model_Metier.facade.FacadeMetier;

import java.time.LocalDate;

/* -------------- TIPS --------------

METTRE LES MEMES PARAMETRES QUE LE LA FACTORY DU DIAGRAMME :
public static MaterielInformatique fabriquerOrdinateur (String numSerie, LocalDate dateGarantie ) {

METTRE LES MEMES PARAMETRES QUE SUR LA CLASSE :
Ordinateur ordinateur = new Ordinateur(numSerie, dateGarantie);

METRE LES SETTERS SUR LES ELEMENTS QU'ILS RESTENT :
ordinateur.setTypeOrdinateur(typeOrdinateur);
return ordinateur;
}

FACTORY NORMALE :
public static Commande fabriquerCommande(final LocalDate dateCommande){
return new Commande(dateCommande);
}
 */


public final class FabriqueMetier {
    public FabriqueMetier() {}



    /*FABRIQUE CREATION DU REPAS*/
    public static Repas fabriquerRepas(final LocalDate dateRepas, final TypeRepas typeRepas) throws RepasException {
        return new Repas(dateRepas,typeRepas);
    }

    /*FABRIQUE CREATION DU PATIENT*/
    public static Patient fabriquerPatient(final String numSecu, final String nom,final String prenom,final LocalDate dateEntree) throws PatientException {
        return new Patient(numSecu, nom,prenom, dateEntree);
    }

}






