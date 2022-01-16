/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import model.*;
import view.*;

/**
 *
 * @author vando
 */
public class PlayerController {
    private Player player;
    private PlayerView view;
    private PlayerInput input;

    public PlayerController(Player player, PlayerView view, PlayerInput input) {
        this.player = player;
        this.view = view;
        this.input = input;
    }
    
    public void updateModel() {
        this.input.beweging(this.player); 
        
        this.player.update();
    }
    
    public void updateView() {
        this.view.update();
    }
    
    public Player getPlayer() {
        return player;
    }

    public PlayerView getView() {
        return view;
    }

    public PlayerInput getInput() {
        return input;
    }
}
