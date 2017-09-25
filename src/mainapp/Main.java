package mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private long timeStart,timeEnd,timeElapsed;
    private Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{
        timeStart = System.currentTimeMillis();
        System.out.println("QY: Application started");
        Parent root = FXMLLoader.load(getClass().getResource("../res/mainwindow.fxml")); //startwindow.fxml
        primaryStage.setTitle("QY - Text Editor");
        primaryStage.setMinHeight(120);
        primaryStage.setMinWidth(300);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        System.out.println("QY: Scene showed");
        timeEnd = System.currentTimeMillis();
        timeElapsed = timeEnd - timeStart;
        System.out.println();
        System.out.println("QY: Everything loaded in " + timeElapsed + "ms");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
