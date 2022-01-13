/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import be.fiiw.exomeda.ImageController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import model.LoadedImage;
import model.Player;

/**
 *
 * @author DaanB
 */
public class PlayerView extends Region{
    private Player model;
    private static int PLAYER_WIDTH = 60;
    private static int PLAYER_HEIGHT = 60;

    public PlayerView(Player model) {
        
        this.model = model;
        this.tekenPlayer();
    }

    public Player getModel() {
        return model;
    }
    
    public void update() {
        this.setTranslateX( this.model.getPosition().x );
        this.setTranslateY( this.model.getPosition().y );
    }
    
    public void tekenPlayer() {
        
        Image image = null;
        image = ImageController.getImage(LoadedImage.Type.PLAYER);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( PLAYER_WIDTH - 5);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    
}
