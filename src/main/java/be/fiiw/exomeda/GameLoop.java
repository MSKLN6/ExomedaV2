/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author DaanB
 */
public class GameLoop extends TimerTask {

    private ExomedaFXMLController controller;
    
    private static int period = 16; // Tijd tussen elke tick [ms] 
    
    public GameLoop(ExomedaFXMLController controller) {
        this.controller = controller;
    }
    
    public int getPeriod(){
        return period;
    }
    
    @Override
    public void run() {
        Platform.runLater(controller::update);
    }
}
