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
public class Player extends Spaceship {
    public static int MAX_HEALTH = 3;
    
    public Player(int health, Vector position){
        health = MAX_HEALTH
        this. position = position;
    }
    
    public Player(int health, Vector position) {
        super(health, position);
        
        this.getDirection().y = -1; // players typically aim to the right of the screen
        
    }

    public void update() {
        super.update();
        
        this.position.x = Math.max( 0, Math.min(this.position.x, App.WINDOW_WIDTH - 1));
        this.position.y = Math.max( 0, Math.min(this.position.y, App.WINDOW_HEIGHT - 1));
    }
}
