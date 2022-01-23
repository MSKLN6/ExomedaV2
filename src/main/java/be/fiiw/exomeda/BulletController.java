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
        this.bullets = new ArrayList<BulletView>();
        
        this.pc = new ArrayList<PlayerController>();
        this.bulletsToRemove = new ArrayList<BulletView>();
        
        this.screen = screen;
    }
    
    public void shootBullet(PlayerController shooter) {
        
       //https://stackoverflow.com/questions/1431681/correct-way-to-synchronize-arraylist-in-java
        synchronized(this.pc){
            this.pc.add( shooter );
        }
    }
    
    public void update(){
        // synchroniseren van de juiste positie van de bullets (model)
        synchronized(this.bullets){
            for ( BulletView bv : this.bullets ) {
                bv.getModel().update();
            }
        }
        
        //updaten van de view
        synchronized(this.bullets){
            synchronized(this.pc){

                for ( PlayerController playerController : this.pc ) {

                    Bullet b = playerController.getBulletGenerator().createBullet();
                    b.setShooter( playerController.getPlayer() );
                    b.setPosition( playerController.getView().getCenterPoint() );
                    
                    int velX = b.getVelocity().getX();
                    
                    b.getVelocity().setX(velX);

                    BulletView bv = playerController.getBulletGenerator().createBulletView( b );
                    bv.setup();

                    bullets.add( bv );
                    this.screen.getChildren().add( bv );
                }

                this.pc.clear();
            }

            for (BulletView bv : this.bullets) {
                bv.update();
                this.checkBulletOffscreen(bv);
            }

            for (BulletView verwijder : this.bulletsToRemove) {
                this.bullets.remove(verwijder);
                this.screen.getChildren().remove(verwijder);
            }
            this.bulletsToRemove.clear();
        
        }
    }
    
    public ArrayList<BulletView> getBullets() {
        return bullets;
    }

    
    private void checkBulletOffscreen( BulletView bullet ) {
        if ( bullet.getModel().getPosition().getY() < - App.WINDOW_HEIGHT ) {
            this.bulletsToRemove.add( bullet );
        }
        else if ( bullet.getModel().getPosition().getY() > App.WINDOW_HEIGHT ) {
            this.bulletsToRemove.add( bullet );
        }
    }
}
