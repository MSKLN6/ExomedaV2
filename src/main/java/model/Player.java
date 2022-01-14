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
    
    
//    public Player() {
//        position = new Vector (App.WINDOW_WIDTH/2, 500);
//        super(position);
//        this.velocity = new Vector(0,0);
//        this.direction = new Vector(-1,0);
//        this.speedAmount = new Vector(1,1);
//    }
    
    public Player(Vector position) {
        super(position = new Vector (App.WINDOW_WIDTH/2, (int)Math.round(App.WINDOW_HEIGHT*0.70)));
        
        this.getDirection().y = -1; // Mikt naar boven
    }
    
    @Override
    public void update() {
        super.update();
        
        this.position.x = Math.max( 0, Math.min(this.position.x, App.WINDOW_WIDTH - 1));
        this.position.y = Math.max( 0, Math.min(this.position.y, App.WINDOW_HEIGHT - 1));
    }
}