package be.fiiw.exomeda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    
    //gameover view
    private GameoverView gameoverView;
    
    //healthbar
    private HealthbarView healthbarView;
    
    // Bepalen van enemy dependencies
    Random random = new Random();
    
    // Bepalen van bullet dependencies
    private BulletController bulletController;
    private BulletGenerator_Player playerBulletGenerator;

    @FXML
    private AnchorPane exomedaAnchorPane;
    private Button pauseButton;
    private Scene scene;
    private Parent root;
    private Stage stage;
    
    @FXML
    private Text scoreValue;
    
    @FXML
    public void initialize(){
        
        playerInputs = new ArrayList<>();
        playerControllers = new ArrayList<>();
        enemyControllers = new ArrayList<>();
        
        bulletController = new BulletController(exomedaAnchorPane);
        playerBulletGenerator = new BulletGenerator_Player(bulletController);
        
        ImageController.preloadImages();
        
        background = new BackgroundView();
        exomedaAnchorPane.getChildren().add(background);
        
        exomedaModel = new Exomeda();
        exomedaView  = new ExomedaView(exomedaModel, this);
        
        KeyboardInput playerInput = new KeyboardInput(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.UP);
        newPlayer(playerInput);

        exomedaAnchorPane.getChildren().add(exomedaView);
        
        healthbarView = new HealthbarView();
        exomedaAnchorPane.getChildren().add(healthbarView);
        
        gameoverView = new GameoverView();
        exomedaAnchorPane.getChildren().add(gameoverView);
        
        exomedaAnchorPane.setOnKeyPressed(this::keyPressed);
        exomedaAnchorPane.setOnKeyReleased(this::keyReleased);
        exomedaAnchorPane.setFocusTraversable(true);
        
        start();
    }
    
    public void switchToPauseScreenFXML(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("PauseScreenFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, App.WINDOW_WIDTH, App.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
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
        if(exomedaModel.getEnemyCount()<20){
            int randomizer = random.nextInt(2);
            if (randomizer == 1){
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
        exomedaModel.update();
        exomedaView.update();
        for (PlayerController pc : playerControllers ) {
            pc.update();
        }        
        for (EnemyController ec : enemyControllers){
            ec.update();
        }
        background.update();
        bulletController.update();
        updateScore();
        if (exomedaModel.isGameover()){
            gameoverView.update();
        }
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
    
    public BulletController getBulletController(){
        return bulletController;
    }
    
    public void updateScore(){
        scoreValue.setText(exomedaView.getScore() + "");
    }
    
}
