package be.fiiw.exomeda;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Player;
import view.BackgroundView;
import view.PlayerView;

public class ExomedaFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane exomeda;
    
    private ArrayList<PlayerStatsView> playerStats;
    private ArrayList<KeyboardInput> playerInputs;
    
    private ArrayList<EntityController> enemies;
    
    private BulletController bulletController;
    private BulletGenerator laserBulletGenerator;
    private BulletGenerator rocketBulletGenerator;
    
    private long previousTime = 0;
    
    private boolean gameOver = false;
    
    private boolean DEBUG_stressTest = false;
    
    private BackgroundView background;
    
    @FXML
    private AnchorPane levelContainer;
    
    @FXML
    private VBox playerList;
    
    @FXML
    private Text fpsCounter;
    private long lastFPSupdate = 0;

    @FXML
    void initialize() {
        update();
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.exomeda.getChildren().add(this.background);
        
        GameLoop gameLoop = new GameLoop(this);
        
        Timer t = new Timer();
        t.scheduleAtFixedRate( gameLoop, 0, GameLoop.TIME );
        
    }

    public void update() {
        this.updateModels();
        Platform.runLater( this::updateViews );
    }

    private void updateViews() {
        this.background.update();
    }

    private void updateModels() {
        
    }

}