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
    
    public void update(){
        updateModel();
        updateView();
    }
    
    public void updateModel() {
        this.enemy.update();
        this.enemy.tick();
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
}
