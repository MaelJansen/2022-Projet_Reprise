/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ISalle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.Salle;
import personnages.Heros;

/**
 *
 * @author majansen
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    
    ILabyrinthe lab;
    Heros h;
    
    public HerosSprite(Heros perso, ILabyrinthe labyrinthe) {
        super(perso, labyrinthe);
        lab =  labyrinthe;
        h = perso;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return h.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return h.getPosition();
    }

    @Override
    public void handle(KeyEvent t) {
        switch (t.getCode()){
            case LEFT:
                h.setSalleChoisie(new Salle(perso.getPosition().getX()-1, perso.getPosition().getY()));
                System.out.println("deplacement en " + h.getSalleChoisie().getX() + "     " + h.getSalleChoisie().getY());
                break;
            case RIGHT:
                h.setSalleChoisie(new Salle(perso.getPosition().getX()+1, perso.getPosition().getY()));
                System.out.println("deplacement en " + h.getSalleChoisie().getX() + "     " + h.getSalleChoisie().getY());
                break;
            case UP:
                h.setSalleChoisie(new Salle(perso.getPosition().getX(), perso.getPosition().getY()-1));
                System.out.println("deplacement en " + h.getSalleChoisie().getX() + "     " + h.getSalleChoisie().getY());
                break;
            case DOWN:
                h.setSalleChoisie(new Salle(perso.getPosition().getX(), perso.getPosition().getY()+1));
                System.out.println("deplacement en " + h.getSalleChoisie().getX() + "     " + h.getSalleChoisie().getY());
                break;
            default:
                break;
        }
        System.out.println("position du personnage" + h.getPosition().getX() + "    "  + h.getPosition().getY());
        System.out.println("");
        for (ISalle s : lab.sallesAccessibles(h)){
                    System.out.println("cases adjacentes" + s.getX() + "    " + s.getY());
        }
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("");
    }  
}
