public class Main {
    public static void main(String[] args) {
        
        DossierPharmacie pharmacie = new DossierPharmacie("Ma Pharmacie");

        
        pharmacie.nouveauPatient("Rawend", new String[]{"Paracétamol", "Aspirine"});
        pharmacie.nouveauPatient("loujain", new String[]{"Ibuprofène", "Aspirine"});
        pharmacie.nouveauPatient("ranim", new String[]{"Paracétamol", "Ibuprofène"});

       
        pharmacie.affiche();

        
        pharmacie.ajoutMedicament("Rawend", "Ibuprofène");

        
        pharmacie.affichePatient("Rawend");

      
        System.out.println("Patients ayant pris de l'Ibuprofène : " + pharmacie.affichePatientAvecMedicament("Ibuprofène"));
    }
}
