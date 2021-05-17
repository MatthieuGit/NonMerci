package acceptance;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nonmerci.*;
import org.junit.Assert;
import org.mockito.Mockito;

public class OrdiStepDef {

    Partie partie;

    @Before
    public void setUp() {
        partie = new Partie();
        GameControler gc = new TextControler(partie);
        partie.setGameControler(gc);
    }


    @Given("^la carte (\\d+) avec (\\d+) jetons est proposée$")
    public void laCarteAvecJetonsEstProposée(int valeurCarte, int nbJetons) {
        CarteMisee carte = new CarteMisee(new Carte(valeurCarte));
        carte.addJeton();
        carte.addJeton();

        JeuDeCarte pioche = Mockito.mock(JeuDeCarte.class);
        Mockito.when(pioche.piocher()).thenReturn(carte);
        Mockito.when(pioche.size()).thenReturn(1, 0);
        Manche manche = new Manche(partie, pioche);
        partie.setManche(manche);
    }

    @And("^le joueur \"([^\"]*)\" a sur son board <([^>]*)>$")
    public void leJoueurOrdiASurSonBoard(String name, String board) {
        Joueur joueur = getJoueurOrCreateJoueur(name);
        String[] valeursCartes = board.replaceAll("--", "  ").split("  ");
        for (String valeursCarte : valeursCartes) {
            joueur.accepteCarte(new CarteMisee(new Carte(Integer.parseInt(valeursCarte))));
        }
    }

    private Joueur getJoueurOrCreateJoueur(String name) {
        Joueur joueur = partie.getJoueurByName(name);
        if (joueur == null) {
            joueur = new JoueurOrdi(name, 0);
            partie.addJoueur(joueur);
        }
        return joueur;
    }

    @And("^le joueur \"([^\"]*)\" a (\\d+) jetons$")
    public void leJoueurOrdiAJetons(String name, int nbJetons) {
        Joueur joueur = getJoueurOrCreateJoueur(name);
        joueur.setJetons(nbJetons);
    }

    @When("^le joueur \"([^\"]*)\" joue$")
    public void leJoueurOrdiJoue(String name) {
        partie.jouer();
    }

    @Then("^le joueur \"([^\"]*)\" prend la carte, son board devient <([^>]*)>$")
    public void leJoueurOrdiPrendLaCarteSonBoardDevient(String name, String board) {
        Joueur joueur = partie.getJoueurByName(name);
        Assert.assertEquals("<"+board+">",joueur.getCartes().toString());
    }


    @And("^le joueur \"([^\"]*)\" dispose maintenant de (\\d+) jetons$")
    public void leJoueurDisposeMaintenantDeJetons(String name, int nbJetons) throws Throwable {
        Joueur joueur = partie.getJoueurByName(name);
        Assert.assertEquals(nbJetons, joueur.getJeton());
    }
}
