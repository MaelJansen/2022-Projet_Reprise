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
    
    /**
     * Une fonction qui permet de savoir la destination du prochain deplacement
     * du monstre
     * @param sallesAccessibles les salles qui lui sont accessibles
     * @return la salle choisie pour le deplacement
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return m.faitSonChoix(sallesAccessibles);
    }

    /**
     * Une fonction pour savoir la position du monstre
     * @return le position du monstre
     */
    @Override
    public ISalle getPosition() {
        return m.getPosition();
    }
    
    /**
     * Le constructeur pour la partie graphique des monstres
     * @param m un monstre
     * @param lab le labyrinthe dans lequel il se trouve
     */
    public MonstreSprite(Monstres m, ILabyrinthe lab){
        super(m, lab,"file:icons/monstre0.gif");
        this.m = m;
        this.lab = lab;
    }
    
}
