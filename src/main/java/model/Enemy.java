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
    
    public Enemy(Vector position) {
//        super(position = new Vector(new Random().nextInt(1280), 0));
        super(position);
        this.getDirection().y = 1; // Mikt naar beneden
    }
    
    @Override
    public void update() {
        super.update();
        
        this.position.x = Math.max( 0, Math.min(this.position.x, App.WINDOW_WIDTH - 1));
        this.position.y = Math.max( 0, Math.min(this.position.y, App.WINDOW_HEIGHT - 1));
    }
}