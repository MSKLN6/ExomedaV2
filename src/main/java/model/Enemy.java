/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.fiiw.exomeda.App;
import java.util.Random;

/**
 *
 * @author DaanB
 */
public class Enemy extends Entity{
    
    Random random = new Random();
    double downVelocity = random.nextInt(4) + 2;
    private static int enemyWidth = 75;
    private static int enemyHeight = 40;
    
    public Enemy(Vector position) {
        super(position);
        int dirY = getDirection().getY();
        dirY = 1; // Mikt naar beneden
        getDirection().setY(dirY);        
    }
    
    @Override
    public void update() {
        super.update();
        
        int posX = position.getX();
        int posY = position.getY();
        
        posX = Math.max(0, Math.min(posX, App.WINDOW_WIDTH - 1));
        
        position.setX(posX);
        position.setY(posY);
    }
    
    public void tick(){
        
        int posY = position.getY();    
        
        posY += this.downVelocity;
        
        position.setY(posY);
        
        if(posY > App.WINDOW_HEIGHT){
            position.setY(-100);
            position.setX(random.nextInt(13) * 100 + 5);
        }
    }

    public static int getEnemyWidth() {
        return enemyWidth;
    }

    public static int getEnemyHeight() {
        return enemyHeight;
    }
    
    
}