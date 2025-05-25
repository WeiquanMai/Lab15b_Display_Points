/*
CSC-239 JAVA
Project Name: Display Points
Student: Weiquan Mai
Date: April 26, 2025
Description: Program utilizes JavaFx to add and remove points.
Program draws a simple circle on the screen if user left clicks, and removes the circle if user right clicks.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.scene.Node;


public class Lab15b extends Application{
    
    @Override // Override the start method in the Application class
    public void start (Stage primaryStage){
        // Create a pane
        Pane pane = new Pane();

        pane.setOnMouseClicked(e->{
            ObservableList<Node> list = pane.getChildren();
            if(e.getButton()== javafx.scene.input.MouseButton.PRIMARY){
                Circle circle = new Circle(e.getX(), e.getY(),5);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.GREEN);
                list.add(circle);
            }
            if(e.getButton()== javafx.scene.input.MouseButton.SECONDARY){
                for(int i = 0; i < list.size(); i++){
                    Node node = list.get(i);
                    if(node.contains(e.getX(),e.getY())){
                      list.remove(node);
                      break;
                    }
                }
            }
        });


        //Create a scene and place it on the stage
        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("Lab15b");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
