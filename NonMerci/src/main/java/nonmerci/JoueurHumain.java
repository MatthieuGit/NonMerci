package nonmerci;

//todo : pas de test sur cette classe

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom_, int jeton_) {
        super(nom_, jeton_);
    }

    @Override
    public boolean veutOuDoitRecupererCarte(CarteMisee carteAprendre, GameControler gameControler) {
        if (naPlusDeJeton()) {
            gameControler.priseObligatoire();
            return true;
        }
        return gameControler.prendreCarte();
    }

    @Override
    public String toString() {
        return nom+" "+jetons;
    }
}
