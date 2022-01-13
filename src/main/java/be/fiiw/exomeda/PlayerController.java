/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import model.Player;
import model.PlayerInput;
import view.PlayerView;

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
        input.beweging(this.player); 
        
        player.update();
    }
    
    public void updateViews() {
        view.update();
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
