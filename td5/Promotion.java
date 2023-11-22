package td5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface Promotion {
    LocalDate debutPromo = LocalDate.of(2022, 3, 19);
    LocalDate finPromo = LocalDate.of(2022, 3, 31);

    double prixDeVente(String dateStr);
    double prixDeVente(double prixHT);

    default boolean estPeriodePromo(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateAchat = LocalDate.parse(dateStr, formatter);
        return !dateAchat.isBefore(debutPromo) && !dateAchat.isAfter(finPromo);
    }
    static double calculerRemise(double prixAvantRemise, double prixApresRemise) {
        return ((prixAvantRemise - prixApresRemise) / prixAvantRemise) * 100;
    }
}
