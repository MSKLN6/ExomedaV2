/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import be.fiiw.exomeda.ImageController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Bullet;
import model.LoadedImage;
import model.Vector;

/**
 *
 * @author vando
 */
public class BulletView_Player extends BulletView {
    private static int WIDTH = 13;
    private static int HEIGHT = 54;
    
    private PlayerView pv;
    
    private static int HALF_WIDTH = WIDTH / 2;
    private static int HALF_HEIGHT = HEIGHT / 2;
    
    private Rectangle hitbox;

    public BulletView_Player(Bullet model) {
        super(model);
    }
    
    public void setup() {

//        hitbox = new Rectangle( -9, -75, BulletView_Player.WIDTH, BulletView_Player.HEIGHT);
//        this.getChildren().add(hitbox);
        
        Image image = ImageController.getImage(LoadedImage.Type.BULLET_PLAYER);
        ImageView iv = new ImageView( image );
        
        iv.setLayoutX(-27);
        iv.setLayoutY(-53);
        iv.setY(-20);
        iv.setX(20);
        
        iv.setFitWidth(13);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        
        this.getChildren().add(iv);
        
        this.update();
        
        this.update();
    }
    
    public int getBulletWidth() {
        return BulletView_Player.WIDTH;
    }
    
    public int getBulletHeight() {
        return BulletView_Player.HEIGHT;
    }
        
    public Vector getCenterPoint() {
        return new Vector( this.model.getPosition().getX() + BulletView_Player.HALF_WIDTH, this.model.getPosition().getY() + BulletView_Player.HALF_HEIGHT);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
}
