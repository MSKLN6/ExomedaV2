/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import be.fiiw.exomeda.App;
import be.fiiw.exomeda.ImageController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import model.LoadedImage;
import model.Vector;

/**
 *
 * @author vando
 */
public class BackgroundView extends Region {

    private Vector positie;
    
    public BackgroundView() {
        this.positie = new Vector(0,0);
        this.setup();
    }

    public void setup() {
        
        Image image = ImageController.getImage(LoadedImage.Type.BACKGROUND);
        
        // see https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( App.WINDOW_WIDTH * 2 );
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    public void update() {
        if ( this.positie.y <  App.WINDOW_HEIGHT ) {
            this.positie.y = 10000;
        }
        else {
            this.positie.y -= 0.001;
        }
        
        this.setTranslateY(- this.positie.y );
    }
}

