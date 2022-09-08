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
    
    @Override
    public void setPosition(ISalle s){
        position = s;
    }

    @Override
    public ISalle getPosition(){
      return position;  
    }
    
}
