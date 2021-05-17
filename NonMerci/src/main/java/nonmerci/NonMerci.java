package nonmerci;

import java.util.ArrayList;

//todo : pas de test sur cette classe

public class NonMerci {

    public static void main(String[] args) {

        Partie partie = new Partie();
        TextControler gc = new TextControler(partie);

        partie.setGameControler(gc);
        partie.addJoueur(new JoueurHumain("VOUS", 11));
        partie.addJoueur(new JoueurOrdi("hal", 11));
        partie.addJoueur(new JoueurOrdi("jarvis", 11));
        Manche manche = new Manche(partie, new JeuDeCarte(35));
        partie.setManche(manche);
        partie.jouer();
        ArrayList<Joueur> joueurs = partie.endGame();
        gc.afficheResultat(joueurs);
    }
}
