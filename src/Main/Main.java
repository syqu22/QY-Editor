package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private long timeStart;
    private long timeEnd;
    private long timeElapsed;


    @Override
    public void start(Stage primaryStage) throws Exception{
        timeStart = System.currentTimeMillis();
        System.out.println("QY: Application started");
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml")); //startwindow.fxml
        System.out.println("QY: FXML loaded");
        primaryStage.setTitle("QY - Text Editor");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        System.out.println("QY: Scene showed");
        timeEnd = System.currentTimeMillis();
        timeElapsed = timeEnd - timeStart;
        System.out.println("==================================");
        System.out.println("QY: Everything loaded in " + timeElapsed + "ms");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
