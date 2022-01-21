package be.fiiw.exomeda;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.*;
import view.*;

public class ExomedaFXMLController{
    // Bepalen van overkoepelend model en view
    private Exomeda exomedaModel;
    private ExomedaView exomedaView;
    
    // Bepalen van alle ArrayLists
    private ArrayList<KeyboardInput> playerInputs;
    private ArrayList<PlayerController> playerControllers;
    private ArrayList<EnemyController> enemyControllers;
    
    // Bepalen van background
    private BackgroundView background;
    
    // Bepalen van enemy dependencies
    Random random = new Random();
    
    // Bepalen van bullet dependencies
    private BulletController bulletController;
    private BulletGenerator_Player playerBulletGenerator;

    @FXML
    private AnchorPane exomedaAnchorPane;
    
    @FXML
    public void initialize(){
        
        playerInputs = new ArrayList<KeyboardInput>();
        playerControllers = new ArrayList<PlayerController>();
        enemyControllers = new ArrayList<EnemyController>();
        
        bulletController = new BulletController(exomedaAnchorPane);
        playerBulletGenerator = new BulletGenerator_Player(bulletController);
        
        ImageController.preloadImages();
        
        background = new BackgroundView();
        exomedaAnchorPane.getChildren().add(background);
        
        exomedaModel = new Exomeda();
        exomedaView  = new ExomedaView(exomedaModel);
        
        KeyboardInput playerInput = new KeyboardInput(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.UP);
        newPlayer(playerInput);

        exomedaAnchorPane.getChildren().add(exomedaView);
        
        exomedaAnchorPane.setOnKeyPressed(this::keyPressed);
        exomedaAnchorPane.setOnKeyReleased(this::keyReleased);
        exomedaAnchorPane.setFocusTraversable(true);
        
        start();
    }
    
    public void newPlayer(KeyboardInput input){
        exomedaModel.newPlayer();
        exomedaView.newPlayer();
        
        PlayerController playerController = new PlayerController(exomedaModel.getPlayer(),exomedaView.getPlayerView(), input, playerBulletGenerator);
        
        playerControllers.add(playerController);
        playerInputs.add(input);
    }
    
    public void spawnEnemy(){
        if (exomedaModel.getEnemyCount()<2){
            newEnemy();
        }
        if(exomedaModel.getEnemyCount()<15){
            int randomizer = random.nextInt(4);
            if (randomizer == 2){
                newEnemy();
            }
        }
    }
    
    public void newEnemy(){
        exomedaModel.newEnemy();
        exomedaView.newEnemy();
        
        EnemyController enemyController = new EnemyController(exomedaModel.getEnemy(), exomedaView.getEnemyView());
        
        enemyControllers.add(enemyController);
    }
    
    public void update(){
        for (PlayerController pc : playerControllers ) {
            pc.update();
        }        
        for (EnemyController ec : enemyControllers){
            ec.update();
        }
        background.update();
        bulletController.update();
    }
    
    public void start(){
        startGameLoop();
        startEnemySpawn();
    }
    
    private void startGameLoop() {
        GameLoop gameLoop = new GameLoop(this);
        Timer t = new Timer();
        t.scheduleAtFixedRate(gameLoop, 0, gameLoop.getPeriod());
    }

    private void startEnemySpawn() {
        EnemyGenerator eg = new EnemyGenerator(this);
        Timer es = new Timer();
        es.scheduleAtFixedRate(eg, 2000, 1000);
    }    
    
    private void keyPressed(KeyEvent event) {
        for ( KeyboardInput input : playerInputs) {
            input.handleKeyPress(event);
        }
    }
    
    private void keyReleased(KeyEvent event) {
        for ( KeyboardInput input : playerInputs) {
            input.handleKeyRelease(event);
        }
    }
}
