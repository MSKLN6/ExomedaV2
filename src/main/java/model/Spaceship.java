/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vando
 */
public class Spaceship {
    int health;
    protected Vector position;
    private Vector velocity; // current velocity
    private Vector direction;
    
    // you could see this as speed/velocity modifiers. Normal velocity changes by some quantity each frame. This can be used to make that faster/slower
    private Vector speedAmount;
    
    public Spaceship(int health, Vector position) {
        this.health = health;
        this.position = position;
        this.velocity = new Vector(0,0);
        this.direction = new Vector(-1,0); // assume most spaceship are facing to the left
        this.speedAmount = new Vector(1,1);
    }
    
    public void update() {
        this.position.x += this.velocity.x * this.speedAmount.x;
        this.position.y += this.velocity.y * this.speedAmount.y;
    }
    
    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }
    
    public Vector getDirection() {
        return direction;
    }

    public void getDirection(Vector direction) {
        this.direction = direction;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
    
    public Vector getSpeedAmount() {
        return speedAmount;
    }

    public void setSpeedAmount(Vector speedAmount) {
        this.speedAmount = speedAmount;
    }
    
}
