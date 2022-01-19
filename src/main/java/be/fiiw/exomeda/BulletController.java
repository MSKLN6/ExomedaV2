/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import model.Bullet;
import view.BulletView;

/**
 *
 * @author vando
 */
public class BulletController {
    private ArrayList<BulletView> bullets;
    
    private ArrayList<PlayerController> shootersWaitingForViews;
    private ArrayList<BulletView> bulletsToRemove;
    
    private AnchorPane container;
    
    public BulletController(AnchorPane container) {
        this.bullets = new ArrayList<BulletView>();
        
        this.shootersWaitingForViews = new ArrayList<PlayerController>();
        this.bulletsToRemove = new ArrayList<BulletView>();
        
        this.container = container;
    }
    
    public void shootBullet(PlayerController shooter) {
        
        // we can't just create and add BulletViews here, sadly...
        // this because input handling/shooting is done in the Timer thread,
        // while UI updates can only be done in the JavaFX thread
        // we also can't make the bullets here and add just views later, because we need information in the SpaceshipController.getView()
        // to create the correct type of BulletView...
        
        // So we keep a list of SpaceshipControllers that shot and actually have them shoot later in updateViews()
        // We need to make this thread safe, because when we have many things shooting bullets,
        // we can and do get ConcurrentModificationException when looping over this in updateViews() to actually make the Bullets
        // see also: https://stackoverflow.com/questions/1431681/correct-way-to-synchronize-arraylist-in-java
        synchronized(this.shootersWaitingForViews){
            this.shootersWaitingForViews.add( shooter );
        }
    }
    
    public void updateModels() {
        // update the bullet models: adjust coordinates
        synchronized(this.bullets){
            for ( BulletView bv : this.bullets ) {
                bv.getModel().update();
            }
        }
    }
    
    public void updateViews() {
        
        synchronized(this.bullets){
            // make view for recently fired bullets
            synchronized(this.shootersWaitingForViews){

                for ( PlayerController playerController : this.shootersWaitingForViews ) {

                    Bullet b = playerController.getBulletGenerator().createBullet();
                    b.setShooter( playerController.getPlayer() );
                    b.setPosition( playerController.getView().getCenterPoint() );
                    
                    int velX = b.getVelocity().getX();
                    int dirX = playerController.getPlayer().getDirection().getX();
                    
                    velX = velX * dirX;
                    
                    b.getVelocity().setX(velX);

                    BulletView bv = playerController.getBulletGenerator().createBulletView( b );
                    bv.setup();

                    bullets.add( bv );
                    this.container.getChildren().add( bv );
                }

                this.shootersWaitingForViews.clear();
            }

            // update views for existing bullets
            for ( BulletView bv : this.bullets ) {
                bv.update();
                this.checkBulletOffscreen( bv );
            }

            // clean up bullets that were marked as removable in this tick
            for ( BulletView toRemove : this.bulletsToRemove ) {
                // remove both from the local list, as from the actual JavaFX container
                this.bullets.remove( toRemove );
                this.container.getChildren().remove( toRemove );
            }
            this.bulletsToRemove.clear();
        
        }
    }
    
    private void checkBulletOffscreen( BulletView bullet ) {
    
        // we want to remove bullets that go off-screen without hitting anything
        if ( bullet.getModel().getPosition().getX() < -500 ) {
            this.bulletsToRemove.add( bullet );
        }
        else if ( bullet.getModel().getPosition().getX() > App.WINDOW_WIDTH + 500 ) {
            this.bulletsToRemove.add( bullet );
        }
        else if ( bullet.getModel().getPosition().getY() < - 500 ) {
            this.bulletsToRemove.add( bullet );
        }
        else if ( bullet.getModel().getPosition().getY() > App.WINDOW_HEIGHT + 500 ) {
            this.bulletsToRemove.add( bullet );
        }
    }
}
