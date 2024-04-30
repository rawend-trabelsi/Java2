package ma.projet.service;

import ma.projet.beans.Client;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IDao<Client> {
    private List<Client> clients = new ArrayList<>();
    private int nextId = 1;

    public boolean create(Client client) {
        Connection connection = Connexion.getConnection();
        if (connection != null) {
            try {
                String query = "INSERT INTO client (nom, prenom) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, client.getNom());
                preparedStatement.setString(2, client.getPrenom());
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Client ajouté avec succès !");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de l'insertion du client dans la base de données !");
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean delete(Client client) {
        Connection connection = Connexion.getConnection();
        if (connection != null) {
            try {
                String query = "DELETE FROM client WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, client.getId());
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Client supprimé avec succès !");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de la suppression du client dans la base de données !");
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean update(Client client) {
        Connection connection = Connexion.getConnection();
        if (connection != null) {
            try {
                String query = "UPDATE client SET nom = ?, prenom = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, client.getNom());
                preparedStatement.setString(2, client.getPrenom());
                preparedStatement.setInt(3, client.getId());
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Client mis à jour avec succès !");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de la mise à jour du client dans la base de données !");
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    @Override
    public Client findById(int id) {
        Connection connection = Connexion.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM client WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    // Créer un objet Client à partir des données récupérées de la base de données
                    Client client = new Client(id, query, query);
                    client.setId(resultSet.getInt("id"));
                    client.setNom(resultSet.getString("nom"));
                    client.setPrenom(resultSet.getString("prenom"));
                    return client;
                } else {
                    System.out.println("Aucun client trouvé avec l'ID " + id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de la recherche du client dans la base de données !");
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

   
    
    @Override
    public List<Client> findAll() {
        List<Client> allClients = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM client";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // Créer un objet Client pour chaque enregistrement dans le résultat
                	 Client client = new Client(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"));
                	    allClients.add(client);
                    client.setId(resultSet.getInt("id"));
                    client.setNom(resultSet.getString("nom"));
                    client.setPrenom(resultSet.getString("prenom"));
                    allClients.add(client);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de la récupération des clients depuis la base de données !");
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return allClients;
    }

}
