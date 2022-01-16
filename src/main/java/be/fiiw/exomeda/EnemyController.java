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
public class EnemyController {
    private Enemy enemy;
    private EnemyView view;

    public EnemyController(Enemy enemy, EnemyView view) {
        this.enemy = enemy;
        this.view = view;
    }
    
    public void updateModel() {
//        this.input.beweging(this.player); 
        
        this.enemy.update();
    }
    
    public void updateView() {
        this.view.update();
    }
    
    public Enemy getEnemy() {
        return enemy;
    }

    public EnemyView getView() {
        return view;
    }

//    public PlayerInput getInput() {
//        return input;
//    }
}
