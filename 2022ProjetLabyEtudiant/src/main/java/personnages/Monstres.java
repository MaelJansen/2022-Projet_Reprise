/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 *
 * @author majansen
 */
public class Monstres extends APersonnage{
    
    
    int nbAleatoire;
    ISalle salleAleatoire;
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        ArrayList<ISalle> accessibles = (ArrayList) sallesAccessibles;
        Random r = new Random();
        salleAleatoire = accessibles.get(r.nextInt(accessibles.size()));
        return salleAleatoire;
    }
    
    public Monstres(ISalle salleDepart){
        this.setPosition(salleDepart);
        salleAleatoire = salleDepart;
    }
    
    @Override
    public ISalle getPosition(){
        return super.getPosition();
    }
    
}
