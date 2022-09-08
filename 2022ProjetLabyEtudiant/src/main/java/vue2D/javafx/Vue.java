package vue2D.javafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;
import javafx.event.EventHandler;

/**
*
* @author INFO Professors team
*/
public class Vue extends AVue implements IVue{
    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;
    
    public Vue(ILabyrinthe labyrinthe){
        this.labyrinthe=labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }
    
    @Override
    public void dessiner() {
     	// recopie du fond (image); murs + salles
         dessin.dessinFond();
         dessin.dessinLab();
         for (ISprite sprite : this){
             sprite.dessiner(dessin.getGraphicsContext2D());
         }     
    }	
    
    @Override
    public boolean add(ISprite sprite){
        super.add(sprite);
        // si le sprite est controle par le clavier
        if(sprite instanceof EventHandler){
            System.out.println("registering keylistener");
            // association de l'ecouteur sur le clavier avec le composant graphique principale
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }
}
