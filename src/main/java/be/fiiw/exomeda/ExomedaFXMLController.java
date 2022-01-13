package be.fiiw.exomeda;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.*;
import view.*;

public class ExomedaFXMLController {
    private Exomeda model;
    private ExomedaView view;
    private ArrayList<KeyboardInput> playerInputs;
    private BackgroundView background;
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane exomeda;

    @FXML
    public void initialize() {
        Player player = new Player();
        
        this.playerInputs = new ArrayList<KeyboardInput>();
        model = new Exomeda();
        view  = new ExomedaView(model);
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.exomeda.getChildren().add(this.background);
        
        KeyboardInput playerInput = new KeyboardInput();
        createPlayer(new Vector(100, 100), playerInput );

        exomeda.getChildren().add(view);
        
        exomeda.setFocusTraversable(true);
        
        start();
    }
    
    public void createPlayer(Vector position, KeyboardInput input){
        Player player = new Player();
        PlayerView playerView = new PlayerView(player);
        
        this.exomeda.getChildren().add(playerView);
        
        this.playerInputs.add(input);
    }
    
    public void start(){
        BeweegEntity task = new BeweegEntity(model, this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(task, 0, 2);
    }
    
    public void updateViews(){
        this.background.update();
    }
    
    public void update() {
        this.updateModels();
        Platform.runLater( this::updateViews );
    }

    private void updateModels() {
        
    }
}
