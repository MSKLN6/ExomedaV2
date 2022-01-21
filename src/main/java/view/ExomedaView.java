/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.Region;
import javafx.scene.layout.AnchorPane;
import java.util.*;
import model.*;

/**
 *
 * @author DaanB
 */
public class ExomedaView extends Region{
    private Exomeda model;
    private AnchorPane spel;
    private PlayerView playerView;
    private EnemyView enemyView;
    private ArrayList<PlayerView> playerViews;

    public ExomedaView(Exomeda exomedaModel) {
        model = exomedaModel;
        spel = new AnchorPane();
        playerViews = new ArrayList<PlayerView>();
        update();
    }
    
    public void newPlayer(){
        
        playerView = new PlayerView(model.getPlayer());
        playerView.tekenPlayer();
        
        spel.getChildren().addAll(playerView);
    }
    
    public void newEnemy(){
        
        enemyView = new EnemyView(model.getEnemy());
        enemyView.tekenEnemy();
        
        spel.getChildren().addAll(enemyView);
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public EnemyView getEnemyView() {
        return enemyView;
    }
    
    public void update(){
        getChildren().clear();
        
        getChildren().addAll(spel);
    }
    
}
