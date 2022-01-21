/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.fiiw.exomeda.*;
import java.util.*;


/**
 *
 * @author DaanB
 */

public class Exomeda {

    private Player player;
    private final int playerPosX;
    private final int playerPosY;
    private Enemy enemy;
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
    }
    
    public void newPlayer(){
        player = new Player(new Vector(playerPosX, playerPosY));
    }
    
    public void newEnemy(){
        enemy = new Enemy(new Vector(random.nextInt(12)*100+5,-35));
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
}
