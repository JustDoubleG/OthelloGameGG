//Sean Byron 
//COSC 
//Fundamentals 2 Lab 
//Lab 8 CircleMover class


//Write a Java program named CircleMover that moves a circle shape in a 
//pane. You should define a pane class for displaying the circle and 
//provide the methods for moving it left, right, up, and down. Check the 
//boundary to prevent the circle from moving out of sight completely.

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class CircleMover2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        double w = 500;
        double h = 500;
        BallPane ballPane = new BallPane(w / 2, h / 2, Math.min(w,h) / 15);

        Button btUp = new Button("Up");
        btUp.setOnAction(e -> ballPane.moveUp());

        Button btDown = new Button("Down");
        btDown.setOnAction(e -> ballPane.moveDown());

        Button btLeft = new Button("Left");
        btLeft.setOnAction(e -> ballPane.moveLeft());

        Button btRight = new Button("Right");
        btRight.setOnAction(e -> ballPane.moveRight());

        HBox buttons = new HBox(btUp, btDown, btLeft, btRight);
        buttons.setSpacing(10);

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);

        Scene scene = new Scene(pane, w, h);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Mover");
        primaryStage.show();
    }

    private class BallPane extends Pane {

        private Circle c;

        public BallPane(double centerX, double centerY, double radius) {
            c = new Circle(centerX, centerY, radius);
            getChildren().add(c);
        }

        public void moveUp() {
            if (c.getCenterY() - c.getRadius()  - 10 < 0) return;
            c.setCenterY(c.getCenterY() - 10);
        }
        public void moveDown() {
            if (c.getCenterY() + c.getRadius() + 10 > getHeight()) return;
            c.setCenterY(c.getCenterY() + 10);
        }
        public void moveRight() {
            if (c.getCenterX() + c.getRadius() + 10 > getWidth()) return;
            c.setCenterX(c.getCenterX() + 10);
        }
        public void moveLeft() {
            if (c.getCenterX() - c.getRadius()  - 10 < 0) return;
            c.setCenterX(c.getCenterX() - 10);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}