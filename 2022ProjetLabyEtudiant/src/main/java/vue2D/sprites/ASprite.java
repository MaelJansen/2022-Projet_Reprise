/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 *
 * @author majansen
 */
public abstract class ASprite implements ISprite{
    
    IPersonnage perso;
    Image spritePerso;
    int posX;
    int posY;

    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spritePerso, posX, posY);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        posX = xpix*15;
        posY = ypix*15;
    }
    
    public ASprite(IPersonnage personnage, ILabyrinthe lab){
        this.perso = personnage;
        posX = lab.getEntree().getX();
        posY = lab.getEntree().getY();
        spritePerso = new Image("file:icons/link/LinkRunShieldD1.gif");
    }
    
    @Override
    public void setPosition(ISalle s){
        perso.setPosition(s);
        setCoordonnees(perso.getPosition().getX(), perso.getPosition().getY());
    }
    
}
