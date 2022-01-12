/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import model.Spaceship;
import model.SpaceshipInput;
import view.SpaceshipView;

/**
 *
 * @author vando
 */
class SpaceshipController {
    private Spaceship ship;
    private SpaceshipView view;
    private SpaceshipInput input;
    
    private BulletGenerator bulletGenerator;
    
    public SpaceshipController(Spaceship ship, SpaceshipView view, SpaceshipInput input, BulletGenerator bulletGenerator) {
        this.ship = ship;
        this.view = view;
        this.input = input;
        
        this.bulletGenerator = bulletGenerator;
    }
    
    public void updateModels() {
        
        // the ship itself
        this.input.apply(this.ship); // this only changes velocities, need to handle firing logic separately
        if ( this.input.fire() ) {
            this.bulletGenerator.shootBullet(this);
        }
        
        this.ship.update();
    }
    
    public void updateViews() {
        this.view.update();
    }
    
    public Spaceship getShip() {
        return ship;
    }

    public SpaceshipView getView() {
        return view;
    }

    public SpaceshipInput getInput() {
        return input;
    }
    
    public BulletGenerator getBulletGenerator() {
        return this.bulletGenerator;
    }
}
