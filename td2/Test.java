package td2;

public class Test {
	public static void main(String[] args) {
		    Article A1 = new Article("pull", 65.8);
	        Article A2 = new Article("jupe", 47.8);

	        Stock stock = new Stock();
	        stock.addNouvArticle(A1, 6);
	        stock.addNouvArticle(A2, 7);

	        System.out.println("le Stock avant la vente est :");
	        stock.sortStock();

	      
	        Facture facture = new Facture(stock);

	    
	        facture.addLigne(4, "pull");
	        facture.addLigne(3, "jupe");
	        System.out.println("Montant total de la facture  est: " + facture.getMontantTotal());

	        System.out.println("le Stock après la vente est :");
	        stock.sortStock();
		}
	
		

	}

