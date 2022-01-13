/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DaanB
 */
public class Entity {
    private Vector position;
    private Vector velocity; // current velocity
    private Vector direction;

    public Entity(Vector position) {
        this.position = position;
        this.velocity = new Vector(0,0);
        this.direction = new Vector(0,-1);
    }
    
    public void update(){
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
    }
    
    
}
