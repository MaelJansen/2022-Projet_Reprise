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

    /**
     * Une méthode qui créer toutes les salles d'un labyrinthe a partir 
     * d'un fichier passer en paramètre
     * @param file le fichier contenant les coordonnées des salles du labyrinthes
     */
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

    /**
     * Une fonction qui permet de controller si les salles sont correctes ou non
     * (si elles ont des coordonnées positives et pas trop grandes)
     * @param s
     * @param hauteur
     * @param largeur
     * @return vrai ou faux en fonction de si la salles est correcte ou pas
     */
    public boolean addSalle(ISalle s, int hauteur , int largeur){
        if ((s.getY()>=0 && s.getY()<hauteur) 
                && (s.getX()>=0 && s.getX()<largeur) && (!this.contains(s))){
            this.add(s);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Une fonction qui retourne les salles acccessibles par le personnages
     * (celles qui lui sont adjacentes)
     * @param bob le personnage dont on veux connaitre les salles accessibles
     * @return un collection de salles (accessibles)
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        ArrayList<ISalle> adjacentes = new ArrayList<>();
        for (ISalle s : this){
            if(bob.getPosition().estAdjacente(s)){
                adjacentes.add(s);
            }
        }
        return adjacentes;
    }

    /**
     * Une fonction qui renvoie l'entrée du labyrinthe 
     * @return une salle (l'entrée du labyrinthe)
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Une fonction qui renvoie la sortie du labyrinthe
     * @return une salle (la sortie du labyrinthe)
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }
    
    // Une fonction qui n'a pas été encore implementée
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Une fonction qui renvoie la largeur du labyrinthe
     * @return le nombre de salles sur la largeur du labyrinthe
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Une fonction qui renvoie la longueur du labyrinthe
     * @return le nombre de salles sur la longueur du labyrinthe
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }
}

