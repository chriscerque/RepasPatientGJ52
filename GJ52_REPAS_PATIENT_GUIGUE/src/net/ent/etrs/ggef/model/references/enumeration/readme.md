Exemple Enum Complexe :

public enum TypePierrePrecieuse {

    TANZANITE("Tanzanite", 1037.00, "bleu saphir, violet brun"),
    JEREMJEVITE("Jeremvite", 1729.00, "blouge"),
    OPALE_DE_FEU("Opale de feu", 1987.00, "orvert"),
    DIAMANT("Diamant", 7.00,"transparent rose saumon"),
    EMERAUDE("Emeraude", 12.00, "vert-bleuté"),
    RUBIS("Rubis", 9.90,"rouge anis"),
    SAPHIR("Saphir", 200.00,"!rouge");


// ATTRIBUTS = donne le nom des proprités de l'enum :

    private final String libelle;
    private final double prix;
    private final String couleur;

//Constructeur :

    TypePierrePrecieuse(String libelle, double prix, String couleur) {
        this.libelle = libelle;
        this.prix = prix;
        this.couleur = couleur;
    }

// GETTERS

    public String getLibelle() { return libelle; }
    public double getPrix() {
        return prix;
    }
    public String getCouleur() {
        return couleur;
    }

// TOSRING

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TypePierrePrecieuse{");
        sb.append("libellé='").append(libelle).append('\'');
        sb.append(", prix=").append(prix);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }