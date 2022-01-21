package be.fiiw.exomeda;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PauseScreenFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button QuitButton;

    @FXML
    private Button RestartButton;
    
    @FXML
    private AnchorPane scenePane;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    public void quit(ActionEvent event){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You are about to quit the game!");
        alert.setContentText("Do you want to quit?: ");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage)scenePane.getScene().getWindow();
            stage.close();
        }
    }
    
    public void switchToExomedaFXML(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ExomedaFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, App.WINDOW_WIDTH, App.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
  
    }
}
    
