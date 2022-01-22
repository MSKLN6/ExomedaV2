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
import javafx.scene.shape.Rectangle;
import model.*;

/**
 *
 * @author DaanB
 */
public class EnemyView extends Region{
    private Enemy model;
    private boolean collided = false;
    
    private Rectangle hitbox;

    public EnemyView(Enemy model) {
        
        this.model = model;
        this.tekenEnemy();
    }

    public Enemy getModel() {
        return model;
    }
    
    public void update() {
        
        int posX = model.getPosition().getX();
        int posY = model.getPosition().getY();
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        
        if (collided){
            removeEnemy();
        }
    }
    
    public void tekenEnemy() {
        
//        Rectangle hitbox = new Rectangle( 0, 0, model.getEnemyWidth(), model.getEnemyHeight());
//        getChildren().add(hitbox);
        
        Image image = null;
        image = ImageController.getImage(LoadedImage.Type.ENEMY_UFO);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth(model.getEnemyWidth());
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
        
        this.update();
    }
    
    public void removeEnemy(){
        this.getChildren().clear();
        model.getPosition().setX(0);
        model.getPosition().setY(-1000000);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
    public boolean collision(BulletView bullet){
        
        int enemyX = getModel().getPosition().getX();
        int enemyY = getModel().getPosition().getY();
        int bulletX = bullet.getModel().getPosition().getX();
        int bulletY = bullet.getModel().getPosition().getY();
        
        int dx = bulletX - enemyX;
        int dy = bulletY - enemyY;
        
        //Hoek rechtsonder
        if (dx > 0 && dx < model.getEnemyWidth() && dy > 0 && dy < model.getEnemyHeight() + 60){
            return true;
        }
        
        //Hoek rechtsboven
        else if (dx > 0 && dx < model.getEnemyWidth() && dy < 0 && dy > -bullet.getBulletHeight()){
            return true;
        }
        
        //Hoek linksboven
        else if (dx < 0 && dx > -bullet.getBulletWidth()&& dy < 0 && dy > -bullet.getBulletHeight()){
            return true;
        }
        
        //Hoek linksonder
        else if (dx < 0 && dx > -bullet.getBulletWidth() && dy > 0 && dy < model.getEnemyHeight()){
            return true;
        }
        
        return false;
    }
    
    public boolean getCollided(){
        return collided;
    }
    
    public void switchCollided(){
        collided = !collided;
    }
        
}