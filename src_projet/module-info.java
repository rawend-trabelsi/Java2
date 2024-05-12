module AGENCE {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    exports controller;
    opens controller to javafx.fxml; // Autorise l'accès réflexif du module javafx.fxml aux classes du package controller

    opens application to javafx.graphics, javafx.fxml;
}
