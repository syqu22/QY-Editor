package mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    final String VERSION = "v0.1";

    @Override
    public void start(Stage primaryStage) throws Exception {
        long timeStart = System.currentTimeMillis();
        System.out.println("QY: " + VERSION + " application started");
        Parent root = FXMLLoader.load(getClass().getResource("../res/mainwindow.fxml")); //startwindow.fxml
        primaryStage.setTitle("QY - Text Editor");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.show();

        System.out.println("QY: Scene showed");
        long timeEnd = System.currentTimeMillis();
        long timeElapsed = timeEnd - timeStart;
        System.out.println();
        System.out.println("QY: Everything loaded in " + timeElapsed + "ms");


    }

    public static void main(String[] args) {
        launch(args);
    }

}
