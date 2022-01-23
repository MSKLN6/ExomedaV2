/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.Region;
import javafx.scene.layout.AnchorPane;
import java.util.*;
import model.*;
import be.fiiw.exomeda.*;

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
    private ArrayList<BulletView> bullets;
    private ArrayList<EnemyView> enemyViews;
    private ExomedaFXMLController controller;
    private int score = 0;

    public ExomedaView(Exomeda exomedaModel, ExomedaFXMLController c) {
        model = exomedaModel;
        spel = new AnchorPane();
        controller = c;
        playerViews = new ArrayList<PlayerView>();
        enemyViews = new ArrayList<EnemyView>();
        update();
        
        bullets = controller.getBulletController().getBullets();
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
        enemyViews.add(enemyView);
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
        collision();
    }
    
    public void collision(){
        for (EnemyView enemy : enemyViews) {
            for (BulletView bullet : bullets) {
                if (enemy.collision(bullet)){
                    enemy.switchCollided();
                    enemyViews.remove(enemy);
                    bullet.stop();
                    model.redEnemyCount();
                    score += 100;
                }
            }
        }
    }

    public int getScore() {
        return score;
    }
}
