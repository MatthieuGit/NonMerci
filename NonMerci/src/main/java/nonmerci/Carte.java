package nonmerci;

//todo : pas de test sur cette classe

public class Carte implements Comparable{

    private Integer point;

    public Carte(int point_){
        point = point_;
    }


    public int getValue() {
        return point;
    }

    public int compareTo(Object o) {
        Carte c = (Carte)o;
        return point.compareTo(c.point);
    }

    @Override
    public String toString() {
        return ""+point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return point.equals(carte.point);
    }

}
