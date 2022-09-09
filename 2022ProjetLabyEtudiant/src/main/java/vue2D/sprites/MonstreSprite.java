/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.Monstres;

/**
 *
 * @author majansen
 */
public class MonstreSprite extends ASprite {
    
    Monstres m;
    ILabyrinthe lab;
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return m.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return m.getPosition();
    }
    
    public MonstreSprite(Monstres m, ILabyrinthe lab){
        super(m, lab,"file:icons/monstre0.gif");
        this.m = m;
        this.lab = lab;
    }
    
}
