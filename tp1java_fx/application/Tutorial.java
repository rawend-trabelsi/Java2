package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Tutorial extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 300, 300);

        Button button = new Button("Hello World");

        // Ajout d'un gestionnaire d'événements pour détecter le clic sur le bouton
        button.setOnAction(e -> {
            System.out.println("Bouton cliqué !");
        });

        layout.getChildren().addAll(button);

        primaryStage.setTitle("CodersLegacy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
