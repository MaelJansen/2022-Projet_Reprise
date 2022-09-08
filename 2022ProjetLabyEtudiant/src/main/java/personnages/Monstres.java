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
    
    Random r = new Random();
    int nbAleatoire;
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        ArrayList<ISalle> accessibles = new ArrayList<>();
        accessibles.addAll(sallesAccessibles);
        ISalle salleAleatoire;
        nbAleatoire = r.nextInt(0 - sallesAccessibles.size());
        salleAleatoire = accessibles.get(nbAleatoire);
        return salleAleatoire;
    }
    
}
