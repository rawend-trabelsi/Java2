package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label dashboardLabel;

    // Cette méthode sera appelée automatiquement après le chargement du fichier FXML
    public void initialize() {
        dashboardLabel.setText("Bienvenue sur le Tableau de Bord !");
    }

    // Méthode pour gérer l'événement de gestion des voyages
    @FXML
    private void handleManageTrips() {
        // Code pour gérer la gestion des voyages
        System.out.println("Gestion des voyages");
    }

    // Méthode pour gérer l'événement de gestion des réservations
    @FXML
    private void handleManageBookings() {
        // Code pour gérer la gestion des réservations
        System.out.println("Gestion des réservations");
    }
}
