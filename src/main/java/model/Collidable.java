/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vando
 */
public interface Collidable {
    public Vector getCenterPoint();
    
    public boolean collidesWith(Collidable c);
    public boolean collidesWith(Vector point);
    
}
