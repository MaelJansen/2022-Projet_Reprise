/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author majansen
 */
public class Heros extends APersonnage{

    private ISalle salleChoisie;

    @Override
    public ISalle getPosition() {
        return super.getPosition();
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        for(ISalle s : sallesAccessibles){
            if(s.getX() == salleChoisie.getX() 
                    && s.getY() ==  salleChoisie.getY()){
                return salleChoisie;
            }
        }
        return getPosition();
    }
    
    public Heros(ISalle salleDepart){
        this.setPosition(salleDepart);
        salleChoisie =salleDepart;
    }

    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    public ISalle getSalleChoisie() {
        return salleChoisie;
    }
}
