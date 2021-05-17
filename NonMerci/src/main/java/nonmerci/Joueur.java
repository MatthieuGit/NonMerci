package nonmerci;


//todo : pas de test sur cette classe

public abstract class Joueur implements Comparable{

    protected int jetons;
    public Board cartesRecuperees;
    protected String nom;

    public Joueur(String nom_, int jeton_){
        jetons = jeton_;
        cartesRecuperees = new Board();
        nom = nom_;
    }

    public int getJeton() {//utilisé pour refuseTest
        return jetons;
    }

    public boolean refuse(CarteMisee enCours) {
        if(jetons>=1){
            enCours.addJeton();
            jetons-=1;
            return true;
        }
        else{
            accepteCarte(enCours);
            return false;
        }
    }

    public void accepteCarte(CarteMisee c) {
        cartesRecuperees.ajouterCarte(c.getCarte());
        jetons+=c.getJeton();
    }

    public int nbCartes(){
        return cartesRecuperees.nbCartes();
    }

    public void setJetons(int jetonsMemoire){
        jetons = jetonsMemoire;
    }

    public int nbPoints() {
        return cartesRecuperees.nbPoints()+jetons;
    }

    public String getNom() {
        return nom;
    }

    public Carte getCartes(int index) {
        return cartesRecuperees.get(index);
    }

    public int compareTo(Object o) {
        Joueur j = (Joueur)o;
        if(nbPoints()>j.nbPoints())return -1;
        if(nbPoints()==j.nbPoints())return 0;
        return 1;
    }

    public Board getCartes() {
        return cartesRecuperees;
    }

    public abstract boolean veutOuDoitRecupererCarte(CarteMisee carteAprendre, GameControler gameControler);

    public boolean naPlusDeJeton() {
        return jetons <=0 ;
    }
}
