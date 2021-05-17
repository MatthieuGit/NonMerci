package nonmerci;

//todo : pas de test sur cette classe

public class CarteMisee {

    private int jetons;

    private final Carte carte;


    public CarteMisee(Carte carte) {
        jetons = 0;
        this.carte = carte;
    }

    public void addJeton() {
        jetons++;
    }

    public int getJeton() {
        return jetons;
    }

    public int getValue() {
        return carte.getValue();
    }

    public int compareTo(Object o) {
        return carte.compareTo(o);
    }

    public String toString() {
        return carte.toString();
    }

    public Carte getCarte() {
        return carte;
    }
}
