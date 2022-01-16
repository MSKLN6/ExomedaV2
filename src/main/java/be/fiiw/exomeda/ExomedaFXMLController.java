package be.fiiw.exomeda;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.*;
import view.*;

public class ExomedaFXMLController{
    // Bepalen van overkoepelend model en view
    private Exomeda model;
    private ExomedaView view;
    
    // Bepalen van alle ArrayLists
    private ArrayList<KeyboardInput> playerInputs;
    private ArrayList<PlayerController> playerControllers;
    private ArrayList<PlayerView> playerViews;
    private ArrayList<EnemyController> enemyControllers;
    
    // Bepalen van background
    private BackgroundView background;
    
    // Bepalen van enemy dependencies
    private int enemyCount;
    Random random = new Random();
    

    @FXML
    private AnchorPane exomeda;
    
    @FXML
    public void initialize() {
        
        this.playerViews = new ArrayList<PlayerView>();
        this.playerInputs = new ArrayList<KeyboardInput>();
        this.playerControllers = new ArrayList<PlayerController>();
        this.enemyControllers = new ArrayList<EnemyController>();
        model = new Exomeda();
        view  = new ExomedaView(model);
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.exomeda.getChildren().add(this.background);
        
        KeyboardInput playerInput = new KeyboardInput(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT);
        this.newPlayer(new Vector(100, 100), playerInput );

        this.exomeda.getChildren().add(view);
        
        this.exomeda.setOnKeyPressed(this::keyPressed);
        this.exomeda.setOnKeyReleased(this::keyReleased);
        this.exomeda.setFocusTraversable(true);
        
        GameLoop gameLoop = new GameLoop(this);
        
        Timer t = new Timer();
        t.scheduleAtFixedRate(gameLoop, 0, gameLoop.getDELTA_TIME());
        
        this.spawnEnemy();
    }
    
    public void newPlayer(Vector position, KeyboardInput input){
        Player player = new Player(position);
        player.setEnginePower( new Vector(5,5) );
        PlayerView playerView = new PlayerView(player);
        
        playerView.tekenPlayer();
        this.exomeda.getChildren().add(playerView);
        
        PlayerController playerController = new PlayerController(player, playerView, input);
        
        this.playerControllers.add(playerController);
        this.playerInputs.add(input);
    }
    
    public void spawnEnemy(){
        
        while(enemyCount < 10){
            int randomizer = random.nextInt(10);
            // SLEEP METHOD
            if (randomizer == 5){
                newEnemy(new Vector(random.nextInt(12)*100+5,10));
            }
        }
        
    }
    
    public void newEnemy(Vector position){
        Enemy enemy = new Enemy(position);
        EnemyView enemyView = new EnemyView(enemy);
        
        enemyView.tekenEnemy();
        this.exomeda.getChildren().add(enemyView);
        
        EnemyController enemyController = new EnemyController(enemy, enemyView);
        
        this.enemyControllers.add(enemyController);
        
        enemyCount += 1;
    }
    
    public void update() {
        this.updateModels();
        Platform.runLater( this::updateViews );
    }

    private void updateModels() {
        for (PlayerController pc : this.playerControllers ) {
            pc.updateModel();
        }        
    }
    
    public void updateViews(){
        this.background.update();
        for (PlayerController pc : this.playerControllers) {
            pc.updateView();
        }
    }
    
    public void start(){
        BeweegEntity task = new BeweegEntity(model, this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(task, 0, 2);
    }
    
    private void keyPressed( KeyEvent evt ) {
        for ( KeyboardInput processor : this.playerInputs ) {
            processor.handleKeyPress( evt );
        }
    }
    
    private void keyReleased( KeyEvent evt ) {
        for ( KeyboardInput processor : this.playerInputs ) {
            processor.handleKeyRelease( evt );
        }
    }    
}
