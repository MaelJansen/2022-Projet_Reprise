package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import vue2D.sprites.ISprite;

/**
*
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private GraphicsContext tampon;
    private Image solImage;
    private Image mur;
    private Image sol;
    private Image sortie;
   
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        dessinLab();
    }
    
     public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.png");
    }
    
    public void dessinFond(){
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }
    
    public void dessinLab(){
        Salle salle;
        int x;
        int y;
        sol = new Image("file:icons/mur0.gif");
        mur = new Image("file:icons/ground.gif");
        sortie = new Image("file:incons/sortie.gif");
        // on dessine le fond du labyrinthe
        for (int i=0; i<labyrinthe.getLargeur(); i++){
            for (int j=0; j<labyrinthe.getHauteur(); j++){
                salle = new Salle(i,j);
                if(!labyrinthe.contains(salle)){
                    tampon.drawImage(sol, i*unite, j*unite, unite, unite);
                }
            }
        }
        // on dessine toutes les salles
        for (ISalle s : labyrinthe){
            x = s.getX();
            y = s.getY();
            tampon.drawImage(mur,x*unite,y*unite,unite,unite);
        }
    }

}
