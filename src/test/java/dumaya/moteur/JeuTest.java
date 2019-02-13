package dumaya.moteur;

import dumaya.menuprincipal.Partie;
import dumaya.moteur.implementation.Jeu;
import dumaya.moteur.implementation.JeuChallenger;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class JeuTest {

    @Before
    public void setUp()  {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        Partie partie = new Partie();
        partie.setChoixModeJeu("C");
    }

    @Test
    public void DefinirCombinaisonSecreteRechJoueur() {
        //arrange
        int nbdeCouleur=4;
        int longueurduSecret=4;
        String typeJoueur="J";
        Jeu jeu = new JeuChallenger(true,"R","C",nbdeCouleur,10,longueurduSecret);
        //act
        String combiSecrete= jeu.definirCombinaisonSecrete(typeJoueur,longueurduSecret, nbdeCouleur);
        //assert
        assertEquals(4, combiSecrete.length());
        assertFalse(combiSecrete.contains("0"));
    }
    @Test
    public void DefinirCombinaisonSecreteMastermindJoueur() {
        //arrange
        int nbdeCouleur=4;
        int longueurduSecret=4;
        String typeJoueur="J";
        Jeu jeu = new JeuChallenger(true,"M","C",nbdeCouleur,10,longueurduSecret);
        //act
        String combiSecrete= jeu.definirCombinaisonSecrete(typeJoueur,longueurduSecret, nbdeCouleur);
        //assert
        char[] tabsecret=combiSecrete.toCharArray();
        assertEquals(4, combiSecrete.length());
        assertFalse(combiSecrete.contains("0"));

        for (int i=0;i<combiSecrete.length();i++)
            assertTrue(nbdeCouleur >= (int) tabsecret[i]);

    }
    @Test
    public void DefinirCombinaisonSecreteRechOrdi() {
        //arrange
        int nbdeCouleur=6;
        String typeJoueur="O";
        int longueurduSecret=4;
        Jeu jeu = new JeuChallenger(true,"R","C",nbdeCouleur,10,longueurduSecret);
        //act
        String combiSecrete= jeu.definirCombinaisonSecrete(typeJoueur,longueurduSecret,nbdeCouleur);
        //assert
        assertEquals(6, combiSecrete.length());
        assertFalse(combiSecrete.contains("0"));
        char[] tabsecret=combiSecrete.toCharArray();
        for (int i=0;i<combiSecrete.length();i++)
        {
            assertTrue(nbdeCouleur>= tabsecret[i]);
        }
    }
    @Test
    public void DefinirCombinaisonSecreteMastermindOrdi() {
        //arrange
        int nbdeCouleur=6;
        int longueurduSecret=23;
        String typeJoueur="O";
        Jeu jeu = new JeuChallenger(true,"M","C",nbdeCouleur,10,longueurduSecret);
        //act
        String combiSecrete= jeu.definirCombinaisonSecrete(typeJoueur,longueurduSecret, nbdeCouleur);
        //assert
        assertEquals(23, combiSecrete.length());
        assertFalse(combiSecrete.contains("0"));
        char[] tabsecret=combiSecrete.toCharArray();
        for (int i=0;i<combiSecrete.length();i++)
        {
            assertTrue(nbdeCouleur>= tabsecret[i]);
        }
    }


    @Test
    public void jeuChallenger() {
        //arrange
        int nbdeCouleur=4;
        int longueurduSecret=4;
        String typeJoueur="J";
        Jeu jeu = new JeuChallenger(true,"R","C",nbdeCouleur,10,longueurduSecret);
        //act
        boolean result = jeu.unJeu();
        //assert
        assertTrue(result);
    }
}
