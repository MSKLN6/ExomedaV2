/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import be.fiiw.exomeda.ImageController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import model.LoadedImage;
import model.Player;
import model.Vector;

/**
 *
 * @author DaanB
 */
public class PlayerView extends Region{
    private Player model;
    
    private Rectangle hitbox;

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
        
        if (model.getCollided()){
            removePlayer();
        }
    }
    
    public void tekenPlayer() {
        
//        hitbox = new Rectangle( 0, 0, model.getPlayerWidth(), model.getPlayerHeight());
//        getChildren().add(hitbox);
        
        Image image = ImageController.getImage(LoadedImage.Type.PLAYER);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView(image);
        iv.setFitWidth(model.getPlayerWidth());
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    public void removePlayer(){
        this.getChildren().clear();
        model.getPosition().setX(0);
        model.getPosition().setY(-1000000);
    }
    
    public void boost() {
        
        Image image = ImageController.getImage(LoadedImage.Type.FIRE);
        Image image2 = ImageController.getImage(LoadedImage.Type.GLOW);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        ImageView iv2 = new ImageView(image2);
        iv.setScaleX(0.6);
        iv.setScaleY(0.8);
        iv.setLayoutY((55));
        iv.setFitHeight(model.getPlayerWidth());
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        iv2.setScaleX(0.5);
        iv2.setScaleY(0.7);
        iv2.setLayoutY((50));
        iv2.setFitHeight(model.getPlayerWidth());
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        
        this.getChildren().add(iv);
        this.getChildren().add(iv2);
        
        this.update();
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
    
}