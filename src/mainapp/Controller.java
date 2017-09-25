package mainapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


public class Controller {

    public Controller(){}

    @FXML BorderPane window;@FXML TextArea textarea;
    @FXML Menu menufile;@FXML MenuItem menufile_open;@FXML MenuItem menufile_save;@FXML MenuItem menufile_saveas;
    @FXML MenuItem menufile_exit;@FXML Menu menuedit;@FXML MenuItem menuedit_find;@FXML Menu menuprint;
    @FXML Menu menuhelp;@FXML MenuItem menuhelp_about;@FXML MenuItem menuhelp_settings;

    @FXML
    private void initialize(){
        System.out.println("QY: FXML loaded");
    }

    @FXML
    private void open(){

    }
    @FXML
    private void save(){

    }
    @FXML
    private void saveAs(){

    }
    @FXML
    private void exit(){

    }
    @FXML
    private void find(){

    }
    @FXML
    private void print(){

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

    }

}
