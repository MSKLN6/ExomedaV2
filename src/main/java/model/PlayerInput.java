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
    
    
    
    public void beweging(Player player) {
        
        Vector velocity = player.getVelocity();

        velocity.x = 0;
        velocity.y = 0;

        if ( this.getUp() ) {
            velocity.y = -1;
        }
        else if ( this.getDown() ) {
            velocity.y = 1;
        }

        if ( this.getLeft() ) {
            velocity.x = -1;
        }
        else if ( this.getRight() ) {
            velocity.x = 1;
        }
    }

    /**
     * @return the Up
     */
    public Boolean getUp() {
        return Up;
    }

    /**
     * @param Up the Up to set
     */
    public void setUp(Boolean Up) {
        this.Up = Up;
    }

    /**
     * @return the Down
     */
    public Boolean getDown() {
        return Down;
    }

    /**
     * @param Down the Down to set
     */
    public void setDown(Boolean Down) {
        this.Down = Down;
    }

    /**
     * @return the Left
     */
    public Boolean getLeft() {
        return Left;
    }

    /**
     * @param Left the Left to set
     */
    public void setLeft(Boolean Left) {
        this.Left = Left;
    }

    /**
     * @return the Right
     */
    public Boolean getRight() {
        return Right;
    }

    /**
     * @param Right the Right to set
     */
    public void setRight(Boolean Right) {
        this.Right = Right;
    }
}
