package mainapp;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Controller{

    public BorderPane window;
    public Menu menufile;
    public MenuItem menufile_open;
    public MenuItem menufile_save;
    public MenuItem menufile_exit;
    public MenuItem menufile_saveas;
    public Menu menuedit;
    public MenuItem menuedit_find;
    public Menu menuprint;
    public MenuItem menuhelp_about;
    public Menu menuhelp;
    public MenuItem menuhelp_settings;
    public ToolBar toolbar;

    public Controller(){}

    private @FXML TextArea textarea;
    private @FXML Label timely;

    private String fileOpened;

    @FXML
    private void initialize(){
        System.out.println("QY: FXML loaded");
        bindToTime();
    }

    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            Calendar time = Calendar.getInstance();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                            timely.setText(simpleDateFormat.format(time.getTime()));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void load(){
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileOpened));
            try {
                while ((line = in.readLine()) != null) {
                    textarea.appendText(line + "\n");
                }
                in.close();
            }catch (IOException e){
                errorAlert(e);
            }
        }catch (FileNotFoundException e){
           errorAlert(e);
        }


    }

    @FXML
    private void open(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("QY - Text Editor");
        File fileSelected = fileChooser.showOpenDialog(null);
        fileOpened = fileSelected.toString();
        textarea.clear();
        load();
    }
    @FXML
    private void save(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("QY - Text Editor");
        File fileSelected =  fileChooser.showSaveDialog(null);
        fileOpened = fileSelected.toString();


    }
    @FXML
    private void saveAs(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("QY - Text Editor");
        File fileSelected =  fileChooser.showSaveDialog(null);
        fileOpened = fileSelected.toString();

    }
    @FXML
    private void exit(){
        System.exit(0);
        //exitAlert();
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
        alert.setContentText("QY is a text editor written in Java.\nMade By Syqu22\nVersion: " + main.VERSION );
        alert.show();
    }
    @FXML
    private void settings(){
        //TODO Settings window
    }

    private void errorAlert(Exception e){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("QY - Editor");
        alert.setContentText(e.toString());
        alert.show();
    }

   /* private void exitAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null); TODO
        alert.setTitle("QY - Editor");
        alert.setContentText("Save before exiting?");
        alert.show();
    }*/

}
