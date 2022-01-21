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
    private BulletGenerator bulletGenerator;

    public PlayerController(Player player, PlayerView view, PlayerInput input, BulletGenerator bulletGenerator) {
        this.player = player;
        this.view = view;
        this.input = input;
        this.bulletGenerator = bulletGenerator;
    }
    
    public void update(){
        updateModel();
        updateView();
    }
    
    public void updateModel() {
        this.input.beweging(this.player);
        
        this.player.update();
        
        if ( this.input.fire() ) {
            this.bulletGenerator.shootBullet(this);
        }
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
    
    public BulletGenerator getBulletGenerator() {
        return this.bulletGenerator;
    }
}
