package nonmerci;

import java.util.SortedSet;
import java.util.TreeSet;

//todo : pas de test sur cette classe

public class Serie {
    private final SortedSet<Carte> cartes;

    public Serie(Carte carte) {
        cartes = new TreeSet<Carte>();
        cartes.add(carte);
    }

    public boolean estCompleteEnDebutPar(Carte carte) {
        return carte.getValue() + 1 == cartes.first().getValue();
    }

    public boolean estCompleteEnFinPar(Carte carte) {
        return carte.getValue() - 1 == cartes.last().getValue();
    }

    public void add(Carte carte) {
        cartes.add(carte);
    }

    public Carte first() {
        return cartes.first();
    }

    public int size() {
        return cartes.size();
    }

    public SortedSet<Carte> getCartes() {
        return cartes;
    }

    public void addAll(Serie next) {
        cartes.addAll(next.cartes);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Carte carte : cartes) {
            builder.append(carte).append("--");
        }
        builder.delete(builder.length()-2, builder.length());
        return builder.toString();
    }
}
