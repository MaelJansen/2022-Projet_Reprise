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
    
    /**
     * Une fonction qui permet d'acceder a la coordonnée X d'une salle
     * @return la coordonnée X d'une salle
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Une fonction qui permet d'acceder a la coordonnée Y d'une salle
     * @return la coordonnée Y d'une salle
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Une fonction qui permet de savoir si la salle est adjacentes a une autre
     * @param autre la salle dont on veut savoir si elle adjacente
     * @return vrai si adjacente et faux sinon
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        return(abs(x-autre.getX())==1 && autre.getY()==y) 
                || (abs(y-autre.getY())==1 && autre.getX()==x);
    }
    
    /**
     * Un constructeur de salle 
     * @param a la coordonnée x de la salle
     * @param b la coordonnée Y de la salle
     */
    public Salle(int a, int b){
        x = a;
        y = b;
    }
}
