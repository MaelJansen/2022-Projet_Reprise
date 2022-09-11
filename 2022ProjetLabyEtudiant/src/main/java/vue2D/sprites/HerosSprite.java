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
    
    /**
     * Le constructeur pour la partie graphique du hero
     * @param perso le personnage du hero
     * @param labyrinthe le labyrinthe dans lequel il se trouve
     */
    public HerosSprite(Heros perso, ILabyrinthe labyrinthe) {
        super(perso, labyrinthe,"file:icons/link/LinkRunShieldD1.gif");
        lab =  labyrinthe;
        h = perso;
    }
    
    /**
     * Une focntion qui permet de connaitre la salle de destination 
     * du prochain déplacement du hero
     * @param sallesAccessibles la liste des salle qui lui sont accessible
     * @return la salle choisie pour le deplacement
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return h.faitSonChoix(sallesAccessibles);
    }

    /**
     * Une fonction qui permet de connaitre a position du hero
     * @return la position du hero
     */
    @Override
    public ISalle getPosition() {
        return h.getPosition();
    }

    /**
     * Une fonction qui permet de choisir au clavier la destination du hero
     * (haut, bas, gauche, droite) 
     * @param t les evenements clavier
     */
    @Override
    public void handle(KeyEvent t) {
        switch (t.getCode()){
            case LEFT:
                h.setSalleChoisie(new Salle(perso.getPosition().getX()-1, perso.getPosition().getY()));
                break;
            case RIGHT:
                h.setSalleChoisie(new Salle(perso.getPosition().getX()+1, perso.getPosition().getY()));
                break;
            case UP:
                h.setSalleChoisie(new Salle(perso.getPosition().getX(), perso.getPosition().getY()-1));
                break;
            case DOWN:
                h.setSalleChoisie(new Salle(perso.getPosition().getX(), perso.getPosition().getY()+1));
                break;
            default:
                break;
        }
    }
}
