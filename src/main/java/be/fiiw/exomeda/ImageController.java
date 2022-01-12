/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.ArrayList;
import javafx.scene.image.Image;
import model.LoadedImage;

/**
 *
 * @author vando
 */
public class ImageController {
    private static ArrayList<LoadedImage> images;

//    public ImageController() {
//    }
    
    public static void preloadImages() {
        ImageController.images = new ArrayList<LoadedImage>();
        
        ImageController.loadImage( LoadedImage.Type.PLAYER, "space ship.png" );
        ImageController.loadImage( LoadedImage.Type.ENEMY_UFO, "Ufo.png" );
        ImageController.loadImage( LoadedImage.Type.ENEMY_BOSS, "Boss.png" );
        ImageController.loadImage( LoadedImage.Type.PROJECTILE, "Bullet player.png" );
        ImageController.loadImage( LoadedImage.Type.BACKGROUND, "background.png" );
    }
    
    public static Image getImage( LoadedImage.Type type ) {
        for ( LoadedImage l : ImageController.images ) {
            if ( l.getType() == type ) {
                return l.getImage();
            }
        }
        
        return null;
    }
    
    private static void loadImage( LoadedImage.Type type, String fileName ) {
        
        // see also https://stackoverflow.com/questions/16099427/cannot-load-image-in-javafx
        Image image = new Image( "file:src/main/resources/images/" +  fileName );
        
        LoadedImage loadedImage = new LoadedImage( type, fileName, image );
        
        ImageController.images.add( loadedImage );
    }
}
