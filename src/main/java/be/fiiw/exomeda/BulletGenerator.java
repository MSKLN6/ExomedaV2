/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import model.Bullet;
import view.BulletView;

/**
 *
 * @author vando
 */
public abstract class BulletGenerator {
    
    private BulletController controller;
    
    public BulletGenerator(BulletController controller) {
        this.controller = controller;
    }
    
    public void shootBullet( PlayerController playerController ) {
        controller.shootBullet(playerController);
    }
    
    public abstract Bullet createBullet();
    public abstract BulletView createBulletView(Bullet bullet);
}
