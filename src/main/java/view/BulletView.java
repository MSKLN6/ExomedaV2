/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.Region;
import model.Bullet;
import model.Vector;

/**
 *
 * @author vando
 */
public abstract class BulletView extends Region {
    protected Bullet model;

    public BulletView(Bullet model) {
        this.model = model;
        this.setup();
    }

    public Bullet getModel() {
        return model;
    }
    
    public abstract void setup();
    
    // supposed to be called once per game loop tick
    public void update() {
        this.setTranslateX( this.model.getPosition().getX() );
        this.setTranslateY( this.model.getPosition().getY() );
    }
    
    protected abstract int getBulletWidth();
    protected abstract int getBulletHeight();
    
    public boolean collidesWith(Vector testPoint) {
        
        if ( testPoint.getX() < this.model.getPosition().getX() ) return false;
        if ( testPoint.getX() > this.model.getPosition().getX() + this.getBulletWidth() ) return false;
        
        if ( testPoint.getY() < this.model.getPosition().getY() ) return false;
        if ( testPoint.getY() > this.model.getPosition().getY() + this.getBulletHeight() ) return false;
        
        return true;
    }
    
    public int getPositionX(){
        return this.model.getPosition().getX();
    }
    
    public int getPositionY(){
        return this.model.getPosition().getY();
    }
    
    public void stop(){
        this.model.getPosition().setY(-10);
    }
    
}
