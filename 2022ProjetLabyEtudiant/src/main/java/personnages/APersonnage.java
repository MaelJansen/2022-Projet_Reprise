/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import labyrinthe.ISalle;

/**
 *
 * @author majansen
 */
public abstract class APersonnage implements IPersonnage{

    ISalle position;
    
    /**
     * Une fonction qui permet de définir une position pour le personnage
     * @param s la salle que l'on veut definir comme position
     */
    @Override
    public void setPosition(ISalle s){
        position = s;
    }

    /**
     * Une fonction qui permet de connaitre la position du personnage
     * @return la position du personnage (salle)
     */
    @Override
    public ISalle getPosition(){
      return position;  
    }
    
}
