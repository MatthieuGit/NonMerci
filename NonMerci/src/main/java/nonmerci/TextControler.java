package nonmerci;

import java.util.ArrayList;
import java.util.Scanner;

//todo : pas de test sur cette classe

public class TextControler implements GameControler {

    private Partie partie;

    public TextControler(Partie partie) {
        this.partie = partie;
    }

    public boolean prendreCarte() {
        System.out.println("Voulez vous prendre la carte - yes / no");
        Scanner scanner = new Scanner(System.in);
        String rep = scanner.nextLine();
        if (rep.equals("yes"))
            return true;
        else return false;
    }

    public void priseObligatoire() {
        System.out.println("Vous n'avez plus de jetons, vous êtes contraint de prendre cette carte");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public void refreshPioche() {
        CarteMisee carteMisee = partie.carteAPrendre();
        System.out.println("\n Carte proposée " + carteMisee.getValue() + " jetons :" + carteMisee.getJeton());
    }


    public void refreshBoard(Joueur joueur) {
        for (Joueur joueur1 : partie.getAllJoueurs()) {
            if (joueur1.equals(joueur)) {
                System.out.println("* "+ joueur1);
                System.out.println(joueur1.getCartes());
            }
            else {
                System.out.println(joueur1);
                System.out.println(joueur1.getCartes());
            }
        }

    }

    public void afficheResultat(ArrayList<Joueur> joueurs) {
        int rank = 1;
        for (Joueur joueur : joueurs) {
            System.out.println(rank + " "+joueur.getNom()+" avec "+joueur.nbPoints());
            rank++;
        }
    }
}
