/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DaanB
 */
public class Vector {
    public int x;   //Public: vermijden van gebruik van teveel getters en setters
    public int y;   //          vergemakkelijkt veel berekeningen 
    
    public Vector() {
        this.x = 0;
        this.y = 0;
    }
    
    public Vector( int x, int y ) {
        this.x = x;
        this.y = y;
    }
}    
