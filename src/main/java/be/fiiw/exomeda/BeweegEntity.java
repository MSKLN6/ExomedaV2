/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Exomeda;

/**
 *
 * @author vando
 */
public class BeweegEntity extends TimerTask{
    private Exomeda model;
    private ExomedaFXMLController controller;
    
    public BeweegEntity(Exomeda model, ExomedaFXMLController exomedaController) {
        this.model = model;
        this.controller = exomedaController;
    }
    
    public void run() {
        model.tick();
        Platform.runLater(controller::update);
    }
}
