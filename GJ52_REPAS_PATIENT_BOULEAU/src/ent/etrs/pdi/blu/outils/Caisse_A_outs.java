package ent.etrs.pdi.blu.outils;

import java.util.Random;
import java.util.Scanner;

public final class Caisse_A_outs {

        private static Scanner lectureClavier = new Scanner(System.in);

/*----------------------
Attributs +0+1
-----------------------*/
        /**
         * Lecture d'un entier. Si la valeur saisie n'est pas un entier, le message
         * "Choix invalide" est affiché, et la méthode attend une nouvelle saisie.
         *
         * @return l'entier saisi.
         */
        public static Integer readInteger() {
            int retour = -1;
            boolean boucle = true;
            do {
                boucle = false;
                try {
                    String chaine = lectureClavier.nextLine();
                    retour = Integer.parseInt(chaine);
                } catch (NumberFormatException e) {
                    System.out.println("Choix invalide");
                    boucle = true;
                }
            } while (boucle);

            return retour;
        }

        /**
         * Lecture d'un entier. Si la valeur saisie n'est pas un entier, le message
         * "Choix invalide" est affiché, et la méthode attend une nouvelle saisie.
         * @param chaine
         * @return l'entier saisi.
         */
        public static Integer readInteger(String chaine) {
            System.out.println(chaine);
            return readInteger();
        }

        /**
         * Lecture d'une chaine de caractère.
         *
         * @return chaine de caractère saisie.
         */
        public static String readString() {
            return lectureClavier.nextLine();
        }

        /**
         * Lecture d'une chaine de caractère.
         * @param chaine message affiché avant la saisie.
         * @return
         */
        public static String readString(String chaine) {
            System.out.println(chaine);
            return readString();
        }


        /**
         * Créer un nouvel entier compris entre 0 et 1 (exclu).
         * @return renvoie le nouvelle entier généré.
         */
        public static double random() {
            return new Random().nextDouble();
        }

        /**
         * Créer un nouvel entier compris entre min et max (exclue).
         * @param min borne inférieure
         * @param max borne supérieure (exclue)
         * @return renvoie le nouvelle entier généré.
         */
        public static Integer random(Integer min, Integer max) {
            Integer retour = -1;
            try {
                retour = new Random().nextInt(max-min)+min;
            }catch (IllegalArgumentException e) {
                System.out.println("la borne max doit être positive ou supérieure  à la borne inférieure.");

            }
            return retour;
        }


/*----------------------
CONSTRUCTEURS PRIVE
-----------------------*/

    private Caisse_A_outs() {
    }

}  // fin de classe