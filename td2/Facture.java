package td2;
import java.util.ArrayList;

public class Facture {
	private ArrayList<LigneFacture> lignes ;
	private Stock stock;	
	
	public Facture(Stock stock) {
		this.stock = stock;
		 lignes=new ArrayList<LigneFacture>();
	}
	
	public Boolean addLigne(int qt, String a)
	{
		
		if(!stock.verifArticle(a)){
	        return false;
	    }
		 int Q = stock.getQt(a);
		    if (Q <= 0 || Q < qt) {
		        return false;
		    }
		    int id = lignes.size() + 1;
		    Article article = stock.getArticle(a);
		    LigneFacture nouvelleLigne = new LigneFacture(id, qt, article);
		    lignes.add(nouvelleLigne);
		    stock.changeQt(a, -qt);
		    return true;
	}
	 public boolean removeLigne (int id)
	 {
		 int size = lignes.size();
	 if(id<size)
		 return false;
	 else
	 {
		 LigneFacture l =lignes.get(id-1);
		 int qt = l.getQt();
		 stock.changeQt(l.getArticle().getNom(), qt);
		 lignes.remove(id -1);
	 for(int i =id-1; i<size-1; i++)
		 lignes.get(i).setId(i+1);
		 return true;
	 }
}
	
	 

		public double getMontantTotal() {
			double montantTotal = 0;
		    for (LigneFacture ligne : lignes) {
		        montantTotal += ligne.getMontantTotal();
		    }
		    return montantTotal;	
		}

}