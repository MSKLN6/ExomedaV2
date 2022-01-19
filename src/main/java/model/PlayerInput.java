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
    protected Boolean Boost;
    protected Boolean Fire;
    
    public PlayerInput(){
        this.Up = false;
        this.Down = false;
        this.Left = false;
        this.Right = false;
        this.Boost = false;
        this.Fire = false;
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
    public Boolean fire() { 
        Boolean fired = this.Fire;
        this.Fire = false;
        
        return fired;
    }
    public Boolean boost(){
        return this.Boost;
    }
    
    public void beweging(Entity schip) {
        
        Vector velocity = schip.getVelocity();
        
        velocity.setX(0);
        velocity.setY(0);
        
        if (this.up()){
            velocity.setY(-3);
        }
        
        else if (this.down()){
            velocity.setY(9);
        }
        
        if (this.left()){
            velocity.setX(-6);
        }
        
        if (this.right()){
            velocity.setX(6);
        }
    }
}
