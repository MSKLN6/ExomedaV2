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
import model.*;

/**
 *
 * @author DaanB
 */
public class EnemyView extends Region{
    private Enemy model;
    private static int ENEMY_WIDTH = 75;
    private static int ENEMY_HEIGHT = 75;

    public EnemyView(Enemy model) {
        
        this.model = model;
        this.tekenEnemy();
    }

    public Enemy getModel() {
        return model;
    }
    
    public void update() {
        this.setTranslateX( this.model.getPosition().x );
        this.setTranslateY( this.model.getPosition().y );
    }
    
    public void tekenEnemy() {
        
        Image image = null;
        image = ImageController.getImage(LoadedImage.Type.ENEMY_UFO);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( ENEMY_WIDTH - 5);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    
}