package mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    final String VERSION = "v0.3"; //Version of application
    final double WIDTH = 600;
    final double HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception { //Start Method
        long timeStart = System.currentTimeMillis();
        System.out.println("QY: " + VERSION);

        //Loader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainwindow.fxml"));
        Parent root = fxmlLoader.load();

        //Settings
        primaryStage.setTitle("QY - Text Editor");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.show();




        //Timer
        long timeEnd = System.currentTimeMillis();
        long timeElapsed = timeEnd - timeStart;
        System.out.println();
        System.out.println("QY: Everything loaded in " + timeElapsed + "ms");
    }

    @Override
    public void stop(){
        System.out.println("QY: Closing...");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
