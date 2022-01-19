/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;
import java.util.Random;

/**
 *
 * @author DaanB
 */
public class EnemyGenerator extends TimerTask{
    
    private ExomedaFXMLController controller;
    
    Random random = new Random();

    public EnemyGenerator(ExomedaFXMLController controller) {
        this.controller = controller;
    }
    
    @Override
    public void run() {
//        this.controller.spawnEnemy();
    }
    
}
