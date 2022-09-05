/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package labyrinthe;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author majansen
 */
public class SalleTest {
    
    public SalleTest() {
    }

    @Test
    public void testGetX() {
        System.out.println("getX");
        Salle test = new Salle(0,1);
        
        // Test du renvoie des coordonnées
        assertTrue(test.getX()== 0);
        assertFalse(test.getX()== 1);
    }

    @Test
    public void testGetY() {
        System.out.println("getY");
        Salle test = new Salle(1,0);
        
        // Test du renvoie des coordonnées
        assertTrue(test.getX()== 1);
        assertFalse(test.getX()== 0);
    }

    @Test
    public void testEstAdjacente() {
        System.out.println("estAdjacente");
        Salle test = new Salle(0,0);
        Salle adjacente = new Salle(1,0);
        Salle nonAdjacente = new Salle(5,5);
        Salle doublons = new Salle(0,0);
        Salle diagonale = new Salle(1,1);
        
        // le cas de case adjacentes
        assertTrue(test.estAdjacente(adjacente)==true);
        // dans le cas de deux même cases
        assertFalse(test.estAdjacente(doublons)==true);
        // le case de case non adjacentes
        assertFalse(test.estAdjacente(nonAdjacente)==true);
        // le cas d'une case en diagoanle
        assertFalse(test.estAdjacente(diagonale));
    }
    
}
