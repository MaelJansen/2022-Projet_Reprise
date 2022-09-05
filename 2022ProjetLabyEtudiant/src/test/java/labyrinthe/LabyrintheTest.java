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
    
    public LabyrintheTest() {
    }

    @Test
    public void testCreerLabyrinthe() {
        System.out.println("creerLabyrinthe");
        Labyrinthe labTest = new Labyrinthe();
        labTest.creerLabyrinthe("labys/level6.txt");
        Labyrinthe labTest2 = new Labyrinthe();
        labTest2.creerLabyrinthe("labys/levelIvalide1.txt");
        ArrayList<ISalle> sallesExistantes = new ArrayList<>();
        boolean bonLab1 = true;
        boolean bonlab2 = true;
        // on test toutes les conditions pour que le  labyrinthe soit correct
        for(ISalle s : labTest){
            if(!(s.getX()>=0 && s.getX()< 50) 
                    && !(s.getY()>=0 && s.getY()<50) 
                    && sallesExistantes.contains(s)){
                bonLab1 = false;
            }
            sallesExistantes.add(s);
        }
        sallesExistantes.clear();
        // on test pour un labyrinthe avec des coordonnées négatives
        for(ISalle s : labTest2){
            if(!(s.getX()>=0 && s.getX()< 50) 
                    && !(s.getY()>=0 && s.getY()<50) 
                    && sallesExistantes.contains(s)){
                bonlab2 = false;
            }
            sallesExistantes.add(s);
        }
        
        
        // on test la création de labyrinthe avec un bon 
        assertTrue(bonLab1 == true);
        // on test la création sans coordonnées nnégatives
        assertTrue(bonlab2 == true);
    }

    @Test
    public void testSallesAccessibles() {
        System.out.println("sallesAccessibles");
        IPersonnage bob = null;
        Labyrinthe instance = new Labyrinthe();
        Collection<ISalle> expResult = null;
        Collection<ISalle> result = instance.sallesAccessibles(bob);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEntree() {
        System.out.println("getEntree");
        Labyrinthe instance = new Labyrinthe();
        ISalle expResult = null;
        ISalle result = instance.getEntree();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSortie() {
        System.out.println("getSortie");
        Labyrinthe instance = new Labyrinthe();
        ISalle expResult = null;
        ISalle result = instance.getSortie();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testChemin() {
        System.out.println("chemin");
        ISalle u = null;
        ISalle v = null;
        Labyrinthe instance = new Labyrinthe();
        Collection<ISalle> expResult = null;
        Collection<ISalle> result = instance.chemin(u, v);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLargeur() {
        System.out.println("getLargeur");
        Labyrinthe instance = new Labyrinthe();
        int expResult = 0;
        int result = instance.getLargeur();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHauteur() {
        System.out.println("getHauteur");
        Labyrinthe instance = new Labyrinthe();
        int expResult = 0;
        int result = instance.getHauteur();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
