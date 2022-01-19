package be.fiiw.exomeda;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
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
    
    // Bepalen van bullet dependencies
    private BulletController bulletController;
    private BulletGenerator_Player playerBulletGenerator;

    @FXML
    private AnchorPane exomeda;
    
    @FXML
    public void initialize(){
        
        this.playerViews = new ArrayList<PlayerView>();
        this.playerInputs = new ArrayList<KeyboardInput>();
        this.playerControllers = new ArrayList<PlayerController>();
        
        this.bulletController = new BulletController( this.exomeda );
        this.playerBulletGenerator = new BulletGenerator_Player(this.bulletController);
        
        this.enemyControllers = new ArrayList<EnemyController>();
        
        model = new Exomeda();
        view  = new ExomedaView(model);
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.exomeda.getChildren().add(this.background);
        
        KeyboardInput playerInput = new KeyboardInput(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.UP);
        this.newPlayer(new Vector(100, 100), playerInput );

        this.exomeda.getChildren().add(view);
        
        this.exomeda.setOnKeyPressed(this::keyPressed);
        this.exomeda.setOnKeyReleased(this::keyReleased);
        this.exomeda.setFocusTraversable(true);
        
        start();
    }
    
    public void newPlayer(Vector position, KeyboardInput input){
        Player player = new Player(position);
        player.setEnginePower(new Vector(5,5));
        PlayerView playerView = new PlayerView(player);
        
        playerView.tekenPlayer();
        this.exomeda.getChildren().add(playerView);
        
        PlayerController playerController = new PlayerController(player, playerView, input, playerBulletGenerator);
        
        this.playerControllers.add(playerController);
        this.playerInputs.add(input);
    }
    
    public void spawnEnemy(){
        if(this.getEnemyCount()<5){
            newEnemy(new Vector(random.nextInt(12)*100+5,10));
            enemyCount += 1;
            System.out.println(enemyCount+"");
        }
//        while(enemyCount < 10){
//            int randomizer = random.nextInt(3);
//            if (randomizer == 2){
//                newEnemy(new Vector(random.nextInt(12)*100+5,10));
//                enemyCount += 1;
//            }
//        }
    }
    
    public int getEnemyCount(){
        return enemyCount;
    }
    
    public void newEnemy(Vector position){
        Enemy enemy = new Enemy(position);
        EnemyView enemyView = new EnemyView(enemy);
        
        enemyView.tekenEnemy();
        this.exomeda.getChildren().add(enemyView);
        
        EnemyController enemyController = new EnemyController(enemy, enemyView);
        
        this.enemyControllers.add(enemyController);
    }
    
    public void update(){
        this.updateModels();
        Platform.runLater(this::updateViews);
    }

    public void updateModels() {
        for (PlayerController pc : this.playerControllers ) {
            pc.updateModel();
        }        
        for (EnemyController ec : this.enemyControllers){
            ec.updateModel();
        }
        this.bulletController.updateModels(); 
    }
    
    public void updateViews(){
        this.background.update();
        for (PlayerController pc : this.playerControllers) {
            pc.updateView();
        }
        for (EnemyController ec : this.enemyControllers){
            ec.updateView();
        }
        this.bulletController.updateViews();
    }
    
    public void start(){
        startGameLoop();
        startEnemySpawn();
    }
    
    private void startGameLoop() {
        GameLoop gameLoop = new GameLoop(this);
        
        Timer t = new Timer();
        t.scheduleAtFixedRate(gameLoop, 0, gameLoop.getDELTA_TIME());
    }

    private void startEnemySpawn() {
        EnemyGenerator eg = new EnemyGenerator(this);
        Timer es = new Timer();
        es.scheduleAtFixedRate(eg, 0, 1000); // Grens bij 24, buiten bereik van FX thread
//        Platform.runLater(() -> {es.scheduleAtFixedRate(eg, 2000, 2000);});  
    }    
    
    private void keyPressed(KeyEvent event) {
        for ( KeyboardInput input : this.playerInputs ) {
            input.handleKeyPress(event);
        }
    }
    
    private void keyReleased(KeyEvent event) {
        for ( KeyboardInput input : this.playerInputs ) {
            input.handleKeyRelease(event);
        }
    }
}
