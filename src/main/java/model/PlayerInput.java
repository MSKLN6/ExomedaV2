/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vando
 */
public class PlayerInput {
    protected Boolean Up;
    protected Boolean Down;
    protected Boolean Left;
    protected Boolean Right;
    
    public PlayerInput(){
        this.Up = false;
        this.Down = false;
        this.Left = false;
        this.Right = false;
    }
    
    public Boolean up() {
        return this.Up;
    }
    public Boolean down() {
        return this.Down;
    }
    public Boolean left() {
        return this.Left;
    }
    public Boolean right() {
        return this.Right;
    }
    
    public void beweging(Entity schip) {
        
        Vector velocity = schip.getVelocity();

        velocity.x = 0;
        velocity.y = 0;

        if (this.up()) {
            velocity.y = -1;
        }
        
        else if (this.down()) {
            velocity.y = 1;
        }

        if (this.left()) {
            velocity.x = -1;
        }
        else if (this.right()) {
            velocity.x = 1;
        }
    }
}
