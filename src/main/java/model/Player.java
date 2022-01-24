/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.fiiw.exomeda.App;

/**
 *
 * @author DaanB
 */
public class Player extends Entity{
    
    private static int playerWidth = 75;
    private static int playerHeight = 75;
    private boolean collided = false;
    
    public Player(Vector position) {
        super(position = new Vector (App.WINDOW_WIDTH/2, (int)Math.round(App.WINDOW_HEIGHT*0.70)));
        
    }
    
    @Override
    public void update() {
        super.update();
        
        int posX = position.getX();
        int posY = position.getY();
        
        posX = Math.max(0, Math.min(posX, App.WINDOW_WIDTH - playerWidth));
        posY = Math.max(0, Math.min(posY, App.WINDOW_HEIGHT - playerHeight));
        
        position.setX(posX);
        position.setY(posY);
    }

    public static int getPlayerWidth() {
        return playerWidth;
    }

    public static int getPlayerHeight() {
        return playerHeight;
    }
    
    // nodig om bullets uit te tekenen
    public Vector getCenterPoint() {
        return new Vector( this.getPosition().getX() + getPlayerWidth() / 2, this.getPosition().getY() + getPlayerHeight()/ 2 );
    }
    
    // Collision idee afgeleid van Jens Vandael
    public boolean collision(Enemy enemy){
        int dx = enemy.getPosition().getX() - position.getX();
        int dy = enemy.getPosition().getY() - position.getY();
        
        //Hoek rechtsonder
        if (dx > 0 && dx < playerWidth && dy > 0 && dy < playerHeight){
            return true;
        }
        
        //Hoek rechtsboven
        else if (dx > 0 && dx < playerWidth && dy < 0 && dy > -Enemy.getEnemyHeight()){
            return true;
        }
        
        //Hoek linksboven
        else if (dx < 0 && dx > -enemy.getEnemyWidth() && dy < 0 && dy > -enemy.getEnemyHeight()){
            return true;
        }
        
        //Hoek linksonder
        else if (dx < 0 && dx > -enemy.getEnemyWidth() && dy > 0 && dy < playerHeight){
            return true;
        }
        
        return false;
    }
    
    public boolean getCollided(){
        return collided;
    }
    
    public void switchCollided(){
        collided = !collided;
    }
    
}