package td5;

public class Vetement extends Article implements Promotion {
    private String couleur;
    private String taille;

    public Vetement(long ref, String lib, float p, int q, String couleur, String taille) {
        super(ref, lib, p, q);
        this.couleur = couleur;
        this.taille = taille;
    }

    @Override
    public float calculPrixTTC() {
        return prixHT * (1 + TVA);
    }

    @Override
    public void decrire() {
        super.decrire();
        System.out.println("Classe : Vetement");
        System.out.println("Couleur : " + couleur);
        System.out.println("Taille : " + taille);
    }

    @Override
    public double prixDeVente(String dateStr) {
        if (estPeriodePromo(dateStr)) {
            return prixHT * 0.7; 
        } else {
            return prixHT;
        }
    }

    @Override
    public double prixDeVente(double prixHT) {
        
        return 0;
    }
}
