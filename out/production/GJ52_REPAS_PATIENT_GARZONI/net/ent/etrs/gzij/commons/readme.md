 /*-----------------------------------------------------------------------------------------------------------*/ 
// Exemple d'application des méthodes présentes dans le dossier Outils afin de nettoyer un jeu de données
// et permettre la fabrication d'un objet (TP Lucky Luke) ,etc.
         splitDonnees(C.TAB_DONNEES[i], ";;");
         splitTablo(tabloDonnees,3,",");
         remplacerCaractere(tabloSplit,"(","");
         remplacerCaractere(tabloSplit,"M","H",2);

// génération d'un tableau de type Personnages pour la génération et le stockage final :

    Personnage[] personnages = new Personnage[C.TAB_DONNEES.length];

// il faut créer des tableaux qui serviront à stocker les infos modifiées :

    String[] tabloDonnees;
    String[] tabloSplit;


// Nettoyage et traitement des données puis création en fin de chaque ligne, du personnage et stockage final :

        for (int i = 0; i < C.TAB_DONNEES.length; i++) {
        // split des données brutes :
            tabloDonnees = splitDonnees(C.TAB_DONNEES[i], ";;");
        // split supplémentaire sur une colonne déterminée (en cas de besoin) :
            tabloSplit = splitTablo(tabloDonnees,3,",");
        // nettoyage des caractères parasites :
            tabloSplit = remplacerCaractere(tabloSplit,"(","");
            tabloSplit = remplacerCaractere(tabloSplit,")","");
            tabloSplit = remplacerCaractere(tabloSplit,"M","H",2);

        // vérification du résultat :
            for (int j = 0; j < tabloSplit.length; j++) {
                console.afficherChaine(tabloSplit[j]);
            }
        // possibilité d'appeler chaque colonne de la ligne afin d'instancier une fabrique :

            personnages[i] = FabriquesMetier.creerpersonnage(tabloSplit[0],tabloSplit[1], Sexe.valueOf(tabloSplit[2]), Role.valueOf(tabloSplit[5]));
            personnages[i].setAlbum(new Album(tabloSplit[3], Integer.parseInt(tabloSplit[4]) ));

            System.out.println(personnages[i]);

        } // fin de boucle for

/*-----------------------------------------------------------------------------------------------------------*/ 