/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import model.Bullet;
import view.BulletView;
import view.BulletView_Player;

/**
 *
 * @author vando
 */
public class BulletGenerator_Player extends BulletGenerator {

    public BulletGenerator_Player(BulletController controller) {
        super(controller);
    }
    
    @Override
    public Bullet createBullet(){
        return new Bullet(1, 20); // 1 damage, 20 speed
    }
    
    @Override
    public BulletView createBulletView(Bullet bullet) {
        return new BulletView_Player( bullet );
    }
}
