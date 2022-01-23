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
    private Boolean Up;
    private Boolean Down;
    private Boolean Left;
    private Boolean Right;
    private Boolean Boost;
    private Boolean Fire;
    
    public PlayerInput(){
        this.Up = false;
        this.Down = false;
        this.Left = false;
        this.Right = false;
        this.Boost = false;
        this.Fire = false;
    }
    
    public Boolean up() {
        return Up;
    }
    public Boolean down() {
        return Down;
    }
    public Boolean left() {
        return Left;
    }
    public Boolean right() {
        return Right;
    }
    public Boolean fire() { 
        Boolean fired = Fire;
        Fire = false;
        
        return fired;
    }
    public Boolean boost(){
        return Boost;
    }
    
    public void setUp(boolean b){
        Up = b;
    }
    
    public void setDown(boolean b){
        Down = b;
    }
    
    public void setLeft(boolean b){
        Left = b;
    }
    
    public void setRight(boolean b){
        Right = b;
    }
    
    public void setBoost(boolean b){
        Boost = b;
    }
    
    public void setFire(boolean b){
        Fire = b;
    }
    
    public void beweging(Entity schip) {
        
        Vector velocity = schip.getVelocity();
        
        velocity.setX(0);
        velocity.setY(0);
        
        if (up()){
            velocity.setY(-3);
        }
        
        else if (down()){
            velocity.setY(9);
        }
        
        if (left()){
            velocity.setX(-6);
        }
        
        if (right()){
            velocity.setX(6);
        }
    }
}
