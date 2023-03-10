/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import personnages.IPersonnage;

/**
 *
 * @author majansen
 */
public class LabyrintheTest {

    @Test
    public void testCreerLabyrinthe() {
        System.out.println("creerLabyrinthe");
        
        // Un premier test avec un bon labyrinthe
        Labyrinthe labTest = new Labyrinthe();
        labTest.creerLabyrinthe("labys/level6.txt");
        // Un test avec un mauvais labyrinthe (coordonées négatives)
        Labyrinthe labTest2 = new Labyrinthe();
        labTest2.creerLabyrinthe("labys/levelInvalide1.txt");
        // Un troisième test avec un autre mauvais labyrinthe (coordonnées trop grandes)
        Labyrinthe labTest3 = new Labyrinthe();
        labTest3.creerLabyrinthe("labys/levelInvalide2.txt");
        // Un quatrième test avec un autre mauvais labyrinthe (salles en doubles)
        Labyrinthe labTest4 = new Labyrinthe();
        labTest4.creerLabyrinthe("labys/levelInvalide3.txt");
        
        ArrayList<ISalle> sallesExistantes1 = new ArrayList<>();
        ArrayList<ISalle> sallesExistantes2 = new ArrayList<>();
        ArrayList<ISalle> sallesExistantes3 = new ArrayList<>();
        ArrayList<ISalle> sallesExistantes4 = new ArrayList<>();
        boolean bonLab1 = true;
        boolean bonlab2 = true;
        boolean bonlab3 = true;
        boolean bonlab4 = true;
        
        // on test toutes les conditions pour que le  labyrinthe soit correct
        for(ISalle s : labTest){
            if(!(s.getX()>=0 && s.getX()< labTest.getLargeur()) 
                    || !(s.getY()>=0 && s.getY()< labTest.getLargeur()) 
                    || sallesExistantes1.contains(s)){
                bonLab1 = false;
            }
            sallesExistantes1.add(s);
        }
        // on test pour un labyrinthe avec des coordonnées négatives
        for(ISalle s : labTest2){
            if(!(s.getX()>=0 && s.getX()< labTest.getLargeur()) 
                    || !(s.getY()>=0 && s.getY()< labTest.getLargeur()) 
                    || sallesExistantes2.contains(s)){
                bonlab2 = false;
            }
            sallesExistantes2.add(s);
        }
        // on test pour un labyrinthe avec des coordonnées trop grandes
        for (ISalle s : labTest3){
            if(!(s.getX()>=0 && s.getX()< labTest.getLargeur()) 
                    || !(s.getY()>=0 && s.getY()< labTest.getLargeur()) 
                    || sallesExistantes3.contains(s)){
                bonlab3 = false;
            }
            sallesExistantes3.add(s);
        }
        // on test pour un labyrinthe avec des coordonnées trop grandes
        for (ISalle s : labTest4){
            if(!(s.getX()>=0 && s.getX()< labTest.getLargeur()) 
                    || !(s.getY()>=0 && s.getY()< labTest.getLargeur()) 
                    || sallesExistantes4.contains(s)){
                bonlab4 = false;
            }
            sallesExistantes4.add(s);
        }
        
        // on test la création de labyrinthe avec un bon 
        assertTrue(bonLab1 == true);
        // on test la création sans coordonnées négatives
        assertTrue(bonlab2 == true);
        // on test pour la création sans coordonnées trop grandes
        assertTrue(bonlab3 == true);
        // on test pour la création sans salles en doubles
        assertTrue(bonlab4 == true);
    }
}
