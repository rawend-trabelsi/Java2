package td5;

public class ProduitElec extends Article implements Promotion {
    private String categorie;

    public ProduitElec(long ref, String lib, float p, int q, String categorie) {
        super(ref, lib, p, q);
        this.categorie = categorie;
    }

    @Override
    public float calculPrixTTC() {
        return prixHT * (1.08f + TVA);
    }

    @Override
    public void decrire() {
        super.decrire();
        System.out.println("Classe : ProduitElec");
        System.out.println("Catégorie : " + categorie);
    }

    @Override
    public double prixDeVente(String dateStr) {
        if (estPeriodePromo(dateStr)) {
            return prixHT * 0.8f; 
        } else {
            return prixHT;
        }
    }

	@Override
	public double prixDeVente(double prixHT) {
		// TODO Auto-generated method stub
		return 0;
	}
}
