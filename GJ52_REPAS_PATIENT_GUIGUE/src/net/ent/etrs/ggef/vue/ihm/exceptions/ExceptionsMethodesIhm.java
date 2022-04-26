package net.ent.etrs.ggef.vue.ihm.exceptions;

import java.util.Objects;

public final class ExceptionsMethodesIhm {
//TODO Javadoc à faire
/*----------------------
GESTION DES OBJETS
-----------------------*/

public static void objectControlerSiNull(final String nomObjetPerso, final Object objet_a_tester) throws ExceptionsIhm {
    if (Objects.isNull(objet_a_tester)) {
        throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_OBJECT_VAUT_NULL, nomObjetPerso));
    }
}

/*----------------------
GESTION DES STRING
-----------------------*/


public static void chaineControlerSiNull(final String nomVariable, final String chaine_a_tester) throws ExceptionsIhm {
    if (Objects.isNull(chaine_a_tester)) {
        throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_STRING_VAUT_NULL, nomVariable));
    }
}

public static void chaineControlerLongueur(final String nomVariable, final String chaine_a_tester, final int longueurMini) throws ExceptionsIhm {
    if (longueurMini != 0) {
        if (chaine_a_tester.length() < longueurMini) {
            throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_STRING_LONGUEUR_INCORRECTE, nomVariable, longueurMini) );
        }
    }
}

/*----------------------
GESTION DES NOMBRES
-----------------------*/

    public static void nombreControlerMinMax(final String nomVariable, final int nombre_a_tester, final int borneMinInclus, final int borneMaxInclus  ) throws ExceptionsIhm {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }


    public static void nombreControlerMinMax(final String nomVariable, final float nombre_a_tester, final float borneMinInclus, final float borneMaxInclus  ) throws ExceptionsIhm {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }

    public static void nombreControlerMinMax(final String nomVariable, final double nombre_a_tester, final double borneMinInclus, final double borneMaxInclus  ) throws ExceptionsIhm {
        if ( nombre_a_tester < borneMinInclus    || nombre_a_tester > borneMaxInclus ) {
            throw new ExceptionsIhm(String.format(ExceptionsConstantesIhm.MSG_ERR_NOMBRE_MIN_MAX, nomVariable, borneMinInclus, borneMaxInclus));
        }
    }

/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/

    private ExceptionsMethodesIhm() {
    }

}  // fin de classe