package mainapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.animation.*;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Controller{

    public Controller(){}

    private @FXML BorderPane window;private @FXML TextArea textarea; private @FXML ToolBar toolbar;private @FXML Label timelb;
    private @FXML Menu menufile;private @FXML MenuItem menufile_open;private @FXML MenuItem menufile_save;private @FXML MenuItem menufile_saveas;
    private @FXML MenuItem menufile_exit;private @FXML Menu menuedit;private @FXML MenuItem menuedit_find;private @FXML Menu menuprint;
    private @FXML Menu menuhelp;private @FXML MenuItem menuhelp_about;private @FXML MenuItem menuhelp_settings;

    @FXML
    private void initialize(){
        System.out.println("QY: FXML loaded");
        bindToTime();
    }

    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),

                        new EventHandler<ActionEvent>(){
                            @Override public void handle(ActionEvent actionEvent) {
                                Calendar time = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                timelb.setText(simpleDateFormat.format(time.getTime()));
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void open(){
        //TODO Open file function
    }
    @FXML
    private void save(){
        //TODO Save file function
    }
    @FXML
    private void saveAs(){
        //TODO SaveAs file function
    }
    @FXML
    private void exit(){
        //TODO Exit function
    }
    @FXML
    private void find(){
        //TODO Find function
    }
    @FXML
    private void print(){
        //TODO Print function
    }
    @FXML
    private void about(){
        Main main = new Main();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("QY is a text editor wrote in Java.\nVersion: " + main.VERSION );
        alert.show();
    }
    @FXML
    private void settings(){
        //TODO Settings window
    }

}
