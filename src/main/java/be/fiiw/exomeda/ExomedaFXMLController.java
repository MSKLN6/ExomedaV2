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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.KeyboardInput;
import model.Player;
import model.Vector;
import view.BackgroundView;
import view.PlayerView;

public class ExomedaFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane exomeda;
    
    private Player player;
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
        player = new Player();
        this.enemies = new ArrayList<EntityController>();
        this.playerStats = new ArrayList<PlayerStatsView>();
        this.playerInputs = new ArrayList<KeyboardInput>();
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.exomeda.getChildren().add(this.background);
        
        KeyboardInput playerInput = new KeyboardInput( KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE );
        this.createPlayer( new Vector(100, 100), playerInput );
        
        GameLoop gameLoop = new GameLoop(this);
        
        this.exomeda.setOnKeyPressed(this::keyPressed);
        this.exomeda.setOnKeyReleased(this::keyReleased);
        this.exomeda.setFocusTraversable(true);
        
        Timer t = new Timer();
        t.scheduleAtFixedRate( gameLoop, 0, GameLoop.TIME );
        
    }

    public void update() {
        this.updateModels();
        Platform.runLater( this::updateViews );
    }

    private void updateViews() {
        this.background.update();

        for ( SpaceshipController p : player) {
            p.updateViews();
        }
    }

    private void createPlayer(Vector position, KeyboardInput input) {
        Player player = new Player(Player.MAX_HEALTH, position );
        player.setSpeedAmount( new Vector(5,5) );
        PlayerView playerView = new PlayerView(player);
        
        playerView.setup();
        this.levelContainer.getChildren().add( playerView );
        
        SpaceshipController playerController = new SpaceshipController( player, playerView, input, this.laserBulletGenerator );
        
        this.player.add( playerController );
        this.playerInputs.add( input );
    }
    
    private void updateModels() {
        for (SpaceshipController p : player) {
            p.updateModels();
        }
    }
        
    private void keyPressed( KeyEvent evt ) {
        for ( KeyboardInput handler : this.playerInputs ) {
            handler.handleKeyPress( evt );
        }
    }
    
    private void keyReleased( KeyEvent evt ) {
        for ( KeyboardInput handler : this.playerInputs ) {
            handler.handleKeyRelease( evt );
        }
    }
}

