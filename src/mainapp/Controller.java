package mainapp;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Controller {

    public Controller(){}

    @FXML AnchorPane mainwind;@FXML TextArea textarea;@FXML ScrollBar scrollright;@FXML ScrollBar scrolldown;
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

    }
    @FXML
    private void settings(){

    }

}
