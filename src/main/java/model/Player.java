/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DaanB
 */
public class Player {
    int health;
    protected Vector position;
    private Vector velocity;
    private Vector direction;
    private Vector speedAmount;
    
    
    public Player() {
        this.health = 3;
        this.position = new Vector (400,400);
        this.velocity = new Vector(0,0);
        this.direction = new Vector(-1,0);
        this.speedAmount = new Vector(1,1);
    }

    public Player(int health, Vector position, Vector velocity, Vector direction, Vector speedAmount) {
        this.health = health;
        this.position = position;
        this.velocity = velocity;
        this.direction = direction;
        this.speedAmount = speedAmount;
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
