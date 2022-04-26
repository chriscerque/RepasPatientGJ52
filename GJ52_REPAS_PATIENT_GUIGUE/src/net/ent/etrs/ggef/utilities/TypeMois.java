package net.ent.etrs.ggef.utilities;

public enum TypeMois {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
    JANVIER(1),
    FEVRIER(2),
    MARS(3),
    AVRIL(4),
    MAI(5),
    JUIN(6),
    JUILLET(7),
    AOUT(8),
    SEPTEMBRE(9),
    OCTOBRE(10),
    NOVEMBRE(11),
    DECEMBRE(12);


    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private int mois;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/

    TypeMois(final int mois) {
        this.mois = mois;
    }
/*----------------------
    ******** Getter ********
    ----------------------*/

    public int getMois() {
        return mois;
    }
   /*------------------------------*
    ******** Autres methodes ********
    -------------------------------*/



} // fin d'Enum
