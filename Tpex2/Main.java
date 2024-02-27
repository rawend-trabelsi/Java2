import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Annuaire annuaire = new Annuaire();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez une commande (+, ?, !,) :");
            String commande = scanner.nextLine();

            if (commande.startsWith("+")) {
                String nom = commande.substring(1);
                System.out.println("Entrez le numéro de téléphone pour " + nom + ":");
                String numero = scanner.nextLine();
                System.out.println("Entrez l'adresse pour " + nom + ":");
                String adresse = scanner.nextLine();
                Fiche fiche = new Fiche(nom, numero, adresse);
                annuaire.ajouterFiche(nom, fiche);
                System.out.println("Fiche ajoutée avec succès !");
            } else if (commande.startsWith("?")) {
                String nom = commande.substring(1);
                Fiche fiche = annuaire.rechercherFiche(nom);
                if (fiche != null) {
                    System.out.println("Fiche pour " + nom + " : " + fiche);
                } else {
                    System.out.println("Aucune fiche trouvée pour " + nom);
                }
            } else if (commande.equals("!")) {
                annuaire.afficherAnnuaire();
            } else {
                System.out.println("Commande invalide !");
                break;
            }
        }
    }
}
