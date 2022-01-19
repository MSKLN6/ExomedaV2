/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.fiiw.exomeda.App;
import view.PlayerView;

/**
 *
 * @author DaanB
 */
public class Player extends Entity{
    
    public Player(Vector position) {
        super(position = new Vector (App.WINDOW_WIDTH/2, (int)Math.round(App.WINDOW_HEIGHT*0.70)));
        
        int dirY = getDirection().getY();
        dirY = -1; // Mikt naar beneden
        getDirection().setY(dirY);
    }
    
    @Override
    public void update() {
        super.update();
        
        int posX = position.getX();
        int posY = position.getY();
        
        posX = Math.max(0, Math.min(posX, App.WINDOW_WIDTH - PlayerView.PLAYER_WIDTH));
        posY = Math.max(0, Math.min(posY, App.WINDOW_HEIGHT - PlayerView.PLAYER_HEIGHT));
        
        position.setX(posX);
        position.setY(posY);
    }
}