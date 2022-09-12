package application;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.Heros;
import personnages.IPersonnage;
import personnages.Monstres;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 *
 * @author arpecher
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;
    ISprite monstres;

    /**
     * Une fonction qui permet de créer un labyrinthe
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby(ranLab());
    }

    /**
     * Une fonction qui permet de créer tout les personnages contenu dans 
     * une collection de sprites
     * @param vue une collection de sprite
     */
    protected void initSprites(IVue vue) {
        // creation du heros 
        Heros h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h, labyrinthe);
        vue.add(this.heros);
        // creation des monstres
        Monstres m;
        for (int i=0; i<10; i++){
            m = new personnages.Monstres(labyrinthe.getSortie());
            this.monstres= new MonstreSprite(m, labyrinthe);
            vue.add(this.monstres);
        }
    }

    /**
     * Une fonction qui permet de gérer les déplacements des différentes entités
     * ainsi que leurs collisions
     * @param vue une collection de sprite
     */
    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!(labyrinthe.getSortie().getX() == heros.getPosition().getX())
                || !(labyrinthe.getSortie().getY() == heros.getPosition().getY())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                p.setPosition(destination); // deplacement
            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition().getX() == heros.getPosition().getX() 
                            && p.getPosition().getY() == heros.getPosition().getY()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(100);
        }
        System.out.println("Gagné!");
    }

    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException eif) {
            System.out.println("Fichier de labyrinthe non-valide");
            System.out.println("Chargement du fichier de secours ...");
            try {
                labyrinthe.creerLabyrinthe("labys/level7.txt");
            } catch (IOException e) {
                System.out.println("Fichier de secours invalide !");
                System.out.println("Erreur de l'application");
                System.exit(1);
            };
        }
    }

    /**
     * Une fonction qui permet de ralentire les actions du code
     * @param nb
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
    
    /**
     * Une fonction qui permet de charger un labyrinthe aléatoire
     * @return un fichier contenant les coordonnées d'un labyrinthe
     */
    public String ranLab(){
        int choix;
        String labChoisie = "labys/level3.txt";
        Random r = new Random();
        choix = r.nextInt(10);
        switch (choix){
            case 1:
                labChoisie = "labys/level3.txt";
                break;
            case 2:
                labChoisie = "labys/level10.txt";
                break;
            case 3:
                labChoisie = "labys/level11.txt";
                break;
            case 4:
                labChoisie = "labys/level12.txt";
                break;
            case 5:
                labChoisie = "labys/level2.txt";
                break;
            case 6:
                labChoisie = "labys/level6.txt";
                break;
            case 7:
                labChoisie = "labys/level7.txt";
                break;
            case 8:
                labChoisie = "labys/level8.txt";
                break;
            case 9:
                labChoisie = "labys/level9.txt";
                break;
            default:
                break;
        }
                
        return labChoisie;
    }
}
