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
import model.Vector;

/**
 *
 * @author DaanB
 */
public class PlayerView extends Region{
    private Player model;
    public static int PLAYER_WIDTH = 75;
    public static int PLAYER_HEIGHT = 75;

    public PlayerView(Player model) {
        
        this.model = model;
        this.tekenPlayer();
        this.boost();
    }

    public Player getModel() {
        return model;
    }
    
    public void update() {
        
        int posX = model.getPosition().getX();
        int posY = model.getPosition().getY();
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
    
    public Vector getCenterPoint() {
        return new Vector( this.model.getPosition().getX() + PlayerView.PLAYER_WIDTH / 2, this.model.getPosition().getY() + PlayerView.PLAYER_HEIGHT / 2 );
    }
    
    public void tekenPlayer() {
        
        //Rectangle r = new Rectangle( 0, 0, PlayerView.PLAYER_WIDTH, PlayerView.PLAYER_HEIGHT);
        //r.setFill( Color.CYAN );
        //this.getChildren().add(r);
        
        Image image = null;
        image = ImageController.getImage(LoadedImage.Type.PLAYER);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView(image);
        iv.setFitWidth(PLAYER_WIDTH);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    public void boost() {
        
        Image image = null;
        image = ImageController.getImage(LoadedImage.Type.FIRE);
        Image image2 = null;
        image2 = ImageController.getImage(LoadedImage.Type.GLOW);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        ImageView iv2 = new ImageView(image2);
        iv.setScaleX(0.6);
        iv.setScaleY(0.8);
        iv.setLayoutY((55));
        iv.setFitHeight(PLAYER_WIDTH);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        iv2.setScaleX(0.5);
        iv2.setScaleY(0.7);
        iv2.setLayoutY((50));
        iv2.setFitHeight(PLAYER_WIDTH);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        
        this.getChildren().add(iv);
        this.getChildren().add(iv2);
        
        this.update();
    }
    
    
}