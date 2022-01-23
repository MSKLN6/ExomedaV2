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
import model.Enemy;
import model.Exomeda;
import model.LoadedImage;
import model.Player;
import model.Vector;

/**
 *
 * @author vando
 */
public class GameoverView extends Region{
    private Vector positie;
    private Exomeda exomeda;

    public GameoverView() {
        this.exomeda = exomeda;
        this.positie = new Vector(0,0);
    }
    
    public void update() {
        gameoverscreen();
    }
    
    private void gameoverscreen(){
        Image image = ImageController.getImage(LoadedImage.Type.GAMEOVER);
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
        ImageView iv = new ImageView( image );
        iv.setFitWidth( App.WINDOW_WIDTH );
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        
        this.getChildren().add(iv);
    }
}
