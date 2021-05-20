package nonmerci;

import java.util.Iterator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MancheUnitTest {

    // todo : couverture de tous les arcs sur la méthode jouer
    private Partie partie;
    private Manche manche;
    private GameControler gameControler;
    private JeuDeCarte pioche;
    @Mock
    private JoueurOrdi joueur1;
    @Mock
    private JoueurHumain joueurHumain;
    @Mock
    private CarteMisee carteAprendre;

    @Before
    public void setUp(){
        partie = mock(Partie.class);
        gameControler = mock(GameControler.class);
        joueur1 = mock(JoueurOrdi.class);
        joueurHumain = mock(JoueurHumain.class);

    }

    @Test
    public void testCarteAprendreTrue(){
        //DEFINE
        pioche = new JeuDeCarte(4);
        manche = new Manche(partie, pioche);

        //WHEN
        when(partie.getJoueurActif()).thenReturn(joueur1);
        when(partie.choixJoueurAuHazard()).thenReturn(joueur1);
        when(partie.getGameControler()).thenReturn(gameControler);
        when(joueur1.veutOuDoitRecupererCarte(ArgumentMatchers.<CarteMisee>any(CarteMisee.class), any(GameControler.class))).thenReturn(true);
        manche.jouer();

        //THEN
        verify(gameControler, times(2)).refreshBoard(partie.getJoueurActif());
    }

    @Test
    public void testWhenPiocheIsVide() {
        //DEFINE
        pioche = new JeuDeCarte(3);
        manche = new Manche(partie, pioche);

        //when
        when(partie.getGameControler()).thenReturn(gameControler);
        manche.jouer();

        //THEN
        verify(gameControler, times(1)).refreshBoard(partie.getJoueurActif());
    }

    @Test
    public void testWhenCarteAprendreIsNull() {
        //DEFINE
        pioche = new JeuDeCarte(4);
        manche = new Manche(partie, pioche);

        //WHEN
        when(partie.getGameControler()).thenReturn(gameControler);
        manche.jouer();

        //THEN
    }


}
