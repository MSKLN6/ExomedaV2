/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;

/**
 *
 * @author vando
 */
class GameLoop extends TimerTask {

    private ExomedaFXMLController controller;
    
    public static int TIME = (int) 2;
    
    public GameLoop(ExomedaFXMLController controller) {
        this.controller = controller;
    }
    
    @Override
    public void run() {
        this.controller.update();
    }
}
