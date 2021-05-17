package nonmerci;

import java.util.ArrayList;

// todo : test de veutOuDoitRecupererCarte (cf JoueurOrdiUnitTest)

public class JoueurOrdi extends Joueur {

    public JoueurOrdi(String nom_, int jeton_) {
        super(nom_, jeton_);
    }

    @Override
    public boolean veutOuDoitRecupererCarte(CarteMisee carteAprendre, GameControler gameControler) {
        if (naPlusDeJeton()) return true;
        ArrayList<Carte> lc = getCartes().getJeuJoueur();
        Carte next = new Carte(carteAprendre.getValue()+1);
        if (lc.contains(next)) return true;
        // Si la carte de valeur immédiatement supérieure à la carte à récupérer est déja dans le
        // board du joueur, la carte à récupérer complète une série par le bas. Il est intéressant
        // de la récupérer.
        Carte previous = new Carte(carteAprendre.getValue()-1);
        if (lc.contains(previous) && carteAprendre.getJeton()>0) return true;
        // Si la carte de valeur immédiatement inférieure à la carte à récupérer est déja dans le
        // board du joueur, la carte à prendre complète une série par le haut, il est intéressant de la prendre si
        // elle comporte des jetons, sinon on peut tenter d'attendre
        if (carteAprendre.getJeton()>carteAprendre.getValue()/2) return true;
        return false;
    }

    @Override
    public String toString() {
        return nom;
    }
}
