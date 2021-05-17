package nonmerci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static java.util.Collections.sort;

//todo : pas de test sur cette classe

public class Partie {
    private ArrayList<Joueur> joueurs;
    private Iterator<Joueur> joueurIterator;
    private int nbJoueurs;
    private int jetonsParJoueur;
    private GameControler gameControler;
    private Manche manche;
    private Joueur joueurActif;


    public Partie() {
        //Une partie est pour l'instant composé d'une liste de joueurs
        joueurs = new ArrayList<Joueur>();
    }

    public ArrayList<Joueur> getAllJoueurs() {
        return joueurs;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void addJoueur(Joueur j) {
        joueurs.add(j);
    }

    public ArrayList<Joueur> endGame() {
        ArrayList<Joueur> ordreFin = new ArrayList<Joueur>();
        ordreFin.addAll(joueurs);
        sort(ordreFin);
        return ordreFin;
    }

    public GameControler getGameControler() {
        return gameControler;
    }

    public void setGameControler(GameControler gameControler) {
        this.gameControler = gameControler;
    }

    public CarteMisee carteAPrendre() {
        return manche.carteAprendre();
    }

    public void setManche(Manche manche) {
        this.manche = manche;
    }

    public void jouer() {
        manche.jouer();
    }


    public Joueur getJoueurActif() {
        return joueurActif;
    }

    public void changeJoueurActif() {
        if (joueurIterator == null)
            joueurIterator = joueurs.iterator();
        if (joueurIterator.hasNext())
            joueurActif = joueurIterator.next();
        else {
            joueurIterator = null;
            changeJoueurActif();
        }
    }

    public Joueur choixJoueurAuHazard() {
        Random random = new Random();
        joueurIterator = joueurs.iterator();
        int decalage = random.nextInt(joueurs.size())+1;
        for (int i = 0; i < decalage; i++) {
            changeJoueurActif();
        }
        return getJoueurActif();
    }

    public Joueur getJoueurByName(String name) {
        for (Joueur joueur : joueurs) {
            if (name.equals(joueur.getNom()))
                return joueur;
        }
        return null;
    }
}
