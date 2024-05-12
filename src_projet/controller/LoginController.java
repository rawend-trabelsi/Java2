package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {
            try {
                redirectToTableau();
            } catch (IOException e) {
                showLoginErrorAlert("Erreur lors du chargement du tableau : " + e.getMessage());
            }
        } else {
            showLoginErrorAlert("Nom d'utilisateur ou mot de passe incorrect !");
        }
    }

    private void redirectToTableau() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableau.fxml"));
        BorderPane tableauPane = loader.load();

        Stage stage = (Stage) usernameField.getScene().getWindow();
        Scene scene = new Scene(tableauPane);
        stage.setScene(scene);
    }


    private void showLoginErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de Connexion");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
