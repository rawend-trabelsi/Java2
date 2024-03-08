package td2;

import java.util.HashMap;
import java.util.*;
import java.util.Iterator;

public class Stock {
	private HashSet<Article> articlesMg = new HashSet<>();
	private HashMap<String, Integer> stockMg = new HashMap<>();

		public boolean addNouvArticle(Article a, int qt )
		{
		if(stockMg.containsKey(a.getNom()))
			return false;
		articlesMg.add(a) ;
		stockMg.put(a.getNom(), qt);
		return true;
		}
		
		public boolean verifArticle(String a) {
		    return stockMg.containsKey(a);
		}
		 
		 public Article getArticle(String a) {
		        for (Article article : articlesMg) {
		            if (article.getNom().equals(a)) {
		                return article;
		            }
		        }
		        return null;
		    }

			public int getQt(String a)
			{
			if(!stockMg.containsKey(a))
				return -1;
			else
				return stockMg.get(a);
			}
			
			public Boolean changeQt(String a, int i)
			{
			if(!stockMg.containsKey(a))
				return false;
				int qt =stockMg.get(a);
				qt = qt +i;
			if(qt<0)
				return false;
			else
				stockMg.put(a, qt);
				return true ; 
				}
		
			
			public boolean removeArticle(String a) {
			    if (!stockMg.containsKey(a))
			        return false;

			    Iterator <Article> it = articlesMg.iterator();
			    while (it.hasNext()) {
			        if (it.next().getNom().equals(a)) {
			            it.remove();
			            stockMg.remove(a);
			            return true;
			        }
			    }
			    return false;
			}
		
		public void sortStock() {
			    TreeMap<String, Integer> s = new TreeMap<>(stockMg);
			    for (String nomArt : s.keySet()) {
			        System.out.println( nomArt + ": " + s.get(nomArt));
			    }
			}
			

}