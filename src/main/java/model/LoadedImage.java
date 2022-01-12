/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.scene.image.Image;

/**
 *
 * @author vando
 */
public class LoadedImage {
    public enum Type {
        PLAYER,
        
        ENEMY_UFO,
        ENEMY_BOSS,
        
        PROJECTILE,
        
        BACKGROUND
    }
    
    private Type type; 
    private String filePath;
    private Image image;

    public LoadedImage(Type type, String filePath, Image image) {
        this.type = type;
        this.filePath = filePath;
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public String getFilePath() {
        return filePath;
    }

    public Image getImage() {
        return image;
    }
}
