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
import model.Exomeda;
import model.LoadedImage;
import model.Vector;

/**
 *
 * @author vando
 */
public class HealthbarView extends Region{
    private Vector positie;

    public HealthbarView() {
        this.positie = new Vector(0,0);
        health3();
    }
    
    public void updateToHealth2() {
        this.getChildren().clear();
        health2();
    }
    
    public void updateToHealth1(){
        this.getChildren().clear();
        health1();
    }
    
    private void health3(){
        Image image = ImageController.getImage(LoadedImage.Type.HEALTH1);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( 110 );
        iv.setLayoutX(App.WINDOW_WIDTH - 150);
        iv.setLayoutY(15);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
    }
    
    private void health2(){
        Image image = ImageController.getImage(LoadedImage.Type.HEALTH2);
        
        // shttps://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( 110 );
        iv.setLayoutX(App.WINDOW_WIDTH - 150);
        iv.setLayoutY(15);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
    }
    
    private void health1(){
        Image image = ImageController.getImage(LoadedImage.Type.HEALTH1);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( 110 );
        iv.setLayoutX(App.WINDOW_WIDTH - 150);
        iv.setLayoutY(15);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
    }
}
