/*-------------------------------------------------------------------------------*/

// Exemple de construction d'un menu depuis une chaine de caratère :

// construction de la 'chaine-menu' :
    StringBuilder strMenu = new StringBuilder();
    strMenu.append("Menu test").append(System.lineSeparator());
    strMenu.append("1 - test").append(System.lineSeparator());
    strMenu.append("2 - test").append(System.lineSeparator());
    strMenu.append(System.lineSeparator());
    strMenu.append("0 - quitter").append(System.lineSeparator());

// Appel de la methode :
    panel.saisirchoixMenu(strMenu.toString(),0,4);

/*-------------------------------------------------------------------------------*/

// Exemple de lancement d'une console ou panel depuis les arguments d'un main :
// Dans Run / Edit configurations /


// vérification de la valeur de l'argument
   System.out.println(args[0]);
// génération d'une ConsoleIhm
    Ihm vue = new IhmConsole();
// Vérification si paramètre passé est ok
    if(Objects.nonNull(args) && args.length >=1){
// Lancement d'un JPanelIhm
    if(args[0].equals("vue=1")) {
        vue = new IhmPanel();
    }

/*-------------------------------------------------------------------------------*/


