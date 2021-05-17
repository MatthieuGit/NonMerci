package nonmerci;

import java.util.*;

//todo : pas de test sur cette classe

public class JeuDeCarte {
    private ArrayList<Carte> deck;


    public JeuDeCarte(int taille) {

        //Création des valeurs des cartes
        List<Integer> liste = new ArrayList<Integer>();
        for(int i = 3 ; i <taille ; i++){
            liste.add(i);
        }
        Random loto = new Random();
        while(liste.size()>24){
            liste.remove(loto.nextInt(liste.size()-1));//choisi 24 cartes parmis les 33, de façon aléatoire
        }
        Collections.shuffle(liste);

        deck = new ArrayList<Carte>();
        for(Integer i : liste){
            Carte carte = new Carte(i);
            deck.add(carte);
        }
    }

    public int size() {
        return deck.size();

    }

    public CarteMisee piocher() {
        Carte cartePioche = deck.remove(0);
        return new CarteMisee(cartePioche);
    }

}
