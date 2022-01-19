/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;

/**
 *
 * @author DaanB
 */
public class GameLoop extends TimerTask {

    private ExomedaFXMLController controller;
    
    private static int DELTA_TIME = 16; // Tijd tussen elke tick [ms] 16ms~60FPS 
    
    public GameLoop(ExomedaFXMLController controller) {
        this.controller = controller;
    }
    
    public int getDELTA_TIME(){
        return this.DELTA_TIME;
    }
    
    @Override
    public void run() {
        this.controller.update();
    }
}
