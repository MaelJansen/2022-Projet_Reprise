/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import static java.lang.Math.abs;

/**
 *
 * @author majansen
 */
public class Salle implements ISalle {
    
    // Les coordonnées de la salle
    private int x;
    private int y;
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean estAdjacente(ISalle autre) {
        return(abs(x-autre.getX())==1 && autre.getY()==y) 
                || (abs(y-autre.getY())==1 && autre.getX()==x);
    }
    
    public Salle(int a, int b){
        x = a;
        y = b;
    }
}
