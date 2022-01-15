/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author DaanB
 */
public class KeyboardInput extends PlayerInput {
    private KeyCode up;
    private KeyCode down;
    private KeyCode left;
    private KeyCode right;
    private KeyCode fire;
    
    public KeyboardInput(KeyCode up, KeyCode down, KeyCode left, KeyCode right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void handleKeyPress( KeyEvent e ) {
        KeyCode code = e.getCode();
        
        if ( code == this.up ) {
            this.Up = true;
        }
        else if ( code == this.down ) {
            this.Down = true;
        }
        else if ( code == this.left ) {
            this.Left = true;
        }
        else if ( code == this.right ) {
            this.Right = true;
        }
    }
    
    public void handleKeyRelease( KeyEvent e ) {
        KeyCode code = e.getCode();
        
        if ( code == this.up ) {
            this.Up = false;
        }
        else if ( code == this.down ) {
            this.Down = false;
        }
        else if ( code == this.left ) {
            this.Left = false;
        }
        else if ( code == this.right ) {
            this.Right = false;
        }
        
        // Note: firing is a special case that's handled in the fire() getter above
    }
}
