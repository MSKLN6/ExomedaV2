/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.fiiw.exomeda.*;
import java.util.*;
import view.*;


/**
 *
 * @author DaanB
 */

public class Exomeda {

    private Player player;
    private final int playerPosX;
    private final int playerPosY;
    private ArrayList<Player> players;
    private Enemy enemy;
    private ArrayList<Enemy> enemies;
    private final int enemyPosX;
    private final int enemyPosY;
    private int enemyCount;
    Random random = new Random();
    
    public Exomeda(){
        playerPosX = 100;
        playerPosY = 100;
        
        enemyCount = 0;
        enemyPosX = random.nextInt(12)*100+5;
        enemyPosY = -50;
        
        enemies = new ArrayList<>();
        players = new ArrayList<>();
    }
    
    public void newPlayer(){
        player = new Player(new Vector(playerPosX, playerPosY));
        players.add(player);
    }
    
    public void newEnemy(){
        enemy = new Enemy(new Vector(random.nextInt(12)*100+5,-35));
        incrEnemyCount();
        enemies.add(enemy);
    }
    
    public void redEnemyCount(){
        enemyCount -= 1;
    }
    
    public void incrEnemyCount(){
        enemyCount += 1;
    }
        
    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    
    public int getEnemyCount(){
        return enemyCount;
    }
    
    public void update(){
        collision();
    }
    
    public void collision(){
        for (Player player : players) {
            for (Enemy enemy : enemies) {
                if (player.collision(enemy)){
                    player.switchCollided();
                    players.clear();
                }
            }
        }
        
    }
}
