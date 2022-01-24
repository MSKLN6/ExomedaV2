package be.fiiw.exomeda;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartingScreenFXMLController {

    @FXML
    private ImageView Alienship;
    private ImageView Alienship1;
    private ImageView ArrowKey;
    private ImageView Background;
    private ImageView Spacebar;
    private Button StartButton;
    private AnchorPane anchorPane;
    
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
   
    // Source: Brocode - Youtube drie verschillende video's
    public void switchToExomedaFXML(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ExomedaFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, App.WINDOW_WIDTH, App.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
  
    }
    
}
