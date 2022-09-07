package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    @Override
    public void creerLabyrinthe(String file) {
        Fichier f = new Fichier(file);
        // dimensions
        largeur=f.lireNombre(); 
        hauteur=f.lireNombre();
        // les coordonnées
        int x = f.lireNombre();
        int y = f.lireNombre();
        // on récupère l'entrée et la sortie
        entree = new Salle(x, y);
        addSalle(entree, hauteur, largeur);
        x = f.lireNombre();
        y = f.lireNombre();
        sortie = new Salle(x,y);
        addSalle(sortie, hauteur, largeur);
        x = f.lireNombre();
        y = f.lireNombre();
        // on récuère les autres salles
        while(x != -1){
            Salle s = new Salle(x,y);
            addSalle(s, hauteur, largeur);
            x = f.lireNombre();
            y = f.lireNombre();
        }
        // ...
    }
    
    // Une fonction qui permet de n'ajouter que des slles valides
    public void addSalle(ISalle s, int hauteur , int largeur){
        if ((s.getY()>=0 && s.getY()<hauteur) 
                && (s.getX()>=0 && s.getX()<largeur) && (!this.contains(s))){
            this.add(s);
        }
        System.out.println("Faux");
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }
}

