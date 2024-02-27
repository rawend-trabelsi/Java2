import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Annuaire {
    private TreeMap<String, Fiche> annuaire;

    public Annuaire() {
        annuaire = new TreeMap<>();
    }

    public void ajouterFiche(String nom, Fiche fiche) {
        annuaire.put(nom, fiche);
    }

    public Fiche rechercherFiche(String nom) {
        return annuaire.get(nom);
    }

    public void afficherAnnuaire() {
        System.out.println("Annuaire :");
        for (Fiche fiche : annuaire.values()) {
            System.out.println(fiche);
        }
    }
}
