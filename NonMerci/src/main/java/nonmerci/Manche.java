package nonmerci;

import java.util.Observable;

// todo : test de la méthode jouer (cf MancheUnitTest)

public class Manche extends Observable {
    private JeuDeCarte pioche;
    private CarteMisee carteAprendre;
    private Partie partie;


    public Manche(Partie partie, JeuDeCarte pioche) {
        this.partie = partie;
        this.pioche = pioche;
    }


    public int sizePioche() {
        return pioche.size();
    }

    public boolean piocheVide() {
        return pioche.size() <= 0;

    }

    public CarteMisee piocher() {
        return pioche.piocher();
    }

    public void jouer() {
        GameControler gameControler = partie.getGameControler();
        Joueur joueur = partie.choixJoueurAuHazard();
        while (!piocheVide()) {
            carteAprendre = piocher();
            while (carteAprendre != null) {
                joueur = partie.getJoueurActif();
                gameControler.refreshPioche();
                gameControler.refreshBoard(joueur);
                if (joueur.veutOuDoitRecupererCarte(carteAprendre, gameControler)) {
                    joueur.accepteCarte(carteAprendre);
                    carteAprendre = null;
                    break;
                } else {
                    joueur.refuse(carteAprendre);
                    partie.changeJoueurActif();
                }
            }
        }
        gameControler.refreshBoard(joueur);
    }


    public CarteMisee carteAprendre() {
        return carteAprendre;
    }
}
