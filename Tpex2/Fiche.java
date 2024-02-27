import java.util.*;

class Fiche implements Comparable<Fiche> {
    private String nom;
    private String numero;
    private String adresse;

    public Fiche(String nom, String numero, String adresse) {
        this.nom = nom;
        this.numero = numero;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Numéro: " + numero + ", Adresse: " + adresse;
    }

    @Override
    public int compareTo(Fiche autreFiche) {
        return this.nom.compareTo(autreFiche.getNom());
    }
}