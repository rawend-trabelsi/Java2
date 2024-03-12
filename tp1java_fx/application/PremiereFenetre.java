package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PremiereFenetre extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);
        primaryStage.setTitle("Ma première fenêtre");
        primaryStage.setScene(scene);

      
        Line line = new Line(50, 50, 200, 100);
        line.setStroke(Color.GREEN); 
        root.getChildren().add(line); 

       
        Rectangle rectangle = new Rectangle(100, 150, 150, 100);
        rectangle.setFill(Color.PINK); 
        root.getChildren().add(rectangle); 

       
        Circle circle = new Circle(300, 250, 50);
        circle.setFill(Color.ORANGE); 
        root.getChildren().add(circle);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
