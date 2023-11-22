package td5;

public class Achat {
    static Article[] supermarche = new Article[4];

    public static void main(String[] args) {

        supermarche[0] = new Vetement(123, "Jupe bleue taille S", 39.000f, 2, "Bleu", "S");
        supermarche[1] = new ProduitElec(145, "TV Led 80cm", 1450.000f, 0, "TV");
        supermarche[2] = new Vetement(178, "Pantalon noir taille M", 42.000f, 5, "Noir", "M");
        supermarche[3] = new ProduitGC(191, "Pâtes", 0.410f, 18);

        double montantTotal = 0;

        for (Article article : supermarche) {
            if (article != null) {
                int qteAchete = Math.min(article.qteStock, 1);

                if (article.estDispo(qteAchete)) {
                    System.out.println("Achat de " + qteAchete + " " + article.libelle);
                    
                    float prixTTC = article.calculPrixTTC();
                    
                    if (article instanceof Promotion) {
                        Promotion promoArticle = (Promotion) article;
                        if (promoArticle.estPeriodePromo("21/03/2023")) {
                            prixTTC = (float) promoArticle.prixDeVente("21/03/2023");
                        }
                    }
                    
                    System.out.println("Prix TTC à payer : " + prixTTC);

                    montantTotal += prixTTC * qteAchete;

                    article.approvisionner(qteAchete);
                } else {
                    System.out.println("Article indisponible : " + article.libelle);
                    
                    if (article instanceof ProduitGC) {
                        ProduitGC produitGC = (ProduitGC) article;
                        produitGC.approvisionner(10);
                    }
                    
                    System.out.println("Article approvisionné. Nouvelle quantité en stock : " + article.qteStock);
                }

                System.out.println("-----------------------");
            }
        }

        System.out.println("Montant total à payer : " + montantTotal);
    }
}
