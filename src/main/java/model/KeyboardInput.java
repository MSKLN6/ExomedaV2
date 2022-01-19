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
    private KeyCode boost;
    
    public KeyboardInput(KeyCode up, KeyCode down, KeyCode left, KeyCode right, KeyCode fire, KeyCode boost) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.fire = fire;
        this.boost = boost;
    }

    public void handleKeyPress( KeyEvent e ) {
        KeyCode key = e.getCode();
        
        if ( key == this.up ) {
            this.Up = true;
        }
        else if ( key == this.down ) {
            this.Down = true;
        }
        else if ( key == this.left ) {
            this.Left = true;
        }
        else if ( key == this.right ) {
            this.Right = true;
        }
        else if ( key == this.fire ) {
            this.Fire = true;
        }
        else if ( key == this.boost ) {
            this.Boost = true;
        }
    }
    
    public void handleKeyRelease( KeyEvent e ) {
        KeyCode key = e.getCode();
        
        if ( key == this.up ) {
            this.Up = false;
        }
        else if ( key == this.down ) {
            this.Down = false;
        }
        else if ( key == this.left ) {
            this.Left = false;
        }
        else if ( key == this.right ) {
            this.Right = false;
        }
    }
}
