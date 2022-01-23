/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author DaanB
 */
public class Entity {
    protected Vector position;
    private Vector velocity;
    Random random = new Random();

    public Entity(Vector position) {
        this.position = position;
        this.velocity = new Vector(0,0);
    }
    
    public Entity(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }
    
    public void update(){
        int posX = position.getX();
        int posY = position.getY();
        
        int velX = velocity.getX();
        int velY = velocity.getY();
        
        posX += velX;
        posY += velY;
        
        position.setX(posX);
        position.setY(posY);
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
