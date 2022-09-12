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

    /**
     * Une fonction qui permet de connaitre la position du hero
     * @return la position du hero (salle)
     */
    @Override
    public ISalle getPosition() {
        return super.getPosition();
    }

    /**
     * Une fonction qui permet de chosir une salle ou allé 
     * (si elle est accessibles)
     * @param sallesAccessibles la liste des salles accessibles
     * @return la salle chosie si elle est accessible et la position sinon
     */
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
    
    /**
     * Le constructeur pour le hero
     * @param salleDepart la salle de depart du hero
     */
    public Heros(ISalle salleDepart){
        this.setPosition(salleDepart);
        salleChoisie =salleDepart;
    }

    /**
     * Une fonction qui permet de definir al salle choisis pour le deplacement
     * du hero
     * @param salleChoisie la salle choisie
     */
    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    /**
     * une fonction qui permet de connaitre la salle choisie pour le deplacement
     * @return la salle choisie
     */
    public ISalle getSalleChoisie() {
        return salleChoisie;
    }
}
