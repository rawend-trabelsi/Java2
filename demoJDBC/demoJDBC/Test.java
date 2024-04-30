package demoJDBC;

import ma.projet.beans.Client;
import ma.projet.service.ClientService;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Créer une instance de ClientService
        ClientService clientService = new ClientService();
        
        // Créer 5 clients
        clientService.create(new Client("SAFI", "Ali"));
        clientService.create(new Client("ALAOUI", "Widane"));
        clientService.create(new Client("RAMI", "Amine"));
        clientService.create(new Client("ALAMI", "Kamal"));
        clientService.create(new Client("SELAMI", "Mohamed"));
        
        // Afficher le client avec l'ID = 3
        Client clientWithId3 = clientService.findById(3);
        if (clientWithId3 != null) {
            System.out.println("Client avec l'ID 3 : " + clientWithId3.getNom() + " " + clientWithId3.getPrenom());
        } else {
            System.out.println("Aucun client trouvé avec l'ID 3");
        }
        
        // Supprimer le client avec l'ID = 3
        Client clientToDelete = clientService.findById(3);
        if (clientToDelete != null) {
            boolean deleteResult = clientService.delete(clientToDelete);
            if (deleteResult) {
                System.out.println("Client avec l'ID 3 supprimé avec succès !");
            } else {
                System.out.println("Échec de la suppression du client avec l'ID 3");
            }
        } else {
            System.out.println("Aucun client trouvé avec l'ID 3, suppression impossible");
        }
        
        // Modifier le client avec l'ID = 2
        Client clientToUpdate = clientService.findById(2);
        if (clientToUpdate != null) {
            clientToUpdate.setNom("trabelsi");
            clientToUpdate.setPrenom("Rawend");
            boolean updateResult = clientService.update(clientToUpdate);
            if (updateResult) {
                System.out.println("Client avec l'ID 2 mis à jour avec succès !");
            } else {
                System.out.println("Échec de la mise à jour du client avec l'ID 2");
            }
        } else {
            System.out.println("Aucun client trouvé avec l'ID 2, mise à jour impossible");
        }
        
        // Afficher la liste des clients
        List<Client> allClients = clientService.findAll();
        System.out.println("Liste des clients :");
        for (Client client : allClients) {
            System.out.println(client.getNom() + " " + client.getPrenom());
        }
    }
}
