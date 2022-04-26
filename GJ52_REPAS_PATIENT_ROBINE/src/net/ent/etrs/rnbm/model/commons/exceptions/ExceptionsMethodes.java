package net.ent.etrs.rnbm.model.commons.exceptions;

import java.util.Objects;

public final class ExceptionsMethodes {

/*----------------------
GESTION DES OBJETS
-----------------------*/

    public static void objectControlerSiNull(String nomObjetPerso, Object objet_a_tester) throws ExceptionsConstructeur {
        if (Objects.isNull(objet_a_tester)) {
            throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_OBJECT_VAUT_NULL, nomObjetPerso));
        }
    }

/*----------------------
GESTION DES STRING
-----------------------*/


    public static void chaineControlerSiNull(String nomVariable, String chaine_a_tester) throws ExceptionsConstructeur {
        if (Objects.isNull(chaine_a_tester)) {
            throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_STRING_VAUT_NULL, nomVariable));
        }
    }

    public static void chaineControlerLongueur(String nomVariable, String chaine_a_tester, int longueurMini) throws ExceptionsConstructeur {
        if (longueurMini != 0) {
            if (chaine_a_tester.length() < longueurMini) {
                throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_STRING_LONGUEUR_INCORRECTE, nomVariable, longueurMini) );
            }
        }
    }

/*----------------------
GESTION DES NOMBRES
-----------------------*/

    public static void nombreControlerMinMax(String nomVariable, int nombre_a_tester, int borneMinInclus, int borneMaxInclus  ) throws ExceptionsConstructeur {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }


    public static void nombreControlerMinMax(String nomVariable, float nombre_a_tester, float borneMinInclus, float borneMaxInclus  ) throws ExceptionsConstructeur {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }

    public static void nombreControlerMinMax(String nomVariable, double nombre_a_tester, double borneMinInclus, double borneMaxInclus  ) throws ExceptionsConstructeur {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsConstructeur(String.format(ExceptionsConstantes.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }

/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/

    private ExceptionsMethodes() {
    }

}
