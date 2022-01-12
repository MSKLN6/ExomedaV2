/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import be.fiiw.exomeda.ImageController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.LoadedImage;
import model.Player;
import model.Vector;

/**
 *
 * @author DaanB
 */
public class PlayerView extends SpaceshipView {
    private Player model;
    
    private static int WIDTH = 60;
    private static int HEIGHT = 75;

    public PlayerView(Player model) {
        super(model);
        
        this.model = model;
        this.setup();
    }

    public Player getModel() {
        return model;
    }
    
    public void setup() {
  
        //re-enable this code to show the "hitbox"
//         Rectangle r = new Rectangle( 0, 0, PlayerAvatarView.WIDTH, PlayerAvatarView.HEIGHT);
//         r.setFill( this.model.getColor() );
//         this.getChildren().add(r);
        
        Image image = null;

        image = ImageController.getImage(LoadedImage.Type.PLAYER);

        // see https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setRotate(90); // the player images are facing UP by default, we want them facing RIGHT 
        iv.setFitWidth( 99 ); // we don't use PlayerAvatarView.WIDTH because we want the hitbox to be a bit smaller than the actual image
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    @Override
    public Vector getCenterPoint() {
        return new Vector( this.model.getPosition().x + PlayerView.WIDTH / 2, this.model.getPosition().y + PlayerView.HEIGHT / 2 );
    }
    
    @Override 
    public boolean collidesWith(Vector testPoint) {
        
        if ( testPoint.x < this.model.getPosition().x ) return false;
        if ( testPoint.x > this.model.getPosition().x + PlayerView.WIDTH ) return false;
        
        if ( testPoint.y < this.model.getPosition().y ) return false;
        if ( testPoint.y > this.model.getPosition().y + PlayerView.HEIGHT ) return false;
        
        return true;
    }
    
}
