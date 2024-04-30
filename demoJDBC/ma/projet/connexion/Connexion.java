package ma.projet.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3307/demoJDBC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/demoJDBC","root","" );
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver JDBC introuvable !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Échec de la connexion à la base de données !");
        }
        return connection;
    }
}
