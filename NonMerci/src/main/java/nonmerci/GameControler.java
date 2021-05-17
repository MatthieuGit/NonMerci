package nonmerci;

public interface GameControler {
     boolean prendreCarte() ;

    void refreshPioche();

    void refreshBoard(Joueur joueur);

    void priseObligatoire();
}
