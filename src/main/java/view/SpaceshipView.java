/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.Region;
import model.Collidable;
import model.Spaceship;
import model.Vector;

/**
 *
 * @author vando
 */
public abstract class SpaceshipView extends Region implements Collidable {
    private Spaceship model;
    
    public SpaceshipView(Spaceship model) {
        this.model = model;
    }
    
    public abstract void setup();
    
    // supposed to be called once per game loop tick
    public void update() {
        this.setTranslateX( this.model.getPosition().x );
        this.setTranslateY( this.model.getPosition().y );
    }
    
    public boolean collidesWith(Collidable c) {
        Vector testPoint = c.getCenterPoint();
        
        return this.collidesWith( testPoint );
    }
}