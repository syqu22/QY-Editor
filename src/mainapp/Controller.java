package mainapp;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Controller{


    public Controller(){}

    private @FXML ToolBar toolbar;
    private @FXML CheckMenuItem menusettings_toolbar;
    private @FXML TextArea textarea;
    private @FXML Label timely;
    private @FXML Label filely;

    //ExtensionFilters
    private final FileChooser.ExtensionFilter fileExtensionFilter1 = new FileChooser.ExtensionFilter("Text File (.txt)", "*.txt");
    private final FileChooser.ExtensionFilter fileExtensionFilter2 = new FileChooser.ExtensionFilter("Configuration File (.ini)", "*.ini");
    private final FileChooser.ExtensionFilter fileExtensionFilter3 = new FileChooser.ExtensionFilter("All files (.*)","*.*");

    private final FileChooser fileChooser = new FileChooser();
    private final FileLocation fileLocation = new FileLocation();
    private final FileName fileName = new FileName();


    @FXML
    private void initialize(){
        System.out.println("QY: FXML loaded");
        setFileChooserSettings();
        timeUpdate();

    }

    //Time in Hours:Seconds
    private void timeUpdate() {
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

    //Load file path from fileLocation then read file with lines
    private void loadFile(){
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileLocation.getFileLocation()));
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

    //Save file in selected file path from fileLocation
    private void saveFile(){
        try(PrintWriter save = new PrintWriter(fileLocation.getFileLocation())){
            save.println(textarea.getText());
        }catch (FileNotFoundException e){
            errorAlert(e);
        }
    }

    @FXML
    //Open File method
    private void open(){
        File fileSelected = fileChooser.showOpenDialog(null);
        if(fileSelected != null){
            fileLocation.setFileLocation(fileSelected.toString());
            fileName.setFileName(fileSelected.getName());
            filely.setText(fileName.getFileName());
            textarea.clear();
            loadFile();
        }else{
           System.err.println("Open File canceled");
        }

    }
    @FXML
    //Save File method
    private void save(){
        if(fileLocation.getFileLocation() == null) {
            File fileSelected = fileChooser.showSaveDialog(null);
            if (fileSelected != null) {
                fileLocation.setFileLocation(fileSelected.toString());
                fileName.setFileName(fileSelected.getName());
                filely.setText(fileName.getFileName());
                saveFile();
            } else {
                System.err.println("Save File canceled");
            }
        }else{
            filely.setText(fileName.getFileName());
            saveFile();
        }


    }
    @FXML
    //Save as File method
    private void saveAs(){
        File fileSelected =  fileChooser.showSaveDialog(null);
        if(fileSelected != null) {
            fileLocation.setFileLocation(fileSelected.toString());
        }else{
            System.err.println("Save as File canceled");
        }

    }
    @FXML
    //Exit app method
    private void exit(){
        System.exit(0);
    }

    //Find word in text method
    @FXML
    private void find(){
        //TODO Find function
    }

    //Show toolbar menu checkbox
    @FXML
    private void toolbar_show(){
       if(menusettings_toolbar.isSelected()){
           toolbar.setManaged(true);
           toolbar.setVisible(true);

       }else{
           toolbar.setManaged(false);
           toolbar.setVisible(false);
       }

    }

    //Print in printer
    @FXML
    private void print(){
        //TODO Print function
    }

    @FXML
    //About app method
    private void about(){
        Main main = new Main();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("QY is a text editor written in Java.\nMade By Syqu22\nVersion: " + main.VERSION );
        alert.show();
    }

    //Error alert method
    private void errorAlert(Exception e){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("QY - Text Editor");
        alert.setContentText(e.toString());
        alert.show();
    }

    //Settings of FileChooser
    private void setFileChooserSettings(){
        fileChooser.getExtensionFilters().add(fileExtensionFilter1);
        fileChooser.getExtensionFilters().add(fileExtensionFilter2);
        fileChooser.getExtensionFilters().add(fileExtensionFilter3);
        fileChooser.setTitle("QY - Editor");
    }

}