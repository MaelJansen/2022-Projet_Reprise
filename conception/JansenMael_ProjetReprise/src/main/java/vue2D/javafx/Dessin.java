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
   
    /**
     * Le constructeur de la partie graphique de l'application
     * @param labyrinthe le labyrinthe qui sera afficher
     * @param sprites la liste des personnages qui seront affichés
     */
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
    
    /**
     * Une fonction qui permet de definire l'image de fond de l'application
     */
    public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.png");
    }
    
    /**
     * La fonction qui permet d'afficher le fond de l'application
     */
    public void dessinFond(){
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }
    
    /**
     * La fonction qui permet de dessiner le labyrinthe
     */
    public void dessinLab(){
        Salle salle;
        int x;
        int y;
        choixImages();
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
        tampon.drawImage(sortie, labyrinthe.getSortie().getX()*unite, labyrinthe.getSortie().getY() * unite,
                unite, unite);
    }
    
    /**
     * Une fonction qui permet de choisir les images pour les salles du labyrinthe
     */
    public void choixImages(){
        sol = new Image("file:icons/mur0.gif");
        mur = new Image("file:icons/ground.gif");
        sortie = new Image("file:icons/sortie.gif");
    }

}
