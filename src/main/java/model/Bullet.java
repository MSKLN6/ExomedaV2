/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vando
 */
public class Bullet {
    private Entity shooter;
    private Vector position;
    private Vector velocity;

    private int speed;
    
    public Bullet(Entity shooter, Vector position, int speed) {
        this.shooter = shooter;
        this.position = position;
        this.speed = speed;
        
        this.velocity = new Vector(speed,0);
    }
    
    public Bullet(int speed) {
        this.speed = speed;
        
        // schooter moet nog gedefinieerd worden.
        this.shooter = null;
        this.position = new Vector(0,0);
        this.velocity = new Vector(0,- speed);
    }
    
    public Vector getPosition() {
        return position;
    }
    
    public void setPosition( Vector position ) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }
    
    public void setShooter(Entity shooter) {
        this.shooter = shooter;
    }
    
    public Entity getShooter() {
        return shooter;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void update() {
        int posX = position.getX();
        int posY = position.getY();
        
        int velX = velocity.getX();
        int velY = velocity.getY();
        
        posX += velX;
        posY += velY;
        
        position.setX(posX);
        position.setY(posY);
    }
    
}
