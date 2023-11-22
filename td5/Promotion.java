package td5;

	import java.time.LocalDate;

	public interface Promotion {
	   
	    LocalDate debutPromo = LocalDate.of(2022, 3, 19);
	    LocalDate finPromo = LocalDate.of(2022, 3, 31);

	   
	    double prixDeVente(String dateStr);
	    double prixDeVente(double prixHT);

	    
	    default boolean estPeriodePromo(String dateStr) {
	        LocalDate dateAchat = LocalDate.parse(dateStr);
	        return (dateAchat.isAfter(debutPromo) || dateAchat.isEqual(debutPromo))
	                && (dateAchat.isBefore(finPromo) || dateAchat.isEqual(finPromo));
	    }
	    static double calculerRemise(double prixAvantRemise, double prixApresRemise) {
	        return ((prixAvantRemise - prixApresRemise) / prixAvantRemise) * 100;
	    }}



		

