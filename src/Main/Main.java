package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Application started");
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/mainwindow.fxml"));
        primaryStage.setTitle("QY - Text Editor");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        System.out.println("Everything is OK");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
