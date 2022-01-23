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
            setUp(true);
        }
        else if ( key == this.down ) {
            setDown(true);
        }
        else if ( key == this.left ) {
            setLeft(true);
        }
        else if ( key == this.right ) {
            setRight(true);
        }
        else if ( key == this.fire ) {
            setFire(true);
        }
        else if ( key == this.boost ) {
            setBoost(true);
        }
    }
    
    public void handleKeyRelease( KeyEvent e ) {
        KeyCode key = e.getCode();
        
        if ( key == this.up ) {
            setUp(false);
        }
        else if ( key == this.down ) {
            setDown(false);
        }
        else if ( key == this.left ) {
            setLeft(false);
        }
        else if ( key == this.right ) {
            setRight(false);
        }
    }
}
