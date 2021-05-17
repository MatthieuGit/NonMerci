package nonmerci;

import java.util.*;

import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;
// todo : tests sur ajouterCarte et nbPoint (cf BoardUnitTest)

// Chaque joueur dispose d'une instance de Board, elle contient les séries de cartes que le joueur a récupéré.

public class Board {
    //Le board contient une liste triée de Serie (qui sont des listes triées de cartes)
    private SortedSet<Serie> board;

    public Board() {
        clear();
    }

    public void clear() {
        board = new TreeSet<Serie>(new Comparator<Serie>() {
            public int compare(Serie o1, Serie o2) {
                return  o1.first().compareTo(o2.first());
            }
        });
    }

    public void ajouterCarte(Carte c) {
        if (board.isEmpty()) {
            board.add(new Serie(c));
            return;
        }
        if (board.first().estCompleteEnDebutPar(c)) {
            board.first().add(c);
            return;
        }
        if (board.last().estCompleteEnFinPar(c)){
            board.last().add(c);
            return;
        }
        Iterator<Serie> iterator = board.iterator();
        Iterator<Serie> iterator1 = board.iterator();
        if (iterator.hasNext()) iterator1.next();

        while (iterator.hasNext() && iterator1.hasNext()) {
            Serie current = iterator.next();
            Serie next = iterator1.next();
            if (current.estCompleteEnDebutPar(c)) {
                current.add(c);
                return;
            }
            if (current.estCompleteEnFinPar(c)) {
                if (next.estCompleteEnDebutPar(c)) {
                    //fusion
                    current.add(c);
                    current.addAll(next);
                    iterator1.remove();
                    return;
                } else {
                    current.add(c);
                    return;
                }
            }

        }
        if (iterator.hasNext()) {
            Serie current = iterator.next();
            if (current.estCompleteEnDebutPar(c) || current.estCompleteEnFinPar(c)) {
                current.add(c);
                return;
            }
        }
        board.add(new Serie(c));
    }

    public int nbPoints() {
        int res = 0;
        for (Serie aSerie : board) {
            res -= aSerie.first().getValue();
        }
        return res;
    }

    public int nbCartes() {
        int res = 0;
        if (board.isEmpty()) return res;
        for (Serie aSerie : board) {
            res += aSerie.size();
        }
        return res;
    }

    public Carte get(int index) {
        ArrayList<Carte> listeDesCartes = getJeuJoueur();

        return listeDesCartes.get(index);

    }

    public ArrayList<Carte> getJeuJoueur() {
        ArrayList<Carte> listeDesCartes = new ArrayList<Carte>();
        for (Serie aSerie : board) {
                listeDesCartes.addAll(aSerie.getCartes());
            }
        return listeDesCartes;

    }

    @Override
    public String toString() {
        if (board.isEmpty()) return "< >";
        StringBuilder builder = new StringBuilder();
        builder.append('<');
        for (Serie serie : board) {
            builder.append(serie).append("  ");
        }
        builder.delete(builder.length()-2, builder.length());
        builder.append('>');
        return builder.toString();
    }
}