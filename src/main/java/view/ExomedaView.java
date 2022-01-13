/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.Region;
import model.Exomeda;

/**
 *
 * @author DaanB
 */
public class ExomedaView extends Region{
    private Exomeda model;

    public ExomedaView(Exomeda exomedaModel) {
        model = exomedaModel;
        update();
    }
    
    public void update(){
        getChildren().clear();
    }
    
}
