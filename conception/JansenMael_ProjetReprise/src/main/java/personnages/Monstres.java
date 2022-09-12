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
    
    /**
     * Une fonction qui permet d'avoir une salle aléatoire pour le deplacement
     * des monstres (parmis les salles qui leurs sont accessibles)
     * @param sallesAccessibles la liste des salles accessibles
     * @return la salle choisie (aléatoirement)
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        ArrayList<ISalle> accessibles = (ArrayList) sallesAccessibles;
        Random r = new Random();
        salleAleatoire = accessibles.get(r.nextInt(accessibles.size()));
        return salleAleatoire;
    }
    
    /**
     * Le constructeur pour les monstres
     * @param salleDepart la salle qui servira de salle de depart aux monstres
     */
    public Monstres(ISalle salleDepart){
        this.setPosition(salleDepart);
        salleAleatoire = salleDepart;
    }
    
    /**
     * Une fonction qui permet de savoir la position d'un monstre
     * @return la position du monstre
     */
    @Override
    public ISalle getPosition(){
        return super.getPosition();
    }
    
}
