/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import model.*;
import view.*;

/**
 *
 * @author vando
 */

public class BulletController {
    private ArrayList<BulletView> bullets;
    
    private ArrayList<PlayerController> pc;
    private ArrayList<BulletView> bulletsToRemove;
    
    private AnchorPane screen;
    
    public BulletController(AnchorPane screen) {
        this.bullets = new ArrayList<>();
        
        this.pc = new ArrayList<>();
        this.bulletsToRemove = new ArrayList<>();
        
        this.screen = screen;
    }
    
    public void shootBullet(PlayerController shooter) {
        
       //https://stackoverflow.com/questions/1431681/correct-way-to-synchronize-arraylist-in-java
        synchronized(pc){
            pc.add( shooter );
        }
    }
    
    public void update(){
        // synchroniseren van de juiste positie van de bullets (model)
        synchronized(bullets){
            for ( BulletView bv : bullets ) {
                bv.getModel().update();
            }
        }
        
        //updaten van de view
        synchronized(bullets){
            synchronized(pc){

                for ( PlayerController playerController : pc ) {

                    Bullet b = playerController.getBulletGenerator().createBullet();
                    b.setShooter( playerController.getPlayer() );
                    b.setPosition( playerController.getPlayer().getCenterPoint() );
                    
                    int velX = b.getVelocity().getX();
                    
                    b.getVelocity().setX(velX);

                    BulletView bv = playerController.getBulletGenerator().createBulletView( b );
                    bv.setup();

                    bullets.add( bv );
                    screen.getChildren().add( bv );
                }

                pc.clear();
            }

            for (BulletView bv : bullets) {
                bv.update();
                checkBulletOffscreen(bv);
            }

            for (BulletView verwijder : bulletsToRemove) {
                bullets.remove(verwijder);
                screen.getChildren().remove(verwijder);
            }
            bulletsToRemove.clear();
        
        }
    }
    
    public ArrayList<BulletView> getBullets() {
        return bullets;
    }

    
    private void checkBulletOffscreen( BulletView bullet ) {
        if ( bullet.getModel().getPosition().getY() < - App.WINDOW_HEIGHT ) {
            bulletsToRemove.add( bullet );
        }
        else if ( bullet.getModel().getPosition().getY() > App.WINDOW_HEIGHT ) {
            bulletsToRemove.add( bullet );
        }
    }
}
