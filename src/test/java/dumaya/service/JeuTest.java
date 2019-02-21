package dumaya.service;

import dumaya.service.implementation.Jeu;
import dumaya.service.implementation.JeuChallenger;
import dumaya.service.implementation.JeuDefenseur;
import dumaya.service.implementation.Partie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class JeuTest {

    @Before
    public void setUp() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        Partie partie = new Partie();
        partie.setChoixModeJeu("C");
    }

    @Test
    public void DefinirCombinaisonSecreteRechJoueur() {
        //arrange
        int nbdeCouleur = 4;
        int longueurduSecret = 4;
        String typeJoueur = "J";
        Jeu jeu = new JeuChallenger(true, "R", nbdeCouleur, 10, longueurduSecret);
        //act
        String combiSecrete = jeu.definirCombinaisonSecrete(typeJoueur, longueurduSecret, nbdeCouleur);
        //assert
        assertEquals(4, combiSecrete.length());
    }

    @Test
    public void DefinirCombinaisonSecreteMastermindJoueur() {
        //arrange
        int nbdeCouleur = 4;
        int longueurduSecret = 20;
        String typeJoueur = "J";
        Jeu jeu = new JeuChallenger(true, "M", nbdeCouleur, 10, longueurduSecret);
        //act
        String combiSecrete = jeu.definirCombinaisonSecrete(typeJoueur, longueurduSecret, nbdeCouleur);
        //assert
        char[] tabsecret = combiSecrete.toCharArray();
        assertEquals(20, combiSecrete.length());
        boolean b=true;
        for (int i = 0; i < combiSecrete.length(); i++) {
            assertTrue(nbdeCouleur+'0' >= tabsecret[i]);
        }

    }


    @Test
    public void DefinirCombinaisonSecreteMastermindOrdi() {
        //arrange
        int nbdeCouleur = 6;
        int longueurduSecret = 5;
        String typeJoueur = "O";
        System.setIn(new ByteArrayInputStream("1234578\n1t58C\n12567\n45201\n".getBytes()));
        Jeu jeu = new JeuChallenger(true, "M", nbdeCouleur, 10, longueurduSecret);
        //act
        String combiSecrete = jeu.definirCombinaisonSecrete(typeJoueur, longueurduSecret, nbdeCouleur);
        //assert
        assertEquals(5, combiSecrete.length());
        char[] tabsecret = combiSecrete.toCharArray();
        for (int i = 0; i < combiSecrete.length(); i++) {
            assertTrue(nbdeCouleur+'0' >= tabsecret[i]);
        }
    }

    @Test
    public void jeuDefenseur() {
        //arrange
        int nbdeCouleur = 4;
        int longueurduSecret = 4;
        String typeJoueur = "J";
        System.setIn(new ByteArrayInputStream("1290\n".getBytes()));
        Jeu jeu = new JeuDefenseur(true, "R", nbdeCouleur, 10, longueurduSecret);
        //act
        boolean result = jeu.unJeu();
        //assert
        assertTrue(result);
    }
}
